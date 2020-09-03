/*
ID: wuhanda1
LANG: JAVA
TASK: ariprog
*/

import java.io.*;
import java.util.*;

public class ariprog{
   public static void main(String[] args) throws IOException {
      
      BufferedReader f = new BufferedReader(new FileReader("ariprog.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
      
      int n = Integer.parseInt(f.readLine());
      int m = Integer.parseInt(f.readLine());

      boolean[] isB = new boolean[m*m+m*m+1]; //max value of any bisquare
      ArrayList<Integer> bisquares = new ArrayList<Integer>();
      TreeSet<Pair> pairs = new TreeSet<Pair>();
      for(int i=0; i<=m; i++){
         for(int j=0; j<=m; j++){
            isB[i*i+j*j] = true; //indices of all bisquares are = true
            bisquares.add(i*i+j*j); //arraylist of all bisquares
         }
      }
      for(int a: bisquares){
         for(int b=1; a+(n-1)*b <= m*m+m*m; b++){ //check every value of b such that the last element is < max
            boolean works = true;
            for(int x =0; x<n; x++){
               if(!isB[a+x*b]){
                  works = false;
                  break;
               }
            }
            if(works)
               pairs.add(new Pair(a, b));
         }
      }
      for(Pair p: pairs)
         out.println(p);
      if(pairs.size() == 0)
         out.println("NONE");
      out.close();
   }
}
class Pair implements Comparable<Pair>{
   int a;
   int b;
   public Pair(int aIn, int bIn){
      a = aIn;
      b = bIn;
   }
   public int compareTo(Pair other){ //returns true if other goes after me, if I come first
      if(b < other.b || (b == other.b && a < other.a))
         return -1;
      else if(b == other.b && a==other.a)
         return 0;
      else
         return 1;
   }
   public String toString(){
      return a+" "+b;
   }
}