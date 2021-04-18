import java.util.Scanner;
import static java.lang.System.out;
import java.io.*;

public class MainClass {
    public static void main(String fsdaf[]) throws IOException {
        System.setIn(new FileInputStream(new File("input.txt")));
        System.setOut(new PrintStream(new File("output.txt")));

        System.out.print("[");
        for(int i = 0; i <10 ; i++)
            System.out.print("\"a\",");
        for(int i = 0; i < 1950; i++)
            System.out.print("\"b\",");
        for(int i = 0; i < 39; i++)
            System.out.print("\"c\",");
        System.out.print("\"c\"]");
        // Scanner sc = new Scanner(System.in);
        // String[] ary = sc.nextLine().split(",");
        // int[] arr = new int[ary.length];
        // int top = 0;
        // for(String s : ary)
        //     arr[top++] = Integer.parseInt(s);
        // top = sc.nextInt();
        // // Temp2 t2 = new Temp2();
        // // int ans = t2.minimumIncompatibility(arr, top);
        // // out.println(ans); 
    }
}