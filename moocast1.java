/*
ID: wuhanda1
LANG: JAVA
TASK: moocast1
*/
import java.io.*;
import java.util.*;
public class moocast1{ 
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("moocast1.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moocast1.out")));
      StringTokenizer st = new StringTokenizer(f.readLine());
      int n = Integer.parseInt(st.nextToken());
      
      int[] x = new int[n];
      int[] y = new int[n];
      for(int i=0; i<n;i++){
         st = new StringTokenizer(f.readLine());
         x[i] = Integer.parseInt(st.nextToken());
         y[i] = Integer.parseInt(st.nextToken());
      }
      parent = new int[n]; //records parents of each node(cow)
      ArrayList<Edge> edges = new ArrayList<Edge>();
      for(int i=0;i<n;i++){ 
         parent[i] = i;
         for(int j=0;j<i;j++){
               int dist = (int)(Math.pow(x[i]-x[j], 2)+Math.pow(y[i]-y[j], 2));//not sqrt??
               edges.add(new Edge(i, j, dist));
         }
      }
      
      Collections.sort(edges);
      int lastWeight = 0;
      int numComponents = n;
      for(Edge curr: edges){
         if(find(curr.i) != find(curr.j)){//not in same group
            merge(curr.i, curr.j);
            lastWeight = curr.w;
            if(--numComponents == 1) //loop over N-1 vertices, then the graph must be connected
               break;
         
         }
      }
      // pw.println(lastWeight);
//       pw.close();
      System.out.println(lastWeight);

   }
   static int[] parent;
   public static int find(int curr){
      return parent[curr] == curr ? curr: (parent[curr] = find(parent[curr]));
   }
   public static void merge(int x, int y){
      parent[find(x)] = find(y);
   }
}
class Edge implements Comparable<Edge>{
   public int i, j, w;
   public Edge(int a, int b, int c){
      i = a;
      j=b;
      w=c;
   }
   public int compareTo(Edge other){
      return (w - other.w);
   }
}