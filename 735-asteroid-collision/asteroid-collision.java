class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> stack = new Stack();

        for(int i=0; i<asteroids.length; i++) {

            if(stack.isEmpty()) {
                stack.push(asteroids[i]);
            } else if(asteroids[i] > 0 && stack.peek() > 0 ||
                asteroids[i] < 0 && stack.peek() < 0) {
                stack.push(asteroids[i]);
            } else if(stack.peek() < 0 && asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else {
                boolean flag = false;
                while(!stack.isEmpty()) {
                    
                    if(stack.peek() > 0 && asteroids[i] < 0) {
                        int prev = Math.abs(stack.peek());
                        int curr = Math.abs(asteroids[i]);

                        if(prev > curr) {
                            flag = true;
                            break;
                        } else if(prev == curr) {
                            flag = true;
                            stack.pop();
                            break;
                        } else if(prev < curr) {
                            stack.pop();
                            }
                    } else {
                        break;
                    }
                }

                if(!flag) {
                    stack.push(asteroids[i]);
                }    
                
            }
        }

        int n = stack.size();
        int[] res = new int[n];

        while(!stack.isEmpty()) {
            res[--n] = stack.pop();
        }

       return res; 
    }
}