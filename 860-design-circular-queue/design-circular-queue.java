class MyCircularQueue {

    class ListNode {

        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    int capacity;
    int count;
    ListNode head, tail;

    public MyCircularQueue(int k) {
        
        capacity = k;
        count = 0;
    }
    
    public boolean enQueue(int value) {
        
        if(isFull()) {
            return false;
        }

        ListNode node = new ListNode(value);

        if(count == 0) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
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