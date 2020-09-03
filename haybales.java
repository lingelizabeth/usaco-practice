/*
ID: wuhanda1
LANG: JAVA
TASK: haybales
*/
import java.io.*;
import java.util.*;
public class haybales{
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("haybales.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
      
      StringTokenizer st = new StringTokenizer(f.readLine());
      int n = Integer.parseInt(st.nextToken());
      int q = Integer.parseInt(st.nextToken());
      
      int[] bales = new int[n];
      StringTokenizer str = new StringTokenizer(f.readLine());
      for(int x=0; x<n; x++)
         bales[x] = Integer.parseInt(str.nextToken());    //an array of length n with all the locations of the haybales
      Arrays.sort(bales);
      
      int startLoc = -1;
      int endLoc = -1;
      for(int i=0; i<q; i++){
         StringTokenizer s = new StringTokenizer(f.readLine());
         int a = Integer.parseInt(s.nextToken()); //start of interval - target
         startLoc = binarySearchLower(a, bales);
         int b = Integer.parseInt(s.nextToken()); //end of interval - target
         endLoc = binarySearchUpper(b, bales);
         if(endLoc == bales.length && startLoc == bales.length)
            out.println(endLoc - startLoc);
         else if(endLoc == bales.length)
            out.println(endLoc - startLoc);
         else
            out.println(endLoc - startLoc +1);

      }  
      out.close();  
   }
   public static int binarySearchLower(int target, int[] array){
      int min = 0;
      int max = array.length;
      while(max >= min){
         int mid = (min + max)/2;
         if(array[mid] > target && mid == 0)
            return 0;
         if(array[mid] == target || (array[mid] > target && array[mid-1] < target)) //|| array[mid] is the smallest index >= target)
            return mid;
         else if(array[mid] < target && mid == array.length - 1)
            return mid + 1;
         if(array[mid] < target) //&& mid != array.length - 1) // if curr val is too small and this is not the last number, go up
            min = mid+1;
         if(array[mid] > target)
            max = mid-1;
      }
      return 0;
   }
   public static int binarySearchUpper(int target, int[] array){
      int min = 0;
      int max = array.length;
      while(max >= min){
         int mid = (min +max)/2;
         if(array[mid] == target) //|| array[mid] is the smallest index >= target)
            return mid;
         else if(array[mid] > target && array[mid-1] < target)
            return mid - 1;
         else if(array[mid] < target && mid == array.length - 1)
            return mid + 1;
         if(array[mid] < target) //&& mid != array.length - 1) // if curr val is too small and this is not the last number, go up
            min = mid+1;
         if(array[mid] > target)
            max = mid-1;
      }
      return array.length -1;
   }
}
