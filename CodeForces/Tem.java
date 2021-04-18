import java.util.Scanner;
import static java.lang.System.out;

import java.io.PrintStream;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;

public class Tem {
    public static void main(String fsdaf[]) throws IOException{
        System.setIn(new FileInputStream(new File("input.txt")));
        System.setOut(new PrintStream(new File("output.txt")));
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] ary = new int[n];
        for(int i = 0; i < n; i++)
            ary[i] = sc.nextInt();

        SegmentTree st = new SegmentTree(ary);
        while(m-- != 0) {
            int t = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();
            if(t == 1) 
                st.setMin(l,r);
            else 
                out.println(st.getMin(l, r-1));
        }
        sc.close();
    }
}