import java.io.*;
import java.util.*;
import static java.lang.System.out;

public class Solution {
    public static HashSet<String> hs;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(new File("input.txt")));
        System.setOut(new PrintStream(new File("output.txt")));
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int cv = 1;
        while(cv <= t) {
            int n = sc.nextInt();
            out.println(dothis(n));
        }
        sc.close();
    }

    private static int dothis(int val) {
        if(val == 1) return val;
        return val%2 == 0? 2*dothis(val/2) -1: 2*dothis(val/2)+1;
    }
}

