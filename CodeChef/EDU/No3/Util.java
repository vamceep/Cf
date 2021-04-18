import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

class Util {
    public static boolean compare() {
        File out = new File("output.txt");
        File comp = new File("comp.txt");
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(out));
            BufferedReader br2 = new BufferedReader(new FileReader(comp));
            String s1 = "";
            String s2 = "";
            int i = 1;
            while ((s1 = br.readLine().trim()) != null && (s2 = br2.readLine().trim()) != null) {
                if(!s1.trim().equals(s2.trim())) {
                    System.out.println("Line no : "+i);
                    br.close(); br2.close();
                    return false;
                }
            }
            System.out.println("End of the file");
            if(s1 == null)
                s2 = br2.readLine();
            br.close(); br2.close();
            return s1 == null && s2 == null;
        }
        catch (Exception e) {
            return false;
        }
    }
}