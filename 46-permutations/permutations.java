class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        helper(nums, result, tempList);

        return result;
    }

    public void helper(int[] nums, List<List<Integer>> result, 
        List<Integer> tempList) {

            if(tempList.size() == nums.length) {
                result.add(new ArrayList<>(tempList));
                return;
            }

            for(int i=0; i<nums.length; i++) {

                if(tempList.contains(nums[i])) {
                    continue;
                }

                tempList.add(nums[i]);
                helper(nums, result, tempList);
                tempList.remove(tempList.size()-1);
        }
    }
}