/*
ID: wuhanda1
LANG: JAVA
TASK: hamming
*/
import java.io.*;
import java.util.*;
public class hamming{ 
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("hamming.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hamming.out")));
      StringTokenizer st = new StringTokenizer(f.readLine());
      
      int n = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());
      int[] solutions = new int[n];
      solutions[0] = 0;
     
      int next = 1;
      for(int i=0; i<Math.pow(2, b); i++){
         String a = convertToBase2(i, b);
         if(hamming(a, solutions, d, b)){
            if(next >= solutions.length)
               break;
            solutions[next] = i;
            next++;
         }
      }
      for(int i=0; i<solutions.length; i++){
         if(i%10==9 || i == solutions.length - 1)
            out.println(solutions[i]);
         else
            out.print(solutions[i]+" ");
      }
      out.close();
   }
   public static boolean hamming(String a, int[] array, int d, int b){//checks if hamming distance is far enough from each element of array
      for(int x=0; x<array.length; x++){
         if(ham(a, convertToBase2(array[x], b)) < d) //if the hamming distance is 2 small
            return false;
      }
      return true;
   }
   public static int ham(String a, String b){
      int d = 0;
      for(int x=0; x<a.length(); x++){
         if(a.charAt(x) != b.charAt(x))
            d++;
      }
      return d;
   }
   public static String convertToBase2(int num, int length){
      String out = "";
      int x = 0;
      while((int)(Math.pow(2, x+1)) <= num)
         x++;
      for(int k = x; k>=0; k--){
         int times = num/(int)(Math.pow(2, k)); //the number of times base goes into num
         out += times+"";
         num = num - times*(int)(Math.pow(2, k));
      }
      while(out.length() < length)
         out ="0"+out;
      return out;
   }
}
