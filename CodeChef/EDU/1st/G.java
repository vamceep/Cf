import java.io.*;
import java.util.*;

class G {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(new File("input.txt")));
        System.setOut(new PrintStream(new File("output.txt")));
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- != 0) {
            int g = sc.nextInt();
            while(g-- != 0) {
                int i = sc.nextInt(), n = sc.nextInt(), q = sc.nextInt();
                
                int a = n/2;
                if(i != 1)
                    a = n - a;
                int ans = q == 1? a: n - a;
                System.out.println(ans);
            }
        }
    }
}
