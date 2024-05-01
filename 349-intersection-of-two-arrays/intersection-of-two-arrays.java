class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i=0, j=0;
        int n1 = nums1.length;
        int n2 = nums2.length;

        List<Integer> res = new ArrayList<>();

        while(i < n1 && j < n2) {

            if(nums1[i] < nums2[j]) {
                i++;
            } else if(nums1[i] > nums2[j]) {
                j++;
            } else {
                if(!res.contains(nums1[i])) {
                    res.add(nums1[i]);
                }

                i++;j++;
            }
        }

        int[] result = new int[res.size()];

        for(int k=0; k<result.length; k++) {
            result[k] = res.get(k);
        }

      return result;  
    }
}