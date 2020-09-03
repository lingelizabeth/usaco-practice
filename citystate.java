/*
ID: wuhanda1
LANG: JAVA
TASK: citystate
*/
import java.io.*;
import java.util.*;
public class citystate{
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("citystate.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("citystate.out")));
      
      int n = Integer.parseInt(f.readLine());
      Map<String, ArrayList<Pair>> map = new HashMap<String, ArrayList<Pair>>();
      
      for(int x = 0; x<n; x++){ //put input into map
         StringTokenizer st = new StringTokenizer(f.readLine());
         String c = new String(st.nextToken()+"");
         String s = new String(st.nextToken()+"");
         Pair temp = new Pair(new String(c), new String(s));
         //System.out.println(temp.getKey()+temp);
         if(map.get(temp.getReverseKey()) == null && map.get(temp.getKey()) == null){
            map.put(temp.getKey()+"", new ArrayList<Pair>());
            map.get(temp.getKey()+"").add(new Pair(new String(c), new String(s)));
         }else if(map.get(temp.getReverseKey()) == null && map.get(temp.getKey()) != null){
            map.get(temp.getKey()).add(new Pair(new String(c), new String(s)));
         }else{
            map.get(temp.getReverseKey()).add(new Pair(new String(c), new String(s)));}
         //for(String key: map.keySet())
         //   System.out.println(key+" "+map.get(key).get(0)+" "+map.get(key).size());
      }
      int ans = 0; //number of pairs
      for(String key: map.keySet()){
         ArrayList<Pair> a = map.get(key);
         //System.out.println(key+" "+a.get(0));
         if(a.size() > 1)
            //check how many pairs are in that list
            for(int x = 0; x<a.size(); x++){
               for(int y = x+1; y<a.size(); y++){
                  if(a.get(x).formsPair(a.get(y)))
                     ans++;
               }    
            }
      }
      out.println(ans);
      out.close();
   }
}
class Pair{
   private String city;
   private String state;
   private String key;
   public Pair(String c, String s){
      city = c+"";
      state = s+"";
      key = c.substring(0, 2)+" "+s.substring(0, 2); //"MI FL"
   }
   // public boolean equalsKey(pair other){
//       if(key.equals(other.key))
//          return true;
//       reverseKey = state.substring(0, 2)+" "+city.substring(0, 2);
//       else if(reverseKey.equals(other.key))
//          return true;
//       return false;
//    }
   public String getKey(){
      return key;
   }
   public String getReverseKey(){
      return state.substring(0, 2)+" "+city.substring(0, 2);
   }
   public boolean formsPair(Pair other){ //forms special pair
      if(state.equals(other.state))
         //System.out.println(city+" "+state+" "+other.city+" "+other.state);
         return false;
      if(key.equals(other.getReverseKey()))
          return true;
      return false;
   }
   public String toString(){
      return city+" "+state+" "+key;
   }
}