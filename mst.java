/*
ID: wuhanda1
LANG: JAVA
TASK: mst
*/
import java.io.*;
import java.util.*;
public class mst{ 

   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("mst2.in"));
      //Scanner sc = new Scanner(System.in);
      StringTokenizer st = new StringTokenizer(f.readLine());
      int v = Integer.parseInt(st.nextToken()); //number of vertices
      int e = Integer.parseInt(st.nextToken());
      
      int[][] graph = new int[v+1][v+1];
      for(int i=0; i<e; i++){
         st = new StringTokenizer(f.readLine());
         int a = Integer.parseInt(st.nextToken());
         int b = Integer.parseInt(st.nextToken());
         int c = Integer.parseInt(st.nextToken());
         graph[a][b] = c;
         graph[b][a] = c;
      }
      //prim's algorithm for finding minimum spanning trees
      //int cost = 0;
      int[] dist = new int[v+1];
      Arrays.fill(dist, Integer.MAX_VALUE);
      dist[1] = 0; //start w one vertex
      boolean[] done = new boolean[v+1];
      for(int count = 0; count<v; count++){
         int u = findMin(dist, done); //find lowest neighbor to all "done" vertices
         done[u] = true;
         for(int i=1;i<=v;i++){
            if(graph[u][i] != 0 && !done[i] && graph[u][i] < dist[i]) //mark all neighbors of curr (u)
               dist[i] = graph[u][i]; //basically this updates dist w dist from u to i, if new value is less
         }
      }
      int sum = 0;
      for(int i=1; i<dist.length; i++){
         sum+=dist[i];
      }
      System.out.println(sum+"");
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