import java.io.*;
import java.util.*;

class F {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(new File("input.txt")));
        System.setOut(new PrintStream(new File("output.txt")));
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- != 0) {
            int n = sc.nextInt();
            System.out.println(dothis(n));
        }
    }

    private static int dothis(int n) {
        int ans = 0;
        int cur = 5;
        for(; cur <= n; cur *= 5)
            ans += n/cur;
        return ans;
    }
}
