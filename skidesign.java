/*
ID: wuhanda1
LANG: JAVA
TASK: skidesign
*/

import java.io.*;
import java.util.*;

public class skidesign {
   public static void main(String[] args) throws IOException {
      BufferedReader f = new BufferedReader(new FileReader("skidesign.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
      
      int n = Integer.parseInt(f.readLine());
      int[] hills = new int[n];
      for(int x=0; x<n; x++) {
         StringTokenizer st = new StringTokenizer(f.readLine());
         hills[x] = Integer.parseInt(st.nextToken());
      }
      int cost = Integer.MAX_VALUE;
      for(int min=0; min<=100; min++){
         int minCost = 0;
            for(int i = 0; i < n; i++){
               int diff = hills[i] - min;
               if(diff > 17){
                   diff -= 17;
                   minCost += diff * diff;
               }else if(diff < 0){
                  minCost += diff * diff;
               }
            }
            cost = Math.min(cost, minCost);
        }
        out.println(cost);
        out.close();
    }
}