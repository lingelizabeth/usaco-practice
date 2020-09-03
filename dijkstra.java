/*
ID: wuhanda1
LANG: JAVA
TASK: dijkstra
*/
import java.io.*;
import java.util.*;
public class dijkstra{ 

   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("dijkstra.in"));
      //Scanner sc = new Scanner(System.in);
      StringTokenizer st = new StringTokenizer(f.readLine());
      int v = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int s = Integer.parseInt(st.nextToken());
      int[][] graph = new int[v+1][v+1];
      for(int i=0; i<e; i++){
         st = new StringTokenizer(f.readLine());
         int a = Integer.parseInt(st.nextToken());
         int b = Integer.parseInt(st.nextToken());
         int c = Integer.parseInt(st.nextToken());
         graph[a][b] = c;
         graph[b][a] = c;
      }
      int[] dist = new int[v+1];
      boolean[] done = new boolean[v+1];
      Arrays.fill(dist, Integer.MAX_VALUE);//change those to -1 later
      dist[s] = 0;
      
      for(int count=0; count<=v; count++){ //didn't work when this was <v, had to be <=
         //choose the vertex with the least distance
         int u = findMin(dist, done); //method that gets the min of the ones that are not done
         done[u] = true;
         for(int i = 0;i<v+1; i++){
            if(!done[i] && graph[u][i] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][i] < dist[i])
               dist[i] = dist[u] + graph[u][i];
         }
      }
      for(int i=1; i<dist.length; i++){
         if(dist[i] == Integer.MAX_VALUE)
            System.out.println("-1");
         else
            System.out.println(dist[i]+"");
      }
      
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
