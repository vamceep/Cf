import java.util.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.File;

class G {
    public static void main(String[] afsadr) throws IOException{
        // System.setIn(new FileInputStream(new File("input.txt")));
        // PrintStream pr = new PrintStream(new File("output.txt"));
        // System.setOut(pr);
        // System.setErr(pr);
        
        Scanner sc = new Scanner(System.in);
        int mod = 1000000007;
        int n = sc.nextInt();
        sc.nextInt();
        
        long ans = 1;
        Stack<Integer> stk = new Stack<Integer>();
        Stack<Integer> idx = new Stack<Integer>();
        for(int i = 0; i < n; i++) {
            int cur = sc.nextInt();
            while(!stk.isEmpty() && stk.peek() > cur) {
                ans = (ans * (i - idx.pop() + 1))%mod;
                stk.pop();
            }
            stk.push(cur);
            idx.push(i);
        }
        
        System.out.println(ans);
        sc.close();
    }
}