class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int max=0, sum=0, count=0;
        boolean flag = false;

        int i=0, j=cardPoints.length;

        while(i < j) {

            if(i < k && count < k && !flag) {
                sum += cardPoints[i];
                count++;
                i++;
                if(count == k)
                    flag=true;
            } else if(count > 0) {
                count--;
                sum -= cardPoints[--i];
                sum += cardPoints[--j];
            } else {
                break;
            }
            max = Math.max(max, sum);
        }

      return Math.max(max, sum);  
    }
}