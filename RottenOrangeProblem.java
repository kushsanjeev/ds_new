/*

In a given grid, each cell can have one of three values:

	the value 0 representing an empty cell;
	the value 1 representing a fresh orange;
	the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

*/


class RottenOrangeProblem {
    public int orangesRotting(int[][] grid) {
        int C = grid[0].length;
        int R = grid.length;
        List<Integer> frontier = new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    frontier.add(i*C+j);
                }
            }
        }
        int[] sr = {-1,0,1,0};
        int[] sc = {0,1,0,-1};
        int hours=0;
        while(frontier.size()>0){
            List<Integer> next = new ArrayList<>();
            for(int val : frontier){
                int r = val/C;
                int c = val%C;
                for(int i=0;i<sr.length;i++){
                    int nr = r+sr[i];
                    int nc = c + sc[i];
                    if(nr>=0 && nr<R && nc>=0 && nc<C && grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        next.add(nr*C+nc);
                    }
                }
            }
            if(next.size()>0)
                hours+=1;
            frontier=next;
        }
          for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                   return -1;
                }
            }
        }
        return hours;
    }
}