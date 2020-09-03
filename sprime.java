/*
ID: wuhanda1
LANG: JAVA
TASK: sprime
*/

import java.io.*;
import java.util.*;
public class sprime{
   static boolean[] primes; //true if index is prime
   static TreeSet<Integer> sprimes;
   public static void main(String[] args) throws IOException {
      BufferedReader f = new BufferedReader(new FileReader("sprime.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));
      
      int n = Integer.parseInt(f.readLine());
      primes = generatePrimes();
      sprimes = new TreeSet<Integer>();
      dfs("2", n);
      dfs("3", n);
      dfs("5", n);
      dfs("7", n);
      
      for(int l:sprimes)
         out.println(l);
      out.close();
   }
   public static void dfs(String num, int n){
      if(num.length() == n){
         if(isPrime(Integer.parseInt(num)))
            sprimes.add(Integer.parseInt(num));
         return;
      }
      for(int i=1; i<=9; i+=2)
         if(isPrime(Integer.parseInt(num)))
            dfs(num+i, n);
   }
   public static boolean isPrime(int p){
      boolean ret = true;
      for(int x=0;x<primes.length;x++)
         if(primes[x] && p!=x && p%x == 0)
            ret = false;
      return ret;
   }
   public static boolean[] generatePrimes(){
      boolean[] primes = new boolean[10000];
      for(int x=2;x<10000;x++){
         boolean works = true;
         for(int d=2;d<=Math.sqrt(x);d++){
            if(x!= d && x%d ==0)
               works = false;
         }
         if(works)
            primes[x] = true;
      }
      return primes;
   }
}
