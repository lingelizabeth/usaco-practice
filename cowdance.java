/*
ID: wuhanda1
LANG: JAVA
TASK: cowdance
*/
import java.io.*;
import java.util.*;
public class cowdance{ 
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("cowdance.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowdance.out")));
      
      StringTokenizer st = new StringTokenizer(f.readLine());
      int n = Integer.parseInt(st.nextToken());
      int tmax = Integer.parseInt(st.nextToken());
      ArrayList<Integer> cows = new ArrayList<Integer>();
      for(int i=0; i<n; i++){
         cows.add(Integer.parseInt(f.readLine()));
      }
      
      //binary search for the minimum value of K
      int min = 1;
      int max = n;
      while(max != min){
         int mid = (min+max)/2; //current value of K
         ArrayList<Integer> cowscopy = new ArrayList<Integer>();
         for(int x: cows)
            cowscopy.add(x);
         
         int[] stage = new int[mid];
         for(int x=0; x<stage.length; x++){
            stage[x] = cowscopy.remove(0);
         }
         int time = 0;
         while(!cowscopy.isEmpty()){
            int m = Integer.MAX_VALUE;
            int index = -1;
            for(int x=0; x<stage.length; x++){
               if(stage[x] < m){
                  m = stage[x];
                  index = x;
               } 
            }
            stage = subtract(stage, m);
            if(!cowscopy.isEmpty())
               stage[index] = cowscopy.remove(0);
            time += m;
         }
         time += findMax(stage);
         if(time <= tmax)
            max = mid;
         else
            min = mid+1;
      }
      out.println(min);
      out.close();
   }
   public static int[] subtract(int[] a, int s){
      for(int x=0; x<a.length; x++){
         a[x] -= s;
      }
      return a;
   }
   public static int findMax(int[] a){
      int max = Integer.MIN_VALUE;
      for(int x=0; x<a.length; x++){
         if(a[x] > max)
            max = a[x];
      }
      return max;
   }
}
