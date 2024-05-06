class Solution {
    public List<String> commonChars(String[] words) {
        
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> innerMap = new HashMap<>();
        String str = words[0];

        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);

            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        for(int i=1; i<words.length; i++) {

            String s = words[i];
            innerMap = new HashMap<>();

            for(int j=0; j<s.length(); j++) {

                char ch = s.charAt(j);

                if(map.containsKey(ch)) {
                    innerMap.put(ch, 
                    Math.min(map.get(ch),innerMap.getOrDefault(ch, 0)+1));
                }

            }

            map = innerMap;
        }

        List<String> res = new ArrayList<>();

        for(char ch : innerMap.keySet()) {
            
            if(innerMap.get(ch) > 1) {

                int l = map.get(ch);

                while(l > 0) {
                     res.add(ch + "");
                     l--;
                }
            } else 
            res.add(ch + "");
        }

      return res;  
    }
}