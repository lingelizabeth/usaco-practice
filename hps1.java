/*
ID: wuhanda1
LANG: JAVA
TASK: hps1
*/
import java.io.*;
import java.util.*;
public class hps1{ 
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("hps1.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hps1.out")));
      
      StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken()); 
		int k = Integer.parseInt(st.nextToken());
      int[] FJ = new int[n];
      String str = "HPS";
      for(int i=0;i<n;i++){
         FJ[i] = str.indexOf(f.readLine().charAt(0));
      }
      
      int[][][] dp = new int[n][k+1][3]; //0 is h, 1 is p, 2 is s
      //dp[0][0][2] = 1;
      for(int j=0;j<3;j++){
         dp[0][0][j] = win(FJ, 0, j);
      }
      for(int i=1;i<n;i++){
         for(int j=0;j<3;j++){

            dp[i][0][j] = dp[i-1][0][j] + win(FJ, i, j);
         }
      }
      for(int i=1;i<n;i++){
         for(int j=1;j<=k;j++){
            dp[i][j][0] = Math.max(Math.max(dp[i-1][j-1][1] + win(FJ, i, 0), dp[i-1][j][0] + win(FJ, i, 0)), 
               dp[i-1][j-1][2] + win(FJ, i, 0));
            dp[i][j][1] = Math.max(Math.max(dp[i-1][j-1][0] + win(FJ, i, 1), dp[i-1][j][1] + win(FJ, i, 1)), 
               dp[i-1][j-1][2] + win(FJ, i, 1));
            dp[i][j][2] = Math.max(Math.max(dp[i-1][j-1][1] + win(FJ, i, 2), dp[i-1][j][2] + win(FJ, i, 2)), 
               dp[i-1][j-1][0] + win(FJ, i, 2));
         }
      }
      System.out.println(Math.max(Math.max(dp[n-1][k][0], dp[n-1][k][1]), dp[n-1][k][2]));
   }

   public static int win(int[] FJ, int i, int move){
      if((FJ[i] == 0 && move == 1) || (FJ[i] == 1 && move == 2) || (FJ[i] == 2 && move == 0)){
         return 1;
      }
      return 0;
   }
}