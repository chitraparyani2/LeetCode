class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        int n = candidates.length;
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        boolean[] used = new boolean[n];

        helper(candidates, target, res, tempList, used, 0);

        return res;
    }

    public void helper(int[] nums, int target, List<List<Integer>> res,
        List<Integer> tempList, boolean[] used, int st) {

            if(target < 0) {
                return;
            }

            if(target == 0) {
                res.add(new ArrayList<>(tempList));
                return;
            }

            for(int i=st; i<nums.length; i++) {

                if(i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
                    continue;
                }

                tempList.add(nums[i]);
                used[i] = true;
                target -= nums[i];

                helper(nums, target, res, tempList, used, i+1);

                tempList.remove(tempList.size()-1);
                used[i] = false;
                target += nums[i];

            }
        }
}