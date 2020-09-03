/*
ID: wuhanda1
LANG: JAVA
TASK: visitfj
*/
import java.io.*;
import java.util.*;
public class visitfj{ 
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("visitfj.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("visitfj.out")));
      
      StringTokenizer s = new StringTokenizer(f.readLine());
      int n = Integer.parseInt(s.nextToken());
      int t = Integer.parseInt(s.nextToken());
      int[][] times = new int[n][n];
      for(int i=0; i<n; i++){
         StringTokenizer st = new StringTokenizer(f.readLine());
         for(int j=0; j<n; j++){
            times[i][j] = Integer.parseInt(st.nextToken());
         }
      }
      int total = 0;
      Node node = new Node(0, 0, times[0][0]);
      while(dist(node.x, node.y, n-1, n-1) >= 3){
         Node min = new Node(0, 0, Integer.MAX_VALUE);
         for(int i=0; i<=3; i++){
            int a = 3-i;
            if(node.x - i >= 0 && node.y -a >=0){
               Node child1 = new Node(node.x - i, node.y -a, times[node.x-i][node.y-a]);
               if(child1.compareTo(min) < 0)
                  min = child1;
            }
            if(node.x - i >= 0 && node.y +a<n){
               Node child2 = new Node(node.x - i, node.y+a, times[node.x-i][node.y+a]);
               if(child2.compareTo(min) < 0)
                  min = child2;
            }
            if(node.x + i <n && node.y -a>=0){
               Node child3 = new Node(node.x +i, node.y -a, times[node.x+i][node.y-a]);
               if(child3.compareTo(min) < 0)
                  min = child3;
            }
            if(node.x+i < n && node.y+a <n){
               Node child4 = new Node(node.x + i, node.y +a, times[node.x+i][node.y+a]);
               if(child4.compareTo(min) < 0)
                  min = child4;
            } 
         }
         node = min;
         total += node.time +3*t;   
      }
      total += t*dist(node.x, node.y, n-1, n-1);
      
      out.println(total);
      out.close();
   }
   public static int dist(int x1, int y1, int x2, int y2){ //x1y1 to x2y2
      return Math.abs(x2-x1) + Math.abs(y2-y1);
   }
}
class Node implements Comparable<Node>{
   int x, y;
   int time;
   //boolean visited;
   public Node(int xin, int yin, int t){
      x=xin;
      y=yin;
      time = t;
      //visited = v;
   }
   public boolean equals(Object o){
      Node other = (Node)(o);
      return (x==other.x && y==other.y);
   }
   public int compareTo(Node other){
      return time-other.time;
   }
}
// ArrayList<Node> list = new ArrayList<Node>();
//       list.add(new Node(0, 0, times[0][0]));
//       int total = -times[0][0]-3*t;
//       while(true){
//          Node node = list.remove(0);
//          total += node.time + 3*t; 
//          //list.clear();
//          if(dist(node.x, node.y, n-1, n-1) < 3){
//             total += dist(node.x, node.y, n-1, n-1)*t;
//             break;
//          }
//          for(int i=0; i<=3; i++){
//             int a = 3-i;
//             if(node.x - i >= 0 && node.y -a >=0){
//                Node child1 = new Node(node.x - i, node.y -a, times[node.x-i][node.y-a]);
//                if(!list.contains(child1))
//                   list.add(child1);
//             }
//              
//             if(node.x - i >= 0 && node.y +a<n){
//                Node child2 = new Node(node.x - i, node.y+a, times[node.x-i][node.y+a]);
//                if(!list.contains(child2))
//                   list.add(child2);
//             }
//             if(node.x + i <n && node.y -a>=0){
//                Node child3 = new Node(node.x +i, node.y -a, times[node.x+i][node.y-a]);
//                if(!list.contains(child3))
//                   list.add(child3);
//             }
//             if(node.x+i < n && node.y+a <n){
//                Node child4 = new Node(node.x + i, node.y +a, times[node.x+i][node.y+a]);
//                if(!list.contains(child4))
//                   list.add(child4);
//             }
//             
//          }
//          Collections.sort(list);
//       }

//       int[][] dp = new int[n][n]; //idk??
//       dp[0][0] = 0;
//       for(int i=1; i<n; i++){
//          if(i%3 == 0 && i !=0){ //if it's three steps away and is not the first field
//             dp[0][i] = dp[0][i-1]+times[0][i]+t;
//             dp[i][0] = dp[i-1][0]+times[i][0]+t;
//          }else{
//             dp[0][i] = dp[0][i-1]+t;
//             dp[i][0] = dp[i-1][0]+t;
//          }
//       }
//       for(int i=1; i<n; i++){
//          for(int j=1; j<n; j++){
//             if((i+j)%3==0)
//                dp[i][j] = times[i][j] + Math.min(dp[i-1][j], dp[i][j-1])+t;
//             else
//                dp[i][j] = t + Math.min(dp[i-1][j], dp[i][j-1]);
//          }
//       }
// 