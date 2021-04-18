import java.io.*;
import java.util.*;

class I {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(new File("input.txt")));
        System.setOut(new PrintStream(new File("output.txt")));
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- != 0) {
            long k = sc.nextLong(); int d1 = sc.nextInt(), d2 = sc.nextInt();
            int[] ary = new int[10];
            int[] map = new int[10];
            Arrays.fill(map, -1);
            
            int len = 0;
            int lsum = d1 + d2;
            int next = lsum%10;
            int csum = lsum;
            int left = 0; int right = 0;
            while(true) {
                if(map[next] != -1) {
                    right = len-1;
                    left = map[next];
                    k -= 2; k -= left;
                    for(int i = 0; i < left; i++) lsum += ary[i];
                    csum -= lsum;
                    break;
                }
                csum += next;
                map[next] = len;
                ary[len++] = next;
                next = csum % 10;
            }
            len = right-left+1;
            
            int rem = (int)(k%len);
            int rsum = 0;
            for(int i = left; i < left + rem; i++) rsum += ary[i];
            long tot = lsum + (k/len)*csum + rsum;
            String ans = tot%3 == 0? "YES": "NO";
            System.out.println(ans);
        }
        sc.close();
    }
}