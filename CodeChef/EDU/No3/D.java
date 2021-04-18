import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.*;

class D {
    static int[] ary;
    public static void main(String args[] ) throws Exception {
        System.setIn(new FileInputStream(new File("input.txt")));
        PrintStream pr = new PrintStream(new File("output.txt"));
        System.setOut(pr);
        System.setErr(pr);


        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ary = new int[40];
        ary[1] = 1;
        ary[2] = 2;
        for(int i = 3; i < 40; i++) ary[i] = ary[i-1]+ ary[i-2]+1;

        while(t-- != 0) {
            int cur = sc.nextInt();
            System.out.println(dothis(cur, 39));
        }

        System.out.println(Util.compare());
    }

    private static String dothis(int k, int idx) {
        if(k == 0) return "";
        if(k == 1) return "1";

        String ret = "10";
        while(idx >= 0 && ary[idx] > k) {
            idx--;
        }

        String rem = dothis(k - ary[idx]+1, idx);
        int zero = idx - 2 - rem.length();
        while(zero-- != 0) ret += "0";
        return ret + rem;
    }
}
