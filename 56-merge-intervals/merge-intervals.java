class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>(){

            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        List<int[]> result = new ArrayList<>();

        for(int[] interval : intervals) {

            if(result.size() == 0) {
                result.add(interval);
            } else if(interval[0] <= result.getLast()[1]) {
                result.getLast()[1] = Math.max(result.getLast()[1], interval[1]);
            } else {
                result.add(interval);
            }
        }
        
       // System.out.println(Arrays.asList(result));

        return result.toArray(new int[result.size()][]);
    }
}