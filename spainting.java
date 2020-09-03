/*
ID: wuhanda1
LANG: JAVA
TASK: spainting
*/
import java.io.*;
import java.util.*;
public class spainting{ 
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("spainting.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("spainting.out")));
      StringTokenizer st = new StringTokenizer(f.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      
      pw.println(n*m);
      pw.close();
   }
}