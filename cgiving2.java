/*
ID: wuhanda1
LANG: JAVA
TASK: cgiving2
*/
import java.io.*;
import java.util.*;
public class cgiving2{ 

   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("cgiving2.in"));
      //Scanner sc = new Scanner(System.in);
      StringTokenizer st = new StringTokenizer(f.readLine());
      
      int n = Integer.parseInt(st.nextToken()); //number of pastures
      int m = Integer.parseInt(st.nextToken()); //number of edges
      int b = Integer.parseInt(st.nextToken()); //number of bulls
      int[][] graph = new int[n+1][n+1];
      
      for(int i=0; i<m; i++){
         st = new StringTokenizer(f.readLine());
         int R_i = Integer.parseInt(st.nextToken());
         int S_i = Integer.parseInt(st.nextToken());
         int L_i = Integer.parseInt(st.nextToken());
         if(graph[R_i][S_i] != 0 && graph[R_i][S_i] < L_i) // only keep smallest lengths
            continue;
         graph[R_i][S_i] = L_i;
         graph[S_i][R_i] = L_i;
      }
      
      int[] dist = new int[n+1]; //copy pasted dijkstra's, should work?
      boolean[] done = new boolean[n+1];
      Arrays.fill(dist, Integer.MAX_VALUE);
      dist[1] = 0;
      
      for(int count=0; count<=n; count++){ //didn't work when this was <v, had to be <=
         //choose the vertex with the least distance
         int u = findMin(dist, done); //method that gets the min of the ones that are not done
         done[u] = true;
         for(int i = 0;i<n+1; i++){
            if(!done[i] && graph[u][i] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][i] < dist[i])
               dist[i] = dist[u] + graph[u][i];
         }
      }//end of copy paste
      String[] out = new String[b];
      for(int i=0; i<b; i++){
         st = new StringTokenizer(f.readLine());
         int bull = Integer.parseInt(st.nextToken()); //# of their pasture
         int cow = Integer.parseInt(st.nextToken());
         out[i] = ""+(dist[bull]+dist[cow]);
      }
      for(String s: out)
         System.out.println(s);
      
   }
   public static int findMin(int[] dist, boolean[] done){
      int mindex = 0;
      for(int i=0; i<dist.length; i++){
         if(!done[i] && dist[i] <= dist[mindex])
            mindex = i;
      }
      return mindex;
   }
}