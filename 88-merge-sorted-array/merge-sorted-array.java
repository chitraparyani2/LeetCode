class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int l1=m-1, l2=n-1;

        int index = m+n;

        while(l1 >= 0 || l2 >= 0) {
            
            if(l1 >= 0 && l2 >= 0 && nums1[l1] >= nums2[l2]) {
                nums1[--index] = nums1[l1];
                l1--;
            } else if(l2 >= 0) {
                nums1[--index] = nums2[l2];
                l2--;
            } else {
                l1--;
            }
        }

    }
}