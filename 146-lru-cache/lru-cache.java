class LRUCache {

    class ListNode {

        int key;
        int val;

        ListNode next;
        ListNode prev;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public void addNode(ListNode node) {

        ListNode temp = head.next;

        head.next = node;
        node.next = temp;
        temp.prev = node;
        node.prev = head;
    }

    public void deleteNode(ListNode node) {

         node.next.prev = node.prev;
         node.prev.next = node.next;
    }

    ListNode head;
    ListNode tail;

    Map<Integer, ListNode> map;

    int capacity;

    public LRUCache(int capacity) {
        
        this.capacity = capacity;
        map = new HashMap<>(capacity);

        head = new ListNode(-1,-1);
        tail = new ListNode(-1,-1);

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        
        if(map.containsKey(key)) {

            ListNode node = map.get(key);
            deleteNode(node);
            addNode(node);

            return node.val;
        }

      return -1;  
    }
    
    public void put(int key, int value) {
        
        if(map.size() < capacity && !map.containsKey(key)) {

            ListNode node = new ListNode(key, value);
            addNode(node);
            map.put(key, node);
        } else if(map.size() <= capacity && map.containsKey(key)) {

            ListNode node = map.get(key);
            deleteNode(node);
            node.val = value;
            addNode(node);
            map.put(key, node);
        } else {

            ListNode node = tail.prev;
            deleteNode(node);

            ListNode newNode = new ListNode(key, value);
            addNode(newNode);

            map.put(key, newNode);
            map.remove(node.key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */