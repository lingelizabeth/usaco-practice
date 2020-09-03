/*
ID: wuhanda1
LANG: JAVA
TASK: cowsignal
*/
import java.io.*;
import java.util.*;
public class cowsignal{
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("cowsignal.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));
      StringTokenizer st = new StringTokenizer(f.readLine());
      
      int m = Integer.parseInt(st.nextToken());
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      
      for(int l=0;l<m;l++){ //for each line
         String line = f.readLine();
         String newline = "";
         for(int c=0; c<n; c++){//for each character in the line
            newline += repeatKTimes(line.charAt(c)+"", k);
            //out.print(repeatKTimes(line.charAt(c)+"", k));
         }
         for(int x=0; x<k; x++)
            out.println(newline);
      }
      out.close();
   }
   public static String repeatKTimes(String s, int k){
      String out = "";
      for(int i=0; i<k; i++)
         out += s;
      return out;
   }
}
