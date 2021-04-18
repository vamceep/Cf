import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.File;

class J {
    public static void main(String[] afsadr) throws IOException{
        System.setIn(new FileInputStream(new File("input.txt")));
        PrintStream pr = new PrintStream(new File("output.txt"));
        System.setOut(pr);
        System.setErr(pr);
        
        FastReader fr = new FastReader();
        
        int n = fr.nextInt();
        int[][] ary = new int[n+2][2];
        for(int i = 1; i <= n; i++)
            ary[i] = new int[] {fr.nextInt(), fr.nextInt()};
        ary[0] = new int[]{0,500};
        ary[ary.length-1] = new int[]{100000, 500};
        
        Arrays.sort(ary,(x,y)->x[0] == y[0]?x[1]-y[1]:x[0]-y[0]);
        
        int left = 0;
        int idx = 0;
        
        while(idx < ary.length) {
            if(ary[idx][0] != ary[left][0])
                ary[++left] = ary[idx];
            idx++;
        }
        left++;

        ary[0][1] = 500;
        ary[left-1][1] = 500;
        ary = Arrays.copyOfRange(ary, 0, left);

        Stack<Integer> stk = new Stack<>();
        int[] lr = new int[ary.length];
        for(int i = 0; i < left;) {
            if(stk.isEmpty() || ary[stk.peek()][1]  < ary[i][1]) {
                lr[i] = stk.isEmpty()? 0: stk.peek();
                stk.push(i++);
            }
            else stk.pop();
        }

        stk = new Stack<>();
        int[] rl = new int[left];
        for(int i = left-1; i >= 0;) {
            if(stk.isEmpty() || ary[stk.peek()][1] < ary[i][1]) {
                rl[i] = stk.isEmpty()? left-1: stk.peek();
                stk.push(i--);
            }
            else stk.pop();
        }
        int ans = 0;
        for(int i = 0; i < left; i++) {
            ans = Math.max(ans, ary[i][1]*(ary[rl[i]][0] - ary[lr[i]][0]));
            if(i != 0)
            ans = Math.max(ans, (ary[i][0] - ary[i-1][0])*500);
        }
        System.out.println(ans);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
    
        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }
        public FastReader(File file) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(file));
        }
    
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
    
        int nextInt() {
            return Integer.parseInt(next());
        }
    
        long nextLong() {
            return Long.parseLong(next());
        }
    
        double nextDouble() {
            return Double.parseDouble(next());
        }
    
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}