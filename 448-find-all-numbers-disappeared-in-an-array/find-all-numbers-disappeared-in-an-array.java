class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> res = new ArrayList<>();

        Set<Integer> set = new HashSet<>();

        for(int num : nums) {
            set.add(num);
        }

        int ind=0;

        while(ind < nums.length) {

            if(!set.contains(ind+1)) {
                res.add(ind+1);   
            }
             ind++;
        }

      return res;  
    }
}