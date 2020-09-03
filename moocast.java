/*
ID: wuhanda1
LANG: JAVA
TASK: moocast
*/
import java.io.*;
import java.util.*;
public class moocast{
   static boolean[][] visited;
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("moocast.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
      
      int n = Integer.parseInt(f.readLine());
      int[][] cows = new int[n][3];
      visited = new boolean[n][3];
      for(int i = 0; i<n; i++){
         StringTokenizer st = new StringTokenizer(f.readLine());
         cows[i][0] = Integer.parseInt(st.nextToken()); //x
         cows[i][1] = Integer.parseInt(st.nextToken());//y
         cows[i][2] = Integer.parseInt(st.nextToken());//p
      }
      int ans = Integer.MIN_VALUE;
      for(int x=0; x<cows.length; x++){
         visited = new boolean[n][3];
         ans = Math.max(ans, search(cows, cows[x][0], cows[x][1], cows[x][2]));
      }
      out.println(ans);
      out.close();
   }
   public static int search(int[][] cows, int x, int y, int p){
      //check every cow to see if it is within radius
      int ret = 0;
      for(int i=0; i<cows.length; i++){
         if(visited[i][0] && visited[i][1]) //if already visited
            return ret;
         int currRow = findI(cows, x, y);
         visited[currRow][0] = visited[currRow][1] = true;
         if(distance(x, y, cows[i][0], cows[i][1]) == 0.0)
            ret+=1;
         else if(distance(x, y, cows[i][0], cows[i][1]) < (double)(p)){
            ret+=search(cows, cows[i][0], cows[i][1], cows[i][2]);
         }else
            ret+=0;
      }
      //if it is, call search on it
      //if its not don't continue
      
      return ret;
   }
   public static int findI(int[][] cows, int x, int y){
      for(int i=0;i<cows.length; i++){
         if(cows[i][0] == x && cows[i][1] == y)
            return 1;
      }
      return -1;
   }
   public static double distance(int x1, int y1, int x2, int y2){
      return Math.sqrt(Math.pow(x2 - x1, 2)+Math.pow(y2-y1, 2));
   }
}
