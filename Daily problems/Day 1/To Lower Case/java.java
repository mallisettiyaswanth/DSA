import java.util.*;
class Solution {
    public String toLowerCase(String s) {
        StringBuilder str = new StringBuilder();
        for(char ch: s.toCharArray()) {
            if(ch >= 65 && ch <= 90) {
                char newChar = (char) (ch + 32);
                str.append(newChar);
            } else {
                str.append(ch);
            }
        }
        return str.toString();
    }
}


// ascii characters of A is 65 and Z is 90 
// ascii characters of a is 97 and z is 112