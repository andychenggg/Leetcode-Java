package Stack.Leetcodes;

class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        boolean [][] visit = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(visit[i][j]) continue;
                else if(grid[i][j] == '0'){
                    visit[i][j] = true;
                }
                else {
                    dfs(grid, i, j, visit);
                    res++;
                }
            }
        }
        return res;

    }

    public void dfs(char[][] grid, int i, int j, boolean [][] visit){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visit[i][j] || grid[i][j] == '0') return;

        visit[i][j] = true;

        dfs(grid, i+1, j, visit);
        dfs(grid, i, j+1, visit);
        dfs(grid, i-1, j, visit);
        dfs(grid, i, j-1, visit);
    }
}