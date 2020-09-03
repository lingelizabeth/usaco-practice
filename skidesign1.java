/*
ID: wuhanda1
LANG: JAVA
TASK: skidesign1
*/
import java.io.*;
import java.util.*;
public class skidesign1{
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("skidesign.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
      
      int n = Integer.parseInt(f.readLine());
      int[] hills = new int[n];
      int[] orig = new int[n];
      boolean[] changed = new boolean[n];
            
      for(int x=0; x<n; x++){
         StringTokenizer st = new StringTokenizer(f.readLine());
         hills[x] = Integer.parseInt(st.nextToken());
         orig[x] = hills[x]+0;
      }
      int cost =0, minCost = 0;
      int diff = hills[getMax(hills)] - hills[getMin(hills)];
      while(diff > 17){
         //int diff = getMax(hills) - getMin(hills);
         minCost = Integer.MAX_VALUE;
         int minX = -1;
         for(int x=0; x<=diff-17; x++){
            int newCost;
            int m = getMax(hills), o = getMin(hills);
            if(changed[m]){
               cost -= Math.abs(orig[m] - hills[m])*Math.abs(orig[m] - hills[m]);
               newCost = (int)(Math.pow(x, 2) + Math.pow(Math.abs(orig[m] - hills[m]) + (diff - x - 17), 2));
            }else if(changed[o]){
               cost -= Math.abs(hills[o] - orig[o])*Math.abs(hills[o] - orig[o]);
               newCost = (int)(Math.pow(Math.abs(hills[o] - orig[o])+x, 2));
            }else{
               newCost = (int)(Math.pow(x, 2) + Math.pow(diff - x -17, 2));
            }
            if(newCost < minCost)
               minX = x;
            minCost = Math.min(minCost, newCost);
         }
         hills[getMax(hills)] -= (diff - minX -17);
         changed[getMax(hills)] = true;
         hills[getMin(hills)] += minX;
         changed[getMin(hills)] = true;
         //if(diff == 27)
         //   System.out.println(hills[getMax(hills)]+" "+hills[getMin(hills)]);
            
         cost += minCost;
         diff = hills[getMax(hills)] - hills[getMin(hills)];
      }
      //int cost = 0;
      //for(int x=0; x<n; x++){
      //   cost += (int)(Math.pow(newHills[x] - hills[x], 2));
      //}
      out.println(cost);
      out.close();
   }
   public static int getMax(int[] array){
      int max = 0;
      for(int x=1; x<array.length; x++)
         if(array[x] > array[max])
            max = x;
      return max;
   }
   public static int getMin(int[] array){
      int min = 0;
      for(int x=1; x<array.length; x++)
         if(array[x] < array[min])
            min = x;
      return min;
   }

}
