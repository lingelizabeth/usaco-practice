/*
ID: wuhanda1
LANG: JAVA
TASK: subset2
*/
import java.io.*;
import java.util.*;
public class subset2{ 
   public static void main(String[] args) throws IOException{
      //BufferedReader f = new BufferedReader(new FileReader("subset2.in"));
      Scanner sc = new Scanner(System.in);
      
      int m = sc.nextInt();//Integer.parseInt(f.readLine());//
      int[] list = new int[m];
      //StringTokenizer st = new StringTokenizer(f.readLine());
      for(int i=0; i<m; i++){
         list[i] = sc.nextInt();//Integer.parseInt(st.nextToken());
      }
      for(int i=1; i<Math.pow(2, m); i++){
         String s = Integer.toString(i, 2);
         s = fill(s, m);
         getSet(s, list);
         System.out.println();
      }
   }
   public static String fill(String s, int l){
      while(s.length() < l){
         s = "0"+s;
      }
      return s;
   }
   public static void getSet(String bin, int[] list){
      for(int i=bin.length() -1; i>=0; i--){
      int j = bin.length()-1-i;
         if(bin.charAt(i) == '1')
            System.out.print(""+list[j]);
      }
   }
}

      