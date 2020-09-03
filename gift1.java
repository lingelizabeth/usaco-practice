/*
ID: wuhanda1
LANG: JAVA
TASK: gift1
*/
import java.io.*;
import java.util.*;

class gift1 {
   public static void main (String [] args) throws IOException {
   // Use BufferedReader rather than RandomAccessFile; it's much faster
   BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
                                                 // input file name goes above
   PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
   int np = Integer.parseInt(f.readLine()); // np = number of people
   Map<String, Integer> map = new LinkedHashMap();
   for(int x=0; x<np;x++){         //makes a map with the names of all the ppl as keys
      map.put(f.readLine().replace("\n", ""), 0); 
   }
   for(int k =0;k<np;k++){
      String key = f.readLine();
      StringTokenizer st = new StringTokenizer(f.readLine());
      int dollars = Integer.parseInt(st.nextToken());    // first integer
      int s = Integer.parseInt(st.nextToken());    // second integer
      for(int x=0;x<s;x++){
         String name = f.readLine();
         map.put(name, map.get(name)+(dollars/s));
      }
      if(s==0)
         map.put(key, map.get(key));
      else
         map.put(key, map.get(key) - dollars + (dollars%s));
   }
   for(String key : map.keySet())   
      out.println(key+" "+map.get(key)); 
   out.close();                                  // close the output file
   }
}