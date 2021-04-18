import java.util.*;

class Solution {
    public boolean isPrintable(int[][] g) {
        int n = g.length, m = g[0].length;
        int[] minr = new int[61];
        int[] minc = new int[61];
        int[] maxr = new int[61];
        int[] maxc = new int[61];
        Arrays.fill(minr, 99999);
        Arrays.fill(minc, 99999);
        Arrays.fill(maxr, -1);
        Arrays.fill(maxc, -1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int u = g[i][j];
                minr[u] = Math.min(minr[u], i);
                minc[u] = Math.min(minc[u], j);
                maxr[u] = Math.max(maxr[u], i);
                maxc[u] = Math.max(maxc[u], j);
            }
        }

        boolean[][] h = new boolean[61][61];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 61; k++) {
                    if (k == g[i][j]) continue;
                    if (minr[k] <= i && i <= maxr[k] && minc[k] <= j && j <= maxc[k]) {
                        h[k][g[i][j]] = true;
                    }
                }
            }
        }

        for (int k = 0; k < 61; k++) {
            for (int i = 0; i < 61; i++) {
                for (int j = 0; j < 61; j++) {
                    h[i][j] |= h[i][k] & h[k][j];
                }
            }
        }
        for(int i = 0;i < 61;i++){
            if(h[i][i])return false;
        }
        return true;
    }
}