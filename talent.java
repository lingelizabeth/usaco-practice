/*
ID: wuhanda1
LANG: JAVA
TASK: talent
*/
import java.io.*;
import java.util.*;
public class talent{ 
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("talent.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("talent.out")));
      StringTokenizer st = new StringTokenizer(f.readLine());
      int n = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      int[] weights = new int[n];
      int[] talents = new int[n];
      double[] ratios = new double[n];
      for(int i=0;i<n;i++){
         st = new StringTokenizer(f.readLine());
         weights[i] = Integer.parseInt(st.nextToken());
         talents[i] = Integer.parseInt(st.nextToken());
         ratios[i] = (double)talents[i]/weights[i];
         //System.out.println(ratios[i]);
      }
      boolean[] used = new boolean[n];
      int totalWeight = 0, totalTalent = 0;
      while(totalWeight < w){
         int i = findMax(ratios, used);
         used[i] = true;
         totalWeight += weights[i];
         totalTalent += talents[i];
      }
      pw.println((int)(Math.floor(((double)totalTalent/totalWeight)*1000)));
      pw.close();
   }
      public static int findMax(double[] ratios, boolean[] used){
      int mindex = 0;
      for(int i=0; i<ratios.length; i++){
         if(!used[i] && ratios[i] > ratios[mindex])
            mindex = i;
      }
      return mindex;
   }
}