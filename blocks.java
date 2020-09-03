/*
ID: wuhanda1
LANG: JAVA
TASK: blocks
*/
import java.io.*;
import java.util.*;
public class blocks{
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("blocks.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));
      int n = Integer.parseInt(f.readLine());
      
      int[] ans = new int[26];
      String alphabet = "abcdefghijklmnopqrstuvwxyz";
      for(int line=0; line < n; line++){
          StringTokenizer st = new StringTokenizer(f.readLine());
          String word1 = st.nextToken();
          String word2 = st.nextToken();
//          for(int x=0; x<l.length(); x++){
//             if(words.charAt(x) != ' ' && words.indexOf(words.charAt(x)) == x)
//                ans[alphabet.indexOf(words.charAt(x))] += 1;
//                //System.out.println(words.charAt(x));
//          }
         for(int x=0;x<alphabet.length();x++) //char in alphabet
            ans[alphabet.indexOf(alphabet.charAt(x))] += Math.max(numTimesChar(alphabet.charAt(x), word1), numTimesChar(alphabet.charAt(x), word2));
      }
      for(int i: ans)
         out.println(i);
      out.close();
   }
   public static int numTimesChar(char c, String word){
      int count = 0;
      for(int x = 0; x<word.length(); x++)
         if(word.charAt(x) == c)
            count++;
      return count;
   }
}
