class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] res = new int[numCourses];
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList();
        int ind = 0;

        for(int i=0; i<numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        for(int[] prereq : prerequisites) {

            int p = prereq[0];
            int q = prereq[1];

            map.get(q).add(p);
            indegree[p]++;
        }

        for(int i=0; i<numCourses; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {

            int val = queue.poll();
            res[ind++] = val;

            for(int v : map.get(val)) {
                indegree[v]--;
                if(indegree[v] == 0) {
                    queue.add(v);
                }
            }
        }

        for(int i=0; i<numCourses; i++) {
            if(indegree[i] != 0) {
                return new int[] {};
            }
        }

      return res;  
    }
}