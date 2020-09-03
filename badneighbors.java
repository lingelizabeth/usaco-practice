/*
ID: wuhanda1
LANG: JAVA
TASK: badneighbors
*/
import java.io.*;
import java.util.*;
public class badneighbors{ 
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("badneighbors.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("badneighbors.out")));
      
      int n = Integer.parseInt(f.readLine());
      StringTokenizer st = new StringTokenizer(f.readLine());
      int[] a = new int[n]; //a for array, holds input
      int[] s = new int[n]; //an array that holds the total amt of money for that index
      
      for(int x=0; x<n; x++){
         a[x] = Integer.parseInt(st.nextToken());
         s[x] = a[x]+0;
      }
      
      int max1 = getMax(a, s, 0, n-1);
      for(int x=0; x<n; x++)
         s[x] = a[x]+0;
      int max2 = getMax(a, s, 1, n);
      out.println(Math.max(max1, max2));
      out.close();

   }
   public static int getMax(int[] a, int[] s, int start, int end){
      for(int i=start; i<end; i++){
         for(int j=start; j<i; j++){
            if((a[i]+s[j]) > s[i] && Math.abs(i-j) > 1) //&& i-j != n-1) //if the total donation is > than current and is not adjacent
                  s[i] = s[j] + a[i];
         }
      }
      int max = 0;
      for(int i:s)
         if(i > max)
            max = i;
      return max;
   }
}
      
