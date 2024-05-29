class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList();

        int[] res = new int[numCourses];
        int s=0;

        for(int i=0; i<numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        for(int[] prereq : prerequisites) {

            int c1 = prereq[0];
            int c2 = prereq[1];

            map.get(c2).add(c1);
            indegree[c1]++;
        }

        for(int i=0; i<numCourses; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {

            int course = queue.poll();
            res[s++] = course;

            for(int d : map.get(course)) {

                indegree[d]--;

                if(indegree[d] == 0) {
                    queue.add(d);
                }
            }
        }

        for(int i=0; i<numCourses; i++) {
            if(indegree[i] != 0) {
                return new int[]{};
            }
        }

      return res;  
    }
}