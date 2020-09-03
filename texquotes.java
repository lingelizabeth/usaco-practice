/*
ID: wuhanda1
LANG: JAVA
TASK: TEX Quotes
*/
import java.io.*;
import java.util.*;
public class texquotes{
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("texquotes.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("texquotes.out")));
      String line = f.readLine();
      boolean left = true;
      while(line != null && !line.isEmpty()){
         for(int i=0;i<line.length();i++){
            if(line.charAt(i) == '"' && left){
               line = line.substring(0, i)+"``"+line.substring(i+1);
               left = !left;
            }
            else if(line.charAt(i) == '"' && !left){
               line = line.substring(0, i)+"''"+line.substring(i+1);
               left = !left;
            }
         }
         out.println(line);
         line = f.readLine();
      }
      out.close();
   }
}
