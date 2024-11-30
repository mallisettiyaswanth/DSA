class Solution:
    def isPalindrome(self, s: str) -> bool:
        n = "".join(s.lower().strip().split(" "))
        newS = ""
        for i in n:
            if i.isalnum():
                newS = newS + i

        if newS[::-1] == newS:
            return True
        else:
            return False
        
