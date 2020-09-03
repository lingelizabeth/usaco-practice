/*
ID: wuhanda1
LANG: JAVA
TASK: paren
*/
import java.io.*;
import java.util.*;
public class paren{ 
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("paren.in"));
      //Scanner sc = new Scanner(System.in);
      
      long mod = 12345678910l;
      int length = Integer.parseInt(f.readLine());//sc.nextInt();//
      long[] stack = new long[length/2+1];
      //String s = "";
      int level = 0;
      for(int i =0; i<length; i++){
         int curr = Integer.parseInt(f.readLine());//sc.nextInt();//
         switch(curr){
            case 0: //(
               level++;
               break;
            case 1: //)
               if(stack[level] == 0)
                  stack[level-1]++;
               else
                  stack[level-1] += stack[level]*2;
               stack[level] = 0;    
               level -= 1; //i moved this to here from after the mod line and it worked?? okay??    
               stack[level] %= mod;
               break;
         }

      }
            

      System.out.println(stack[0]);
   }
}
//          if(curr == 0)
//             s += "(";
//          else if(curr == 1)//curr.equals("1"))
//             s += ")";
//       int score = 0;
//       int currScore = 0;
//       //Stack stack = new Stack();
//       for(int i =0; i<length; i++){
//          
//          if(s.charAt(i) == '('){
// 
//             stack.push(s.charAt(i)+"");
//          }else if(s.charAt(i) == ')'){
//             stack.pop();
//             if(stack.isEmpty()){
//                currScore += 1;
//                //System.out.println(currScore+" "+s.charAt(i));
//             }else if(stack.peek().equals(")")){
//                currScore *= 2;
//                //System.out.println(currScore+" "+s.charAt(i));
//             }
//          }
//          if(stack.isEmpty()){
//             score += currScore;
//             currScore = 0;
//          }
//       }