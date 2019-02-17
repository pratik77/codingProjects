import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BracketBalancing {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        LinkedList<Character> brackets = new LinkedList();
        char[] str = s.toCharArray();
        int len = str.length;
        char currBracket;
        for(int i = 0 ; i < len ; i++){
            if(str[i] == '(' || str[i] == '[' || str[i] == '{'){
                brackets.push(str[i]);
            }
            else if(str[i] == ')'){
                if(brackets.size() == 0) return "NO";
                currBracket = brackets.peek();
                if(currBracket == '('){
                    brackets.pop();
                }
                else return "NO";
            }
            else if(str[i] == ']'){
                if(brackets.size() == 0) return "NO";
                currBracket = brackets.peek();
                if(currBracket == '['){
                    brackets.pop();
                }
                else return "NO";
            }
            else if(str[i] == '}'){
                if(brackets.size() == 0) return "NO";
                currBracket = brackets.peek();
                if(currBracket == '{'){
                    brackets.pop();
                }
                else return "NO";
            }
        }
        return "YES";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./"));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String[] results = new String[t];
        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            results[tItr] = isBalanced(s);

//            bufferedWriter.write(result);
//            bufferedWriter.newLine();
        }
        for (int tItr = 0; tItr < t; tItr++) {
        	System.out.println(results[tItr]);
        }
        
        //bufferedWriter.close();

        //scanner.close();
    }
}
