import java.io.*;
import java.util.*;

class E {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(new File("input.txt")));
        System.setOut(new PrintStream(new File("output.txt")));
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- != 0) {
            int n = sc.nextInt();
            Stack<Integer> stk = new Stack();
            for(int i =0; i< n; i++) {
                int cur = sc.nextInt();
                if(stk.size() == 0 || stk.peek() > cur) stk.push(cur);
            }
            System.out.println(stk.size());
        }
    }
}
