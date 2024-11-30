class Solution {
    public boolean isPalindrome(String s) {
        String n = s.toLowerCase().replace(" ", "");
        StringBuilder str = new StringBuilder();
        for(char ch: n.toCharArray()) {
            if(Character.isLetterOrDigit(ch)) {
                str.append(ch);
            }
        }
        String original = str.toString();
        String reverse = str.reverse().toString();
        return original.equals(reverse);
    }
}