class Solution {
    public String decodeString(String s) {
        
        Stack<Integer> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        int num = 0;
        StringBuilder res = new StringBuilder();
        for(int i=0; i<s.length(); i++) {

            char ch = s.charAt(i);

            if(Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if(ch == '[') {
                stack1.push(num);
                num=0;
                stack2.push(ch);
            } else if(ch == ']') {
                solve(stack1, stack2);
            } else {
                stack2.push(ch);
            }
        }

        while(!stack2.isEmpty()) {
            res.append(stack2.pop());
        }
      return res.reverse().toString();  
    }

    public void solve(Stack<Integer> stack1, Stack<Character> stack2) {

        int val=stack1.pop();
        StringBuilder sb = new StringBuilder();

        while(!stack2.peek().equals('[')) {
            sb.append(stack2.pop());
        }

        stack2.pop();
        sb.reverse();

        String res = evaluate(val, sb.toString());

        for(int i=0; i<res.length(); i++) {
            char ch = res.charAt(i);
            stack2.push(ch);
        }
    }

    public String evaluate(int val, String s) {

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<val; i++) {
            sb.append(s);
        }
      return sb.toString();  
    }
}