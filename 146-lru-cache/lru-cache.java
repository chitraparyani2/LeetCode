class LRUCache {

    class Node {

        int key;
        int val;

        Node next;
        Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int capacity;

    Node pre;
    Node post;

    Map<Integer, Node> map = new HashMap<>(capacity);
    
    public void addNode(Node node) {

        Node next = pre.next;

        pre.next = node;
        node.next = next;
        node.next.prev = node;
        node.prev = pre;

    }

    public void deleteNode(Node node) {

        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public LRUCache(int capacity) {
        
        this.capacity = capacity;

        pre = new Node(-1, -1);
        post = new Node(-1, -1);

        pre.next = post;
        post.prev = pre;
    }
    
    public int get(int key) {

        if(map.containsKey(key)) {

            Node node = map.get(key);
            deleteNode(node);
            addNode(node);

            return node.val;
        }
      return -1;  
    }
    
    public void put(int key, int value) {
        
        if(map.size() < capacity && !map.containsKey(key)) {

            Node node = new Node(key, value);
            addNode(node);
            map.put(key, node);
        } else if(map.containsKey(key)) {

            Node node = map.get(key);
            node.val = value;
            deleteNode(node);
            addNode(node);
        } else {

            Node node = new Node(key, value);

            int k = post.prev.key;

            Node n = map.get(k);

            deleteNode(n);
            addNode(node);

            map.put(key, node);
            map.remove(k);

        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */