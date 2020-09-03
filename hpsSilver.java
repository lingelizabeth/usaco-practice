/*
ID: wuhanda1
LANG: JAVA
TASK: hps silver
*/
import java.io.*;
import java.util.*;
public class hpsSilver{ 
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("hpsSilver.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hpsSilver.out")));
      
      int n = Integer.parseInt(f.readLine());
      int[][] games = new int[n][3]; //H, P, S
      int h = 0, p = 0, s = 0;
      for(int i=0;i<n;i++){
         String in = f.readLine();
         if(i > 0){
            for(int j=0; j<3; j++)
               games[i][j] = games[i-1][j];
         }
         if(in.equals("H")){
            h++;
            games[i][0] += 1;
         }else if(in.equals("P")){
            p++;
            games[i][1] += 1;
         }else if(in.equals("S")){
            s++;
            games[i][2] += 1;
         }
      }
      int win = 0; //max number of games she can win
      for(int x=0; x<n; x++){
         int left = Math.max(games[x][0], Math.max(games[x][1], games[x][2]));
         int right = Math.max(h-games[x][0], Math.max(p-games[x][1], s-games[x][2]));
         win = Math.max(win, left+right);
      }
      out.println(win);
      out.close();
   }
}