import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    // static int[] componentsInGraph(int[][] gb) {
    //     return null;
    // }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(new File("input.txt")));
        System.setOut(new PrintStream(new File("output.txt")));

        int n = Integer.parseInt(scanner.nextLine().trim());
        HashSet<Integer> pr = new HashSet();
        pr.add(2);pr.add(3); pr.add(5); pr. add(7); pr.add(11); pr.add(13);
        int [] prs = new int[]{2,3,5,7,11,13};

        ArrayList<Integer>[] als = new ArrayList[9];
        for(int i = 0; i < als.length; i++)
            als[i] = new ArrayList();

        for(int i = 1; i <= 9; i++) {
            for(int j : prs) {
                int val = i-j;
                if(val > 0 && val < 10 && i != val) {
                    als[i-1].add(val);
                }
            }
        }

        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        while(q-- != 0) {
            int[][] ary = new int[3][3];
            for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                ary[i][j] = sc.nextInt();
            int ans= 0;
        }

        int[] ary = new int[6];
        for(int i = 0; i < 6; i++) 
            ary[i] = sc.nextInt();
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 1000000-25; i++)
            sb.append('a');
        
        sb.append("bcdefghijklmnopqrstuvwxyz");
        System.out.println(sb.toString());
        System.out.println(sb.length());
    }
}
