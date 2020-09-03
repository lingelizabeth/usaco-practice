/*
ID: wuhanda1
LANG: JAVA
TASK: wormhole1
*/
import java.io.*;
import java.util.*;
public class wormhole1{
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("wormhole.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
      
      int n = Integer.parseInt(f.readLine()); //number of wormholes
      int[][] pts = new int[n][2];
      
      for(int x=0; x<n; x++){
         StringTokenizer st = new StringTokenizer(f.readLine());
         pts[x][0] = Integer.parseInt(st.nextToken());
         pts[x][1] = Integer.parseInt(st.nextToken());
      }
      
      int ans = 0, count = 0;
      for(int x=0; x<n; x++){
         for(int y=x+1;y<n; y++){
            count++;
            if(isCycle(pts[x][0], pts[x][1], pts[y][0], pts[y][1]))
               ans++;
         }
      }
      System.out.println(count);
      out.println(ans);
      out.close();
   }
   public static boolean isCycle(int x1, int y1, int x2, int y2){
      return (x2 > x1 && y1==y2);
   }
}
