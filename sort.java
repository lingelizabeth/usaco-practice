/*
ID: wuhanda1
LANG: JAVA
TASK: sort
*/
import java.io.*;
import java.util.*;
public class sort{ 
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("sort.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("sort.out")));
      StringTokenizer st = new StringTokenizer(f.readLine());
      int n = Integer.parseInt(st.nextToken());
      //PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
      //LinkedList<Integer> ll = new LinkedList<Integer>();
      int[] a = new int[n];
      for(int i=0;i<n;i++){
         //st = new StringTokenizer(f.readLine());      
         //ll.add(Integer.parseInt(f.readLine()));
         a[i] = Integer.parseInt(f.readLine());
      }
      int moo = 0;
      boolean sorted = false;
      while(!sorted){
         sorted = true;
         moo++;
         for(int i =0;i<=n-2;i++){
            if(a[i+1] < a[i]){
               swap(a, i, i+1);
            }
         }
         for(int i =n-2;i>=0;i--){
            if(a[i+1] < a[i]){
               swap(a, i, i+1);
            }
         }
         for(int i = 0;i<=n-2;i++){
            if(a[i+1] < a[i]){
               sorted = false;
            }
         }
      }

      pw.println(moo);
      pw.close();
   }
   public static int findBig(LinkedList<Integer> ll){
      int bigIn = 0;
      for(int i=0;i<ll.size();i++){
         if(ll.get(i) >= ll.get(bigIn))
            bigIn = i;
      }
      return bigIn;
   }
   public static int findSmall(LinkedList<Integer> ll){
      int smallIn = 0;
      for(int i=0;i<ll.size();i++){
         if(ll.get(i) < ll.get(smallIn))
            smallIn = i;
      }
      return smallIn;
   }
   public static void swap(int[] a, int i1, int i2){
      int temp = a[i1];
      a[i1] = a[i2];
      a[i2] = temp;
   }
}



//       while(ll.size() > 1){
//          int big = findBig(ll);
//          int small = findSmall(ll);
//          if((big != ll.size()-1) && (small != 0)){
//             ll.remove(findBig(ll));
//             ll.remove(findSmall(ll));
//             moo++;
//          }else if(big != ll.size()-1){
//             ll.remove(big);
//             ll.remove(findSmall(ll));
//             ll.remove(findSmall(ll));
//             moo++;
//          }else if(small != 0){
//             ll.remove(big);
//             ll.remove(findSmall(ll));
//             ll.remove(findBig(ll));
//             moo++;
//          }else{
//             ll.remove(big);
//             ll.remove(findSmall(ll));
//          }
//       }