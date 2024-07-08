class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> numStack = new Stack();
        Stack<String> opStack = new Stack();

        for(int i=0; i<tokens.length; i++) {

            String token = tokens[i];

            if(token.equals("+")) {

                int num2 = numStack.pop();
                int num1 = numStack.pop();
                numStack.push(num1 + num2);

            } else if(token.equals("-")) {
                
                int num2 = numStack.pop();
                int num1 = numStack.pop();
                numStack.push(num1 - num2);

            } else if(token.equals("*")) {

                int num2 = numStack.pop();
                int num1 = numStack.pop();
                numStack.push(num1 * num2);

            } else if(token.equals("/")) {

                int num2 = numStack.pop();
                int num1 = numStack.pop();
                numStack.push(num1 / num2);

            } else {
                
                numStack.push(Integer.valueOf(token));
            }
        }

      return numStack.pop();  
    }
}