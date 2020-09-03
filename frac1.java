/*
ID: wuhanda1
LANG: JAVA
TASK: frac1
*/
import java.io.*;
import java.util.*;
public class frac1{
   public static void main(String[] args) throws IOException {
      BufferedReader f = new BufferedReader(new FileReader("frac1.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));
      
      int n = Integer.parseInt(f.readLine());
      TreeSet<Fraction> frac = new TreeSet<Fraction>();
      
      for(int x=0; x<=n; x++){
         for(int y=1; y<=n; y++){
            if(x<=y)
               frac.add(new Fraction(x, y));
         }
      }
      for(Fraction fr:frac)
         out.println(fr);
      out.close();
   }
}
class Fraction implements Comparable<Fraction>{
   int num;
   int den;
   public Fraction(int n, int d){
      int g = gcd(n, d);
      num = n/g;
      den = d/g;
   }
   private int gcd(int n, int d){
      int gcd = 1;
      int curr = 1;
      while(curr <= Math.min(n, d)){
         if(n%curr == 0 && d%curr == 0)
            gcd = curr;
         curr++;
      }
      return gcd;
   }
   public int compareTo(Fraction other){
      if(num == other.num && (den == other.den || num == 0))
         return 0;
      else if(num*other.den > den*other.num)
         return 1;
      else
         return -1;
   }
   public String toString(){
      return num+"/"+den;
   }
}