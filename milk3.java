/*
ID: wuhanda1
LANG: JAVA
TASK: milk3
*/

import java.io.*;
import java.util.*;
public class milk3{
   static TreeSet<Node> visited;
   static int aMax, bMax, cMax;
   public static void main(String[] args) throws IOException {
      
      BufferedReader f = new BufferedReader(new FileReader("milk3.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));
      StringTokenizer st = new StringTokenizer(f.readLine());

      aMax = Integer.parseInt(st.nextToken());
      bMax = Integer.parseInt(st.nextToken());
      cMax = Integer.parseInt(st.nextToken());
      visited = new TreeSet<Node>();
      
      dfs(new Node(0, 0, cMax));
      //dfs(new Node(8, 0, 2));
      String ans = "";
      for(Node n: visited)
         if(n.a == 0)
            ans += n.c+" ";
      ans = ans.substring(0, ans.length() - 1);
      out.println(ans);
      out.close();
   }
   public static void dfs(Node n){
      if(!visited.contains(n)){
         visited.add(n);
         if(n.c > aMax - n.a) //pouring c to a as long as c can fill a
            dfs(new Node(aMax, n.b, n.c - aMax + n.a));
         else//pouring c to a if c will empty out
            dfs(new Node(n.a + n.c, n.b, 0));
         if(n.c > bMax - n.b) //pouring c to b
            dfs(new Node(n.a, bMax, n.c-bMax+n.b));
         else
            dfs(new Node(n.a, n.b+n.c ,0));
         if(n.a > cMax - n.c) //pouring a to c
            dfs(new Node(n.a - cMax + n.c, n.b, cMax));
         else
            dfs(new Node(0, n.b, n.c + n.a));
         if(n.a > bMax - n.b) //pouring a to b
            dfs(new Node(n.a - bMax + n.b, bMax, n.c));
         else
            dfs(new Node(0, n.a + n.b, n.c));
         if(n.b > aMax - n.a) //b to a
            dfs(new Node(aMax, n.b - aMax + n.a, n.c));
         else
            dfs(new Node(n.a + n.b, 0, n.c));
         if(n.b > cMax - n.c) //b to c
            dfs(new Node(n.a, n.b - cMax + n.c, cMax));
         else
            dfs(new Node(n.a, 0, n.b+n.c));
      }
   }
}
class Node implements Comparable<Node>{
   int a;
   int b;
   int c;
   public Node(int aIn, int bIn, int cIn){
      a = aIn;
      b = bIn;
      c = cIn;
   }
   public boolean equals(Node other){
      return (a == other.a && b == other.b && c == other.c);
   }
   public int compareTo(Node other){
      if(!equals(other) && c == other.c)
         return a - other.a;
      return c - other.c;
   }
}
