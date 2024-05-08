class Solution {
    public String[] findRelativeRanks(int[] score) {
        
        int n = score.length;
        Integer[] res = new Integer[n];

         for(int i=0; i<score.length; i++) {
            res[i] = score[i];
        }

        Arrays.sort(res, Collections.reverseOrder());

        Map<Integer, String> map = new HashMap<>();

        for(int i=0; i<res.length; i++) {

            if(i==0) {
                map.put(res[i], "Gold Medal");
            } else if(i == 1) {
                map.put(res[i], "Silver Medal");
            } else if(i == 2) {
                map.put(res[i], "Bronze Medal");
            } else {
                map.put(res[i], i+1 + 
                "");
            }
        }

        String[] result = new String[n];

        for(int i=0; i<score.length; i++) {
            result[i] = map.get(score[i]);
        }

      return result;  
    }
}