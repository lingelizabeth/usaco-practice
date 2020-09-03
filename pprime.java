/*
ID: wuhanda1
LANG: JAVA
TASK: pprime
*/

import java.io.*;
import java.util.*;
public class pprime{
   static boolean[] primes; //true if index is prime
   public static void main(String[] args) throws IOException {
      BufferedReader f = new BufferedReader(new FileReader("pprime.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));
      StringTokenizer st = new StringTokenizer(f.readLine());
      int a1 = Integer.parseInt(st.nextToken());
      int b1 = Integer.parseInt(st.nextToken());
      TreeSet<Integer> pprimes = new TreeSet<Integer>();
      primes = generatePrimes();
      
      //one digit palindromes
      pprimes.add(5);
      pprimes.add(7);
      //two digit palindromes
      for(int x=1; x<=9; x++){
         int palindrome = 10*x+x;
            if(isPrime(palindrome))
               pprimes.add(palindrome);
      }
      //3 digit palindromes&4
      for(int x=1; x<=9; x++){
         for(int y=0; y<=9; y++){
               int palindrome = 100*x+10*y+x;
               if(isPrime(palindrome))
                  pprimes.add(palindrome);
               palindrome = 1000*x+100*y+10*y+x;
               if(isPrime(palindrome))
                  pprimes.add(palindrome);
         }
      }
      //5 digit & 6digits
      for(int x=1; x<=9; x++){
         for(int y=0; y<=9; y++){
            for(int z=0; z<=9; z++){
               int palindrome = 10000*x+1000*y+100*z+10*y+x;
               if(isPrime(palindrome))
                  pprimes.add(palindrome);
               palindrome = 100000*x+10000*y+1000*z+100*z+10*y+x;
               if(isPrime(palindrome))
                  pprimes.add(palindrome);
            }
         }
      } 
       //7 digit&8
      for(int x=1; x<=9; x++){
         for(int y=0; y<=9; y++){
            for(int z=0; z<=9; z++){
               for(int a=0; a<=9; a++){
                  int palindrome = 1000000*x+100000*y+10000*z+1000*a+100*z+10*y+x;
                  if(isPrime(palindrome))
                     pprimes.add(palindrome);
                  palindrome = 10000000*x+1000000*y+100000*z+10000*a+1000*a+100*z+10*y+x;
                  if(isPrime(palindrome))
                     pprimes.add(palindrome);
               }
            }
         }
      } 
      for(int q: pprimes)
         if(a1 <= q  && q <= b1)
            out.println(q);
      out.close();
   }
   public static boolean isPrime(int p){
      boolean ret = true;
      //if(primes[p])
      //   return true;
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
