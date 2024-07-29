
class MyQueue {
    ArrayList<Integer> arr;

    public MyQueue() {
        arr = new ArrayList<Integer>();
    }
    
    public void push(int x) {
        arr.add(x);
    }
    
    public int pop() {
        return arr.remove(0);
    }
    
    public int peek() {
        return arr.get(0);
    }
    
    public boolean empty() {
        return arr.isEmpty();
    }
}
