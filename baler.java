/*
ID: wuhanda1
LANG: JAVA
TASK: baler
*/
import java.io.*;
import java.util.*;
public class baler{
   static int n, xt, yt;
   static int[] x, y, r;
   static boolean[] v;
   static double[] speed;
   static double ans;
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("baler.in"));
      //Scanner sc = new Scanner(System.in);
      StringTokenizer st = new StringTokenizer(f.readLine());
      
      n = Integer.parseInt(st.nextToken());
      xt = Integer.parseInt(st.nextToken()); //final roller x
      yt = Integer.parseInt(st.nextToken()); //final y
      x = new int[n+1];
      y = new int[n+1];
      r = new int[n+1];
      v = new boolean[n+1];
      speed = new double[n+1];
      int start = -1;
      ans = -1;   
            
      for(int i=0; i<n;i++){
         st = new StringTokenizer(f.readLine());
         x[i] = Integer.parseInt(st.nextToken()); 
         y[i] = Integer.parseInt(st.nextToken()); 
         r[i] = Integer.parseInt(st.nextToken());
         if(x[i] == 0 && y[i] == 0)
            start = i;
      }
      speed[start] = 10000;
      v[start] = true;
      dfs(start, 10000);
      System.out.println((int)ans);
      
   }
   public static void dfs(int p, double d){ //roller # and speed
      if(x[p] == xt && y[p] == yt)
         ans = d;
      for(int i=0; i<n; i++){
         if(v[i])
            continue;
         if(Math.pow(x[i] - x[p], 2) + Math.pow(y[i] - y[p], 2) == Math.pow(r[i]+r[p], 2)){
            v[i] = true;
            speed[i] = -speed[p]*r[p]/r[i];
            dfs(i, d+Math.abs(speed[i]));
         }
            
      }
   }
}