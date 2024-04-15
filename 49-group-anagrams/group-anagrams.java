class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
       // List<List<String>> res = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {

            char[] chArray = str.toCharArray();
            Arrays.sort(chArray);
            String s = new String(chArray);

            if(!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(str);
        }

        return new ArrayList<>(map.values());
    }
}