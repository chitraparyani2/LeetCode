class Solution {
    public boolean backspaceCompare(String s, String t) {
        
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for(int i=0; i<s.length(); i++) {

            char ch = s.charAt(i);

            if(ch != '#') {
                stack1.push(ch);
            } else {
                if(!stack1.isEmpty()) {
                    stack1.pop();
                }
            }
        }

        for(int j=0; j<t.length(); j++) {

            char ch = t.charAt(j);

            if(ch != '#') {
                stack2.push(ch);
            } else {
                if(!stack2.isEmpty()) {
                    stack2.pop();
                }
            }
        }

        while(!stack1.isEmpty() && !stack2.isEmpty()) {

            if(stack1.peek() != stack2.peek()) {
                return false;
            } else {
                stack1.pop();
                stack2.pop();
            }
        }
      return stack1.isEmpty() && stack2.isEmpty();  
    }
}