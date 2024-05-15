class Solution {
    public String decodeString(String s) {
        
        Stack<Integer> countStack = new Stack<>();
        Stack<Character> charStack = new Stack<>();

        int digit = 0;
        for(int i=0; i<s.length(); i++) {

            char ch = s.charAt(i);

            if(Character.isDigit(ch)) {
                digit = digit * 10 + ch - '0';
            } else if(ch == '[') {
                countStack.push(digit);
                digit = 0;
                charStack.push(ch);
            } else if(ch == ']') {
                evaluate(countStack, charStack);
            } else {
                charStack.push(ch);
            }
        }

        StringBuilder res = new StringBuilder();

        while(!charStack.isEmpty()) {
            res.append(charStack.pop());
        }

      return res.reverse().toString();  
    }

    public void evaluate(Stack<Integer> countStack, 
                                Stack<Character> charStack) {

            
            StringBuilder sb = new StringBuilder();
            StringBuilder sb1 = new StringBuilder();
            int count = countStack.pop();

            while(charStack.peek() != '[') {
                sb.append(charStack.pop());
            }

            charStack.pop();
            sb.reverse();

            for(int i=0; i<count; i++) {
                sb1.append(sb.toString());
            }

            String s = sb1.toString();

            for(int i=0; i<s.length(); i++) {
                charStack.push(s.charAt(i));
            }
    }
}