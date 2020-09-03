/*
ID: wuhanda1
LANG: JAVA
TASK: feast
*/
import java.io.*;
import java.util.*;
public class feast{ 
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("feast.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("feast.out")));
      StringTokenizer st = new StringTokenizer(f.readLine());
      int t = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      boolean[][] dp = new boolean[2][t+1];//the first is drank already or not, 2nd is current fullness
                              //those are the 2 parameters because apples/oranges don't rlly matter
      dp[0][0]=true;
      for(int i = 0;i<dp.length;i++){
         for(int j = 0;j<dp[j].length;j++){
            if(!dp[i][j])
               continue;
            if(j+x <= t)
               dp[i][j+x] = true; //can eat one more apple
            if(j+y <= t)
               dp[i][j+y] = true; //mark if can eat one more orange
            if(i+1<dp.length) //if we haven't drank yet
               dp[i+1][j/2] = true;//mark point after drinking water in 2nd row, which means after drinking
               //mark fullness as half of current
         }
      }
      int ret = t;
      while(!dp[1][ret]){
         ret--;
      }
      System.out.println(ret);
   }
}