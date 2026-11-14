package Months.Oct_2026;

public class practice_dfs {
    public static void main(String[] args) {
        System.out.println(countGroup(new int[][]{{0, 0, 1},{1, 0, 1},{1, 1, 0}}));

    }
    public static int  countGroup(int [][] grid){
        int count = 0;
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == 0 && !visited[r][c]){
                    count++;
                    dfs(grid, visited, r, c);
                }
            }
        }
        return count;
    }
    private static void dfs(int[][] grid, boolean[][] visited, int r, int c) {
        int rows = grid.length, cols = grid[0].length;
        // stop if outside the grid
        if(r < 0 || r >= rows || c < 0 || c >= cols){
            return;
        }
        //stop if the water or already visited
        if(grid[r][c] == 1 || visited[r][c]){
            return;
        }
        //mark current cell visited
        visited[r][c] = true;
        dfs(grid, visited, r-1, c); // up
        dfs(grid, visited, r+1, c); // down
        dfs(grid, visited, r, c-1); // left
        dfs(grid, visited, r, c+1); // right
    }
}
