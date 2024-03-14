class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> tempList = new ArrayList<>();

        helper(candidates, target, res, tempList, 0);

        return res;
    }

    public void helper(int[] can, int target, List<List<Integer>> res, 
        List<Integer> tempList, int st) {

            if(target < 0) {
                return;
            }

            if(target == 0) {
                res.add(new ArrayList<>(tempList));
                return;
            }

            for(int i=st; i<can.length; i++) {
                target -= can[i];
                tempList.add(can[i]);
                helper(can, target, res, tempList, i);
                target += can[i];
                tempList.remove(tempList.size()-1);
            }
        }
}