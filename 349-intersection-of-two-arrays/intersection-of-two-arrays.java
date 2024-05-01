class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        List<Integer> res = new ArrayList<>();

        Set<Integer> set = new HashSet();

        for(int num : nums1) {
            set.add(num);
        }

        for(int num : nums2) {
            if(set.contains(num)) {
                res.add(num);
                set.remove(num);
            }
        }

        int[] result = new int[res.size()];

        for(int i=0; i<res.size(); i++) {
            result[i] = res.get(i);
        }

      return result;  
    }
}