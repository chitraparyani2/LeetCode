class Solution {
    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        helper(n, k, res, list, 1);

      return res;  
    }

    public void helper(int n, int k, List<List<Integer>> res, 
        List<Integer> temp, int st) {

            if(temp.size() == k) {
                res.add(new ArrayList<>(temp));
                return;
            }

            for(int i=st; i<=n; i++) {
                temp.add(i);
                helper(n, k, res, temp, i+1);
                temp.remove(temp.size()-1);
            }
        }
}