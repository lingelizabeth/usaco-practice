/*
ID: wuhanda1
LANG: JAVA
TASK: sort3
*/
import java.io.*;
import java.util.*;
public class sort3{ 
   public static void main(String[] args) throws IOException {
      BufferedReader f = new BufferedReader(new FileReader("sort3.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));
      
      int n1 = 0, n2 = 0, n3 = 0; //1s go 0 to n1 - 1, 2s go n1 to n2 - 1, 3s go n2 to n3 - 1
      int n = Integer.parseInt(f.readLine());
      int[] nums = new int[n];
      int swaps = 0;
      for(int x=0; x<n; x++){
         nums[x] = Integer.parseInt(f.readLine());
         if(nums[x] == 1)
            n1++;
         else if(nums[x] == 2)
            n2++;
         else if(nums[x] == 3)
            n3++;
      }
      //swap as many as possible of the 1s in the 2 part with the 2s in the 1 part
      int one = 0, two = n1;
      while(one < n1-1 && two < n1 + n2 - 1){
         if(nums[one] != 2)
            one++;
         if(nums[two] != 1)
            two++;
         if(nums[one] == 2 && nums[two] == 1){
            swaps++;
            swap(one, two, nums);
         }   
      }
      //swap as many as possible of the 1s in the 3 part with the 3s in the 1 part
      one = 0;
      int three = n1+n2;
      while(one < n1-1 && three < n1+n2+n3 - 1){
         if(nums[one] != 3)
            one++;
         if(nums[three] != 1)
            three++;
         if(nums[one] == 3 && nums[three] == 1){
            swaps++;
            swap(one, three, nums);
         }   
      }
      //swap as many as possible of the 2s in the 3 part with the 3s in the 2 part
      three = n1+n2;
      two = n1;
      while(two < n1+n2 - 1 && three < n1+n2+n3-1){
         if(nums[three] != 2)
            three++;
         if(nums[two] != 3)
            two++;
         if(nums[three] == 2 && nums[two] == 3){
            swaps++;
            swap(three, two, nums);
         }   
      }
      //swap all the ones into place O(n) time
      for(int x=n1; x<nums.length; x++){
         if(nums[x] == 1){
            for(int y=0; y<=n1-1;y++){
               if(nums[y] != 1){
                  swap(x, y, nums);
                  swaps++;
                  break;
               }
            }
         }
      }
      //swap all the twos into place O(n) time
      for(int x=0; x<nums.length; x++){
         if(x == n1)
            x = n1+n2;//skip over the 2s section
         if(nums[x] == 2){
            for(int y=n1; y<=n1+n2-1;y++){
               if(nums[y] != 2){
                  swap(x, y, nums);
                  swaps++;
                  break;
               }
            }
         }
      }
      out.println(swaps);
      out.close();
   }
   public static void swap(int a, int b, int[] array){
      int temp = array[a];
      array[a] = array[b];
      array[b] = temp;
   }
}