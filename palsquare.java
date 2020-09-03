/*
ID: wuhanda1
LANG: JAVA
TASK: palsquare
*/
import java.io.*;
import java.util.*;
public class palsquare{
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
      
      int base = Integer.parseInt(f.readLine());
      for(int i =1; i<=300; i++)
         if(isPalindrome(convert(i*i, base)))
            out.println(convert(i, base)+" "+convert(i*i, base));
      out.close();
   }
   public static String convert(int num, int base){ //convert to base b
      String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      Map<Integer, String> map = new HashMap();
      for(int x = 0; x<alphabet.length(); x++)
         map.put(x+10, alphabet.charAt(x)+"");
      
      String out = "";
      int x = 0;
      while((int)(Math.pow(base, x+1)) < num)
         x++;
      for(int k = x; k>=0; k--){
         int times = num/(int)(Math.pow(base, k)); //the number of times base goes into num
         if(times > 9 && times < base)
            out += map.get(times);
         else
            out += times+"";
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
