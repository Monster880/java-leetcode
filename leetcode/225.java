class MyStack {

    private Queue<Integer>[] q;

    private int getInd(){
        return q[0].isEmpty()? 1 : 0;
    }

    /** Initialize your data structure here. */
    public MyStack() {
        q = new Queue[2];
        for(int i=0;i<2;i++){
            q[i] = new LinkedList<>();
        }
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q[getInd()].add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int ind = getInd();
        for(; q[ind].size() > 1; q[ind ^ 1].add(q[ind].poll()));
        return q[ind].poll();
    }
    
    /** Get the top element. */
    public int top() {
        int r = pop();
        push(r);
        return r;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q[0].isEmpty() && q[1].isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */