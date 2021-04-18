import java.util.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.File;

class C {
    public static void main(String[] afsadr) throws IOException{
        System.setIn(new FileInputStream(new File("input.txt")));
        System.setOut(new PrintStream(new File("output.txt")));
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- != 0) {
            String cur = sc.nextLine();
            System.out.println(dothis(cur));
        }
        sc.close();
    }
    
    private static int dothis(String s) {
    	int ans = 0;
    	if(s.length() == 0 || s.charAt(0) != '<')
    		return ans;
    	int idx = -1;
    	int left = 0;
    	for(int i = 0; i < s.length(); i++) {
		char c = s.charAt(i);
		if(c == '<') left++;
		else if(c == '>') {
			if(left == 1) ans = Math.max(ans, i+1);
			left--;
			if(left < 0) break;
		}
    	}
	return ans;
    }
}