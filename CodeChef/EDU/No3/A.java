import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.File;

class A {
    public static void main(String[] afsadr) throws IOException{
        System.setIn(new FileInputStream(new File("input.txt")));
        PrintStream pr = new PrintStream(new File("output.txt"));
        System.setOut(pr);
        System.setErr(pr);
        
        FastReader fr = new FastReader();
        int t = fr.nextInt();
        while(t-- != 0) {
            int n = fr.nextInt();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            int energy = fr.nextInt();
            for(int i = 0; i < n; i++)
                pq.offer(fr.nextInt());
            
            int ans = 0;
            while(!pq.isEmpty() && energy > 0) {
                int cur = pq.poll();
                energy -= cur;
                if(cur/2 != 0) pq.offer(cur/2);
                ans++;
            }
            if(energy > 0) 
                System.out.println("Evacuate");
            else 
                System.out.println(ans);
        }
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