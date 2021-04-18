import java.util.Scanner;
import java.io.*;
import java.util.Arrays;
import java.util.*;

class NSolution {
    
    public static void main(String[] flsda) throws IOException{
        // System.setIn(new FileInputStream(new File("input.txt")));
        // System.setOut(new PrintStream(new File("output.txt")));
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> al = new ArrayList();
        if(al instanceof ChoseTheCorrectAnswer) {
            System.out.println("Yes it is my bro");
        }
        String cur = sc.nextLine();
        while(!cur.equals("0")) {
        }
        sc.close();
    }
    private static void dothis_a() {

    }
    private static int dothis(String s) {
        int ans = 0;
        int l = 0, r = s.length()-1;
        StringBuilder sb = new StringBuilder(s);
        while(l < r) {
            char lc =sb.charAt(l);
            char rc = sb.charAt(r);
            int ll = l;
            int rr = r;
            while(ll < r && sb.charAt(ll) != rc) ll++;
            while(rr > l && sb.charAt(rr) != lc) rr--;

            if(ll == r && rr == l) return -1;
            if(ll - l <= r - rr) {
                sb.insert(l, rc);
                sb.deleteCharAt(ll+1);
                ans += ll-l;
            }
            else {
                sb.insert(r+1, lc);
                sb.deleteCharAt(rr);
                ans += r - rr;
            }
            l++;r--;
        }
        return ans;
    }
}

class Trip implements Comparable<Trip> {
    int idx;
    int dir;
    int time;
    public Trip(int iid, int ddir, int ttime) {
        idx = iid;
        dir = ddir; time = ttime;
    }

    @Override
    public int compareTo(Trip t) {
        return time == t.time? 
                    dir == t.dir?
                        idx - t.idx:
                        t.dir - dir:
                    time - t.time;
    }
}