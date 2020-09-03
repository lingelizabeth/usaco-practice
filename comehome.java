/*
ID: wuhanda1
LANG: JAVA
TASK: comehome
*/
import java.io.*;
import java.util.*;
public class comehome{ 

   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("comehome.in"));
      //Scanner sc = new Scanner(System.in);
      int n = Integer.parseInt(f.readLine());
      int[][] graph = new int[52][52];
      String num2char = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
      //for(int i=0; i<52;i++)
      //   for(int j=0;j<52;j++)
      //      if(i != j)
      //         graph[i][j] = Integer.MAX_VALUE;
      for(int i=0; i<n; i++){
         StringTokenizer st = new StringTokenizer(f.readLine());
         int a = char2num(st.nextToken().charAt(0));
         int b = char2num(st.nextToken().charAt(0));
         int d = Integer.parseInt(st.nextToken());
         if(graph[a][b] != 0 && graph[a][b] < d)
            continue;
         graph[a][b] = d;
         graph[b][a] = d;
      }
      
      int[] dist = new int[52]; //dist of each from barn
      boolean[] done = new boolean[52];
      Arrays.fill(dist, Integer.MAX_VALUE);
      dist[25] = 0; //should be Z aka barn
      
      for(int count=0; count<52-1; count++){ //didn't work when this was <v, had to be <=
         //choose the vertex with the least distance
         int u = findMin(dist, done); //method that gets the min of the ones that are not done
         done[u] = true;
         for(int i = 0;i<52; i++){
            if(!done[i] && graph[u][i] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][i] < dist[i])
               dist[i] = dist[u] + graph[u][i];
         }
      }
      int min = 0;
      for(int i=0;i<25;i++){
         if(dist[i] < dist[min])
            min = i;
      }
      System.out.println(num2char.charAt(min)+" "+dist[min]);
   }
   public static int char2num(char c){ //lol not sure
      if(Character.isUpperCase(c)){
         //System.out.println(c+" "+Character.getNumericValue(c)+" "+(Character.getNumericValue(c) - Character.getNumericValue('A')));
         return Character.getNumericValue(c) - Character.getNumericValue('A');
      }else{
         //System.out.println(c+" "+Character.getNumericValue(c)+" "+(Character.getNumericValue(c)-Character.getNumericValue('a')+26));
         return Character.getNumericValue(c)-Character.getNumericValue('a')+26;}
   }
   public static int findMin(int[] dist, boolean[] done){
      int mindex = 0;
      for(int i=0; i<dist.length; i++){
         if(!done[i] && dist[i] <= dist[mindex])
            mindex = i;
      }
      return mindex;
   }
   
}