class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ls = new ArrayList<String>();
        for(int i = 1; i <= n; i++) {
            ls.add(
                i % 3 == 0 && i % 5 == 0 ? "FizzBuzz" : i % 3 == 0 ? "Fizz" : i % 5 == 0 ? "Buzz": i + ""
            );
        }
        return ls;
    }
}