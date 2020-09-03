/*
ID: wuhanda1
LANG: JAVA
TASK: lphone
*/
import java.io.*;
import java.util.*;
public class lphone1{ 
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("lphone.in"));
      //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lphone.out")));
      
      int row = 0;
      int col = 0;
      
      StringTokenizer s = new StringTokenizer(f.readLine());
      int w = Integer.parseInt(s.nextToken());
      int h = Integer.parseInt(s.nextToken());
      
      Node[][] field = new Node[h][w];
      for(int r = 0; r<h; r++){ //builds the field
         String line = f.readLine();
         for(int c=0; c<w; c++){
            field[r][c] = new Node(r, c, ""+line.charAt(c));
            if(field[r][c].s.equals("C")){
               row = r;
               col = c;
            }
         }
      }
      
      Queue<Node> q = new LinkedList<Node>();//ArrayList<String>();
      q.add(field[row][col]);
      field[row][col].d=0;
      while(!q.isEmpty()){
         Node curr = (Node)q.remove();
         if(curr.visited == true)
            continue;
         curr.visited = true;
         if(curr.last != null && curr.last.last != null && curr.last.last.r != curr.r && curr.last.last.c != curr.c){
            if(curr.last.d == -1){
               curr.last.d = curr.last.last.d+1;  //marks all corners
               curr.d = curr.last.d;
            }
            System.out.println(curr.r+" "+ curr.c+" "+curr.d);
            //System.out.println(curr.r+" "+curr.c+" "+curr.last.last.r+" "+curr.last.last.c);
         }
         q.addAll(neighbors(field, curr.r, curr.c));
         if(curr.s.equals("C") && !(curr.r == row && curr.c == col))
            //System.out.println(retrace(curr)+"");
            System.out.println(curr.d+"");
      }
      
   }
   public static int retrace(Node start){
      int corners = 0;
      //Queue<Node> path = new LinkedList<Node>();
      Node curr = start;
      //path.add(curr);
      //if(curr.corner)
         //corners++;
      while(curr.last != null && curr.last.last != null){
         if(curr.last.last.r != curr.r && curr.last.last.c != curr.c){
            corners++;
            System.out.println(curr.last.r+" "+curr.last.c);
         }
         curr = curr.last;
         //if(curr.corner)
            //corners++;
         //path.add(curr);
      }
      //for(Node st: path)
         //System.out.print(st.s+" ");
      return corners;
   }
   
   public static Queue<Node> neighbors(Node[][] field, int r, int c){
      Queue<Node> n = new LinkedList<Node>();
      if(r-1>0 && !field[r-1][c].visited && !field[r-1][c].s.equals("*")){
         n.add(field[r-1][c]);
         field[r-1][c].setLast(field[r][c]);
      }
      if(c-1>0&& !field[r][c-1].visited && !field[r][c-1].s.equals("*")){
         n.add(field[r][c-1]);
         field[r][c-1].setLast(field[r][c]);
      }
      if(r+1<field.length && !field[r+1][c].visited && !field[r+1][c].s.equals("*")){
         n.add(field[r+1][c]);
         field[r+1][c].setLast(field[r][c]);
      }
      if(c+1<field[0].length && !field[r][c+1].visited && !field[r][c+1].s.equals("*")){
         n.add(field[r][c+1]);
         field[r][c+1].setLast(field[r][c]);
      }
      return n;
   }
}
class Node implements Comparable<Node>{
   boolean visited;
   int r;
   int c;
   Node last;
   String s;
   int d;
   //boolean corner;
   public Node(int row, int col, String str){
      r = row;
      c = col;
      s = str;
      visited = false;
      d=-1;
      //corner = false;
   }
   public int compareTo(Node other){
      return (d-other.d);
   }
   public void setLast(Node l){
      last = l;
      //d = last.d;
   }
}
//44 min