class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums1.length; i++) {
            map.put(nums1[i], i);
        }

        int[] res = new int[n];

        for(int j=0; j<nums2.length; j++) {

            if(map.containsKey(nums2[j])) {
                int ind = map.get(nums2[j]);
                int val = checkNextGreatest(j, nums2[j], nums2);
                res[ind] = val;
            }
        }

      return res;  
    }

    public int checkNextGreatest(int ind, int val, int[] nums) {

        int res = Integer.MAX_VALUE;

        for(int i=ind; i<nums.length; i++) {

            if(nums[i] > val) {
                res = nums[i];
                break;
            }
        }
      return res == Integer.MAX_VALUE ? -1 : res;  
    }
}