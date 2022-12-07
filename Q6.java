import java.util.*;
import java.io.*;

public class Q6 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Q6inp.txt");
        Scanner sc = new Scanner(file);
        String inp = sc.nextLine();
        Stack<Character> stack = new Stack<Character>();
        for(int i = 3; i < inp.length() - 1; i++){
            String sub = inp.substring(i-3, i+1);
            for(int j = 0; j < sub.length(); j++){
                if(!stack.contains(sub.charAt(j))){
                    stack.push(sub.charAt(j));
                }
            }
            if(stack.size() == 4){
                System.out.println(i+1);
                break;
            }
            stack.clear();
        }
        sc.close();
    }
}