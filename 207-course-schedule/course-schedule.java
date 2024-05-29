class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        boolean[] visited = new boolean[numCourses];
        boolean[] inStack = new boolean[numCourses];

        for(int i=0; i<numCourses; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for(int[] prereq : prerequisites) {

            int c1 = prereq[0];
            int c2 = prereq[1];

            adjList.get(c1).add(c2);
        }

        for(int i=0; i<numCourses; i++) {
            boolean res = isCycle(i, adjList, visited, inStack);
            if(!res) {
                return false;
            }
        }
      return true;  
    }

    public boolean isCycle(int c, Map<Integer, List<Integer>> adjList,
        boolean[] visited, boolean[] inStack) {

            if(inStack[c]) {
                return false;
            }
            
            if(visited[c]) {
                return true;
            }

            visited[c] = true;
            inStack[c] = true;

            for(int s : adjList.get(c)) {
                boolean res = isCycle(s, adjList, visited, inStack);
                if(!res) {
                    return false;
                }
            }

            inStack[c] = false;

          return true;  
        }
}