/*
ID: wuhanda1
LANG: JAVA
TASK: atlarge
*/
import java.io.*;
import java.util.*;
public class atlarge{ 
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("atlarge.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("atlarge.out")));
      StringTokenizer st = new StringTokenizer(f.readLine());
      
      int n = Integer.parseInt(st.nextToken());
      int K = Integer.parseInt(st.nextToken());
      HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>(); //adjacency list
      //int[][] graph = new int[n+1][n+1];

      for(int i=0;i<n-1;i++){ //construct graph
         st = new StringTokenizer(f.readLine());
         int a = Integer.parseInt(st.nextToken());
         int b = Integer.parseInt(st.nextToken());
         if(!graph.containsKey(a))
            graph.put(a, new ArrayList<Integer>());
         graph.get(a).add(b);
         if(!graph.containsKey(b))
            graph.put(b, new ArrayList<Integer>());
         graph.get(b).add(a);
      }
      

     
      ArrayList<Integer> exits = new ArrayList<Integer>();
      for(int i=1; i<=n; i++){
         if(graph.get(i).size() == 1)
            exits.add(i);
      }    
      int[][] dp = new int[exits.size()+1][n+1];
      for(int i=0;i<exits.size();i++){ //after this dp holds  dist+1 from exits.get(i) to j
         Queue<Integer> q = new LinkedList<Integer>();
         dp[i][exits.get(i)] = 1;
         
         q.add(exits.get(i));
         while(!q.isEmpty()){
            int curr = (int)q.remove();
            //dp[curr.r1][curr.c1][curr.dir1][curr.r2][curr.c2][curr.dir2] = true;
   
            for(int next:graph.get(curr)){ //for all neighbors
               if(dp[i][next] ==0){
                  dp[i][next] = dp[i][curr]+1;
                  q.add(next);
               }
            }
         }//end copy paste
      }
      Queue<Integer> q = new LinkedList<Integer>();
         dp[exits.size()][K] = 1;
         
         q.add(K);
         while(!q.isEmpty()){
            int curr = (int)q.remove();
            //dp[curr.r1][curr.c1][curr.dir1][curr.r2][curr.c2][curr.dir2] = true;
   
            for(int next:graph.get(curr)){ //for all neighbors
               if(dp[exits.size()][next] ==0){
                  dp[exits.size()][next] = dp[exits.size()][curr]+1;
                  q.add(next);
               }
            }
         }//end copy paste
      
      boolean[] guarded = new boolean[exits.size()];
      int count=0;
      for(int i=0; i<exits.size(); i++){ //for every possible number of farmers
         
         int u = findMin(dp[exits.size()], guarded, exits);
         guarded[u] = true;
         for(int j=0;j<exits.size();j++){
            if(dp[u][exits.get(j)] <= dp[exits.size()][exits.get(j)])
               count++;
         }
         if(count >= exits.size()){
            pw.println(i+1);
            pw.close();
            break;
         }
      }
      
      
      
   }
   public static int findMin(int[] dist, boolean[] guarded, ArrayList<Integer> exits){//returns index of exits or whatever
   int mindex = -1;
   int min = Integer.MAX_VALUE;
   for(int i =0;i<exits.size(); i++){
      if(!guarded[i] && dist[exits.get(i)] < min){
         mindex = i;
         min = dist[exits.get(i)];
      }
   }
   return mindex;
}
}

      //int[] farmers = new int[n+1];
//       boolean[] guarded = new boolean[n+1];
//       int count=0;
//       for(int i=0; i<n; i++){ //for every possible number of farmers
//          
//          int u = findMin(graph[exits.get(i)], guarded, exits);
//          guarded[u] = true;
//          for(int j=0;j<exits.size();j++){
//             if(graph[u][exits.get(j)] <= graph[K][exits.get(j)])
//                count++;
//          }
//          if(count >= exits.size()){
//             pw.println(i+1);
//             pw.close();
//             break;
//          }
//       }
      //pw.close();

//    public int[] getDists(ArrayList<Integer> exits, int n, int[][] graph){
//       int[] dists = new int[exits.size()];
//       for(int i=0;i<dists.length;i++){
//          dists[i] = graph[n][exits.get(i)];
//       }
//       return dists;
//    }
//    public static int findMin(int[] dist, boolean[] done, ArrayList<Integer> exits ){
//       int mindex = 0;
//       for(int i=0; i<dist.length; i++){
//          if(!done[i] && dist[i] < dist[mindex] && exits.contains(i))
//             mindex = i;
//       }
//       return mindex;
//    }
