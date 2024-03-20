class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> tempList = new ArrayList<>();

        boolean[] used = new boolean[nums.length];

        helper(nums, result, tempList, used);

        return result;
    }

    public void helper(int[] nums, List<List<Integer>> result, 
        List<Integer> tempList, boolean[] used) {

            if(nums.length == tempList.size()) {
                result.add(new ArrayList<>(tempList));
            }

            for(int i=0; i<nums.length; i++) {

                if(i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
                    continue;
                }

                if(used[i]) {
                    continue;
                }

                tempList.add(nums[i]);
                used[i] = true;

                helper(nums, result, tempList, used);

                tempList.remove(tempList.size()-1);
                used[i] = false;
            }
        }
}