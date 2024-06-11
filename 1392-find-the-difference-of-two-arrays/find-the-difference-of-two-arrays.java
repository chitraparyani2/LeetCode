class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        
        List<List<Integer>> res = new ArrayList();
        List<Integer> list1 = new ArrayList();
        List<Integer> list2 = new ArrayList();

        // Map<Integer, Integer> map1 = new HashMap();
        // Map<Integer, Integer> map2 = new HashMap();

        Set<Integer> set1 = new HashSet();
        Set<Integer> set2 = new HashSet();

        for(int num : nums1) {
            // map1.put(num, map1.getOrDefault(num,0)+1);
            set1.add(num);
        }

        for(int num : nums2) {
           // map2.put(num, map2.getOrDefault(num,0)+1);
           set2.add(num);
        }

        for(int num : nums1) {
            if(!set2.contains(num) && !list1.contains(num)) {
                list1.add(num);
            }
        }

        for(int num : nums2) {
            if(!set1.contains(num) && !list2.contains(num)) {
                list2.add(num);
            }
        }

        res.add(list1);
        res.add(list2);

      return res;  
    }
}