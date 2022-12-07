import java.util.*;
import java.util.regex.*;
import java.io.*;

public class Q5p2 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Q5inp.txt");
        Scanner sc = new Scanner(file);

        String inputstack = sc.nextLine(), temp;
        int lengthinput = inputstack.length();
        int num_stack = lengthinput / 4 + 1;

        do {
            temp = sc.nextLine();
            inputstack += temp;
        } while (!temp.equals(""));

        int num_row = inputstack.length() / lengthinput - 1;

        // System.out.println(lengthinput + " " + num_stack + " " + num_row + " " +
        // inputstack.length() + "\n" + inputstack + "\n");

        List<Stack<Character>> list = new ArrayList<Stack<Character>>();

        for (int i = 0; i < num_stack; i++) {
            list.add(new Stack<Character>());
            for (int j = 0; j < num_row; j++) {
                char c = inputstack.charAt(((lengthinput * (num_row - 1 - j))) + (i == 0 ? 1 : 4 * i + 1));
                // System.out.println(i + " " + j + " " + c);
                if (c != ' ') {
                    list.get(i).push(c);
                }
            }
        }

        String input_operation = "";
        while (sc.hasNextLine()) {
            input_operation = sc.nextLine();
            // split the input_operation to extract only numbers
            int op[] = Pattern.compile("\\d+")
                    .matcher(input_operation)
                    .results()
                    .map(MatchResult::group)
                    .mapToInt(Integer::parseInt)
                    .toArray();
            // System.out.println(Arrays.toString(op));

            char c[] = new char[op[0]];
            for (int i = 0; i < op[0]; i++) {
                c[i] = list.get(op[1] - 1).pop();
            }
            for (int i = 0; i < op[0]; i++) {
                list.get(op[2] - 1).push(c[op[0] - 1 - i]);
            }
        }

        for (int i = 0; i < num_stack; i++) {
            System.out.print(list.get(i).pop());
        }
    }
}