/*
ID: wuhanda1
LANG: JAVA
TASK: auto
*/
import java.io.*;
import java.util.*;
public class auto{ 

   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("auto.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("auto.out")));
      //Scanner sc = new Scanner(System.in);
      StringTokenizer st = new StringTokenizer(f.readLine());
      int w = Integer.parseInt(st.nextToken());//sc.nextInt();
      int n = Integer.parseInt(st.nextToken());//sc.nextInt();
      //sc.nextLine();
      ArrayList<Word> dict = new ArrayList<Word>();
      for(int i=0; i<w; i++){
         dict.add(new Word(f.readLine(), i+1));//sc.nextLine(), i+1));
      }
      Collections.sort(dict);
      
      String[] out = new String[n];
      for(int i=0; i<n;i++){
         st = new StringTokenizer(f.readLine());
         int K_i = Integer.parseInt(st.nextToken());//sc.nextInt();
         String pre = st.nextToken();//sc.next();
         //sc.nextLine();
         int index = findPrefix(pre, dict);
         if(!(index+K_i-1 >= dict.size()) && dict.get(index + K_i - 1).w.substring(0, pre.length()).equals(pre))
            out[i] = dict.get(index + K_i-1).i+"";
         else
            out[i] = "-1";
      }
      for(String s: out)
         pw.println(s);
         //System.out.println(s);
      pw.close();
       
   }
   public static int findPrefix(String pre, ArrayList<Word> dict){
      int low = 0;
      int high = dict.size() -1;
      while(low < high){
         int mid = (low + high)/2;
         String s = dict.get(mid).w;//.substring(0, pre.length()); //find the index of str w that prefix
         if(pre.compareTo(s) < 0)
            high = mid;
         else //if(pre.compareTo(s) > 0)
            low = mid+1;
      }
      return low;
   }
}
class Word implements Comparable<Word>{
   String w;
   int i;
   public Word(String st, int in){
      w = st;
      i = in;
   }
   public int compareTo(Word other){
      return w.compareTo(other.w);
   }
}
