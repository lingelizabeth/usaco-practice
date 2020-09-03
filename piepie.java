/*
ID: wuhanda1
LANG: JAVA
TASK: piepie
*/
import java.io.*;
import java.util.*;
public class piepie{ 
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("piepie.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("piepie.out")));
      
      //read in input
      StringTokenizer st = new StringTokenizer(f.readLine());
      int n = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken()); //change to long
      int[][] pies = new int[2*n][2]; //change to long
      for(int i =0; i<2*n; i++){
         st = new StringTokenizer(f.readLine());
         pies[i][0] = Integer.parseInt(st.nextToken()); //bessie's tastiness val
         pies[i][1] = Integer.parseInt(st.nextToken()); //elsie's
      }
      int[] ans = new int[n];
      Arrays.fill(ans, Integer.MAX_VALUE);
      for(int c=0;c<n;c++){
         //int[] lastPie = new int[2*n]; //0 for b, 1 for e USED?
         //Arrays.fill(lastPie, -1);
         boolean[] used = new boolean[2*n];
         int[] dp = new int[2*n];//holds length of the subsequence
         Arrays.fill(dp, Integer.MAX_VALUE);
         dp[c] = 1;//start w pie c
         used[c] = true;
         //int lastPie = c;
         for(int i=0;i<dp.length;i++){  
         for(int lastPie = 0; lastPie<dp.length;lastPie++){        
            if(lastPie < n && i>=n && pies[lastPie][1] - pies[i][1] <= d && used[lastPie]){//elsie giving to bessie
               dp[i] = Math.min(dp[i], dp[lastPie]+1);
            }else if(lastPie>=n && i <n && pies[lastPie][0] - pies[i][0] <= d &&used[lastPie]){ //bessie giving to elsie
               dp[i] = Math.min(dp[i], dp[lastPie]+1);
            }
         }
         }
         ArrayList<Integer> endPies = getEndPies(pies);
         for(int i=0;i<endPies.size();i++){
            if(dp[endPies.get(i)] < ans[c])
               ans[c] = dp[endPies.get(i)];
         }
      }
      for(int a: ans){
          pw.println(a);
       }
       pw.close();
   }
   public static ArrayList<Integer> getEndPies(int[][] pies){//returns list of indices of pies w 0 tasty
      ArrayList<Integer> ret = new ArrayList<Integer>();
      for(int i=0;i<pies.length;i++){
         if(pies[i][0] == 0 || pies[i][1] == 0)
            ret.add(i);
      }
      return ret;
   }
}
   
// class Exchange{
//    int[] tasty; //size 2 array w bessie's and elsie's tastiness vals
//    int numGiven;
//    boolean[] used;//size 2*n array of all pies
//    boolean isElsie; //refers to the giver (aka whos pie it is)
//    public Exchange(int[] t, int n, boolean[] u, boolean i){
//       tasty = t;
//       numGiven = n;
//       used = u;
//       isElsie = i;
//    }
// }

     //  Queue q = new LinkedList<Exchange>(); //this has to be a bfs to find the min numGiven
//       int[] ans = new int[n];
//       for(int c=0;c<n;c++){
//          int minGiven = Integer.MAX_VALUE;
//          boolean[] used = new boolean[2*n];
//          used[c] = true;
//          q.add(new Exchange(pies[c], 1, used, false));
//          while(!q.isEmpty()){
//             Exchange curr = (Exchange)q.remove();
//             if(curr.tasty[(!curr.isElsie)?1:0] == 0){
//                if(curr.numGiven<minGiven)
//                   minGiven = curr.numGiven;
//             }
//             if(curr.isElsie){
//                for(int i =0; i<n; i++){
//                   if(!curr.used[i] && pies[i][0] - curr.tasty[0] <= d){
//                      curr.used[i] = true;
//                      q.add(new Exchange(pies[i], curr.numGiven+1, curr.used, !curr.isElsie));
//                   }
//                }
//             }else if(!curr.isElsie){
//                for(int i =n; i<2*n; i++){
//                   if(!curr.used[i] && pies[i][1] - curr.tasty[1] <= d){
//                      curr.used[i] = true;
//                      q.add(new Exchange(pies[i], curr.numGiven+1, curr.used, !curr.isElsie));
//                   }
//                }
//             }
//          }
//          if(minGiven == Integer.MAX_VALUE) minGiven = -1;
//          ans[c] = minGiven;
//       }
//       for(int a: ans){
//          pw.println(a);
//       }
//       pw.close();