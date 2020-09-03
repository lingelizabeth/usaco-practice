/*
ID: wuhanda1
LANG: JAVA
TASK: subset
*/
import java.io.*;
import java.util.*;
public class subset{ 
   public static int[][] memo;
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("subset.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("subset.out")));
      
      //bottom up dp
      int n = Integer.parseInt(f.readLine());
      if(((n*(n+1))/2) % 2 == 1){ //if the total sum of the numbers isn't divisible by 2
                                  //immediately print 0
                                  //(didn't work before this)
         pw.println("0");
         pw.close();
      }
      long[][] dp = new long[n+1][(n*(n+1))/4+1]; //has to be long
                                       //table[i][j] holds the number of ways to get sum j with the first i numbers
                                       //table[i][0] is always 1
      
      dp[0][0] = 1; 
      for(int i =1; i<n+1; i++){
         for(int j=0; j<(n*(n+1))/4+1 && i!=0; j++){ //one loop copies the prev row to account for
            dp[i][j] = dp[i-1][j];           //all the possibilities without the new number i
         }
         for(int j = 0; j < (n*(n+1))/4-i+1; j++){ //another loop to count how many ways we can add i
            if(j+i <= (n*(n+1))/4)
               dp[i][j+i] += dp[i-1][j];  //ways to make sum j+i(new num) increased by the number of ways to make j
                                          //for example the number of ways to make 4+3 is the number of ways to make 4 with n-1
                                          //newbucket[4+3] += olderbucket[4]
            
         }
      }
      pw.println(dp[n][(n*(n+1))/4]/2); //answer is divided by two because it should by # of partitions
      pw.close();
   }
}
      
