/*
ID: wuhanda1
LANG: JAVA
TASK: lphone
*/
import java.io.*;
import java.util.*;
public class lphone2{ 
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("lphone.in"));
      
      StringTokenizer s = new StringTokenizer(f.readLine());
      int w = Integer.parseInt(s.nextToken());
      int h = Integer.parseInt(s.nextToken());
      String[][] field = new String[h][w];
      boolean[][] visited = new boolean[h][w];
      int[][] distance = new int[h][w]; //actually just saves corners?
      
      for(int r =0; r<h; r++){
      String line = f.readLine();
         for(int c=0; c<w; c++){
            field[r][c] = ""+line.charAt(c);
         }
      }
      
      Queue<Node> q = new LinkedList<Node>();
      
      for(int r =0; r<h; r++){ //append start pos "C" to the queue
         for(int c=0; c<w; c++){
            if(field[r][c].equals("C"))
               q.add(new Node(r, c, field[r][c]));
               break;
         }
      }
      
//       while(!q.isEmpty()){
//          Node curr = q.remove();
//          if(curr.visited == true)
//             continue;
//          curr.visited = true;
//          q.addAll(curr.neighbors(field));
//       }
      
      boolean first = true;
      while(!q.isEmpty()){
         Node curr = (Node)q.remove();
         if(curr.visited == true)
            continue;
         curr.visited = true;
         q.addAll(curr.neighbors(field));
         if(curr.last != null && curr.last.last != null && curr.last.last.r != curr.r && curr.last.last.c != curr.c)
            distance[curr.r][curr.c] = distance[curr.last.r][curr.last.c] +1;
         else
            distance[curr.r][curr.c] = distance[curr.last.r][curr.last.c];
            //curr.last.corner = true;  //marks all corners
         if(curr.s.equals("C") && !first)
            System.out.println(distance[curr.r][curr.c]);
         first = false;
      }
      
   }
   

}

class Node{
   boolean visited;
   int r;
   int c;
   Node last;
   String s;
   boolean corner;
   public Node(int row, int col, String str){
      r = row;
      c = col;
      s = str;
      visited = false;
      corner = false;
   }
   public Queue neighbors(String[][] field){
      Queue n = new LinkedList<String>();
      if(r-1>0 && !field[r-1][c].equals("*")){
         n.add(new Node(r-1, c, field[r-1][c]));
         field[r-1][c].last = field[r][c];
      }
      if(c-1>0 && !field[r][c-1].equals("*")){
         n.add(new Node(r, c-1, field[r][c-1]));
         field[r][c-1].last = field[r][c];
      }
      if(r+1<field.length && !field[r+1][c].equals("*")){
         n.add(new Node(r+1, c, field[r+1][c]));
         field[r+1][c].last = field[r][c];
      }
      if(c+1<field[0].length && !field[r][c+1].equals("*")){
         n.add(new Node(r, c+1, field[r][c+1]));
         field[r][c+1].last = field[r][c];
      }
      return n;
   }
}
