/*
ID: wuhanda1
LANG: JAVA
TASK: gravity
*/
import java.io.*;
import java.util.*;
public class gravity{ 
   static char[][] map;
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("gravity.in"));
      //PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("gravity.out")));
      
      StringTokenizer st = new StringTokenizer(f.readLine());
      int n = Integer.parseInt(st.nextToken()); 
      int m = Integer.parseInt(st.nextToken());
      //Point c, d;
      int startX = -1, startY = -1, endX= -1, endY= -1;
      char[][] map = new char[n][m]; 
      int[][] graph = new int[n*m][n*m];//with the numbers of the points as indices
                                        //contains 1s and 0s for lengths
       for(int[] a:graph)
          Arrays.fill(a, -1);
      int counter = 0;
      for(int i=0;i<n;i++){
         String str = f.readLine();
         for(int j=0;j<m;j++){
            map[i][j] = str.charAt(j);            
            if(str.charAt(j) == 'C'){
               //c = new Point(i, j);
               startX = i;
               startY = j;
            }
            else if(str.charAt(j) == 'D'){
               //d = new Point(i, j);
               endX=i;
               endY=j;
            }
            if(str.charAt(j) != '#'){ //so the map has 1, 2, 3,... at each vertex
               map[i][j] = (char)counter;
               counter++;
            }
         }
      }
      //make the new graph - has a 0 between horizontal things and a 1 between verticals
      for(int j=0; j<m;j++){
         for(int i=0;i<n;i++){
            if(map[i][j] != '#'){ //lmao idk if this will behave how i want it to
               
               //at this point i should be right below a ## idk??
               //this part sets edge length 0 to horizontal vertices if they are 1 apart
               int j1 = j+1;
               //for(int j2 = j+1; j2<m;j2++){
                  if(j1<m && map[i][j1] != '#' && i-1 >= 0 && map[i-1][j1] == '#'){
                     graph[map[i][j]][map[i][j1]] = 0;
                     graph[map[i][j1]][map[i][j]] = 0;   
                  }               
               //}
               
               int curr = i;
               while(curr+1 < n && map[curr+1][j] != '#')
                  curr += 1;
               if(curr+1 == n)
                  break; //which will break out of this i and go to the next ??
                  
               //AT THIS POINT curr is some row who is right above a ##
               //this part sets edge length 0 to horizontal vertices if they are 1 apart
               //for(int j2 = j+1; j2<m;j2++){
               int j2 = j+1;
                  if(j2<m && map[curr][j2] != '#' && curr+1 < n&& map[curr+1][j2] == '#'){ //the case where its above is NOT ACCOUNTED FOR
                     graph[map[curr][j]][map[curr][j2]] = 0;
                     graph[map[curr][j2]][map[curr][j]] = 0;   
                  }               
               //}
               
               graph[map[i][j]][map[curr][j]] = 1;
               graph[map[curr][j]][map[i][j]] = 1;
               i = curr+1;
            }
            
         }
      }

      //dijkstra's w a twist - copy pasted
      int[] dist = new int[counter];
      boolean[] done = new boolean[counter];
      Arrays.fill(dist, Integer.MAX_VALUE);//change those to -1 later
      dist[map[startX][startY]] = 0; //SET START
      
      for(int count=0; count<=counter; count++){
         //choose the vertex with the least distance
         int u = findMin(dist, done); //method that gets the min of the ones that are not done
         done[u] = true;
         for(int i = 0;i<counter; i++){
            if(!done[i] && graph[u][i] != -1 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][i] < dist[i])
               dist[i] = dist[u] + graph[u][i];
         }
      }
      if(dist[map[endX][endY]] == Integer.MAX_VALUE)
         System.out.println(-1);
         //pw.println("-1");
      else
         System.out.println(dist[map[endX][endY]]);
         //pw.println(""+dist[map[endX][endY]]);
   }
   public static int findMin(int[] dist, boolean[] done){
      int mindex = 0;
      int min = Integer.MAX_VALUE;
      for(int i=0; i<dist.length; i++){
         if(!done[i] && dist[i] <= min){ // <= means it returns indices of those who have Integer.MAX_VALUE as dist
                                         //which ends up working bc they each get marked as done....
            min = dist[i];
            mindex = i;
         }
      }
      return mindex;
   }
   //returns a point w the new coordinates after falling
   // dir = -1 for falling down dir = +1 for going up
   
//    public static Point fall(Point p, int dir){
//       while(mat[p.x][p.y+dir])
//    }
}
// class Point{
//    int x, y;
//    public Point(int x1, int y1){
//       x=x1;
//       y=y1;
//    }
// }