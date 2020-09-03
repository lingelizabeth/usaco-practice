/*
ID: wuhanda1
LANG: JAVA
TASK: hideseek
*/
import java.io.*;
import java.util.*;
public class hideseek{ 
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("hideseek.in"));
      //Scanner sc = new Scanner(System.in);
      StringTokenizer st = new StringTokenizer(f.readLine());
      
      int n = Integer.parseInt(st.nextToken()); //vertices
      int m = Integer.parseInt(st.nextToken());
      int[][] graph = new int[n+1][n+1];
      for(int i=0;i<m;i++){
         st = new StringTokenizer(f.readLine());
         int a = Integer.parseInt(st.nextToken()); 
         int b = Integer.parseInt(st.nextToken()); 
         graph[a][b]=1;
         graph[b][a]=1;
      }
      //copy paste dijkstras
      int[] dist = new int[n+1];
      boolean[] done = new boolean[n+1];
      Arrays.fill(dist, Integer.MAX_VALUE);//change those to -1 later
      dist[1] = 0;
      
      for(int count=0; count<=n; count++){ //didn't work when this was <v, had to be <=
         //choose the vertex with the least distance
         int u = findMin(dist, done); //method that gets the min of the ones that are not done
         done[u] = true;
         for(int i = 0;i<n+1; i++){
            if(!done[i] && graph[u][i] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][i] < dist[i])
               dist[i] = dist[u] + graph[u][i];
         }
      }
      int farBarn = 0, maxDist = Integer.MIN_VALUE, numBarns = 0;
      for(int i=2;i<=n;i++){
         if(dist[i] > maxDist){
            farBarn = i;
            maxDist = dist[i];
         }
      }
      for(int i=2;i<=n;i++){
         if(dist[i] == maxDist)
            numBarns++;
      }
      System.out.println(farBarn+" "+maxDist+" "+numBarns);
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