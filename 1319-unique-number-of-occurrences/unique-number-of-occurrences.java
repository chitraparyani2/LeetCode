class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        
        Map<Integer, Integer> countMap = new HashMap();
        Set<Integer> set = new HashSet();

        for(int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0)+1);
        }

        for(int key : countMap.keySet()) {
            int val = countMap.get(key);
            if(set.contains(val)) {
                return false;
            }
            set.add(val);
        }
      
      return true;
    }
}