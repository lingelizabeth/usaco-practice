/*
ID: wuhanda1
LANG: JAVA
TASK: namenum
*/
import java.io.*;
import java.util.*;
public class namenum{
   public static void main(String[] args) throws IOException{
      BufferedReader d = new BufferedReader(new FileReader("dict.txt"));
      ArrayList<String> dictionary = new ArrayList<String>();
      String nextWord = d.readLine();
      while(nextWord != null){
         dictionary.add(nextWord);
         nextWord = d.readLine();
      }
      BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
      
      String num = f.readLine();
      HashMap<String, Integer> map = new HashMap();
      String alphabet = "ABCDEFGHIJKLMNOPRSTUVWXY";
      int curr = 1;
      for(int x = 0; x<alphabet.length();x++){
         if(x%3 == 0)
            curr += 1;
         map.put(alphabet.charAt(x)+"", curr);
      }
      boolean printed = false;
      for(String s:dictionary){
         String n = "";
         for(int k=0; k<s.length(); k++)
            n += map.get(s.charAt(k)+"");
         if(n.equals(num)){
            out.println(s);
            boolean printed = true;}
      }
      if(!printed)
         out.println("NONE");
      out.close();
   }
}