/*
ID: wuhanda1
LANG: JAVA
TASK: cardgame
*/
import java.io.*;
import java.util.*;
public class cardgame{ 
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("cardgame.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cardgame.out")));
      int n = Integer.parseInt(f.readLine());
      boolean[] used = new boolean[2*n+1]; 
      ArrayList<Integer> elsie = new ArrayList<Integer>();
      for(int i=0; i<n;i++){
         int num = Integer.parseInt(f.readLine());
         used[num] = true;
         elsie.add(num);
      }
      ArrayList<Integer> bessie = new ArrayList<Integer>();
      for(int i=1; i<2*n+1;i++){
         if(!used[i])
            bessie.add(i);
      }
      //separate upper and lower halves, for 1st half, we should use our higher half, second we should use our lower half
      Collections.sort(bessie);
      int wins = 0;
      ArrayList<Integer> elsie1 = new ArrayList<Integer>(); //first half of elsie's
      ArrayList<Integer> bessie1 = new ArrayList<Integer>(); //second half of bessie's
      for(int i=0; i<n/2;i++){
         elsie1.add(elsie.get(i));
         bessie1.add(bessie.get(i+n/2));
      }
      Collections.sort(elsie1);
      Collections.sort(bessie1);
      int lowest = 0; //bessie's lowest ununsed card
      for(int i=0; i<elsie1.size(); i++){ //beat elsie w our lowest card
         while(lowest < bessie1.size()){
            if(bessie1.get(lowest) > elsie1.get(i)){
               wins++;
               lowest++;
               break;
            }else{
               lowest++;
            }
         }
      }
      //upper half
      ArrayList<Integer> elsie2 = new ArrayList<Integer>(); //second half of elsie's
      ArrayList<Integer> bessie2 = new ArrayList<Integer>(); //second half of bessie's (smaller)
      for(int i=n/2; i<n;i++){
         //elsie2[i-n/2] = elsie.get(i);
         //bessie2[i-n/2] = bessie.get(n-1-i); //bessie's will be the smallest ones is increasing order
         elsie2.add(elsie.get(i));
         bessie2.add(bessie.get(i-n/2));
      }
      Collections.sort(elsie2, Collections.reverseOrder());
      Collections.sort(bessie2, Collections.reverseOrder()); //so they'll b biggest to smallest
      int highest = 0; //index of bessie's highest ununsed card
      for(int i=0; i<elsie2.size(); i++){ //beat elsie w our lowest card
         while(highest < bessie2.size()){
            if(bessie2.get(highest) < elsie2.get(i)){
               wins++;
               highest++;
               break;
            }else{
               highest++;
            }
         }
      }
      //System.out.println(wins);
      pw.println(wins);
      pw.close();
   }
}