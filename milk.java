/*
ID: wuhanda1
LANG: JAVA
TASK: milk
*/
import java.io.*;
import java.util.*;
public class milk{
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("milk.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
      StringTokenizer st = new StringTokenizer(f.readLine());
      
      Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
      int req = Integer.parseInt(st.nextToken()); //amt of milk we need
      int num = Integer.parseInt(st.nextToken()); //number of farmers
      for(int x = 0; x<num; x++){
         StringTokenizer s = new StringTokenizer(f.readLine());
         int a = Integer.parseInt(s.nextToken());
         int b = Integer.parseInt(s.nextToken());
         if(map.get(a) != null)
            map.put(a, map.get(a) + b);
         else
            map.put(a, b);
      } // has all the farmers sorted by price
      
      int milkBought = 0; //units of milk bought
      int amtSpent = 0;
      for(int count:map.keySet()){
         if(map.get(count)+milkBought < req){
            milkBought += map.get(count);
            amtSpent += map.get(count)*count;
         }else if(milkBought == req){
            break;
         }else{
            int amt = req - milkBought;
            milkBought += amt;
            amtSpent += amt*count;
         }
      }
      out.println(amtSpent+"");
      out.close();
   }
}