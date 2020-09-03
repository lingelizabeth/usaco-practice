/*
ID: wuhanda1
LANG: JAVA
TASK: wormhole
*/
import java.io.*;
import java.util.*;
public class wormhole{
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("wormhole.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
      
      int n = Integer.parseInt(f.readLine()); //number of wormholes
      int[] x = new int[13];
      int[] y = new int[13];
      int[] partners = new int[13];
      int[] next = new int[13];
      
      for(int i=1; i<=n; i++){
         StringTokenizer st = new StringTokenizer(f.readLine());
         x[i] = Integer.parseInt(st.nextToken());
         y[i] = Integer.parseInt(st.nextToken());
      }
      
      for(int i=1; i<=n; i++){
         for(int j=1; j<=n; j++){
            if(x[j] > x[i] && y[i] == y[j]){
               if(next[i] == 0 || x[j] - x[i] < x[next[i]] - x[i])
                  next[i] = j; //populate next with the next point ..... index
            }
         }
      }
      
      out.println(solve(x, y, partners, next, n));
      out.close();

   }
   public static int solve(int[] x, int[] y, int[] partners, int[] next, int n){
      int total = 0, i = 1;
      
      while(partners[i] != 0){
         i++;
         if(i > n)
            break;
      }
      if(i > n){
         if(isCycle(partners, next, n))
            return 1;
         else
            return 0;
      }
      
      for(int j = i+1; j<= n; j++){
         if(partners[j] == 0){
            partners[i] = j;
            partners[j] = i;
            total += solve(x, y, partners, next, n);
            partners[i] = partners[j] = 0;
         }
      }
      return total;
   }
   public static boolean isCycle(int[] partners, int[] next, int n){
      for(int i=1; i<=n; i++){
         int pos = i;
         for(int count=1; count<=n; count++){
            pos = next[partners[pos]];
         }
         if(pos != 0)
            return true;
      }
      return false;
   }
}
