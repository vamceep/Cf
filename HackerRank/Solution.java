import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {
    
    static int twoStacks(int x, int[] a, int[] b) {
        int[] pa = new int[a.length+1];
        int[] pb = new int[b.length+1];

        for(int i = 0; i < a.length; i++) pa[i+1] = a[i] + pa[i];
        for(int i = 0; i < b.length; i++) pb[i+1] = b[i] + pb[i];

        int ans = 0;
        for(int i = 0; i < pa.length; i++) {
            if(pa[i] > x) break;

            int idx = binSearch(pb, 0, b.length, x - pa[i]);
            ans = Math.max(ans , i + idx);
        }
        for(int i = 0; i < pb.length; i++) {
            if(pb[i] > x) return ans;

            int idx = binSearch(pa, 0, a.length, x - pb[i]);
            ans = Math.max(ans , i + idx);
        }
        return ans;
    }

    private static int binSearch(int[] ary, int s, int e, int val) {
        while (s + 1 < e) {
            int mid = (s + e)/2;
            if(ary[mid] > val) e = mid;
            else s = mid;
        }
        return s;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream(new File("input.txt")));
        System.setOut(new PrintStream(new File("output.txt")));
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));
        Scanner sc = new Scanner(System.in);
        int g = Integer.parseInt(sc.nextLine().trim());
        for (int gItr = 0; gItr < g; gItr++) {
            String[] nmx = sc.nextLine().split(" ");

            int n = Integer.parseInt(nmx[0].trim());
            int m = Integer.parseInt(nmx[1].trim());
            int x = Integer.parseInt(nmx[2].trim());

            int[] a = new int[n];
            String[] aItems = sc.nextLine().split(" ");
            for (int aItr = 0; aItr < n; aItr++) {
                int aItem = Integer.parseInt(aItems[aItr].trim());
                a[aItr] = aItem;
            }

            int[] b = new int[m];
            String[] bItems = sc.nextLine().split(" ");
            for (int bItr = 0; bItr < m; bItr++) {
                int bItem = Integer.parseInt(bItems[bItr].trim());
                b[bItr] = bItem;
            }

            int result = twoStacks(x, a, b);
            System.out.println(String.valueOf(result));
        }
    }
}
