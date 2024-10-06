class Solution(object):
    def reverseKGroup(self, head, k):
        l = []
        temp = head
        while temp :
            l.append(temp.val)
            temp = temp.next
        
        new = []
        i = 0
        while(i < len(l)):
            j = []
            if(len(l) - i < k):
                j = l[i:]
            else:
                j = l[i:i+k]
                j.reverse()
            new.extend(j)
            i = i + k

        temp = head
        i = 0
        while temp:
            temp.val = new[i]
            i = i + 1
            temp = temp.next
        
        return head


        