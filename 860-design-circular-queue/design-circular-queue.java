class MyCircularQueue {

    class Node {

        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    Node head, tail;
    int capacity;
    int count;

    public MyCircularQueue(int k) {
        capacity = k;
        count = 0;
    }
    
    public boolean enQueue(int value) {
        
        if(isFull()) {
            return false;
        }

        if(count == 0) {
            head = tail = new Node(value);
        } else {
            tail.next = new Node(value);
            tail = tail.next;
        }

        count++;
      return true;  
    }
    
    public boolean deQueue() {
        
        if(isEmpty()) {
            return false;
        }

        head = head.next;
        count--;
      return true;  
    }
    
    public int Front() {
        
        if(isEmpty()) {
            return -1;
        }
      return head.val;  
    }
    
    public int Rear() {
        
        if(isEmpty()) {
            return -1;
        }
      return tail.val;  
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