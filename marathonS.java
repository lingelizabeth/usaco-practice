//(Analysis by Nick Wu)
//Let's define f(n,k)f(n,k) to be the smallest distance needed to end up at point nn having skipped exactly kk points.
//Given that we are at a specific point, if we knew that we wanted to skip xx points, then we would want to know f(n-x-1,k-x)f(n-x-1,k-x). However, we don't know what the optimal number is. We can try all possible numbers of points to skip - this gives us an O(nk2)O(nk2) algorithm.
//Here is my Java solution, which computes all f(n,k)f(n,k) values in a bottom-up fashion.

import java.io.*;
import java.util.*;
public class marathonS {
  
  static int[] x, y;
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("marathon.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("marathon.out")));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    x = new int[n];
    y = new int[n];
    for(int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      x[i] = Integer.parseInt(st.nextToken());
      y[i] = Integer.parseInt(st.nextToken());
    }
    int[][] dp = new int[k+1][n];
    for(int i = 0; i < dp.length; i++) {
      Arrays.fill(dp[i], 1 << 30);
    }
    dp[0][0] = 0;
    dp[0][n-1] = distBetween(0, n-1);
    for(int y = 0; y < n; y++) { //to loop through all the points 0 to the end
      for(int p = 0; p < y; p++) {
        //for(int l = j+1; l < n && i + l-j-1 <= k; l++) {
          //nt nextI = i + (l-j-1);
          //int nextJ = l;
          dp[x][y] = Math.min(dp[x][y], dp[x-1][p] + distBetween(p, y));
        //}
      }
    }
    pw.println(dp[k][n-1]);
    pw.close();
  }
  
  public static int distBetween(int i, int j) {
    return dist(x[i], y[i], x[j], y[j]);  
  }

  public static int dist(int x1, int y1, int x2, int y2) {
    int x = x1-x2;
    int y = y1-y2;
    return Math.abs(x) + Math.abs(y);
  }

}