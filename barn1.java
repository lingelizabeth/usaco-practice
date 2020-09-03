/*
ID: wuhanda1
LANG: JAVA
TASK: barn1
*/
import java.io.*;
import java.util.*;
public class barn1{
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("barn1.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
      StringTokenizer st = new StringTokenizer(f.readLine());

      int m = Integer.parseInt(st.nextToken());//number of boards
      int s = Integer.parseInt(st.nextToken());//total number of stalls
      int c = Integer.parseInt(st.nextToken());//number of cows in stalls
      int[] barn = new int[c];//list of indices of cows
      boolean[] boards = new boolean[s];//true if board covering stall, false otherwise
      for(int x = 0; x<barn.length; x++)
         barn[x] = Integer.parseInt(f.readLine());
      Arrays.sort(barn);
      int blocked = 0;
      for(int x=0; x<boards.length; x++)
         if(x+1 >= barn[0] && x+1 <= barn[barn.length - 1]){
            boards[x] = true; //one board covering the whole thing
            blocked++;
         }
      //for(int x=1; x<=m-1; x++){ //split it m-1 times
      while(numBoards(boards) < m && numBoards(boards) < c){
         //System.out.println(blocked);
         blocked -= getSpace(barn, boards);
         //System.out.println(blocked);
         
//          for(int i=0; i<boards; i++){//go thru the boards array 
//             int max = Integer.MIN_VALUE, count = 0;
//             if(barn[x] == false)
//                count++; 
//          }
      }
      out.println(blocked+"");
      out.close();
   }
   public static int getSpace(int[] barn, boolean[] boards){ // returns the largest difference between 2 elements in barn as long as the space has a board covering it
      int max = Integer.MIN_VALUE;
      int a = -1, b = -1;
      ArrayList<Integer> diffs = new ArrayList<Integer>();
      for(int x=1; x<barn.length; x++)
         if(hasBoards(boards, barn[x-1], barn[x]) && barn[x] - barn[x-1] > max){ //if the area has boards over it
            //diffs.add(barn[x] - barn[x-1]);
            max = barn[x] - barn[x-1];
            a = barn[x-1];
            b = barn[x];
         }
      //Collections.sort(diffs);
      removeBoards(boards, a, b);
      return max - 1; //diffs.get(diff.size() - 1);
   }
   public static void removeBoards(boolean[] boards, int a, int b){
      for(int x=a; x<b-1; x++)
         boards[x] = false;
   }
   public static boolean hasBoards(boolean[] boards, int a, int b){ //not including a or b bc we assume there are cows there
      for(int x=a; x< b-1; x++)
         if(boards[x] == false)
            return false;
      return true;
   }
   public static int numBoards(boolean[] boards){
      int b = 0;
      for(int x = 0; x<boards.length; x++){
         if(x == 0 && boards[x] == false)
            ;
         else if((x == 0 && boards[x] == true) || (boards[x-1] == false && boards[x] == true))
            b++;
      }
      return b;
   }
}
