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

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void updateNode(ListNode node) {

        deleteNode(node);
        addNode(node);
    }

    ListNode head;
    ListNode tail;
    int capacity;
    Map<Integer, ListNode> map;

    public LRUCache(int capacity) {
        
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head = new ListNode(-1,-1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        
        if(map.containsKey(key)) {
            ListNode node = map.get(key);
            updateNode(node);
            return node.val;
        }
      return -1;  
    }
    
    public void put(int key, int value) {
        
           ListNode node = new ListNode(key, value);
        if(map.size() < capacity && !map.containsKey(key)) {

            addNode(node);
            map.put(key, node);

        } else if(map.size() <= capacity && map.containsKey(key)) {

            ListNode oldNode = map.get(key);
            deleteNode(oldNode);
            addNode(node);
            map.put(key, node);

        } else {

            int oldKey = tail.prev.key;
            ListNode oldNode = map.get(oldKey);
            deleteNode(oldNode);
            addNode(node);
            map.remove(oldNode.key);
            map.put(key, node);

        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */