import java.util.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.File;

class D {
    public static void main(String[] afsadr) throws IOException{
        System.setIn(new FileInputStream(new File("input.txt")));
        System.setOut(new PrintStream(new File("output.txt")));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] ret = new int[4];
        int cur = 0;
        int left = 0;
        int start = 0;
        for(int i = 1; i <= n; i++) {
            cur = sc.nextInt();
            if(cur == 1) {
                left++;
                if(left == 1) start = i;
                if(left > ret[0]) {
                    ret[0] = left;
                    ret[1] = i;
                }
            }
            else {
                if(left == 1) {
                    if(i - start+1 > ret[2]) {
                        ret[2] = i-start+1;
                        ret[3] = start;
                        start = i;
                    }
                }
                left--;
            }
        }
        sc.close();
        System.out.format("%d %d %d %d%n",ret[0],ret[1], ret[2],ret[3]);
    }
}