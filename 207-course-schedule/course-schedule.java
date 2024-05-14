class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        boolean[] visited = new boolean[numCourses];
        boolean[] inStack = new boolean[numCourses];

        for(int i=0; i<numCourses; i++) {
            adjList.put(i, new ArrayList());
        }

        for(int[] prereq : prerequisites) {

            int p0 = prereq[0];
            int p1 = prereq[1];

            adjList.get(p1).add(p0);
        }

        for(int i=0; i<numCourses; i++) {
            if(!helper(i, adjList, visited, inStack)) {
                return false;
            }
        }
      return true;  
    }

    public boolean helper(int s, Map<Integer, List<Integer>> adjList,
        boolean[] visited, boolean[] inStack) {

            if(inStack[s]) {
                return false;
            }
            
            if(visited[s]) {
                return true;
            }

            visited[s] = true;
            inStack[s] = true;

            for(int c : adjList.get(s)) {
                if(!helper(c, adjList, visited, inStack)){
                    return false;
                }
            }

            inStack[s] = false;

          return true;
        }
}