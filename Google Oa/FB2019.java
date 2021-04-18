import java.io.*;
import java.util.*;
import static java.lang.System.out;

public class FB2019 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(new File("input.txt")));
        System.setOut(new PrintStream(new File("output.txt")));
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int testcase = 1;
        while(testcase < t+1) {
            int n = sc.nextInt();
            int s = sc.nextInt();
            HashSet<Integer>[] emp = new HashSet[n];
            HashSet<Integer>[] crs = new HashSet[s];
            for(int i = 0; i < n; i++) emp[i] = new HashSet();
            for(int i = 0; i < s; i++) crs[i] = new HashSet();

            for(int i = 0; i < n; i++) {
                int cs = sc.nextInt();
                while(cs-- != 0) {
                    int id = sc.nextInt();
                    emp[i].add(id-1);
                    crs[id-1].add(i);
                }
            }
            HashSet<String> ans = new HashSet();
            for(int i = 0; i < n; i++) {
                HashSet<Integer> cur_empCr = emp[i];
                for(Integer i : cur_empCr.)
            }
            out.format("Case #%d: %d%n",testcase, ans.size());
        }
        sc.close();
    }

}