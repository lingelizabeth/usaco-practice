/*
ID: wuhanda1
LANG: JAVA
TASK: bphoto
*/
import java.io.*;
import java.util.*;
public class bphoto{ 
   static int[] BIT;
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("bphoto.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("bphoto.out")));
      
      int n = Integer.parseInt(f.readLine());
      int[] cows  = new int[n];
      for(int i=0;i<n;i++){
         cows[i] = Integer.parseInt(f.readLine());
      }
      int[] cows2 = cows.clone();
      Arrays.sort(cows2);
      for(int i=0;i<n;i++){
         int index = binarySearch(cows2, 0, cows2.length, cows[i]);
         cows[i] = index;
      } //cows[i] is replaced w range (0, n)
      BIT = new int[n+1]; //n+1??
      int[] left = new int[n]; //number of cows taller than cow[i] to its left, based on index not height???
      int[] right = new int[n]; //number of cows taller than cow[i] to its right
      for(int i=0;i<n;i++){//array1 left to right
         update(cows[i], 1, n);
         left[i] = i - (getSum(cows[i])) +1;
      }
      BIT = new int[n+1];
      for(int i=0;i<n;i++){//array1 right to left
         update(cows[n-i-1], 1, n);
         right[n-i-1] = i - getSum(cows[n-i-1]) +1;
      }
      int ans = 0;
      for(int i=0;i<n;i++){
         if(right[i] > left[i]*2 || left[i] > right[i]*2)
            ans++;
      
      }
      //System.out.println(ans);
      pw.println(ans);
      pw.close();
   }
   public static void update(int index, int val, int n){
      index++;
      while(index <= n){
         BIT[index] += val;
         index = index + (index & (-index));
      }
   }
   public static int getSum(int index){
      int sum = 0;
      index++;
      while(index > 0){
         sum += BIT[index];
         index = index - (index & (-index));
      }
      return sum;
   }
   public static int binarySearch(int arr[], int l, int r, int x) //left, right, x, returns INDEX
    {
        if (r>=l)
        {
            int mid = l + (r - l)/2;
 
            // If the element is present at the 
            // middle itself
            if (arr[mid] == x)
               return mid;
 
            // If element is smaller than mid, then 
            // it can only be present in left subarray
            if (arr[mid] > x)
               return binarySearch(arr, l, mid-1, x);
 
            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid+1, r, x);
        }
 
        // We reach here when element is not present
        //  in array
        return -1;
    }
}