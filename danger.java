/*
ID: wuhanda1
LANG: JAVA
TASK: danger
*/
import java.io.*;
import java.util.*;
public class danger{ 

   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("danger.in"));
      //Scanner sc = new Scanner(System.in);
      StringTokenizer st = new StringTokenizer(f.readLine());
      int n = Integer.parseInt(st.nextToken()); //number of vertices
      int m = Integer.parseInt(st.nextToken());
      int[] seq = new int[m];
      for(int i =0; i<m; i++){
         seq[i] = Integer.parseInt(f.readLine());
      }
      int[][] graph = new int[n+1][n+1];//ignoring 0
      for(int i =1; i<=n; i++){
         st = new StringTokenizer(f.readLine());
         for(int j=1;j<=n;j++){
            int d = Integer.parseInt(st.nextToken());
            graph[i][j] = d;
         }
      }
      for(int i=1; i<=n; i++){
         for(int j=1; j<=n; j++){
            for(int k=1; k<=n; k++){
               if(graph[j][k] > graph[j][i] +graph[i][k])
                  graph[j][k] = graph[j][i] + graph[i][k];
            }
         }
      }
      
      int ans = 0;
      for(int i=0; i<m-1;i++){
         ans += graph[seq[i]][seq[i+1]];
      }
      System.out.println(ans+"");
   }
}