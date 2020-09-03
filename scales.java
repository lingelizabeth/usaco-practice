/*
ID: wuhanda1
LANG: JAVA
TASK: scales
*/
import java.io.*;
import java.util.*;
public class scales{ 
   static int n; //number of weights
   static int[] weights;
   static int[][] memo;
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("scales.in"));
      //Scanner sc = new Scanner(System.in);
      StringTokenizer st = new StringTokenizer(f.readLine());
      
      n = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      weights = new int[n];
      for(int i=0;i<n;i++){
         weights[i] = Integer.parseInt(f.readLine());
      }
      memo = new int[n][c+1];
      for(int[] a: memo)
         Arrays.fill(a, -1);
      System.out.println(dp(0, c)+"");
   }
   public static int dp(int id, int rem){//id of the current weight and REMaining
                           //it returns the maxweight
      if(id < n && memo[id][rem] != -1)
         return memo[id][rem];
      if(rem == 0){
         memo[id][rem] = 0;
         return 0;
      }if(id == n){ //SO ID is 0...n-1!!!
         return 0;
      }if(weights[id] > rem){
         memo[id][rem] = dp(id + 1, rem);
         return memo[id][rem];
      }if(weights[id] <= rem){
         memo[id][rem] = Math.max(dp(id + 1, rem), weights[id] + dp(id + 1, rem-weights[id]));
         return memo[id][rem];
      }
      return 0;
   }
}