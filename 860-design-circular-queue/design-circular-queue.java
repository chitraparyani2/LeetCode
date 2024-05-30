class MyCircularQueue {

    int[] arr;
    int front;
    int rear;
    int count;
    int capacity;

    public MyCircularQueue(int k) {
        
        capacity = k;
        arr = new int[k];
        front=0;
        rear=0;
        count=0;
    }
    
    public boolean enQueue(int value) {
        
        if(isFull()) {
            return false;
        }

        arr[rear%capacity] = value;
        rear++;
        count++;

      return true;  
    }
    
    public boolean deQueue() {
        
        if(isEmpty()) {
            return false;
        }

        front++;
        count--;
      return true;  
    }
    
    public int Front() {
        
        if(isEmpty()) {
            return -1;
        }
        return arr[front%capacity];
    }
    
    public int Rear() {
        
        if(isEmpty()) {
            return -1;
        }
        
        return arr[(rear-1)%capacity];
    }
    
    public boolean isEmpty() {
        
        if(count == 0) {
            return true;
        }
      return false;  
    }
    
    public boolean isFull() {
        
        if(count == capacity) {
            return true;
        }
      return false;  
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