import java.util.*;
import java.io.*;

class Q3p2 {
    public static void main(String[] args) {
        try {
            File file = new File("Q3inp.txt");
            Scanner sc;
            sc = new Scanner(file);
            String str1, str2, str3;
            int i = 1, priority_sum = 0;
            char found;
            while (sc.hasNextLine()) {
                str1 = sc.nextLine();
                str2 = sc.nextLine();
                str3 = sc.nextLine();
                found = findInString(str1, str2, str3);

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

    static char findInString(String str1, String str2, String str3) {
        char c = ' ';
        int l1 = str1.length();
        int l2 = str2.length();
        int l3 = str3.length();

        //find character present in all three strings
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                for (int k = 0; k < l3; k++) {
                    if (str1.charAt(i) == str2.charAt(j) && str2.charAt(j) == str3.charAt(k)) {
                        c = str1.charAt(i);
                        break;
                    }
                }
            }
        }
        return c;
    }
}