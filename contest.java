/*
ID: wuhanda1
LANG: JAVA
TASK: contest
*/
import java.io.*;
import java.util.*;
public class contest{ 
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("contest.in"));
      //Scanner sc = new Scanner(System.in);
      StringTokenizer st = new StringTokenizer(f.readLine());
      
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      int[][] graph = new int[n+1][n+1];
      for(int i=0;i<m;i++){
         st = new StringTokenizer(f.readLine());
         int a = Integer.parseInt(st.nextToken()); //winner
         int b = Integer.parseInt(st.nextToken()); //loser
         //graph[a][b]=1;
         graph[b][a]=1; //lets say its a directed graph w path from smaller to bigger
      }
      
      for(int i=1;i<=n;i++){ //make everything accessible by itself?
         graph[i][i] = 1;
      }
      //int[][] dist = new int[n+1][n+1];
      for(int i=1;i<=n;i++){
         for(int j=1;j<=n;j++){
            for(int k=1;k<=n;k++){ //grrr
               if((graph[j][i] != 0 && graph[i][k] != 0) && graph[j][k] < graph[j][i] + graph[i][k]) //(graph[j][k] != 0 || graph[)
                  graph[j][k] = graph[j][i] + graph[i][k];
            }
         }
      }
      int ans = 0;
      for(int i=1;i<=n;i++){
         boolean connected = true;
         for(int j=1;j<=n;j++){
            if(graph[i][j] == 0 && graph[j][i] == 0)
               connected = false;
         }
         if(connected)
            ans += 1;
      }
      System.out.println((ans)+"");
   }
}