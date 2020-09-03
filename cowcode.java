/*
ID: wuhanda1
LANG: JAVA
TASK: cowcode
*/
import java.io.*;
import java.util.*;
public class cowcode{ 
   static long[] array;
   static String s;
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("cowcode.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowcode.out")));
      StringTokenizer st = new StringTokenizer(f.readLine());
      s = st.nextToken();
      long n = Long.parseLong(st.nextToken());

      //generate array
      array = new long[60]; //2^40 > 10^18
      int iter = 0;
      for(int x=0; x<array.length; x++){
         if(s.length()*(long)(Math.pow(2, x)) < Long.MAX_VALUE)
            array[x] = s.length()*(long)(Math.pow(2, x));
         else
            array[x] = Long.MAX_VALUE;
         if(x > 0 && (array[x] > n && array[x-1] < n))
            iter = x;
      }
      //int iter = 0;
//       long length = (long)(s.length());
//       while(2*length < n){
//          length *= 2;
//          iter++;
//       }
      String ans = recur(n, iter);
      out.println(ans);
      out.close();
   }
   public static String recur(long n, int i){ //i is the iteration number
      if(i == 0) //if this is the first iteration
         return s.charAt((int)(n-1))+"";
      long index = n%array[i-1]; //indexth number of the current block 
      if(index == 0)
         index = array[i-1];
      if(n <= array[i-1])//if this is the first half of the iteration
         return recur(n, i-1);
      else if(index == 1) //if this is the first number of the current block
         return recur(array[i-1], i-1);
      else
         return recur(index-1, i-1);
   }
}
