import java.util.*;
import java.io.*;

class Q8 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("Q8inp.txt"));
        List<String> input = new ArrayList<String>();
        while (sc.hasNextLine())
            input.add(sc.nextLine());
        int visible_count = 2 * (input.size() + input.get(0).length()) - 4;
        Q8 obj = new Q8();
        for (int i = 1; i < input.get(0).length() - 1; i++) {
            for (int j = 1; j < input.size() - 1; j++) {
                visible_count += obj.checktree(input, i, j);
            }
        }
        System.out.println(visible_count);
    }

    public int checktree(List<String> input, int x, int y) {
        int curr_height = input.get(y).charAt(x), max_height = -1;
        // check left
        for (int i = 0; i < x; i++) {
            if (input.get(y).charAt(i) > max_height) {
                max_height = input.get(y).charAt(i);
            }
        }
        if (max_height < curr_height) {
            return 1;
        }
        max_height = -1;
        // check right
        for (int i = x + 1; i < input.get(0).length(); i++) {
            if (input.get(y).charAt(i) > max_height) {
                max_height = input.get(y).charAt(i);
            }
        }
        if (max_height < curr_height) {
            return 1;
        }
        max_height = -1;
        // check up
        for (int i = 0; i < y; i++) {
            if (input.get(i).charAt(x) > max_height) {
                max_height = input.get(i).charAt(x);
            }
        }
        if (max_height < curr_height) {
            return 1;
        }
        max_height = -1;
        // check down
        for (int i = y + 1; i < input.size(); i++) {
            if (input.get(i).charAt(x) > max_height) {
                max_height = input.get(i).charAt(x);
            }
        }
        if (max_height < curr_height) {
            return 1;
        }
        return 0;
    }
}