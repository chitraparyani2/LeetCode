class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();

        int[] indegree = new int[numCourses];

        for(int i=0; i<numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        for(int[] prereq : prerequisites) {

            int p = prereq[0];
            int q = prereq[1];

            map.get(p).add(q);
            indegree[q]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<indegree.length; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {

            int course = queue.poll();

            for(int c : map.get(course)) {
                indegree[c]--;

                if(indegree[c] == 0) {
                    queue.add(c);
                }
            }
        }

        for(int i=0; i<indegree.length; i++) {
            if(indegree[i] != 0) {
                return false;
            }
        }

        return true;
    }
}