/*
ID: wuhanda1
LANG: JAVA
TASK: tractor
*/
import java.io.*;
import java.util.*;
public class tractor{ 
   static Queue<Point> zero, one;
   static int[][] dist, graph;
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("tractor.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("tractor.out")));
      
      //NOTE: for some reason this lab doesn't work unless you make graph and dist have size 1002(not 1001)
      //and in addNeighbor you allow x2 and y2 to be 1001 ???
      
      //read in input
      StringTokenizer st = new StringTokenizer(f.readLine());     
      int n = Integer.parseInt(st.nextToken()); //vertices
      graph = new int[1002][1002];//1 if bale, 0 otherwise 
      dist = new int[1002][1002]; //dist to get to a square...how many bales were moved
      zero = new LinkedList<Point>(); //all points that are 0 dist(no bale)
      one = new LinkedList<Point>(); //points that are 1 away (have a bale)
      int x1 = Integer.parseInt(st.nextToken());//location of the tractor
      int y1 = Integer.parseInt(st.nextToken());
      zero.add(new Point(x1, y1));
      dist[x1][y1] = 1; //just to mark it, will subtract later
      
      for(int i=1;i<=n;i++){
         st = new StringTokenizer(f.readLine()); 
         int a = Integer.parseInt(st.nextToken());
         int b = Integer.parseInt(st.nextToken());
         graph[a][b] = 1;
      }
      
      while(!zero.isEmpty()||!one.isEmpty()){
         if(zero.isEmpty()){ //if there are no more 0 away, add all one away to the queue
            while(!one.isEmpty()){
               zero.add(one.remove());//should remove first element, check
            }
         }
         Point curr = zero.remove();
         addNeighbor(curr.x, curr.y, curr.x-1, curr.y);
         addNeighbor(curr.x, curr.y, curr.x, curr.y-1);
         addNeighbor(curr.x, curr.y, curr.x+1, curr.y);
         addNeighbor(curr.x, curr.y, curr.x, curr.y+1);
      }
      System.out.println(dist[0][0]-1);
   }
   public static void addNeighbor(int x1, int y1, int x2, int y2){
      if(x2>=0 &&x2 <= 1001 && y2>=0 && y2<=1001 && (dist[x2][y2] == 0 || dist[x1][y1]+graph[x2][y2] < dist[x2][y2])){
         dist[x2][y2] = dist[x1][y1]+graph[x2][y2];
         if(graph[x2][y2] == 0)
            zero.add(new Point(x2, y2));
         else
            one.add(new Point(x2, y2));
      }
   }
}
class Point{
   int x, y;
   public Point(int x1, int y1){
      x=x1;
      y=y1;
   }
}