/*
ID: wuhanda1
LANG: JAVA
TASK: preface
*/
import java.io.*;
import java.util.*;
public class preface{ 
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("preface.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("preface.out")));
      
      int n = Integer.parseInt(f.readLine());
      String[] nums = new String[n];
      int[] count = new int[7];
      
      for(int i =0; i<=n; i++){
         //convert i to roman numeral
         String roman = convert(i);
         //System.out.println(roman);
         for(int x=0; x<roman.length(); x++){
            if(roman.charAt(x) == 'I')
               count[0] += 1;
            else if(roman.charAt(x) == 'V')
               count[1] += 1;
            else if(roman.charAt(x) == 'X')
               count[2] += 1;
            else if(roman.charAt(x) == 'L')
               count[3] += 1;
            else if(roman.charAt(x) == 'C')
               count[4] += 1;
            else if(roman.charAt(x) == 'D')
               count[5] += 1;
            else if(roman.charAt(x) == 'M')
               count[6] += 1;
         }
      }
      String ro = "IVXLCDM";
      for(int i=0; i< count.length; i++){
         if(count[i] == 0)
            continue;
         else
            out.println(ro.charAt(i)+" "+count[i]);
      }
      out.close();
   }
   public static String convert(int n){
      String r = "";
      if(n >= 1000){
         int th = (n/1000)*1000;
         if(th == 3000)
            r += "MMM";
         if(th == 2000)
            r += "MM";
         if(th == 1000)
            r += "M";
         n = n%1000;
      }if(n >= 100){
         int h = (n/100)*100;
         if(h == 900)
            r += "CM";
         if(h == 800)
            r += "DCCC";
         if(h == 700)
            r += "DCC";
         if(h == 600)
            r += "DC";
         if(h == 500)
            r += "D";
         if(h == 400)
            r += "CD";
         if(h == 300)
            r += "CCC";
         if(h == 200)
            r += "CC";
         if(h == 100)
            r += "C";
         n = n%100;
      }if(n >= 10){
         int t = (n/10)*10;
         if(t == 90)
            r += "XC";
         if(t == 80)
            r += "LXXX";
         if(t == 70)
            r += "LXX";
         if(t == 60)
            r += "LX";
         if(t == 50)
            r += "L";
         if(t == 40)
            r += "XL";
         if(t == 30)
            r += "XXX";
         if(t == 20)
            r += "XX";
         if(t == 10)
            r += "X";
         n = n%10;
      }if(n > 0){
         if(n == 9)
            r += "IX";
         if(n == 8)
            r += "VIII";
         if(n == 7)
            r += "VII";
         if(n == 6)
            r += "VI";
         if(n == 5)
            r += "V";
         if(n == 4)
            r += "IV";
         if(n == 3)
            r += "III";
         if(n == 2)
            r += "II";
         if(n == 1)
            r += "I";
      }
      return r;
   }
}
