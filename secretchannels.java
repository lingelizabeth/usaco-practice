/*
ID: wuhanda1
LANG: JAVA
TASK: secretchannels
*/
import java.io.*;
import java.util.*;
public class secretchannels{ 
   public static void main(String[] args) throws IOException{
      Scanner sc = new Scanner(System.in);
      while(true){
         String input = sc.nextLine();
         int a = Integer.parseInt(input.charAt(0)+"");
         int b = Integer.parseInt(input.charAt(1)+"");
         int c = Integer.parseInt(input.charAt(2)+"");
         int d = Integer.parseInt(input.charAt(3)+"");
         a = (a+5)%10;
         b = (b+5)%10;
         c = (c+5)%10;
         d = (d+5)%10;
         System.out.println(d+""+c+""+b+""+a);
      }
   }
}