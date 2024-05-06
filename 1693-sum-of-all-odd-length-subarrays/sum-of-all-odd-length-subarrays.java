class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        
        int sum=0;

        int count=0, n=arr.length;

        for(int i=0; i<n; i++) {

            sum += arr[i];
            count=1;
            int innersum = arr[i];

            for(int j=i+1; j<n; j++) {

                count++;
                innersum += arr[j];
                if(count%2 != 0) {
                    sum += innersum;
                }
            }
            
            innersum = 0;
        }

      return sum;  
    }
}