/*
ID: wuhanda1
LANG: JAVA
TASK: taming
*/
import java.io.*;
import java.util.*;
public class taming{ 
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("taming.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("taming.out")));
      
      int n = Integer.parseInt(f.readLine());
      int[] log = new int[n];
      StringTokenizer st = new StringTokenizer(f.readLine());
      for(int i=0;i<n;i++){
         log[i] = Integer.parseInt(st.nextToken());
      }
      
      int[] potLog = new int[n];      
      //deal w 1 breakout first
      Arrays.fill(potLog, -1);
      potLog[0] = 0;
      pw.println(check(potLog.clone(), log));
      //2 thru n breakouts
      for(int numBreakouts = 2; numBreakouts <= n; numBreakouts++){
         int minInc = Integer.MAX_VALUE; //minInconsistent
         int minIndex = -1;
         //ArrayList<Integer> mindices = new ArrayList<Integer>();
         for(int i=0;i<n;i++){ //index of the new potential breakout
            int[] testLog = potLog.clone();
            if(testLog[i] == 0)
               continue; //don't check this one
            testLog[i] = 0;
            int c = check(testLog, log);
            if(c == 0)
               continue;
            if(c <= minInc) //this breakout index is the min
               minIndex = i; //what if this is the smallest so far? it'll change to this & change agin later
            minInc = Math.min(minInc, c);   
         }
         pw.println(minInc);
         potLog[minIndex] = 0;        
      }
      pw.close();
      //check seems to be good. 
//       int[] a = {0, -1, -1, 0, -1, -1};
//       int[] b = {2, 3, 3, 1, 1, 3};
//       System.out.println(check(a, b));
   }
   public static int check(int[] potLog, int[] log){
      int n=log.length, numSince = 0, inc = 0; //numsince0, inconsistencies
      for(int i=0; i<n;i++){
         if(potLog[i] ==0)
            numSince = 0;
         potLog[i] = numSince;
         if(potLog[i] != log[i])
            inc++;
         numSince++;
      }
      return inc;
   }
}