class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        for(int i=0; i<n; i++) {

            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int j=i+1, k=n-1;

            while(j < k) {

                int sum = nums[i] + nums[j] + nums[k];

                if(sum == 0) {

                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(nums[i]);
                    tempList.add(nums[j]);
                    tempList.add(nums[k]);

                    result.add(tempList);

                    j++;
                    k--;

                    while(j < k && nums[j] == nums[j-1]) {j++;}
                    while(k > j && nums[k] == nums[k+1]) {k--;}

                } else if(sum > 0) {
                    k--;
                } else {
                    j++;
                }

            }
        }
      return result;  
    }
}