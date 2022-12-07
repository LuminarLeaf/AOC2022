import java.util.*;
import java.util.regex.*;
import java.io.*;

public class Q5 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Q5inp.txt");
        Scanner sc = new Scanner(file);
        String inputstack = sc.nextLine(), temp;
        int lengthinput = inputstack.length();
        int num_stack = lengthinput / 4 + 1;
        while (!(temp = sc.nextLine()).equals("")) {
            inputstack += temp;
        }
        int num_row = inputstack.length() / lengthinput - 1;
        List<Stack<Character>> list = new ArrayList<Stack<Character>>();
        for (int i = 0; i < num_stack; i++) {
            list.add(new Stack<Character>());
            for (int j = 0; j < num_row; j++) {
                char c = inputstack.charAt(((lengthinput * (num_row - 1 - j))) + (i == 0 ? 1 : 4 * i + 1));
                if (c != ' ') {
                    list.get(i).push(c);
                }
            }
        }
        String input_operation = "";
        while (sc.hasNextLine()) {
            input_operation = sc.nextLine();
            int op[] = Pattern.compile("\\d+")
                    .matcher(input_operation)
                    .results()
                    .map(MatchResult::group)
                    .mapToInt(Integer::parseInt)
                    .toArray();
            while (op[0]-- != 0) {
                char c = list.get(op[1] - 1).pop();
                list.get(op[2] - 1).push(c);
            }
        }
        for (int i = 0; i < num_stack; i++) {
            System.out.print(list.get(i).pop());
        }
    }
}