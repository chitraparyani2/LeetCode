class Solution {
    public int calculate(String s) {
        
        int num = 0;
        char operator = '+';
        int res = 0;

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<s.length(); i++) {

            char ch = s.charAt(i);

            if(Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            if((!Character.isDigit(ch) && !Character.isWhitespace(ch)) || i == s.length()-1) {

                if(operator == '+') {
                    stack.push(num);
                } else if(operator == '-') {
                    stack.push(-1 * num);
                } else if(operator == '*') {
                    stack.push(stack.pop() * num);
                } else if(operator == '/') {
                    stack.push(stack.pop() / num);
                }

                    num=0;
                    operator = ch;
            }
        }

      while(!stack.isEmpty()) {
        res += stack.pop();
      }

      return res;  
    }
}