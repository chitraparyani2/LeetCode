class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
         Map<Integer, List<Integer>> adjList = new HashMap<>();
         int[] indegree = new int[numCourses];
         Queue<Integer> queue = new LinkedList<>();

         for(int i=0; i<numCourses; i++) {
            adjList.put(i, new ArrayList<>());
         }

         for(int[] prereq : prerequisites) {

            int p0 = prereq[0];
            int p1 = prereq[1];

            adjList.get(p0).add(p1);

            indegree[p1]++;
         }

         for(int i=0; i<numCourses; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
         }

         while(!queue.isEmpty()) {

            int temp = queue.poll();

            for(int c : adjList.get(temp)) {
                indegree[c]--;

                if(indegree[c] == 0) {
                    queue.add(c);
                }
            }
         }

         for(int i=0; i<numCourses; i++) {
            if(indegree[i] != 0) {
                return false;
            }
         }

        return true;
    }
}