class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        
        m = --m;
        n = --n;
        int index = m+n+1;

        while(m >= 0 || n >= 0) {

            while(m >= 0 && n >= 0) {
                if(nums1[m] >= nums2[n])
                    nums1[index--] = nums1[m--];
                else 
                    nums1[index--] = nums2[n--];
            }

            while(n >= 0) {
                nums1[index--] = nums2[n--];
            }
            m--;
        }
    }
}