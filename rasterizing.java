/*
ID: wuhanda1
LANG: JAVA
TASK: rasterizing
*/
import java.io.*;
import java.util.*;
public class rasterizing{ 
   static double[][] vertices;
   static double[] slopes;
   public static void main(String[] args) throws IOException{
      Scanner sc = new Scanner(System.in);
      vertices = new double[3][2];
      for(int i=0;i<3;i++){
         for(int j=0;j<2;j++){
            vertices[i][j] = sc.nextDouble();
         }
      }
      slopes = new double[3];
      slopes[0] = (vertices[0][1] - vertices[1][1])/(vertices[0][0] - vertices[1][0]); //0 and 1
      slopes[1] = (vertices[1][1] - vertices[2][1])/(vertices[1][0] - vertices[2][0]); //1&2
      slopes[2] = (vertices[0][1] - vertices[2][1])/(vertices[0][0] - vertices[2][0]); //0&2
      sc.nextLine();
      int n = sc.nextInt();
      sc.nextLine();
      for(int i=0;i<n;i++){
         double X = sc.nextDouble();
         double Y = sc.nextDouble();
         sc.nextLine();
         if(numTrue(X, Y))
            System.out.println("1");
         else
            System.out.println("0");
      }
      
   }
   //(x, y) is the point to be checked
   public static boolean numTrue(double x, double y){ //true if below or on line, false if above
      int numTrue = 0;
      if(y < slopes[0]*(x-vertices[0][0])+vertices[0][1])
         numTrue++;
      if(y < slopes[1]*(x-vertices[1][0])+vertices[1][1])
         numTrue++;
      if(y < slopes[2]*(x-vertices[0][0])+vertices[0][1])
         numTrue++;
      if(numTrue == 1 || numTrue == 2)
         return true;
      return false;
   }
}