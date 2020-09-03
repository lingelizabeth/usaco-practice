/*
ID: wuhanda1
LANG: JAVA
TASK: grafixMask
Topcoder
*/
import java.io.*;
import java.util.*;
public class grafixMask{ 
   static boolean[][] fill;
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("grafixMask.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("grafixMask.out")));
      
      String in = f.readLine();
      String[] input = in.split(", ");
      fill = new boolean[400][600];
      for(int i=0; i< input.length; i++){
         StringTokenizer st = new StringTokenizer(input[i].substring(1, input[i].length()-1));
         int x1 = Integer.parseInt(st.nextToken());
         int y1 = Integer.parseInt(st.nextToken());
         int x2 = Integer.parseInt(st.nextToken());
         int y2 = Integer.parseInt(st.nextToken());
         for(int x=x1; x<=x2; x++){
            for(int y=y1; y<=y2; y++) //^should this be inclusive?
               fill[x][y] = true;
         }
      }
      ArrayList<Integer> ans = new ArrayList<Integer>();
      for(int x=0; x<400;x++){
         for(int y=0; y<600;y++){
            if(!fill[x][y])
               ans.add(doFill(x, y));
         }
      }
      Collections.sort(ans);
      for(int n: ans)
         out.print(n+" ");
      out.println();
      out.close();
   }
   public static int doFill(int x, int y){
      int count = 0;
      Stack s = new Stack();
      s.push(new Node(x, y));
      while(!s.isEmpty()){
         Node curr = (Node)(s.pop());
         if(curr.x < 0 || curr.x > 399 || curr.y < 0 || curr.y > 599 || fill[curr.x][curr.y])
            continue;
         fill[curr.x][curr.y] = true;
         count++;
         s.push(new Node(curr.x-1, curr.y));
         s.push(new Node(curr.x+1, curr.y));
         s.push(new Node(curr.x, curr.y+1));
         s.push(new Node(curr.x, curr.y-1));
      }
      return count;
   }
}
class Node{
   int x;
   int y;
   public Node(int xin, int yin){
      x = xin;
      y = yin;
   }
}