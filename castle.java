/*
ID: wuhanda1
LANG: JAVA
TASK: castle
*/

import java.io.*;
import java.util.*;
public class castle{
   static Square[][] castle;
   public static void main(String[] args) throws IOException {
      BufferedReader f = new BufferedReader(new FileReader("castle.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));
      
      StringTokenizer st = new StringTokenizer(f.readLine());
      int m = Integer.parseInt(st.nextToken());
      int n = Integer.parseInt(st.nextToken());
      castle = new Square[n][m];

      //READING IN THE CASTLE
      for(int x=0; x<n; x++){
      StringTokenizer s = new StringTokenizer(f.readLine());
        for(int y=0; y<m; y++){
            castle[x][y] = new Square(new boolean[4], -1);
            int c = Integer.parseInt(s.nextToken());
            String w = convert(c);
            for(int i=0; i<4; i++)
               if(w.charAt(i) == '1')
                  castle[x][y].walls[i] = true;
        }
      }
      //printing a castle...
//       for(int c=0;c<m;c++){
//          if(castle[0][c].walls[2])
//             System.out.print(" _");
//          else
//             System.out.print(" ");
//       }
//       System.out.println();
//       for(int r=0; r<n; r++){
//          for(int c=0; c<m; c++){
//             if(c ==0){
//                if(castle[r][c].walls[3])
//                   System.out.print("|");
//                else
//                   System.out.print(" ");
//             }
//             if(castle[r][c].walls[0])
//                System.out.print("_");
//             else
//                System.out.print(" ");
//             if(castle[r][c].walls[1])
//                System.out.print("|");
//             else
//                System.out.print(" ");
//          }
//          System.out.println();
//       }
      //PAINTING THE CASLTE ( MARKING ROOMS )
      int roomNum = 0;
      for(int r=0; r<n; r++){
         for(int c=0; c<m; c++){
            if(castle[r][c].room == -1){
               floodfill(r, c, roomNum);
               roomNum++;
            }
         }
      }
      //WRITE COLORS
//       for(int r=0; r<n; r++){
//          for(int c=0; c<m; c++){
//             System.out.print(castle[r][c].room+" ");
//          }
//          System.out.println();
//       }
      //GET AREA OF EACH ROOM AND MAX AREA
      int[] area = new int[roomNum];
      int maxArea = Integer.MIN_VALUE;
      for(int r=0; r<n; r++){
         for(int c=0; c<m; c++){
            area[castle[r][c].room]++;
            if(area[castle[r][c].room] > maxArea)
               maxArea = area[castle[r][c].room];
         }
      }
      //FINDING THE BEST WALL
      int maxP = 0;
      int bestR = 50, bestC = 50;
      String bestDir = "";
      ArrayList<Wall> oWalls = new ArrayList<Wall>();
      for(int r=0; r<n; r++){
         for(int c=0; c<m; c++){
            if(c+1<m && castle[r][c].room != castle[r][c+1].room){
               maxP = Math.max(maxP, area[castle[r][c].room] + area[castle[r][c+1].room]);
               if(maxP == area[castle[r][c].room] + area[castle[r][c+1].room]){ //the room and the one on its right
                  // bestR = r+1;
//                   bestC = c+1;
//                   bestDir = "E";
                  oWalls.add(new Wall(r+1, c+1, "E", maxP));
               }
            }if(r+1<n && castle[r][c].room != castle[r+1][c].room){
               maxP = Math.max(maxP, area[castle[r][c].room] + area[castle[r+1][c].room]);
               if(maxP == area[castle[r][c].room] + area[castle[r+1][c].room]){ //the room and the one below it
                  oWalls.add(new Wall(r+2, c+1, "N", maxP));
               }
            }            
         }
      }
      Collections.sort(oWalls);
      out.println(area.length);
      out.println(maxArea);
      out.println(maxP);
      out.println(oWalls.get(0));
      out.close();
   }
   public static void floodfill(int r, int c, int roomNum){
      if(castle[r][c].room == -1 && !(r<0 || c<0 || r>castle.length || c>castle[0].length)){//unpainted
         castle[r][c].room = roomNum;
         if(!castle[r][c].walls[3])
            floodfill(r, c-1, roomNum);
         if(!castle[r][c].walls[2])
            floodfill(r-1, c, roomNum);
         if(!castle[r][c].walls[1])
            floodfill(r, c+1, roomNum);
         if(!castle[r][c].walls[0])
            floodfill(r+1, c, roomNum);
      }
   }
   public static String convert(int num){ //convert to base 2
      String out = "";
      int x = 0;
      while((int)(Math.pow(2, x+1)) <= num)
         x++;
      for(int k = x; k>=0; k--){
         int times = num/(int)(Math.pow(2, k)); //the number of times base goes into num
         out += times+"";
         num = num - times*(int)(Math.pow(2, k));
      }
      while(out.length() < 4)
         out ="0"+out;
      return out;
   }

}
class Square{
   boolean[] walls; //s e n w
   int room;
   public Square(boolean[] w, int r){
      walls = w;
      room = r;
   }
}
class Wall implements Comparable<Wall>{
   int r;
   int c;
   String dir;
   int maxP;
   public Wall(int rIn, int cIn, String d, int m){
      r = rIn;
      c = cIn;
      dir = d;
      maxP = m;
   }
   public int compareTo(Wall other){
      if(maxP != other.maxP)
         return other.maxP-maxP;
      if(c != other.c)
         return c-other.c;
      else if(r != other.r) //farther to the west
         return other.r-r;
      else if(dir =="E" && other.dir =="N")
         return 1;
      else if(dir == "N" && other.dir == "E")
         return -1;
      return 0;
   }
   public String toString(){
      return r+" "+c+" "+dir;
   }
}