/*
ID: wuhanda1
LANG: JAVA
TASK: daycare
*/
import java.io.*;
import java.util.*;
public class daycare{ 
   public static void main(String[] args) throws IOException{
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      sc.nextLine();
      ArrayList<Integer> id = new ArrayList<Integer>();
      for(int i=0;i<n;i++){
         int curr = sc.nextInt();
         if(id.contains(curr))
            id.remove(id.indexOf(curr));
         else
            id.add(curr);
      }
      System.out.println(id.get(0));
   }
}