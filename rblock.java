/*
ID: wuhanda1
LANG: JAVA
TASK: rblock
*/
import java.io.*;
import java.util.*;
public class rblock{ 
   static int n, m;
   static int[][] farm;
   static int[] dist, prev;
   static boolean[] visited;
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("rblock.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("rblock.out")));
      
      StringTokenizer s = new StringTokenizer(f.readLine());
      n = Integer.parseInt(s.nextToken());
      m = Integer.parseInt(s.nextToken());
      
      farm = new int[n][n]; //farm is a 2D adjacency matrix holding the length of the path from [a][b] or infinity(63) otherwise
      for(int i=0; i< farm.length; i++)
         Arrays.fill(farm[i], 63);
      for(int i=0; i<m; i++){ //filling the farm array
         StringTokenizer st = new StringTokenizer(f.readLine());
         int A_j = Integer.parseInt(st.nextToken());
         int B_j = Integer.parseInt(st.nextToken());
         int L_j = Integer.parseInt(st.nextToken());
         farm[A_j-1][B_j-1] = L_j;
      }
      int original = best_path(0, n-1);
      ArrayList<Integer> path = new ArrayList<Integer>();
      
      for(int i=n-1; i!= -1; i=prev[i]) //prev is an array that holds the index of the prev node
         path.add(i);
         
      int most_doubled = original;
      
      for(int i =0; i+1<(int)path.size(); i++){ //what?
         int a = path.get(i), b = path.get(i+1);
         farm[a][b] *= 2;
         farm[b][a] *= 2;
         most_doubled = Math.max(most_doubled, best_path(0, n-1));
         farm[a][b] /= 2;
         farm[b][a] /= 2;
      }
      out.println(most_doubled-original);
      out.close();
   }
   public static int best_path(int start, int end){
      dist = new int[n];
      prev = new int[n]; //we have this array just so we know what the path is the first time
      visited = new boolean[n]; //keep track of which nodes we've visited, so we always go to a new one
      Arrays.fill(dist, 63); //distance to every node is infinity(63)
      Arrays.fill(prev, -1);
      dist[start] = 0; //except the starting node, which has distance 0
      while(true){
         int close = -1;
         for(int i=0; i<n; i++) //look for the shortest distance one, looping through every node
            if(!visited[i] && (close == -1 || dist[i] < dist[close])) //checks if the node is visited and gets the shortest dist
               close = i;                                            //this is just djikstra's
               
         if(close == -1) //the last time you go thru everything will be vistied
            break;   //so close will be -1, and you break.
            
         visited[close] = true; //mark current node as visited
         
         for(int i=0;i<n;i++){ //looping through every node ,why do we loop through every node rather than the ones adjacent to curr?
            if(dist[close] + farm[close][i] < dist[i]){ //if the distance from curr to the node is less than its current dist
               dist[i] = dist[close] + farm[close][i]; //replace its current dist
               prev[i] = close;  //and then use the prev[] to say the previous one is the curr node
            }
               
         }
      }
      return dist[end]; //return the distance to the end, which is the sum of what it took to get there
   }
}