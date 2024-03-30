class Solution {
    public String addBinary(String a, String b) {
        
        StringBuilder sb = new StringBuilder();

        int m = a.length();
        int n = b.length();

        int carry = 0, val1=0, val2=0;

        while(m > 0 || n > 0) {

            if(m > 0) {
                val1 = Integer.valueOf(a.charAt(m-1)) - '0';
            } else {
                val1 = 0;
            }

            if(n > 0) {
                val2 = Integer.valueOf(b.charAt(n-1)) - '0';
            } else {
                val2 = 0;
            }

            int sum = val1 + val2 + carry;

            sb.append(sum%2);
            carry = sum/2;

            m--;
            n--;

        }

        if(carry > 0) {
            sb.append(carry);
        }

       return sb.reverse().toString(); 
    }
}