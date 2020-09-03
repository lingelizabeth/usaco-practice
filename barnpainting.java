/*
ID: wuhanda1
LANG: JAVA
TASK: barnpainting
*/
import java.io.*;
import java.util.*;
public class barnpainting{ 
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("barnpainting.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("barnpainting.out")));
      
      //read in input
      StringTokenizer st = new StringTokenizer(f.readLine());
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken()); 
      //int[][] graph = new int[n+1][n+1]; //basically adjacency matrix, 0 is empty
      Hashmap<Integer, ArrayList<Integer>> graph = new Hashmap<Integer, ArrayList<Integer>>(); //adjacency list
      int[] colors = new int[n+1]; //0 is empty, colors[i] is the color of barn i
      int[][] dp = new int[n+1][3]; //no vertex 0, color 3 is 0
      for(int i=0;i<n-1;i++){
         st = new StringTokenizer(f.readLine());
         int a = Integer.parseInt(st.nextToken());
         int b = Integer.parseInt(st.nextToken()); 
         //graph[a][b] = 1;
         //graph[b][a] = 1;
         if(!graph.containsKey(a))
            graph.put(a, new ArrayList<Integer>);
         graph.get(a).add(b);
         if(!graph.containsKey(b))
            graph.put(b, new ArrayList<Integer>);
         graph.get(b).add(a);
      }
      for(int i=0; i<k; i++){
         st = new StringTokenizer(f.readLine());
         int a = Integer.parseInt(st.nextToken());
         int b = Integer.parseInt(st.nextToken());
         colors[a] = (b%3);
         //dp[a][(b+1)%3] = 0;
         //dp[a][(b+2)%3] = 0;
      }
      solve(v, 0);
      //int ans = dp[
      
      
   }
   public static void solve(int v, int parent){
      for(int u:graph.get(v))//neightbors(v)
         calc(u,v);
      if(colors[v] != 0){
	      dp[v][(colors[v]+1)%3] = 0; d[v][(colors[v]+2)%3] = 0;
         }
      dp[v][0] = 1; //why
      for(int u: graph.get(v)){
         if(u == parent)
            break;//except parent
         dp[v][0] *= (dp[u][1]+dp[u][2]); //distributive property, add (me*kid in color 1 +me*kid in color 2)
      }
      //return dp[v][
      
      
      

   }

}



//       //loop....through
//       int[] possible = new int[n+1]; //0 is a dummy
//       possible[0] = 1;
//       for(int i=1;i<n+1;i++){ //1 thru n for each vertex
//          int count = 0;
//          for(int j=0;j<graph.get(i).size(); j++){
//             if(colors[j] != 0)
//                count++;
//          }
//       }
//    public static int ways(int[] colors, HashMap<Integer, ArrayList<Integer>> graph){
//       if(!contains(colors, 0))
//          return 1; //1 possibility.
//       for(int i=0;i<colors.length;i++){//for every one that has color
//          if(colors[i] !=0){
//             int[] c = {1, 2, 3};
//             for(int j=0;j<graph.get(i);j++){//for every one of its neighbors
//                ways(
//             }
//             
//          }
//       }
//    }
//    public static boolean contains(int[] a, int x){
//       for(int i=0;i<a.length;i++){
//          if(a[i] == x)
//             return true;
//       }
//       return false;
//    }