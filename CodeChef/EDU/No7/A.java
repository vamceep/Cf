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
    public static void main(String[] afsadr) throws IOException} {
        System.setIn(new FileInputStream(new File("input.txt")));
        PrintStream pr = new PrintStream(new File("output.txt"));
        System.setOut(pr);
        System.setErr(pr);

        FastReader fr = new FastReader();

        int t = fr.nextInt();
        while (t-- != 0) {
            int n = fr.nextInt();
            int[] ary = new int[n];
            for (int i = 0; i < n; i++)
                ary[i] = fr.nextInt();

            long ans = 0;
            int len = 0;

            for (int i = 0; i < ary.length; i++) {
                int cur_len = 1;
                if (i != 0 && ary[i] >= ary[i - 1])
                    cur_len += len;

                len = cur_len;
                ans += cur_len;
            }

            System.out.println(ans);

        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
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