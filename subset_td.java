/*
ID: wuhanda1
LANG: JAVA
TASK: subset
*/
import java.io.*;
import java.util.*;
public class subset_td{ 
   public static int[][] memo;
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("subset.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("subset.out")));
      
      int n = Integer.parseInt(f.readLine());
      int[] set = new int[n];
      //for(int i = 0; i<n; i++)
      //   set[i] = i+1;
      memo = new int[n+1][sum(n)/2+1];
      for(int i = 0; i<memo.length; i++){
         Arrays.fill(memo[i], -1);
      }
      if(sum(n)%2 == 1)
         out.println("0");
      else
         out.println(ways(1, sum(n)/2, n)/2);
      out.close();
   }
   public static long ways(int num, int sum, int n){ //num is the current value in the subset
                                                     //we choose to include it or not 
                                                     //so we go thru all values in the set sequentially
      if(sum == 0)
         return 1;
      if(sum < 0)
         return 0;
      if(num == n+1)
         return 0;
      //System.out.println(memo[num][sum]);
      if(memo[num][sum] != -1)
         return memo[num][sum]; // = ways(num+1, sum, n);
      //if(memo[num+1][sum-n] == -1)
      //      memo[num+1][sum-n] = ways(num+1, sum-num, n);
      long ans = -1;
      ans =  ways(num+1, sum, n) + ways(num+1, sum-num, n);
      memo[num][sum] = (int)ans;
      //System.out.println(num+" "+sum+" "+ways(num+1, sum, n)+" "+ways(num+1, sum-num, n)+" "+ans);
      return ans;
   }
   public static int sum(int n){
      int s = 0;
      for(int i =1; i<=n; i++)
         s += i;
      return s;
   }
}