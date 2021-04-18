import java.util.Scanner;

public class Timplate {
    public static void main(String fsdaf[]) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- != 0) {
            int n = sc.nextInt();
            for(int i = 0; i < n-1; i++) {
                System.out.print(1);
                System.out.print(' ');
            }
            System.out.println(1);
        }
        sc.close();
    }
}