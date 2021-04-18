import java.util.*;
import java.io.*;

class gfg {
    public static void main(String[] afdsfd) throws IOException{
        System.setIn(new FileInputStream(new File("input.txt")));
        System.setOut(new PrintStream(new File("output.txt")));
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- != 0) {
            int n = sc.nextInt();
            int[] ary = new int[n];
            for(int i = 0; i < n; i++)
                ary[i] = sc.nextInt();

            int[] ltr = new int[n];
            int[] rtl = new int[n];

            dothis(ary, ltr);
            int l = 0;
            int r = n-1;
            while(l < r) {
                int tmp = ary[l];
                ary[l++] = ary[r];
                ary[r--] = tmp;
            }
            dothis(ary, rtl);
            l= 0;
            r = ary.length-1;
            while(l < r) {
                int tmp = rtl[l];
                rtl[l++] = rtl[r];
                rtl[r--] = tmp;
            }
            int ans = 0;
            for(int i = 0; i < n; i++)
                ans = Math.max(ans, ltr[i] + rtl[i] - 1);
            System.out.println(ans);
        }
        sc.close();
    }

    private static void dothis(int[] ary, int[] dp) {
        dp[0] = 1;
        Arrays.fill(dp, 1);
        for(int i = 1; i < ary.length; i++) {
            for(int j = 0; j < i; j++) {
                if(ary[j] < ary[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        
    }
}
// "1111111"
// ["1.1.11.111","1.1.111.11","1.11.1.111","1.11.11.11","1.11.111.1","11.111.1.11","111.1.11.1","11.1.1.111","11.1.11.11","1.11.111.1","11.11.1.11","11.1.11.1","11.111.1.1","111.1.1.11","111.1.11.1","111.11.1.1"]
// ["1.1.11.111","1.1.111.11","1.11.1.111","1.11.11.11","1.11.111.1","1.111.1.11","1.111.11.1","11.1.1.111","11.1.11.11","11.1.111.1","11.11.1.11","11.11.11.1","11.111.1.1","111.1.1.11","111.1.11.1","111.11.1.1"]