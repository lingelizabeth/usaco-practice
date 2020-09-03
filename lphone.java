/*
ID: wuhanda1
LANG: JAVA
TASK: lphone
*/
import java.io.*;
import java.util.*;
public class lphone{ 

   public static void main(String[] args) throws IOException{
      //BufferedReader f = new BufferedReader(new FileReader("lphone.in"));
      
      Scanner sc = new Scanner(System.in);
      int w = sc.nextInt();//Integer.parseInt(s.nextToken());
      int h = sc.nextInt();//Integer.parseInt(s.nextToken());
      sc.nextLine();
      int count = 0;
      int[][] mark = new int[h+1][w+1];
      Node[] cows = new Node[2];
      char[][] field = new char[h+1][w+1];
      int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
      //boolean[][] visited = new boolean[h][w];
      //int[][] dist = new int[h][w]; //actually just saves corners?
      //for(int[] a:dist)
         //Arrays.fill(a, Integer.MAX_VALUE);
      

      int k=0;
      for(int r =0; r<h; r++){
      String line = sc.nextLine();
         for(int c=0; c<w; c++){
            field[r][c] = line.charAt(c);
            if(field[r][c] == 'C'){
               cows[k] = new Node(r, c);
               k++;
            }
         }
      }
      
      mark[cows[0].x][cows[0].y] = 1; //mark location of the first cow
      Queue<Node> q = new LinkedList<Node>();
      q.add(cows[0]);
      
      while(!q.isEmpty()){ //or while(true){
         Node curr = (Node)q.remove();
         count = mark[curr.x][curr.y]; //huh??
         
         for(int d = 0; d<4; d++){
            for(int i=curr.x+dir[d][0], j = curr.y+dir[d][1]; i>= 0 && i<h && j>=0 && j<w; i+= dir[d][0], j+= dir[d][1]){
               //for(int j = curr.y+dir[d][1]; j>=0 && j<w; j+= dir[d][1]){
                  if(field[i][j] == '*')
                     break;
                  if(mark[i][j] == 0){
                     mark[i][j] = count+1;
                     Node n = new Node(i, j);
                     q.add(n);
                  }
               if(i == cows[1].x && j == cows[1].y){
                  //System.out.println("cow "+i+" "+j);
                  System.out.println((mark[i][j]-2)+"");
                  return;}
               //}
            }
         }
      }
      
   }
}
class Node{
   int x;
   int y;
   public Node(int x1, int y1){
      x = x1;
      y = y1;
   }
}