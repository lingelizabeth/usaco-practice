/*
ID: wuhanda1
LANG: JAVA
TASK: dualpal
*/
import java.io.*;
import java.util.*;
public class dualpal{
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("dualpal.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
      StringTokenizer st = new StringTokenizer(f.readLine());
      
      int max = Integer.parseInt(st.nextToken());
      int s = Integer.parseInt(st.nextToken());
      int count = 0;
      int x = s+1;
      while(count != max){
         int c = 0;
         for(int base = 2; base <= 10; base++)
            if(isPalindrome(convert(x, base)))
               c++;
         if(c >= 2){
            out.println(x);
            count++;
         }
         x++;
      }
      out.close();
   }
   public static String convert(int num, int base){ //convert to base b
      String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      //Map<Integer, String> map = new HashMap();
      //for(int x = 0; x<alphabet.length(); x++)
      //   map.put(x+10, alphabet.charAt(x)+"");
      
      String out = "";
      int x = 0;
      while((int)(Math.pow(base, x+1)) < num)
         x++;
      for(int k = x; k>=0; k--){
         int times = num/(int)(Math.pow(base, k)); //the number of times base goes into num
         //if(times > 9 && times < base)
         //   out += map.get(times);
         //else
         out += alphabet.charAt(times)+"";
         num = num - times*(int)(Math.pow(base, k));
      }
      return out;
   }
   public static boolean isPalindrome(String num){
      Stack stack = new Stack();
      String reverse = "";
      for(int x=0; x<num.length(); x++)
         stack.push(num.charAt(x)+"");
      for(int x=0; x<num.length(); x++)
         reverse += stack.pop();
      return num.equals(reverse);
   }
}