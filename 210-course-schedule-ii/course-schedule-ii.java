class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();

        int[] indegree = new int[numCourses];
        int[] result = new int[numCourses];

        for(int i=0; i<numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        for(int[] pre : prerequisites) {

            int p = pre[0];
            int q = pre[1];

            map.get(q).add(p);
            indegree[p]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<indegree.length; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        int index=0;

        while(!queue.isEmpty()) {

            int element = queue.poll();
            result[index++] = element;

            for(int e : map.get(element)) {
                indegree[e]--;

                if(indegree[e] == 0) {
                    queue.add(e);
                }
            }
        }

        for(int i=0; i<indegree.length; i++) {
            if(indegree[i] != 0) {
                return new int[]{};
            }
        }

      return result;  
    }
}