import java.util.*;
import java.io.*;

class A {
    public static void main(String[] are) throws IOException{
        System.setIn(new FileInputStream(new File("input.txt")));
        PrintStream ps = new PrintStream(new File("output.txt"));
        System.setOut(ps);
        System.setErr(ps);
        
        Scanner sc = new Scanner(System.in);

        int len1 = sc.nextInt();
        int len2 = sc.nextInt();
        String ans = "not equal";
        if(len1 == len2) {
            int[] a1 = new int[len1];
            int[] a2 = new int[len2];
            for(int i = 0; i < len1; i++) {
                a1[i] = sc.nextInt();
            }
            for(int i = 0; i < len1; i++)
                a2[i] = sc.nextInt();
            int i = 0;
            for(i = 0; i <len1; i++)
                if(a1[i] != a2[i])
                    break;

            if(i == len1) ans = "equal";
        }
        System.out.println(ans);
    }
}