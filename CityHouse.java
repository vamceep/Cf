import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;


class CityHouse {
    ArrayList[][] dp;
    public int shortestDistance(int[][] grid) {
        int r = grid.length;
        if(r == 0) return -1;
        int c = grid[0].length;
        if(c == 0) return -1;
        
        int cnt = 0;
        for(int[] arr : grid)
        for(int ar : arr) {
            if(ar == 1) cnt++;
        }
        dp = new ArrayList[r][c];
        for(int i = 0; i < r; i++)
        for(int j = 0; j < c; j++)
            if(grid[i][j] == 0)
                dp[i][j] = new ArrayList<Long>();
        for(int i = 0; i < r; i++)
        for(int j = 0; j < c; j++) {
            if(grid[i][j] == 1) {
                bfs(i,j, grid);
            }
            
        }
        long ans = Integer.MAX_VALUE;
        for(int i = 0; i < r; i++)
        for(int j = 0; j < c; j++) {
            if(grid[i][j] != 0 || dp[i][j].size() != cnt) continue;
            long cs = 0l;
            ArrayList<Long> al = dp[i][j];
            for(int k = 0;k < cnt; k++) {
                cs += al.get(k);
            }
            ans = Math.min(ans, cs);
        }
        return ans == Integer.MAX_VALUE?-1:(int)ans;
    }
    
    private void bfs(int x, int y, int[][] g) {
        Queue<Integer> xs = new LinkedList<Integer>();
        Queue<Integer> ys = new LinkedList<Integer>();
        g[x][y] += 10;
        int[][] cnfg = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        xs.offer(x);
        ys.offer(y);
        int dist = 0;
        int size = 1;
        while(xs.size() != 0) {
            x = xs.poll();
            y = ys.poll();
            size--;
            for(int i = 0; i < 4; i++) {
                int nx = cnfg[i][0]+x;
                int ny = cnfg[i][1]+y;
                if(state(nx,ny, g)) {
                    dp[nx][ny].add(0l + dist+1);
                    xs.offer(nx);
                    ys.offer(ny);
                    g[nx][ny] += 10;
                }
            }
            if(size == 0) {
                dist++;
                size = xs.size();
            }
        }
        for(int i = 0; i < g.length; i++)
        for(int j = 0; j < g[0].length; j++)
            if(g[i][j] > 2) g[i][j] -= 10;
    }
    
    private boolean state(int x, int y, int[][] g){
        if(x < 0 || y < 0 || x == g.length || y == g[0].length) return false;
        return g[x][y] == 0;
    }
}