/*
ID: wuhanda1
LANG: JAVA
TASK: polish notation (prefix to infix)
*/
import java.io.*;
import java.util.*;
public class polishNotation{ 
   static String operators = "*+";
   static String ints = "0123456789";
   public static void main(String[] args) throws IOException{
      Scanner sc = new Scanner(System.in);
      String input = sc.nextLine();
      input = input.replaceAll(" ", "");
      
      System.out.println(evaluate(input));
   }
   public static String evaluate(String input){
      char operator = input.charAt(0);
      String thing1 = "", thing2 = "";
      if(operators.indexOf(input.charAt(1)) != -1){
         thing1 = input.substring(1, input.length()-1);
         thing2 = ""+input.charAt(input.length() - 1);
      }else{
         thing1 = ""+input.charAt(1);
         thing2 = input.substring(2);
      }
      if(ints.indexOf(thing1) != -1 && ints.indexOf(thing2) != -1){
         if(operator == '+')
            return "("+thing1+"+"+thing2+")";
         else if(operator == '*')
            return "("+thing1+"*"+thing2+")";;
      }else if(ints.indexOf(thing1) == -1 && operator == '+'){
         return "("+evaluate(thing1)+"+"+Integer.parseInt(thing2)+")";
      }else if(ints.indexOf(thing1) == -1 && operator == '*'){
         return "("+evaluate(thing1)+"*"+Integer.parseInt(thing2)+")";
      }else if(ints.indexOf(thing2) == -1 && operator == '+'){
         return "("+Integer.parseInt(thing1)+"+"+evaluate(thing2)+")";
      }else if(ints.indexOf(thing2) == -1 && operator == '*'){
         return "("+Integer.parseInt(thing1)+"*"+evaluate(thing2)+")";
      }
      return "";
   }
}