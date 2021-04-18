import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(new File("input.txt")));
        System.setOut(new PrintStream(new File("output.txt")));

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- != 0) {
            int n = sc.nextInt();
            int[] ary = new int[n];
            for(int i = 0; i < n; i++) 
                ary[i] = sc.nextInt();
            System.out.println(dothis(ary));
        }
    }

    private static int dothis(int[] ary) {
        int left = 0;
        int right = 1;
        int ans = 1;
        Arrays.sort(ary);
        while(right < ary.length) {
            if(ary[left] + ary[left +1 ] > ary[right]) 
                right++;
            else {
                ans = Math.max(ans, right - left);
                left++;
            }
        }
        ans = Math.max(ans, right - left);
        return ans;
    }
}

