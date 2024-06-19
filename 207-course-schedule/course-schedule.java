class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();

        boolean[] visited = new boolean[numCourses];
        boolean[] inStack = new boolean[numCourses];

        for(int i=0; i<numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        for(int[] prereq : prerequisites) {

            int p = prereq[0];
            int q = prereq[1];

            map.get(q).add(p);
        }

        for(int i=0; i<numCourses; i++) {
            if(!helper(i, map, visited, inStack)) {
                return false;
            }
        }
      return true;  
    }

    public boolean helper(int st, Map<Integer, List<Integer>> map,
        boolean[] visited, boolean[] inStack) {

            if(inStack[st]) {
                return false;
            }

            if(visited[st]) {
                return true;
            }

            visited[st] = true;
            inStack[st] = true;

            for(int s : map.get(st)) {
                if(!helper(s, map, visited, inStack)) {
                    return false;
                }
            }
            
            inStack[st] = false;
        return true;  
    }
}