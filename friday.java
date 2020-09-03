/*
ID: wuhanda1
LANG: JAVA
TASK: friday
*/
import java.io.*;
import java.util.*;

public class friday{
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("friday.in"));
      int numYears = Integer.parseInt(f.readLine());
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
      Map<Integer, Integer> map = new HashMap(); //count
      map.put(0, 0); //sun
      map.put(1, 0); //mon
      map.put(2, 0); //tues
      map.put(3, 0); //etc
      map.put(4, 0);
      map.put(5, 0);
      map.put(6, 1);
      int lastMonth = 6; //saturday the 13th jan 1900, day of the week the 13th was on last month
      int currMonth = 1;
      int currYear = 1900;
      for(int x = 0;x<12*numYears-1;x++){
         int daysPassed = 13+(getDaysInMonth(currMonth, currYear) - 13); //since last month
         int d = daysPassed%7;
         int dotwott = (d+lastMonth)%7; //day of the week of the 13th
         map.put(dotwott, map.get(dotwott)+1);
         lastMonth = dotwott;
         currMonth++;
         if(currMonth == 13)
            currMonth = 1;
         if(x%12 == 11)
            currYear++;
      }
      out.print(map.get(6)+" ");
      for(int x =0;x<6;x++)
         if(x == 5)
            out.print(map.get(x)+"\n");
         else
            out.print(map.get(x)+" ");
      out.close();
   }
   public static int getDaysInMonth(int month, int year){
      boolean isLeapYear = false;
      if(year%100==0 && year%400 == 0)
         isLeapYear = true;
      else if(year%100 != 0 && year%4==0)
         isLeapYear = true;
      if(month == 9 || month == 4 || month==6 || month==11)
         return 30;
      else if(month == 2 && !isLeapYear)
         return 28;
      else if(month == 2 && isLeapYear)
         return 29;
      else
         return 31;
   }
}