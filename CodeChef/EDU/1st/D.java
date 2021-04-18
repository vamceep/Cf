import java.io.*;
import java.util.*;

class D {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(new File("input.txt")));
        System.setOut(new PrintStream(new File("output.txt")));
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] ary = new int[t];
        for(int i = 0; i < t; i++) ary[i] = sc.nextInt();
        Arrays.sort(ary);
        System.out.println(dothis(ary));
        sc.close();
    }

    private static long dothis(int[] ary) {
        long ans = 0;
        int len = ary.length;
        for(int i = 0; i < len; i++) 
            ans = Math.max(ans, 1l*ary[i] * (len - i));
        return ans;
    }
}
