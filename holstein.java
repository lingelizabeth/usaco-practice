/*
ID: wuhanda1
LANG: JAVA
TASK: holstein
*/
import java.io.*;
import java.util.*;
public class holstein{ 
   static String best;
   static int[][] feeds;
   static int[] vit;
   static String map; 
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("holstein.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("holstein.out")));
      
      int v = Integer.parseInt(f.readLine());
      vit = new int[v]; //vitamin requiremnents
      StringTokenizer st = new StringTokenizer(f.readLine());
      for(int x=0; x<v; x++)
         vit[x] = Integer.parseInt(st.nextToken());
      int g = Integer.parseInt(f.readLine());
      feeds = new int[g][v];
      for(int x=0; x<g; x++){
         st = new StringTokenizer(f.readLine());
         for(int y=0; y<v; y++){
            feeds[x][y] = Integer.parseInt(st.nextToken());
         }
      }
      map = "0123456789ABCDEF"; //map[index] is the representation of index
      best = "";  
      // for(int x=0;x<15;x++){
//          recur("", x); 
//          if(best != "")
//             break;
//       }
      recur("");
      out.print(best.length());
      for(int x = 0; x<best.length(); x++)
         out.print(" "+(map.indexOf(best.charAt(x)+"")+1));
      out.println();
      out.close();
   }
   public static void recur(String c){ //, int l){ //find all solutions of length l
      if(meetsReq(c)){
         //System.out.println(c);
//          if(c.length() == best.length() && Integer.parseInt(best.charAt(0)+"") < Integer.parseInt(c.charAt(0)+""))
//             return;
         if(best == "")
            best = c;
         else if(c.length() < best.length())
            best = c;
         else if(c.length() == best.length() && map.charAt(Integer.parseInt(best.charAt(0)+"")) > map.charAt(Integer.parseInt(c.charAt(0)+"")))//isSmaller(c, best))
            best = c;
         return;
      }
      for(int x=0; x<feeds.length; x++){
         if(c.length() == 0)
            recur(c+""+map.charAt(x));
         else if(!contains(c, map.charAt(x)) &&  x > map.indexOf(c.charAt(c.length()-1)))//Integer.parseInt(map.charAt(Integer.parseInt(c.charAt(c.length()-1)+"")))) //c.length() < l && 
            recur(c+""+map.charAt(x));//, l);
      }
   }
   public static boolean contains(String c, char x){
      if(c.length() == 0)
         return false;
      for(int i=0; i<c.length(); i++){
         if(c.charAt(i) == x)// || c.charAt(i) == Integer.parseInt(x+""))
            return true;
      }
      return false;
   }
   // public static boolean isSmaller(String c, String other){
//       int csum = 0, osum = 0;
//       for(int x=0; x<c.length(); x++){
//          for(int y=0; y<feeds[Integer.parseInt(c.charAt(x)+"")].length; y++)
//             csum += feeds[Integer.parseInt(c.charAt(x)+"")][y];
//       }
//       for(int x=0; x<other.length(); x++){
//          for(int y=0; y<feeds[Integer.parseInt(other.charAt(x)+"")].length; y++)
//             osum += feeds[Integer.parseInt(other.charAt(x)+"")][y];
//       }
//       return csum < osum;
//    }
   public static boolean meetsReq(String s){
      //if(s.length() > best.length())
      //   return false;
      int[] test = new int[vit.length];
      for(int feed=0;feed<s.length();feed++){
         for(int y=0; y<feeds[map.indexOf(s.charAt(feed))].length; y++){
//             if(feeds[Integer.parseInt(s.charAt(feed)+"")][y] == 0 && vit[y] > 0){
//                s = "0000000000000000";
//                return true;
//             }
            test[y] += feeds[map.indexOf(s.charAt(feed))][y];//[Integer.parseInt(s.charAt(feed)+"")][y];
         }
      }
      for(int x=0;x<test.length;x++){
         if(test[x] < vit[x])
            return false;
      }
      return true;
   }
//    public static boolean isImpossible(String s){
//       boolean[] works = new boolean[s.length()]; //if each feed in s works
//       for(int x=0; x<s.length();x++){ //for each feed in s (each scoop)
//          for(int y=0; y<feeds[Integer.parseInt(s.charAt(x)+"")].length; y++){ //for every vitamin
//             if(feeds[Integer.parseInt(s.charAt(x)+"")][y] != 0) //if every one is 0 than return true
//                works[x] = true;
//             else if(feeds[Integer.parseInt(s.charAt(x)+"")][y] == 0 && vit[y] == 0)
//                works[x] = true;
//          }
//       }
//       if(s == "")
//          return false;
//       for(int x=0; x<works.length; x++)
//          if(!works[x])
//             return true;
//       return false;
//    }
}
