class Solution {
    int index=0;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();

        boolean[] visited = new boolean[numCourses];
        boolean[] inStack = new boolean[numCourses];
        int[] res = new int[numCourses];

        for(int i=0; i<numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        for(int[] pre : prerequisites) {

            int subject = pre[0];
            int depSubj = pre[1];
            
            map.get(subject).add(depSubj);
        }

        for(int i=0; i<numCourses; i++) {

            boolean r = helper(i, map, visited, inStack, res);
            if(!r) {
                return new int[]{};
            }
        }
       return res; 
    }

    public boolean helper(int course, Map<Integer, List<Integer>> map,
            boolean[] visited, boolean[] inStack, int[] res) {

                if(inStack[course]) {
                    return false;
                }

                if(visited[course]) {
                    return true;
                }

                visited[course] = true;
                inStack[course] = true;

                for(int c : map.get(course)) {
                    if(!helper(c, map, visited, inStack, res)) {
                        return false;
                    }
                }

                inStack[course] = false;
                res[index++] = course;

            return true;
        }
}