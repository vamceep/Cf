import java.io.*;
import java.util.*;

class C {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(new File("input.txt")));
        System.setOut(new PrintStream(new File("output.txt")));
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- != 0) {
            String s = sc.nextLine();
            System.out.println(dothis(s));
        }
    }

    private static String dothis(String s) {
        int[] map = new int[26];
        int l = 0;
        int r = s.length()/2-1;
        for(int i = 0; i <= r; i++) {
            map[s.charAt(i)-'a']++;
        }
        l = s.length() %2 == 0? r+1: r+2;
        while(l < s.length()) {
            map[s.charAt(l++)-'a']--;
        }
        String yes = "YES";
        String no = "NO";
        
        for(int i : map) if(i != 0) return no;
        return yes;
        
    }
}
