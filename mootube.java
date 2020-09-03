/*
ID: wuhanda1
LANG: JAVA
TASK: mootube
*/
import java.io.*;
import java.util.*;
public class mootube{ 
   static int[] size;
   static int[] parent;
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("mootube.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));
      StringTokenizer st = new StringTokenizer(f.readLine());
      int n = Integer.parseInt(st.nextToken());
      int q = Integer.parseInt(st.nextToken());
      
      
      //build union find data structure, making each node its own component
      //adjacency matrix and parent[] ??
      //int[][] graph = new int[n+1][n+1]; //0s have nothing
      ArrayList<Edge> graph = new ArrayList<Edge>();
      parent = new int[n+1];
      size = new int[n+1]; 
      for(int i=0; i<n-1;i++){
         st = new StringTokenizer(f.readLine());
         int a = Integer.parseInt(st.nextToken());
         int b = Integer.parseInt(st.nextToken());
         int c = Integer.parseInt(st.nextToken());
         // graph[a][b] = c;
//          graph[a][b] = c;
         graph.add(new Edge(a, b, c));
      }
      for(int i=1; i<=n; i++)
         parent[i] = i;
      Arrays.fill(size, 1);
      Collections.sort(graph);
      //take in queries, remember their original indices and then sort
      Query[] queries = new Query[q];
      for(int i=0; i<q;i++){
         st = new StringTokenizer(f.readLine());
         int k = Integer.parseInt(st.nextToken());
         int v = Integer.parseInt(st.nextToken());
         queries[i] = new Query(i, v, k);
      }
      Query[] sorted = queries;
      Arrays.sort(sorted);
      //make a sorted list of the edges???
      
      int[] ans = new int[q];
      for(int i=0;i<sorted.length;i++){
         for(Edge e: graph){
            if((i==0 && e.c >= queries[i].k) || (i > 0 && e.c >= queries[i].k && e.c<queries[i-1].k))
               union( e.a, e.b);
         }
         ans[sorted[i].i] = size[find(sorted[i].v)];
         //pw.println(size[queries[i].v]);
      }
       for(int i=0; i<ans.length; i++){
          pw.println(ans[i]-1); //if aans[i] == 1 print 0 //ans -1?
       }
      pw.close();
   }
   public static void union(int u, int v){ //where u and v are the indices k of the 2 nodes to union
      int p1 = find(u);
      int p2 = find(v);
      if(p1>p2){
         parent[p1] = p2;
         size[p2] += size[p1];
      }else{
         parent[p2] = p1;
         size[p1] += size[p2];
      }
   } 
   public static int find( int v){
      if(parent[v] == v)
         return v;
      else
         return find(parent[v]);
   }
}
class Query implements Comparable<Query>{
   int i;
   int k;
   int v;
   public Query(int index, int node, int relevance){
      i = index;
      v = node;
      k = relevance;
   }
   public int compareTo(Query other){
      return (other.k - this.k); //ok this should sort it in decreasing order?
   }
}
class Edge implements Comparable<Edge>{
   int a;
   int b;
   int c;
   public Edge(int first, int second, int weight){
      a = first;
      b = second;
      c = weight;
   }
   public int compareTo(Edge other){
      return (other.c - this.c); //ok this should sort it in decreasing order?
   }
}