/*
ID: wuhanda1
LANG: JAVA
TASK: lines
*/
import java.io.*;
import java.util.*;
public class lines{ //exception cases were +-infinity and +-0

   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("lines.in"));
      //Scanner sc = new Scanner(System.in);
      StringTokenizer st = new StringTokenizer(f.readLine());
      
      int n = Integer.parseInt(st.nextToken()); 
      TreeSet<Float> slopeSet = new TreeSet<Float>();
      Point[] points = new Point[n];
      for(int i=0; i<n; i++){
         st = new StringTokenizer(f.readLine());
         int X_i = Integer.parseInt(st.nextToken()); 
         int Y_i = Integer.parseInt(st.nextToken()); 
         points[i] = new Point(X_i, Y_i);
      }
      
      for(int i=0; i<n-1; i++){
         for(int j = i+1; j<n; j++){
            //System.out.println(points[i]+" "+points[j]+" "+points[i].getSlope(points[j]));
            if(points[i].getSlope(points[j]) == (float)0.0 && slopeSet.contains((float)0.0))//if i don't do this
                                                      //then -0.0 will be one of the elements idk why
                                                      //same thing for infinity and -infinity
               continue;
            if(points[i].getSlope(points[j]) == Float.POSITIVE_INFINITY && slopeSet.contains(Float.NEGATIVE_INFINITY)
            || points[i].getSlope(points[j]) == Float.NEGATIVE_INFINITY && slopeSet.contains(Float.POSITIVE_INFINITY))
               continue;
            slopeSet.add(points[i].getSlope(points[j]));
         } 
      }
      for(Float fl: slopeSet)
         System.out.println(fl+"");
      System.out.println(slopeSet.size());
   }
}
class Point{
   int x;
   int y;
   public Point(int x1, int y1){
      x = x1;
      y = y1;
   }
   public float getSlope(Point other){
      return (float)(other.y - y)/(other.x - x);
   }
   public String toString(){
      return x+" "+y;
   }
}