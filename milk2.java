/*
ID: wuhanda1
LANG: JAVA
TASK: milk2
*/
import java.io.*;
import java.util.*;
public class milk2{
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
      
      int n = Integer.parseInt(f.readLine());
      Map<Integer, Integer> times = new TreeMap(); //TREEMAPS OVERRIDE IF DUPLICATE ENTRIES 
      for(int x=0;x<n;x++){ //read the thing and put into a list.....
         StringTokenizer s = new StringTokenizer(f.readLine());
         int start = Integer.parseInt(s.nextToken());
         int end = Integer.parseInt(s.nextToken());
         if(times.get(start) != null) // if duplicate
            if(end < times.get(start)) // if the current end time is earlier than existing
               end = times.get(start); // set it to existing
         times.put(start, end);
      }
      int minStart = Integer.MAX_VALUE; //for the longest consecutive time
      int maxEnd = Integer.MIN_VALUE; //for the end of the consecutive time
      int notMilked = 0;
      boolean first = true;
      int longest = 0;
      int max = Integer.MIN_VALUE;

      for(int x: times.keySet()){
         int start = x;
         int end = times.get(x);
         if(first){
            minStart = start;
            maxEnd = end;
            first = false;
         }

         if(start <= maxEnd && end > maxEnd){
            maxEnd = end;
         }else if(start > maxEnd){ //if theres no overlap, save the old longest length and make the new one the next one
            System.out.println(minStart+" "+maxEnd+" "+start+" "+end);
            if(maxEnd - minStart > longest)
               longest = maxEnd - minStart;
            minStart = start;
            maxEnd = end;
         }
         //if(end < min && min - end > notMilked)  //if end is before start or start is after end...save as 
         //   notMilked = minStart - end;
         if(start > max && start-max > notMilked)
            notMilked = start-max;

         if(end > max)
            max = end;
      }
      if(maxEnd - minStart > longest)
         longest = maxEnd - minStart;
      out.println(longest+" "+notMilked);
      out.close();
   }
}