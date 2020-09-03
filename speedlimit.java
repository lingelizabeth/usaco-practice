/*
ID: wuhanda1
LANG: JAVA
TASK: speedlimit
*/
import java.io.*;
import java.util.*;
public class speedlimit{ 
   public static void main(String[] args) throws IOException{
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int townX = sc.nextInt();
      int townY = sc.nextInt();
      sc.nextLine();
      //time = dist*speed limit, keep graph w time as the thing
      double[][] graph = new double[n][n]; 
      for(int i=0;i<n;i++ ){
         // speedLim = sc.nextInt();
//          t
         StringTokenizer st = new StringTokenizer(sc.nextLine());
         if(!st.hasMoreTokens())
            break;
         int speedLimit = Integer.parseInt(st.nextToken());
         int firstCity = Integer.parseInt(st.nextToken());
         int lastCity = firstCity;
         int totalLength = 0;
         //firstLength = st.nextToken();
         while(st.hasMoreTokens()){ //currently only works for 2 cities
            int someLength = Integer.parseInt(st.nextToken());
            totalLength += someLength;
            int someCity = Integer.parseInt(st.nextToken());
            if(graph[lastCity][someCity] == 0.0 || (someLength/speedLimit) < graph[lastCity][someCity]){
               graph[lastCity][someCity] = someLength/speedLimit;    
               graph[someCity][lastCity] = someLength/speedLimit;  
            }
            lastCity=someCity;    
         }
         if(graph[firstCity][lastCity] == 0.0 || (totalLength/speedLimit) < graph[firstCity][lastCity]){
            graph[firstCity][lastCity] = totalLength/speedLimit;
            graph[lastCity][firstCity] = totalLength/speedLimit;
         }
      }
      //run a dijkstra on it
      double[] dist = new double[n];
      boolean[] done = new boolean[n];
      Arrays.fill(dist, Integer.MAX_VALUE);//change those to -1 later
      dist[townX] = 0;
      
      for(int count=0; count<=n; count++){ //didn't work when this was <v, had to be <=
         //choose the vertex with the least distance
         int u = findMin(dist, done); //method that gets the min of the ones that are not done
         done[u] = true;
         for(int i = 0;i<n; i++){
            if(!done[i] && graph[u][i] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][i] < dist[i])
               dist[i] = dist[u] + graph[u][i];
         }
      }
      System.out.println(dist[townY]);
   }
   public static int findMin(double[] dist, boolean[] done){
      int mindex = 0;
      for(int i=0; i<dist.length; i++){
         if(!done[i] && dist[i] <= dist[mindex])
            mindex = i;
      }
      return mindex;
   }
}