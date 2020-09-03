/*
ID: wuhanda1
LANG: JAVA
TASK: 3nplus1
*/
import java.io.*;
import java.util.*;
public class Threenplus1{ 
   public static void main(String[] args) throws IOException{
      while(true){
         Scanner sc = new Scanner(System.in);
         int i = sc.nextInt();
         int j = sc.nextInt();
         int max = 0;
         for(int x=i; x<=j; x++){
            int n = x;
            int cycle = 1;
            while(n != 1){
               if(n%2 == 1)
                  n=3*n+1;
               else if(n%2 == 0)
                  n = n/2;
               cycle++;
            }
            if(cycle > max)
               max = cycle;
         }
         System.out.println(i+" "+j+" "+max);
      }
   }
}
