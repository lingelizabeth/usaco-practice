/*
ID: wuhanda1
LANG: JAVA
TASK: catchcow
*/
import java.io.*;
import java.util.*;
public class catchcow{ 
   public static void main(String[] args) throws IOException{
      Scanner sc = new Scanner(System.in);
          
          
      
      int N = sc.nextInt();
      int K = sc.nextInt();
      
      boolean[] visited = new boolean[Math.max(2*K, N+1)];
      int[] dist = new int[Math.max(2*K, N+1)];
      Arrays.fill(dist, Integer.MAX_VALUE);
      dist[N] = 0;
      
      Queue q = new LinkedList();
      
      q.add(N);
      while(!q.isEmpty()){
         int X = (int)q.remove();
         //System.out.println(X+" "+dist[X]);
         if(visited[X])
            continue;
         visited[X] = true;
         if(X-1 >= 0){
            q.add(X-1);
            if(dist[X-1] == Integer.MAX_VALUE)
               dist[X-1] = dist[X]+1;
         }
         if(X+1<=K){
            q.add(X+1);
            if(dist[X+1] == Integer.MAX_VALUE)
               dist[X+1] = dist[X]+1;
            
         }
         if(X < K){ //&& 2*X <= visited.length -1){
            q.add(2*X);
            if(dist[2*X] == Integer.MAX_VALUE)
               dist[2*X] = dist[X]+1;
         }
         if(X == K)
            System.out.println(dist[K]);
            
      }
      
      
   }
}
