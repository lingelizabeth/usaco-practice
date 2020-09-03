/*
ID: wuhanda1
LANG: JAVA
TASK: combo
*/
import java.io.*;
import java.util.*;
public class combo{
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("combo.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
      
      int n = Integer.parseInt(f.readLine()); //how many numbers on a dial
      int[] fj = new int[3]; //fj's combination
      StringTokenizer st = new StringTokenizer(f.readLine());
      for(int x=0; x<fj.length; x++)
         fj[x] = Integer.parseInt(st.nextToken());
      int[] m = new int[3]; //master combination
      StringTokenizer s = new StringTokenizer(f.readLine());
      for(int x=0; x<m.length; x++)
         m[x] = Integer.parseInt(s.nextToken());

      int ans = 0;
      for(int x=1; x<=n; x++){
         for(int y=1; y<=n; y++){
            for(int z=1; z<=n; z++){
               if(close(x, fj[0], n) && close(y, fj[1], n) && close(z, fj[2], n))
                  ans++;
               else if(close(x, m[0], n) && close(y, m[1], n) && close(z, m[2], n))
                  ans++;
            }
         }
      }
      out.println(ans);
      out.close();
   }
   public static boolean close(int x, int y, int n){
      return (Math.abs(x-y) <= 2 || Math.abs(x-y) >= n-2);
   }
}
