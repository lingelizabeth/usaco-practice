/*
ID: wuhanda1
LANG: JAVA
TASK: numtri
*/

import java.io.*;
import java.util.*;
public class numtri{
   public static void main(String[] args) throws IOException {
      BufferedReader f = new BufferedReader(new FileReader("numtri.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
      
      int n = Integer.parseInt(f.readLine());
      int[][] triangle = new int[n][n];
      int[][] maxSum = new int[n][n];
      for(int i=0;i<n;i++){
         StringTokenizer st = new StringTokenizer(f.readLine());
         for(int j=0; j<n; j++){
            if(st.hasMoreTokens())
               triangle[i][j] = Integer.parseInt(st.nextToken());
         }
      }
      maxSum[n-1] = triangle[n-1]; //set all the maxSums of the last row to their vals
      for(int i=n-2; i>=0; i--){ //going upwards thru the rows
         for(int j=0; j<i+1;j++){
            maxSum[i][j] = triangle[i][j] + Math.max(maxSum[i+1][j], maxSum[i+1][j+1]);
         }
      }
      int ans = Integer.MIN_VALUE;
      for(int j=0; j<n;j++){
         if(maxSum[n-1][j] >ans)
            ans = maxSum[n-1][j];
      }
      out.println(maxSum[0][0]);
      out.close();
   }
}