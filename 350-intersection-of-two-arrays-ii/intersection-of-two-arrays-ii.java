class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i=0, j=0;
        int n1=nums1.length, n2=nums2.length;

        List<Integer> res = new ArrayList<>();

        while(i < n1 && j < n2) {

            if(nums1[i] < nums2[j]) {
                i++;
            } else if(nums1[i] > nums2[j]) {
                j++;
            } else {
                res.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] result = new int[res.size()];
        int ind=0;

        for(int num : res) {
            result[ind++] = num;
        }

      return result;  
    }
}