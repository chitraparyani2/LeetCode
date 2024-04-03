class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] inStack = new boolean[numCourses];

        for(int i=0; i<numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        for(int[] pre : prerequisites) {

            int p = pre[0];
            int q = pre[1];

            map.get(q).add(p);
        }

        for(int i=0; i<numCourses; i++) {
            boolean res = helper(i, map, visited, inStack);
                if(!res) {
                return false;
                }
            }
      return true;  
    }

    public boolean helper(int course, Map<Integer, List<Integer>> map,
            boolean[] visited, boolean[] inStack) {

                if(inStack[course]) {
                    return false;
                }

                if(visited[course]) {
                    return true;
                }

                visited[course] = true;
                inStack[course] = true;

                for(int c : map.get(course)) {
                    if(!helper(c, map, visited, inStack)) {
                        return false;
                    }
                }

                inStack[course] = false;

       return true;
    }
}