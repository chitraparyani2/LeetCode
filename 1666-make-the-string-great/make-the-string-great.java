class Solution {
    public String makeGood(String s) {

     if(s.length() == 0) {
        return s;
     }   

     Stack<Character> stack = new Stack();
     int i=0;

     while(i < s.length()) {

        Character ch = s.charAt(i);

        if(!stack.isEmpty() && Character.isUpperCase(ch) && stack.peek().equals(Character.toLowerCase(ch))) {
            stack.pop();
         } else if(!stack.isEmpty() && Character.isLowerCase(ch) && stack.peek().equals(Character.toUpperCase(ch))) {
            stack.pop();
        } else {
            stack.push(ch);
        }

        i++;
     }

     StringBuilder sb = new StringBuilder();

     while(!stack.isEmpty()) {
        sb.append(stack.pop());
     }

     return sb.reverse().toString();
    }
}