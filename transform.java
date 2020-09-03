/*
ID: wuhanda1
LANG: JAVA
TASK: transform
*/
import java.io.*;
import java.util.*;
public class transform{
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("transform.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
      
      int n = Integer.parseInt(f.readLine());
      String[] start = new String[n*n];
      String[] end = new String[n*n];
      String currLine = "";

      for(int x = 0; x<n*n; x++){
         if(x%n == 0)
            currLine = f.readLine();
         start[x] = currLine.charAt(x%n)+"";        
      }
      for(int x = 0; x<n*n; x++){
         if(x%n == 0)
            currLine = f.readLine();
         end[x] = currLine.charAt(x%n)+"";        
      }
      if(equals(rotate90(start, n), end))
         out.println("1");
      else if(equals(rotate90(rotate90(start, n), n), end))
         out.println("2");
      else if(equals(rotate90(rotate90(rotate90(start, n), n), n), end))
         out.println("3");
      else if(equals(reflect(start, n), end))
         out.println("4");
      else if(equals(rotate90(reflect(start, n), n), end) || equals(rotate90(rotate90(reflect(start, n), n), n), end) 
      || equals(rotate90(rotate90(rotate90(reflect(start, n), n), n), n), end))
         out.println("5");
      else if(equals(start, end))
         out.println("6");
      else
         out.println("7");
      out.close();
   }
   public static String[] rotate90(String[] a, int n){
      int topRight = n-1, botRight = a.length - 1;
      int curr = topRight, col = 0; //col is the number of columns away from the right that we are
      String[] result = new String[a.length];
      for(int x = 0;x<a.length;x++){
         result[curr] = a[x];
         if(curr == botRight-col){
            col += 1;
            curr = topRight -col;
         }else
            curr += n;
      }
      return result;
   }
   public static String[] reflect(String[] a, int n){
      int curr = n-1;
      String[] result = new String[a.length];
      for(int x = 0;x<a.length;x++){
         result[curr] = a[x];
         if(curr%n == 0)
            curr = curr + (2*n) - 1;
         else
            curr--;
      }
      return result;
   }
   public static boolean equals(String[] a, String[] other){
      if(a.length != other.length)
         return false;
      for(int x=0;x<a.length;x++)
         if(!a[x].equals(other[x]))
            return false;
      return true;
   }
}
// class Image{
//    String[] tiles;
//    int topLeft, topRight, botLeft, botRight;
//    public Image(String[] a, n){
//       tiles = a;
//       topLeft = 0;
//       topRight = n-1;
//       botLeft = a.length - n;
//       botRight = a.length - 1;
//    }
//    public String[] rotate90(){
//       String[] result = new String[tiles.len
//    }
// }   
// for(String s:rotate90(start, n))
//             System.out.print(s);
//             System.out.println();
//       for(String s:end)
//          System.out.print(s);
//          System.out.println();