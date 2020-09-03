/*
ID: wuhanda1
LANG: JAVA
TASK: auto
*/
import java.io.*;
import java.util.*;
public class auto1{ 

   public static void main(String[] args) throws IOException{
      //BufferedReader f = new BufferedReader(new FileReader("auto.in"));
      Scanner sc = new Scanner(System.in);
      int w = sc.nextInt();
      int n = sc.nextInt();
      for(int i =0; i< w; i++){
         String word = sc.nextLine();
         for(int j=0; j<word.length(); j++){
            if(!dict.contains(word.substring(0, j))//check for syntax lmao
               dict.add(word.substring(0, j));
            else
               dict.put(word.substring(0, j), word);//put word at key word.substring
         }
      }
      for(int i=0; i<n; i++){
         int Ki = sc.nextInt();
         String lookup = sc.next(); //right?
         System.out.println(dict.get(lookup).get(Ki));//if it exists...
      }
      
      Map<String, String> dict = new HashMap<String, String>();
      
      
      
   }
}