class Solution {

    int m=0,n=0;
    public int orangesRotting(int[][] grid) {
        
        Queue<int[]> queue = new LinkedList();

        m = grid.length;
        n = grid[0].length;
        int res =0;
        boolean flag=false;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {

                if(grid[i][j] == 2) {
                    queue.add(new int[]{i,j});
                }
            }
        }

        int[][] dir = {{-1,0},{0,1},{0,-1},{1,0}};

        while(!queue.isEmpty()) {
            
            int size = queue.size();
            
            if(!flag) {
                flag=true;
            } else {
                res++;
            }

            for(int i=0; i<size; i++) {

                int[] temp = queue.poll();

                for(int[] d : dir) {
                    int x=temp[0]+d[0];
                    int y=temp[1]+d[1];

                    if(x < 0 || y < 0 || x >= m || y >= n) {
                        continue;
                    }

                    if(grid[x][y] == 1) {
                        grid[x][y]=2;
                        System.out.println(x + "and" + y);
                        queue.add(new int[]{x,y});
                    }
                }
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }

      return res;  
    }
}