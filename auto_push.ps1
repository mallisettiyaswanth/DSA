$watchFolder = Get-Location  # Set to current directory
$branch = "main"
$repoPath = $watchFolder

Write-Host "Monitoring $watchFolder for changes..."

# Set up the filesystem watcher
$watcher = New-Object System.IO.FileSystemWatcher
$watcher.Path = $watchFolder
$watcher.Filter = "*.*"
$watcher.IncludeSubdirectories = $true
$watcher.EnableRaisingEvents = $true
$watcher.NotifyFilter = [System.IO.NotifyFilters]::FileName, [System.IO.NotifyFilters]::LastWrite, [System.IO.NotifyFilters]::Size

# Define event actions
$action = {
    $filePath = $Event.SourceEventArgs.FullPath
    $changeType = $Event.SourceEventArgs.ChangeType

    Start-Sleep -Seconds 2  # Ensure the file is fully written

    Set-Location $repoPath

    if ($changeType -eq "Created" -or $changeType -eq "Changed") {
        if ((Test-Path $filePath) -and ((Get-Item $filePath).length -gt 0)) {
            Write-Host "Detected ${changeType}: ${filePath}"

            git add "$filePath"
            git commit -m "Auto-commit: ${changeType} $(Split-Path $filePath -Leaf)"
            git push origin $branch

            Write-Host "Changes pushed to GitHub: ${filePath}"
        } else {
            Write-Host "Skipping empty file: ${filePath}"
        }
    }
    elseif ($changeType -eq "Deleted") {
        Write-Host "Detected Deletion: ${filePath}"

        git rm "$filePath" --ignore-unmatch
        git commit -m "Auto-commit: Deleted $(Split-Path $filePath -Leaf)"
        git push origin $branch

        Write-Host "File deletion pushed to GitHub."
    }
}

# Register the event handlers
Register-ObjectEvent -InputObject $watcher -EventName "Created" -Action $action
Register-ObjectEvent -InputObject $watcher -EventName "Changed" -Action $action
Register-ObjectEvent -InputObject $watcher -EventName "Deleted" -Action $action

Write-Host "Press Ctrl+C to stop the script."
while ($true) { Start-Sleep -Seconds 1 }
