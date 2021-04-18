import java.util.*;
import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import static java.lang.System.out;

class H {

    public static void main(String fsdasd[]) throws IOException {
        System.setIn(new FileInputStream(new File("input.txt")));
        PrintStream pr = new PrintStream(new File("output.txt"));
        System.setOut(pr);
        System.setErr(pr);
        
        Scanner sc = new Scanner(System.in);
        // String s = sc.nextLine();
        // int k = sc.nextInt();
        // List<String> ll = new Sol().unique(s,k);
        // for(String ss : ll) {
        //     System.out.print(ss + " ");
        // }
        double val = sc.nextDouble();
        BigDecimal bg = new BigDecimal(Double.toString(val));
        bg = bg.setScale(2, RoundingMode.CEILING);
        double al = bg.doubleValue();
        out.println(al);
    }
    
}

class Sol {
    public List<String> unique(String s, int k) {
        LinkedList<String> ans = new LinkedList();
        int[] map = new int[26];
        int left = 0;
        int right = 0;
        int cnt = 0;
        while(right != s.length()) {

        }
        return ans;
    }
}
