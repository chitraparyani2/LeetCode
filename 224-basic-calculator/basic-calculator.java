class Solution {
    public int calculate(String s) {
        
        Stack<Integer> stack = new Stack<>();

        int res=0, num=0, sign=1;

        for(int i=0; i<s.length(); i++) {

            char ch = s.charAt(i);

            if(ch == ' ') {
                continue;
            } else if(Character.isDigit(ch)) {
                num = num*10 + (ch - '0');
            } else if(ch == '+') {
                res += num*sign;
                num=0;
                sign=1;
            } else if(ch == '-') {
                res += num*sign;
                num=0;
                sign=-1;
            } else if(ch == '(') {
                stack.push(res);
                stack.push(sign);
                
                res = 0;
                num=0;
                sign=1;
            } else if(ch == ')') {
                res += num*sign;
                res *= stack.pop();
                res += stack.pop();
                num=0;
                sign=1;
            }
        }

        if(num != 0) {
            res += num*sign;
        }

      return res;  
    }
}