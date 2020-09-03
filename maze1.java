/*
ID: wuhanda1
LANG: JAVA
TASK: maze1
*/
import java.io.*;
import java.util.*;
public class maze1{ 
   static int[][] mark;
   static int[] dy = {1, -1, 0, 0};
   static int[] dx = {0, 0, 1, -1};
   static int h, w;
   static char[][] maze;
   public static void main(String[] args) throws IOException{
      //BufferedReader f = new BufferedReader(new FileReader("maze1.in"));
      Scanner sc = new Scanner(System.in);
      
      StringTokenizer s = new StringTokenizer(sc.nextLine());//f.readLine());
      w = Integer.parseInt(s.nextToken());
      h = Integer.parseInt(s.nextToken());
      maze = new char[2*h+1][2*w+1];
      mark = new int[h+1][w+1];
      
      //read in the field as a 2d string array
      for(int r=0;r<2*h+1; r++){
         String line = sc.nextLine();
         for(int c=0; c<2*w+1; c++){
            maze[r][c] = line.charAt(c);
         }
      }
      //go to every exit along the outside and bfs, mark dist at each internal point
      //what about overlap?
      for(int i=0; i<h;i++){
         if(maze[2*i+1][0] == ' ') //explain???
            bfs(i, 0);
         if(maze[2*i+1][2*w] == ' ')
            bfs(i, w-1);
      }
      for(int i=0; i<w;i++){
         if(maze[0][2*i+1] == ' ') //explain???
            bfs(0, i);
         if(maze[2*h][2*i+1] == ' ')
            bfs(h-1, i);
      }
      int best=0;
      for (int i=0; i<h; i++){
         for (int j=0; j<w; j++)
            best = Math.max(best, mark[i][j]);
      }
      System.out.println(best+"");
   }
   public static void bfs(int x, int y){
      mark[x][y] = 1;
      Queue<Pair> q = new LinkedList<Pair>();
      q.add(new Pair(x, y));
      mark[x][y] = 1; //what?
      
      while(!q.isEmpty()){
         Pair p = (Pair)q.remove();
         
         for(int i =0; i<4; i++){
            int nx = p.x+dx[i];
            int ny = p.y+dy[i];
            if(ny<0 || nx <0 || nx >= h || ny >= w)
               continue;
            if((mark[nx][ny] != 0 && mark[nx][ny] <= mark[p.x][p.y]+1)|| maze[2*p.x+1+dx[i]][2*p.y+1+dy[i]] != ' ')
               continue;
            mark[nx][ny] = mark[p.x][p.y] +1;
            q.add(new Pair(nx, ny));
         }
      }
      
   }
   
}
class Pair{
   int x;
   int y;
   public Pair(int x1, int y1){
      y = y1;
      x= x1;
   }
}