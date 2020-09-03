/*
ID: wuhanda1
LANG: JAVA
TASK: lphone
*/
import java.io.*;
import java.util.*;
public class lphone3{ 
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("lphone.in"));
      
      StringTokenizer s = new StringTokenizer(f.readLine());
      int w = Integer.parseInt(s.nextToken());
      int h = Integer.parseInt(s.nextToken());
      String[][] field = new String[h][w];
      boolean[][] visited = new boolean[h][w];
      int[][] dist = new int[h][w]; //actually just saves corners?
      for(int[] a:dist)
         Arrays.fill(a, Integer.MAX_VALUE);
      
      for(int r =0; r<h; r++){
      String line = f.readLine();
         for(int c=0; c<w; c++){
            field[r][c] = ""+line.charAt(c);
         }
      }

      Queue<Node> q = new LinkedList<Node>();

      for(int r =0; r<h; r++){ //append start pos "C" to the queue
         for(int c=0; c<w; c++){
            if(field[r][c].equals("C")){
               q.add(new Node(field[r][c], r, c, null));
               dist[r][c] = 0;
               break;
            }
         }
         if(!q.isEmpty())
            break;
      }
      
      //q.add(N);
      while(!q.isEmpty()){
         Node curr = (Node)q.remove();
         //System.out.println(X+" "+dist[X]);
         int r = curr.r;
         int c = curr.c;
         if(visited[r][c])
            continue;
         visited[r][c] = true;
         if(r-1>0 && !field[r-1][c].equals("*") && !visited[r-1][c]){ //idk if visited check is necessary !field[r-1][c].visited
            q.add(new Node(field[r-1][c], r-1, c, curr));
            if(dist[r-1][c] == Integer.MAX_VALUE && isCorner(curr)){
               dist[curr.last.r][curr.last.c] = dist[curr.last.last.r][curr.last.last.c];
               dist[r][c] = dist[curr.last.r][curr.last.c];
               dist[r-1][c] = dist[r][c]+1;
            }
         }
         if(c-1>0&&  !field[r][c-1].equals("*") && !visited[r][c-1]){ //!field[r][c-1].visited &&
            q.add(new Node(field[r][c-1], r, c-1, curr));
            if(dist[r][c-1] == Integer.MAX_VALUE && isCorner(curr)){
               dist[curr.last.r][curr.last.c] = dist[curr.last.last.r][curr.last.last.c];
               dist[r][c] = dist[curr.last.r][curr.last.c];
               dist[r][c-1] = dist[r][c]+1;
            }
            
         }
         if(r+1<field.length && !field[r+1][c].equals("*") && !visited[r+1][c]){ //&& !field[r+1][c].visited 
            q.add(new Node(field[r+1][c], r+1, c, curr));
            if(dist[r+1][c] == Integer.MAX_VALUE && isCorner(curr)){
               dist[curr.last.r][curr.last.c] = dist[curr.last.last.r][curr.last.last.c];
               dist[r][c] = dist[curr.last.r][curr.last.c];
               dist[r+1][c] = dist[r][c]+1;
            }
         }
         if(c+1<field[0].length && !field[r][c+1].equals("*")&& !visited[r][c+1]){ // && !field[r][c+1].visited
            q.add(new Node(field[r][c+1], r, c+1, curr));
            if(dist[r][c+1] == Integer.MAX_VALUE && isCorner(curr)){
               dist[curr.last.r][curr.last.c] = dist[curr.last.last.r][curr.last.last.c];
               dist[r][c] = dist[curr.last.r][curr.last.c];
               dist[r][c+1] = dist[r][c]+1;
            }
         }
         if(field[r][c].equals("C"))
            System.out.println(dist[r][c]);
            
      }
      
      
   }
   public static boolean isCorner(Node curr){
      if(curr.last != null && curr.last.last != null && curr.last.last.r != curr.r && curr.last.last.c != curr.c){
         return true;
      }
      return false;
   }
}
class Node{
   int r;
   int c;
   String s;
   Node last;
   public Node(String st, int row, int col, Node l){
      s = st;
      r = row;
      c = col;
      last = l;
   }
}


// before i add "last" to the node class
// /*
// ID: wuhanda1
// LANG: JAVA
// TASK: lphone
// */
// import java.io.*;
// import java.util.*;
// public class lphone{ 
//    public static void main(String[] args) throws IOException{
//       BufferedReader f = new BufferedReader(new FileReader("lphone.in"));
//       
//       StringTokenizer s = new StringTokenizer(f.readLine());
//       int w = Integer.parseInt(s.nextToken());
//       int h = Integer.parseInt(s.nextToken());
//       String[][] field = new String[h][w];
//       boolean[][] visited = new boolean[h][w];
//       int[][] dist = new int[h][w]; //actually just saves corners?
//       Arrays.fill(dist, Integer.MAX_VALUE);
//       
//       for(int r =0; r<h; r++){
//       String line = f.readLine();
//          for(int c=0; c<w; c++){
//             field[r][c] = ""+line.charAt(c);
//          }
//       }
// 
//       Queue<Node> q = new LinkedList<Node>();
// 
//       for(int r =0; r<h; r++){ //append start pos "C" to the queue
//          for(int c=0; c<w; c++){
//             if(field[r][c].equals("C"))
//                q.add(new Node(field[r][c], r, c));
//                dist[r][c] = 0;
//                break;
//          }
//       }
//       
//       //q.add(N);
//       while(!q.isEmpty()){
//          Node curr = (Node)q.remove();
//          //System.out.println(X+" "+dist[X]);
//          int r = curr.r;
//          int c = curr.c;
//          if(visited[r][c])
//             continue;
//          visited[r][c] = true;
//          if(r-1>0 && !field[r-1][c].equals("*")){ //idk if visited check is necessary !field[r-1][c].visited
//             q.add(new Node(field[r-1][c], r-1, c));
//             if(dist[r-1][c] == Integer.MAX_VALUE && isCorner())
//                dist[r-1][c] = dist[r][c]+1;
//          }
//          if(c-1>0&&  !field[r][c-1].equals("*")){ //!field[r][c-1].visited &&
//             q.add(new Node(field[r][c-1], r, c-1));
//             if(dist[r][c-1] == Integer.MAX_VALUE)
//                dist[r][c-1] = dist[r][c]+1;
//             
//          }
//          if(r+1<field.length && !field[r+1][c].equals("*")){ //&& !field[r+1][c].visited 
//             q.add(new Node(field[r+1][c], r+1, c));
//             if(dist[r+1][c] == Integer.MAX_VALUE)
//                dist[r+1][c] = dist[r][c]+1;
//          }
//          if(c+1<field[0].length && !field[r][c+1].equals("*")){ // && !field[r][c+1].visited
//             q.add(new Node(field[r][c+1], r, c+1));
//             if(dist[r][c+1] == Integer.MAX_VALUE)
//                dist[r][c+1] = dist[r][c]+1;
//          }
//          if(field[r][c].equals("C"))
//             System.out.println(dist[r][c]);
//             
//       }
//       
//       
//    }
// }
// class Node{
//    int r;
//    int c;
//    String s;
//    public Node(String st, int row, int col){
//       s = st;
//       r = row;
//       c = col;
//    }
// }