/*
ID: wuhanda1
LANG: JAVA
TASK: hayfeast
*/
import java.io.*;
import java.util.*;
public class hayfeast{ 
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("hayfeast.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hayfeast.out")));
      //read input
      StringTokenizer st = new StringTokenizer(f.readLine());
      int n = Integer.parseInt(st.nextToken());
      long m = Long.parseLong(st.nextToken());
      int[] flavor = new int[n]; //flavor[i] is the flavor of bale i
      int[] spicy = new int[n];
      for(int i=0;i<n;i++){
         st = new StringTokenizer(f.readLine());
         flavor[i] = Integer.parseInt(st.nextToken());
         spicy[i] = Integer.parseInt(st.nextToken());
      }
      int i =0, j =0, currFlavor = flavor[0];
      int minSpice = Integer.MAX_VALUE();
      while(j<=n){
         while(currFlavor < m){
            j++;
            currFlavor += flavor[j];
         }
         while(currFlavor >= m){
            if(currFlavor >= m)
               minSpice = Math.min(minSpice, MINSPICE ON THIS INTERVAL);
            i++;
            currFlavor -= flavor[j];
         }
      }

   }
}
//    public static int maxSpice(int i, int j, int[] spicy){
//       int max = Integer.MIN_VALUE;
//       for(int k = i;k<j;k++){ //includes i but not j
//          if(spicy[k] > max)
//             max = spicy[k];
//       }
//       return max;
//    }


//old code
//       //calculate prefix sums of flavor AND PREFIX SUMS OF MAX VALUES
//       long[] sums = new long[n+1];//sums[i] holds sum of flavor from bale 0 to bale i-1
//       //int[] maxs = new int[n+1] NOPE DOESN'T WORK
//       //sums[1] += flavor[0];  //this way sums[0] just has the number 0
//       for(int i=0;i<n;i++){
//          sums[i+1] = sums[i]+flavor[i];
//       }
//       //loop through every possible interval to check for flavor req and min spiciness
//       int minSpice = Integer.MAX_VALUE;
//       for(int i=0;i<n;i++){
//          for(int j=i+1;j<n+1;j++){
//             if(sums[j] - sums[i] >= m){ //if this is i=1 to j=5 it means bales 1, 2, 3, 4
//                int maxsp = maxSpice(i, j, spicy);  //includes i but not j
//                if(maxsp < minSpice)
//                   minSpice = maxsp;
//             }
//          }
//       }
//       pw.println(minSpice);
//       pw.close();