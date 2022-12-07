import java.util.*;
import java.io.*;

class Q3 {
    public static void main(String[] args) {
        try {
            File file = new File("Q3inp.txt");
            Scanner sc;
            sc = new Scanner(file);
            String str;
            int i = 1, priority_sum = 0;
            char found;
            while (sc.hasNextLine()) {
                str = sc.nextLine();
                found = findInString(str);

                System.out.println(i + "\t" + found);

                // priority of a = 1 and z = 26
                // priority of A = 27 and Z = 52
                if (found >= 'A' && found <= 'Z') {
                    priority_sum += (found - 'A' + 27);
                } else if (found >= 'a' && found <= 'z') {
                    priority_sum += (found - 'a' + 1);
                }
                i++;
            }
            sc.close();
            System.out.println(priority_sum);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    static char findInString(String str) {
        char c = ' ';
        int l = str.length();

        //check if any character is present in both halves of the string
        for (int i = 0; i < l / 2; i++) {
            for (int j = l / 2; j < l; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    c = str.charAt(i);
                    break;
                }
            }
        }
        return c;
    }
}