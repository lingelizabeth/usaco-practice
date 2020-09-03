/*
ID: wuhanda1
LANG: JAVA
TASK: nocross
*/
import java.io.*;
import java.util.*;
public class nocross{ 
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("nocross.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("nocross.out")));
      
      int n = Integer.parseInt(f.readLine());
      int[] road1 = new int[n];
      int[] road2 = new int[n];
      for(int i=0; i<n; i++){
         road1[i] = Integer.parseInt(f.readLine());
      }
      for(int i=0; i<n; i++){
         road2[i] = Integer.parseInt(f.readLine());
      }
      
      int count = 0;
      for(int i=0; i<n; i++){
         if(Math.abs(road1[i]-road2[i]) < 4){
            count++;
         }
      }
      
      out.println(count+1);
      out.close();
   }
}
