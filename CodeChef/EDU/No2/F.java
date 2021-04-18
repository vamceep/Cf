import java.util.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.File;

class F {
    public static void main(String[] afsadr) throws IOException{
        System.setIn(new FileInputStream(new File("input.txt")));
        PrintStream pr = new PrintStream(new File("output.txt"));
        System.setOut(pr);
        System.setErr(pr);
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- != 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] ary = new int[n];
            for(int i = 0; i < n; i++)
                ary[i] = sc.nextInt();
            
            System.out.println(dothis(ary, k));
        }
        sc.close();
    }
    
    private static int dothis(int[] ary, int k) {
        int ans = 0;
        int[] map = new int[k];
        int left = 0;
        int cnt = 0;
        for(int i = 0; i < ary.length; i++) {
            map[ary[i]-1]++;
            if(map[ary[i]-1] == 1) cnt++;

            if(cnt == k) {
                ans = Math.max(ans, i - left);
                while(cnt == k) {
                    map[ary[left]-1]--;
                    left++;
                    if(map[ary[left-1]-1] == 0) cnt--;
                }
            }
        }
        ans = Math.max(ans, ary.length - left);

        return ans;
    }
}