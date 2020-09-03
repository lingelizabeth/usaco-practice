/*
ID: wuhanda1
LANG: JAVA
TASK: lasers
*/
import java.io.*;
import java.util.*;
public class lasers{ 
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("lasers.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lasers.out")));
      StringTokenizer st = new StringTokenizer(f.readLine());
      int n = Integer.parseInt(st.nextToken());
      int laserX = Integer.parseInt(st.nextToken());
      int laserY = Integer.parseInt(st.nextToken());
      int barnX = Integer.parseInt(st.nextToken());
      int barnY = Integer.parseInt(st.nextToken());
      
      Map<Line, Integer> dist = new HashMap<Line, Integer>();
      LinkedList<Line> q = new LinkedList<Line>();
      q.add(new Line(laserY, true));
      dist.put(new Line(laserY, true), 0);
      q.add(new Line(laserX, false));
      dist.put(new Line(laserX, false), 0);
      Map<Integer, ArrayList<Integer>> xtoY = new HashMap<Integer, ArrayList<Integer>>();
      Map<Integer, ArrayList<Integer>> ytoX = new HashMap<Integer, ArrayList<Integer>>();
      for(int i=0; i<n; i++){
         st = new StringTokenizer(f.readLine());
         int x = Integer.parseInt(st.nextToken());
         int y = Integer.parseInt(st.nextToken());
         if(!xtoY.containsKey(x)){
            xtoY.put(x, new ArrayList<Integer>());
         }
         xtoY.get(x).add(y); //add the y value of this mirror to the list associated w this x
         if(!ytoX.containsKey(y)){
            xtoY.put(y, new ArrayList<Integer>());
         }
         xtoY.get(y).add(x);
      }
      int ret = -1;
      while(!q.isEmpty()){
         Line curr = q.removeFirst();
         if(curr.horizontal && curr.val == barnY){
            ret = dist.get(curr); // so dits stores the number of mirrors to get to ....that pt?
            break;
         }
         if(!curr.horizontal && curr.val == barnX){
            ret = dist.get(curr);
            break;
         }
         Map<Integer, ArrayList<Integer>> source = curr.horizontal ? ytoX:xtoY;
         if(source.containsKey(curr.val)){
            for(int dest: source.get(curr.val)){
               Line nextLine = new Line(dest, !curr.horizontal);
               if(!dist.containsKey(nextLine)){
                  dist.put(nextLine, dist.get(curr)+1);//updates next line for every y or every x
                  q.add(nextLine); //then adds to q, does xtoY and ytoX contain every x/y value or just some?
               }
            }
         }
      }
      System.out.println(ret);
   }
}
class Line{
   public int val;
   public boolean horizontal;
   public Line(int v, boolean h){
      val = v;
      horizontal = h;
   }
   @Override
   public int hashCode(){
      final int prime = 31;
      int result = 1;
      result = prime*result+(horizontal ? 1231: 1237);
      result = prime * result +val;
      return result;
   }
   @Override
   public boolean equals(Object obj){
      if(this == obj)
         return true;
      if(obj == null)
         return false;
      if(getClass() != obj.getClass())
         return false;
      Line other = (Line)obj;
      if(horizontal != other.horizontal || val != other.val)
         return false;
      return true;
   }
}