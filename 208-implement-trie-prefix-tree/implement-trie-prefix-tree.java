class Trie {

    class TrieNode {

        Map<Character, TrieNode> children;
        boolean isEnd;

        public TrieNode() {
            children = new HashMap();
            isEnd = false;
        }
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        
        TrieNode prev = root;
        int i = 0;

        while(i < word.length() && prev.children.containsKey(word.charAt(i))) {
            prev = prev.children.get(word.charAt(i));
            i++;
        }

        while(i < word.length() && !prev.children.containsKey(word.charAt(i))) {
            prev.children.put(word.charAt(i), new TrieNode());
            prev = prev.children.get(word.charAt(i));
            i++;
        }

        prev.isEnd = true;

    }
    
    public boolean search(String word) {
        
        TrieNode prev = root;

        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if(prev.children.containsKey(ch)) {
                prev = prev.children.get(ch);
            } else {
                return false;
            }
        }
      return prev.isEnd;  
    }
    
    public boolean startsWith(String prefix) {
        
        TrieNode prev = root;

         for(int i=0; i<prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if(prev.children.containsKey(ch)) {
                prev = prev.children.get(ch);
            } else {
                return false;
            }
        }
      return true;  
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */