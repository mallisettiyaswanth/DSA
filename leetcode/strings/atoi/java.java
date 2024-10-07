class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }
        StringBuilder str = new StringBuilder();
        int neg = 1;
        int i = 0;
        if (s.charAt(i) == '-') {
            neg = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }
        while (i < s.length() && s.charAt(i) == '0') {
            i++;
        }
        int ret = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            char c = s.charAt(i);
            int digit = c - '0';
            if (ret > (Integer.MAX_VALUE - digit) / 10) {
                return neg == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ret = ret * 10 + digit;
            i++;
        }

        return ret * neg;
    }
}
