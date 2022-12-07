import java.util.*;
import java.io.*;

public class Q6p2 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Q6inp.txt");
        Scanner sc = new Scanner(file);
        String inp = sc.nextLine();
        Stack<Character> stack = new Stack<Character>();
        for(int i = 13; i < inp.length() - 1; i++){
            String sub = inp.substring(i-13, i+1);
            for(int j = 0; j < sub.length(); j++){
                if(!stack.contains(sub.charAt(j))){
                    stack.push(sub.charAt(j));
                }
            }
            if(stack.size() == 14){
                System.out.println(i+1);
                break;
            }
            stack.clear();
        }
        sc.close();
    }
}