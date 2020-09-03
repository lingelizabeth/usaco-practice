/*
ID: wuhanda1
LANG: JAVA
TASK: ride
*/
import java.io.*;
import java.util.*;

class ride {
   public static void main (String [] args) throws IOException {
   // Use BufferedReader rather than RandomAccessFile; it's much faster
   BufferedReader f = new BufferedReader(new FileReader("ride.in"));
                                                 // input file name goes above
   PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
   String comet = f.readLine().replace("\n","");    // name of comet
   String group = f.readLine().replace("\n","");    // name of group
   Map<String, Integer> map = new HashMap();
   String[] array = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
   for(int x=0;x<array.length;x++){
      map.put(array[x], x+1);
   }
   int p1 = getProduct(comet, map);
   int p2 = getProduct(group, map);
   if(p1%47 == p2 % 47)
      out.println("GO");  
   else
      out.println("STAY");                           // output result
   out.close();                                  // close the output file
   }
   public static int getProduct(String s, Map<String, Integer> m){
      int product = 1;
      for(int x = 0;x<s.length();x++){
         product = product * m.get(""+s.charAt(x));
      }
      return product;
   }
}