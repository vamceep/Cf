// import java.io.IOException;
import java.util.*;
import java.io.*;

class Solution {
    public static void main(String afasjf[]) throws IOException {
        System.setIn(new FileInputStream(new File("input.txt")));
        System.setOut(new PrintStream(new File("output.txt")));
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int cno = 1;

        while (cno <= t) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int p = sc.nextInt();
            int[][] ary = new int[n][k + 1];
            for (int i = 0; i < n; i++) {
                for (int j = 1; j <= k; j++) {
                    ary[i][j] = sc.nextInt() + ary[i][j - 1];
                }
            }
            int[][] dp = new int[n][p];
            for(int[] i : dp) Arrays.fill(i, -2);
            int ans = dothis(ary, p, 0, dp);

            System.out.format("Case #%d: %d%n", cno++, ans);
        }
    }

    private static int dothis(int[][] ary, int cnt, int start, int[][] dp) {
        
        if (cnt == 0 || start == ary.length) {
            return cnt == 0 ? 0 : -1;
        }

        if(dp[start][cnt-1] != -2) return dp[start][cnt-1];

        int ans = 0;
        for (int i = cnt; i >= 0; i--) {
            if(i >= ary[start].length) continue;
            int cur = dothis(ary, cnt - i, start + 1, dp);
            if (cur >= 0)
                ans = Math.max(ans, ary[start][i] + cur);
        }
        dp[start][cnt-1] = ans;
        return ans;
    }
}