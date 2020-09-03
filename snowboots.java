/*
ID: wuhanda1
LANG: JAVA
TASK: snowboots
*/
import java.io.*;
import java.util.*;
public class snowboots{ 
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("snowboots.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("snowboots.out")));
      StringTokenizer st = new StringTokenizer(f.readLine());
      int n = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      //int[] tiles = new int[n];
      int[] depthID = new int[n];
      int[] bootID = new int[b];
      LinkedList<Integer> tiles = new LinkedList<Integer>();
      st = new StringTokenizer(f.readLine());
      for(int i =0; i<n;i++){
         tiles.add(Integer.parseInt(st.nextToken()));
         depthID[i] = i;
      }
      Boot[] boots = new Boot[b];
      for(int i=0; i<b; i++){
         st = new StringTokenizer(f.readLine());
         int si = Integer.parseInt(st.nextToken());
         int di = Integer.parseInt(st.nextToken());
         boots[i] = new Boot(di, si);
         bootID[i] = i;
      }
      Arrays.sort(boots);
      Collections.sort(tiles);
      int[] ans = new int[b];
      for(int i=0; i<boots.length; i++){//go in decreasing order
         int tileIndex = tiles.length-1;
         while(tileIndex >= 0 && tiles.get(depthID[tileIndex]) > boots[i].snow){
            tiles.remove(tileIndex)
            tileIndex--;
            maxSnow = Math.max(maxStep, 
         }
         ans[bootID[i]] = (maxStep <= boots[i].dist);
      }
      pw.close();
   }
}
class Boot implements Comparable<Boot>{
   int dist, snow;
   public Boot(int d, int s){
      dist = d;
      snow = s;
   }
   public int compareTo(Boot other){
      return (other.s - s);
   }
}
class Tile{
   int snow, index;
   public Tile(int i, int s){
      index = i;
      snow = s;
   }
   // public int compareTo(Boot other){
//       return (other.s - s);
//    }
   public int dist(Tile other){
      return Math.abs(other.i - i);
   }
}