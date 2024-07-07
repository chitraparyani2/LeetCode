class Solution {

    class UnionFind {

        int[] parent;
        int[] rank;
        int count = 0;

        public UnionFind(char[][] grid) {

            int m = grid.length;
            int n = grid[0].length;

            parent = new int[m*n];
            rank = new int[m*n];

            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {

                    if(grid[i][j] == '1') {
                        parent[i*n+j] = i*n+j;
                        count++;
                        rank[i*n+j] = 0;
                    }
                }
            }
        }

        public int findParent(int x) {

            if(x != parent[x]) {
                return findParent(parent[x]);
            }
          return parent[x];  
        }

        public void union(int x, int y) {

            int rootX = findParent(x);
            int rootY = findParent(y);

            if(rootX != rootY) {

                if(rank[rootX] >= rank[rootY]) {
                    rank[rootX]++;
                    parent[rootY] = rootX;
                } else {
                    rank[rootY]++;
                    parent[rootX] = rootY;
                }
                count--; 
            }
           
        }

        public int getCount() {
            return count;
        }
    }

    public int numIslands(char[][] grid) {
        
        UnionFind uf = new UnionFind(grid);

        int m = grid.length;
        int n = grid[0].length;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {

                if(grid[i][j] == '1') {
                    grid[i][j] = '0';
                    if(i-1 >= 0 && grid[i-1][j] == '1') {
                        uf.union(i*n+j, (i-1)*n+j);
                    }

                    if(i+1 < m && grid[i+1][j] == '1') {
                        uf.union(i*n+j, (i+1)*n+j);
                    }

                    if(j-1 >= 0 && grid[i][j-1] == '1') {
                        uf.union(i*n+j, i*n+j-1);
                    }

                    if(j+1 < n && grid[i][j+1] == '1') {
                        uf.union(i*n+j, i*n+j+1);
                    }
                }
            }
        }

      return uf.count;  
    }
}