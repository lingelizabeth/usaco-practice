/*
ID: wuhanda1
LANG: JAVA
TASK: cownav
*/
import java.io.*;
import java.util.*;
public class cownav{ 
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("cownav.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cownav.out")));
      
      int n = Integer.parseInt(f.readLine());
      int[][] grid = new int[n][n];
      int[][][][][][] dp = new int[n][n][4][n][n][4]; //?
      char[] moves = {'F', 'L', 'R'};
      
      for(int i=0;i<n;i++){//grid holds 1s for Es, 0s for Hs
         String str = f.readLine();
         for(int j=0; j<n;j++){
            if(str.charAt(j) == 'E')
               grid[i][j] = 1;
            else if(str.charAt(j) == 'H')
               grid[i][j] = 0;
         }
      }
      Queue<Node> q = new LinkedList<Node>();
      dp[n-1][0][0][n-1][0][1] = 1;
      int ans = Integer.MAX_VALUE;
      q.add(new Node(n-1, 0, 0, n-1, 0, 1));
      while(!q.isEmpty()){
         Node curr = (Node)q.remove();
         //dp[curr.r1][curr.c1][curr.dir1][curr.r2][curr.c2][curr.dir2] = true;
         if(curr.r1 == 0&&curr.c1 == grid[0].length-1 && curr.r2 == 0&& curr.c2 == grid[0].length-1){
            //ans = Math.min(ans, curr.moves);
            pw.println(dp[curr.r1][curr.c1][curr.dir1][curr.r2][curr.c2][curr.dir2]-1);
            //System.out.println(ans);
            break;
         }
         for(char m:moves){
            Node node = curr.nextMove(m, grid);
            if(dp[node.r1][node.c1][node.dir1][node.r2][node.c2][node.dir2] ==0){
               dp[node.r1][node.c1][node.dir1][node.r2][node.c2][node.dir2] = dp[curr.r1][curr.c1][curr.dir1][curr.r2][curr.c2][curr.dir2]+1;
               q.add(node);
            }
         }
      }
      //System.out.println(ans);
      //pw.println(ans);
      pw.close();
      
   }
}
class Node{
   int r1, c1, dir1, r2, c2, dir2, moves; //dir 0 up, 1 east >, 2 down, 3 west <
                        //turning right is adding 1 mod 4
                        //turning left is subtracting 1 mod 4
   //boolean up1, up2; //true if facing up false if facing right
   public Node(int r1, int c1, int dir1, int r2, int c2, int dir2){ //int moves){
      this.r1 = r1;
      this.c1 = c1;
      this.dir1 = dir1;
      this.r2 = r2;
      this.c2 = c2;
      this.dir2 = dir2;
      //this.moves = moves; 
   }
   public Node nextMove(char move, int[][] grid){//F, L, R
      int newr1 = r1, newc1 = c1, newr2 = r2, newc2 = c2;
      int newdir1 = dir1, newdir2 = dir2;
      if(!(r1 == 0 && c1 == grid[0].length-1)){//if the first block's not at the goal
         if(move == 'F' && (dir1==0 && r1>0 && grid[r1-1][c1] ==1))
            newr1 = r1-1;
         if(move == 'F' && dir1==1 && c1<grid[0].length-1 && grid[r1][c1+1] ==1)
            newc1 = c1+1;
         if(move == 'F' && (dir1==2 && r1<grid.length-1 && grid[r1+1][c1] ==1))
            newr1 = r1+1;
         if(move == 'F' && dir1==3 && c1>0 && grid[r1][c1-1] ==1)
            newc1 = c1-1;
         if(move == 'L'){
            newdir1 = (((dir1-1)%4)+4)%4;
         }
         if(move == 'R'){
            newdir1 = (dir1+1)%4;
         }
      
      }
      if(!(r2 == 0&&c2 == grid[0].length-1)){//if 2nd block is not at goal
         if(move == 'F' && dir2==0 && r2>0 && grid[r2-1][c2] ==1)
            newr2 = r2-1;
         if(move =='F' && dir2==1 && c2<grid[0].length-1 && grid[r2][c2+1] ==1)
            newc2 = c2+1;
         if(move == 'F' && (dir2==2 && r2<grid.length-1 && grid[r2+1][c2] ==1))
            newr2 = r2+1;
         if(move == 'F' && dir2==3 && c2>0 && grid[r2][c2-1] ==1)
            newc2 = c2-1;
         if(move == 'L'){
             newdir2 = (((dir2-1)%4)+4)%4;
         }
         if(move == 'R'){
            newdir2 = (dir2+1)%4;
         }
      }
      Node ret = new Node(newr1, newc1, newdir1, newr2, newc2, newdir2);//, moves+1);
      return ret;
   }
   
}

//       if(move == 'F'){
//          if(up1 && r1>0 && grid[r1+1][c1] ==1)
//             newr1 = r1+1;
//          if(!up1 && c1<grid[0].length-1 && grid[r1][c1+1] ==1)
//             newc1 = c1+1
//          if(up2 && r2>0 && grid[r2+1][c2] ==1)
//             newr2 = r2+1;
//          if(!up2 && c2<grid[0].length-1 && grid[r2][c2+1] ==1)
//             newc2 = c2+1;
//       }
//       else if(move == 'L'){
//          if(!up1)
//             newup1 = true;
//          if(!up2)
//             newup2 = true;
//       }
//       else if(move == 'R'){
//          if(up1)
//             newup1 = false;
//          if(up2)
//             newup2 = false;
//       }