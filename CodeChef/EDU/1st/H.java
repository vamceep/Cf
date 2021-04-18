import java.io.*;
import java.util.*;

class H {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(new File("input.txt")));
        System.setOut(new PrintStream(new File("output.txt")));
        
        Scanner sc = new Scanner(System.in);
        final String indian = "INDIAN";
        final String cwon = "CONTEST_WON";
        final String tcb = "TOP_CONTRIBUTOR";
        final String bf = "BUG_FOUND";
        final String chost = "CONTEST_HOSTED";

        int t = sc.nextInt();
        while(t-- != 0) {
            int act = sc.nextInt();
            int div = sc.nextLine().trim().equals(indian)? 200: 400;
            int ladoo = 0;

            for(int i = 0; i < act; i++) {
                String cur = sc.nextLine();
                int idx = cur.indexOf(' ');
                int val = 0;
                if(!cur.equals(tcb) && !cur.equals(chost)) val = Integer.parseInt(cur.substring(idx+1));
                if(idx >= 0) cur = cur.substring(0, idx);
                switch(cur) {
                    case cwon: {
                        ladoo += 300 + Math.max(0, 20 - val);
                        break;
                    }
                    case tcb: {
                        ladoo += 300;
                        break;
                    }
                    case bf: {
                        ladoo += val;
                        break;
                    }
                    case chost: {
                        ladoo += 50;
                        break;
                    }
                }
            }
            System.out.println(ladoo/div);
        }
    }
}
