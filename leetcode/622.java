class MyCircularQueue {
    private int rear, front;
    private int[] q;
    private int size;

    public MyCircularQueue(int k) {
        rear = k -1;
        size = 0;
        q = new int[k];
    }
    
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        ++size;
        q[rear = (rear + 1) % q.length] = value;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        --size;
        return true;
    }
    
    public int Front() {
        return isEmpty() ? (-1) : q[(rear - size + 1 + q.length) % q.length];
    }
    
    public int Rear() {
        return isEmpty() ? (-1) : q[rear];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == q.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */