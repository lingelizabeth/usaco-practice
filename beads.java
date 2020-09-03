/*
ID: wuhanda1
LANG: JAVA
TASK: beads
*/
import java.util.*;
import java.io.*;
public class beads{
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("beads.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
      
      int n = Integer.parseInt(f.readLine());
      String nl = f.readLine(); //necklace
      String longest = ""; // longest chain of beads
      
      for(int i=0;i<n;i++){
         int curr = plus(i, n);
         int comparer = i;
         String beads = "";
         if(nl.charAt(i) != 'w')
            beads = ""+nl.charAt(i);
         while(nl.charAt(curr) == 'w' || equal(nl.charAt(curr), nl.charAt(comparer))){
            if(curr == i){ // if you've looped through the entire thing
                out.println(n+"");
                out.close();
                System.exit(0);
            }
            if(nl.charAt(curr) != 'w' && nl.charAt(comparer) == 'w'){ //if the first one(the comparer) was white but the current one isn't
               beads += nl.charAt(comparer); 
               comparer = curr;}              //make it = to the first colored bead
            beads += nl.charAt(curr);        //if it works, add it to beads
            curr = plus(curr, n);
         }
         comparer = curr; 
         while(nl.charAt(curr) == 'w' || equal(nl.charAt(curr), nl.charAt(comparer))){
            if(curr == i){ // if you've looped through the entire thing
                break;
            }
            beads += nl.charAt(curr);
            curr = plus(curr, n);
         }
         if(beads.length() > longest.length())
            longest = beads;
      }
      //System.out.println(longest);
      out.println(longest.length());
      out.close();
   }
   public static boolean equal(char a, char b){
      //System.out.println(a.equals("w")+"");
      if(a == 'w' || b =='w')
         return true;
      else
         return (a == b);
   }
   public static int plus(int x, int len){
      int out = x+1;
      if(out > len - 1)
         out = 0;
      return out;
   }
}
         // int curr = i;
//          String beads = "";
//          int comparer = i;
//          if(nl.charAt(i) == 'w'){
//             int temp = i;
//             while(nl.charAt(temp) == 'w')
//                temp = sub(temp, n);
//             comparer = temp;
//          }
//          while(equal(nl.charAt(comparer), nl.charAt(curr))){
//             beads = nl.charAt(curr)+beads;
//             curr = sub(curr, n);
//             if(curr == i){
//                out.println(n+"");
//                out.close();
//                System.exit(0);
//             }
//          }
//          curr = plus(i, n); //curr = i+1; 
//          int temp = plus(i, n); //= i+1;
//          if(nl.charAt(temp) == 'w'){
//             int t = plus(i, n);
//             while(nl.charAt(t) == 'w')
//                t = plus(t, n);
//             temp = t;
//          }
//          while(equal(nl.charAt(temp), nl.charAt(curr))){
//             beads += nl.charAt(curr);
//             curr=plus(curr, n);
//             if(curr == i+1)
//                break;
//          }
//          if(beads.length() > longest.length())
//             longest = beads;
// 