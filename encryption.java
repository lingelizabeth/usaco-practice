/*
ID: wuhanda1
LANG: JAVA
TASK: encryption
*/
import java.io.*;
import java.util.*;
public class encryption { 
   public static void main(String[] args) throws IOException{
      Scanner sc = new Scanner(System.in);
      String alpha = "abcdefghijklmnopqrstuvwxyz"; //0 to 25
      int n = sc.nextInt();
      int[] nums = new int[n];
      for(int i=0;i<n;i++)
         nums[i] = sc.nextInt();
      sc.nextLine();
      String s = sc.nextLine();
      sc.nextLine();
      String out = "";
      for(int i=0;i<n;i++){
         out += alpha.charAt((alpha.indexOf(s.charAt(i))+1+nums[i])%26-1);
      }
      System.out.println(out);
   }
}