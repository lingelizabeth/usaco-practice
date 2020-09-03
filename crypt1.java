/*
ID: wuhanda1
LANG: JAVA
TASK: crypt1
*/
import java.io.*;
import java.util.*;
public class crypt1{
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("crypt1.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
      
      int n = Integer.parseInt(f.readLine());
      StringTokenizer st = new StringTokenizer(f.readLine());
      int[] subset = new int[n];
      for(int x=0; x<n; x++)
         subset[x] = Integer.parseInt(st.nextToken());
      Arrays.sort(subset);
      int ans = 0;
      for(int a=0; a<n; a++){
         //System.out.print(a+" "+subset[a]);
         for(int b=0; b<n; b++){
            for(int c=0; c<n; c++){
               for(int d=0; d<n; d++){
                  for(int e=0; e<n; e++){
                     int abc = 100*subset[a]+10*subset[b]+subset[c];
                     int de = 10*subset[d]+subset[e];
                     int p1 = abc*subset[e];
                     int p2 = abc*subset[d];
                     
                     if((p1+"").length() != 3 || (p2+"").length() != 3)
                        //System.out.println((p1+"").length() +" "+ (p2+"").length());
                        break;
                     //System.out.println(p1+" "+allDigitsIn(subset, p1));
                     if(allDigitsIn(subset, p1) && allDigitsIn(subset, p2) && allDigitsIn(subset, abc*de)){
                        //System.out.println((abc*subset[e])+" "+abc+"*"+de+" = "+abc*de);
                        ans++;
                     }
                  }
               }
            }
         }
      }
      out.println(ans);
      out.close();
   }
   public static boolean allDigitsIn(int[] subset, int r){
      String s = r+"";
      for(int i=0; i<s.length(); i++){
         if(!contains(subset, Integer.parseInt(""+s.charAt(i))))
            return false;
      }
      return true;
   }
   public static boolean contains(int[] subset, int x){
      for(int i=0; i<subset.length; i++){
         if(subset[i] == x)
            return true;
      }
      return false;
   }
}
