/*
ID: wuhanda1
LANG: JAVA
TASK: chessMetric
*/
import java.io.*;
import java.util.*;
public class chessMetric{ 
   static int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {1, 1}, {1, -1}, {-1, -1}, {-1, 1},
   {2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("chessMetric.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("chessMetric.out")));
      int size = Integer.parseInt(f.readLine());
      StringTokenizer st = new StringTokenizer(f.readLine());
      st.nextToken();
      int startX = Integer.parseInt(st.nextToken());
      st.nextToken();
      int startY = Integer.parseInt(st.nextToken());
      st = new StringTokenizer(f.readLine());
      st.nextToken();
      int endX = Integer.parseInt(st.nextToken());
      st.nextToken();
      int endY = Integer.parseInt(st.nextToken());
      int numMoves = Integer.parseInt(f.readLine());
      long[][] dp = new long[size][size];
      
      dp[startX][startY] = 1; 
      for(int m=0;m<numMoves;m++){
         for(int i=0; i<size;i++){
            for(int j=0;j<size;j++){
               for(int d=0;d<dir.length;d++){
                  dp[i][j] = dp[i+dir[d][0]][j+dir[d][1]]+1;
               }
            }
         }
      }
   }
}