class MyCircularQueue {

    int[] arr;
    int rear, front, size, k;

    public MyCircularQueue(int k) {
        
        this.k = k;
        arr = new int[k];
        this.rear=-1;
        this.front=-1;
        this.size=0;
    }
    
    public boolean enQueue(int value) {
        
        if(isFull()) {
            return false;
        }

        if(rear == k) {
            rear = 0;
        }

        if(rear == k && front == k) {
            rear = -1;
            front = -1;
        }

        if(front == -1 && rear == -1) {
            front = 0;
            rear = 0;
        }

        arr[rear] = value;
        rear +=1;
        size +=1;

      return true;  
    }
    
    public boolean deQueue() {
        
        if(isEmpty()) {
            return false;
        }
        
        if(front == k) {
            front = 0;
        }

        int value = arr[front];
        front += 1;
        size -= 1;

        return true;
    }
    
    public int Front() {
        
        if(isEmpty()) {
            return -1;
        }

        if(front == k) {
            front = 0;
        }

        return arr[front];
    }
    
    public int Rear() {
        
        if(isEmpty()) {
            return -1;
        }

        return arr[rear-1];
    }
    
    public boolean isEmpty() {
        
        if(size == 0) {
            return true;
        }
      return false;  
    }
    
    public boolean isFull() {
        
        if(size == k) {
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