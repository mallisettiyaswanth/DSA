class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder strBul = new StringBuilder();
        int openParanthesis = 0;
        for(Character ch: s.toCharArray()) {
            if(ch == '(') {
                if(openParanthesis > 0) {
                    strBul.append(ch);
                }
                openParanthesis++;
            } else {
                openParanthesis--;
                if(openParanthesis > 0) {
                    strBul.append(ch);
                }
            }
        }


        return strBul.toString();
    }
}
