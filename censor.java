/*
ID: wuhanda1
LANG: JAVA
TASK: censor
*/
import java.io.*;
import java.util.*;
public class censor{ 
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("censor.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("censor.out")));
      
      String s = f.readLine();
      String sub = f.readLine();
      String r = "";
      for(int i=0; i<s.length(); i++){
         r += s.charAt(i)+"";
         if(r.length() > sub.length() && (r.substring(r.length() - sub.length())).equals(sub))
            r = r.substring(0, r.length() - sub.length());
      }
      out.println(r);
      out.close();
   }
//    public static boolean endEqualsSub(String s, String sub){
//       if(s.length() < sub.length())
//          return false;
//       String end = s.substring(s.length() - sub.length());
//       return end.equals(sub);
//    }
}
