import java.util.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.File;

class E {
    public static void main(String[] afsadr) throws IOException{
        System.setIn(new FileInputStream(new File("input.txt")));
        PrintStream pr = new PrintStream(new File("output.txt"));
        System.setOut(pr);
        System.setErr(pr);
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- != 0) {
            sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();
            System.out.println(dothis(s));
        }
        sc.close();
    }
    
    private static String dothis(String s) {
        StringBuilder res = new StringBuilder();
        Stack<Character> stk = new Stack<Character>();
        for(char c : s.toCharArray()) {
            if(Character.isLetterOrDigit(c))
                res.append(c);

            else if(c == '(') 
                stk.push(c);
            
            else if(c == ')'){
                while(stk.peek() != '(')
                    res.append(stk.pop());
                stk.pop();
            }
            else {
                while(!stk.isEmpty() && stk.peek() != '(' && pre(stk.peek()) >= pre(c))
                    res.append(stk.pop());
                stk.push(c);
            }
        }
        while(!stk.isEmpty()) res.append(stk.pop());
        return res.toString();
    }

    private static int pre(char c) {
        if(c == '+' || c == '-') return 0;
        if(c == '/' || c == '*') return 1;
        return 2;
    }
}