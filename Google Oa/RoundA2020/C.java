import java.io.*;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Collections;

class C {
    public static void main(String[] fadsjlkf) throws IOException {
        System.setIn(new FileInputStream(new File("input.txt")));
        System.setOut(new PrintStream(new File("output.txt")));
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int count = 1;
        while (count <= testCases) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] ary = new int[n];
            for (int i = 0; i < n; i++) {
                ary[i] = sc.nextInt();
            }

            int ans = dothis(k, ary);
            sb.append(String.format("Case #%d: %d%n", count++, ans));
        }
        System.out.print(sb.toString());
    }

    private static int dothis(int k, int[] ary) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 1; i < ary.length; i++) 
            pq.offer(ary[i] - ary[i - 1]);

        while (k-- != 0 && !pq.isEmpty()) {
            int cur = pq.poll();
            if(cur == 1) return 1;
            int left = cur / 2;
            int right = cur - left;
            pq.offer(left);
            pq.offer(right);
        }
        return pq.isEmpty()? 0: pq.peek();
    }
}