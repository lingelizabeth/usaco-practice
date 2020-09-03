/*
ID: wuhanda1
LANG: JAVA
TASK: zigzag
*/
import java.io.*;
import java.util.*;
public class zigzag{ 
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("zigzag.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("zigzag.out")));
      
      int n = Integer.parseInt(f.readLine());
      StringTokenizer st = new StringTokenizer(f.readLine());
      int[][] a = new int[n][2]; //holds 1 for positive diff, -1, 0
      int[] s = new int[n]; //holds states which have the length of the subsequence?
      int[] last = new int[n]; //holds the last one in the subsequence before index
      Arrays.fill(last, -1);
      for(int x=0; x<n; x++){
         a[x][1] = Integer.parseInt(st.nextToken());
         s[x] = 1;
      }
      for(int i=0; i<a.length; i++){
         for(int j=0; j<i; j++){
            if((a[i][1]-a[j][1]) > 0 && (a[j][0] == -1 || a[j][0] == 0)){
               if(s[j] + 1 > s[i]){
                  s[i] = s[j] + 1;
                  last[i] = j;
               }
               a[i][0] = 1;
            }else if(a[j][1]-a[i][1]>0 && (a[j][0] == 1 || a[j][0] == 0)){
               if(s[j] + 1 > s[i]){
                  s[i] = s[j] + 1;
                  last[i] = j;
               }
               a[i][0] = -1;
            }
         }
      }
      //int max = 0;
      int index = 0;
      for(int i=0; i<s.length; i++)
         if(s[i] > s[index])
            //max = s[i];
            index = i;
      out.println(s[index]);
      out.close();
      for(int x=index; x>=0; x=last[x]){
         System.out.print(a[x][1]+" ");
      }
      //System.out.println(a[0][1]); //prints the whole sequence but I'm not sure how to get the last one w/o infinite loop
   }
}
