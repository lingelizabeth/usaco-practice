/*
ID: wuhanda1
LANG: JAVA
TASK: square
*/
import java.io.*;
import java.util.*;
public class square{
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("square.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("square.out")));
      
      int[] x = new int[4];
      int[] y = new int[4];
      
      for(int i=0; i<2; i++){ //populates the 2 arrays w four points
         StringTokenizer st = new StringTokenizer(f.readLine());
         if(i == 0){
            x[0] = Integer.parseInt(st.nextToken());
            y[0] = Integer.parseInt(st.nextToken());
            x[1] = Integer.parseInt(st.nextToken());
            y[1] = Integer.parseInt(st.nextToken());
         }else{
            x[2] = Integer.parseInt(st.nextToken());
            y[2] = Integer.parseInt(st.nextToken());
            x[3] = Integer.parseInt(st.nextToken());
            y[3] = Integer.parseInt(st.nextToken());
         }
      }
      out.println((int)(Math.pow(Math.max(getMax(x) - getMin(x), getMax(y) - getMin(y)), 2)));
      out.close();
   }
   public static int getMax(int[] array){
      int max = 0;
      for(int x=0; x<array.length; x++)
         if(array[x] > max)
            max = array[x];
      return max;
   }
   public static int getMin(int[] array){
      int min = 11;
      for(int x=0; x<array.length; x++)
         if(array[x] < min)
            min = array[x];
      return min;
   }
}
