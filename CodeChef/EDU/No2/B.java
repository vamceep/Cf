import java.util.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.File;

class B {
    public static void main(String[] afsadr) throws IOException{
        System.setIn(new FileInputStream(new File("input.txt")));
        System.setOut(new PrintStream(new File("output.txt")));
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- != 0) {
            int bm = sc.nextInt();
            int am = bm;
            int n = bm;
            int a = 0, b = 0, ans = 0;
            sc.nextLine();
            String sss = sc.nextLine();
            for(int i = 0; i < 2*n; i++) {
                int cur = sss.charAt(i)-'0';
                if(i%2 == 0) {
                    if(cur == 0) am--;
                    else a++;
                }
                else {
                    if(cur == 0) bm--;
                    else b++;
                }
                if(a > bm || b > am) {
                    ans = i+1;
                    break;
                }
            }

            if(ans == 0) ans = 2*n;
            System.out.println(ans);
        }
        sc.close();
    }
}