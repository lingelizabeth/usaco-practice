/*
ID: wuhanda1
LANG: JAVA
TASK: nearestneighbors
*/
import java.io.*;
import java.util.*;
public class nearestneighbors{ 
   public static void main(String[] args) throws IOException{
//       BufferedReader f = new BufferedReader(new FileReader(".in"));
//       PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(".out")));
      Scanner sc = new Scanner(System.in);
      int x = sc.nextInt();
      int y = sc.nextInt();
      int z = sc.nextInt();
      int k = sc.nextInt();
      sc.nextLine();
      Obj[] knownObj = new Obj[x];
      for(int i=0;i<x;i++){
         ArrayList<Double> list = new ArrayList<Double>();
         for(int j=0; j<y;j++){
            list.add(sc.nextDouble());
            
         }
         knownObj[i] = new Obj(sc.nextInt(), list);
      }
      //basically for each query just find all its neighbors dist and the best N get the majority lol
      for(int i=0;i<z;i++){
         ArrayList<Double> list = new ArrayList<Double>();
         for(int j=0; j<y;j++)
            list.add(sc.nextDouble());         
         Obj temp = new Obj(-1, list);
         ArrayList<Integer> classes = findNearest(k, knownObj, temp);
         Map<Integer, Integer> map = new HashMap<Integer, Integer>();
         for (int n : classes) {
            Integer count = map.get(n);
            map.put(i, count != null ? count+1 : 0);
         }//makes a map that gves the number of time the key shows up in classes
         // Integer popular = Collections.max(map.entrySet(),
//             new Comparator<Map.Entry<Integer, Integer>>() {
//             @Override
//             public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
//                return o1.getValue().compareTo(o2.getValue());
//             }
//          }).getKey();
//          System.out.println(popular);
         int max = Integer.MIN_VALUE;
         for(int key: map.keySet()){
            if(map.get(key) > max)
               max = key;
         }
         System.out.println(max);
      }
   }
//    public int[] neighborsToClass(ArrayList<Integer> nearest, Obj[] knownObj){
//       int[] classes = new int[nearest.size()];
//       for(int i=0;i<nearest.size();i++){
//          classes[i] = knownObj[nearest.get(i)].cl;
//       }
//       
//    }
   public static double dist(ArrayList<Double> list1, ArrayList<Double> list2){
      double d =0;
      for(int i=0;i<list1.size();i++){
         d += Math.pow(list2.get(0) - list1.get(0), 2);
      }
      return Math.pow(d, 1/2);
   }
   public static ArrayList<Integer> findNearest(int n, Obj[] knownObj, Obj curr){ //returns a list of the indices of the n nearest
                                                                                                 //*classes?
      PriorityQueue<Distance> q = new PriorityQueue<Distance>();
      for(int i=0;i<knownObj.length;i++){
         double dist = dist(knownObj[i].list, curr.list);
         q.add(new Distance(dist, i));
      }
      //ArrayList<Integer> nearest = new ArrayList<Integer>();
      ArrayList<Integer> classes = new ArrayList<Integer>();
      for(int i=0; i<n; i++){
         //nearest.add(q.get(i));
         classes.add(knownObj[q.poll().obj].cl);
      }
      return classes;//nearest;
   }
}
class Obj{
   int cl;
   ArrayList<Double> list;
   public Obj(int c, ArrayList<Double> l){
      list = l;
      cl = c;
   }
}
class Distance implements Comparable<Distance>{
   double dist;
   int obj; //the dist and the object which the distance is to
   public Distance(double d, int o){
      dist = d;
      obj = o;
   }
   public int compareTo(Distance other){
      return (int)(other.dist - dist); //to sort in increasing order
   }
}