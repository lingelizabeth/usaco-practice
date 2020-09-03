
/*
ID: wuhanda1
LANG: JAVA
TASK: 
*/
import java.io.*;
import java.util.*;
public class nthPrime{ 
   public static void main(String[] args) throws IOException{
      System.out.println(nthPrime(27332));
   }
   
   public static int nthPrime(int n){
    int candidate, count;
    for(candidate = 2, count = 0; count < n; ++candidate) {
        if (isPrime(candidate)) {
            ++count;
        }
    }
    // The candidate has been incremented once after the count reached n
    return candidate-1;
   }
   private static boolean isPrime(int n) {
    for(int i = 2; i < n; ++i) {
        if (n % i == 0) {
            // We are naive, but not stupid, if
            // the number has a divisor other
            // than 1 or itself, we return immediately.
            return false;
        }
    }
    return true;
}
}