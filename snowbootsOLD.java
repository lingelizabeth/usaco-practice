/*
ID: wuhanda1
LANG: JAVA
TASK: snowboots
*/
import java.io.*;
import java.util.*;
public class snowbootsOLD{ 
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("snowboots.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("snowboots.out")));
      StringTokenizer st = new StringTokenizer(f.readLine());
      int n = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int[] tiles = new int[n];
      st = new StringTokenizer(f.readLine());
      for(int i =0; i<n;i++){
         tiles[i] = Integer.parseInt(st.nextToken());
      }
      for(int i=0; i<b; i++){
         boolean printed = false;
            st = new StringTokenizer(f.readLine());
            int s_i = Integer.parseInt(st.nextToken());
            int d_i = Integer.parseInt(st.nextToken());
            Queue<Integer> q = new LinkedList<Integer>(); //holds indices of tiles
            q.add(0);
            while(!q.isEmpty()){
               int curr = q.remove();
               if(curr >= n-1){
                  pw.println("1");
                  printed = true;
                  break;
               }
               for(int j=curr+1;j<n;j++){
                  if(tiles[j] <= s_i && (Math.abs(j-curr))<= d_i)
                     q.add(j);
               }
            }
            if(!printed)
               pw.println("0");
      }
      pw.close();
   }
}