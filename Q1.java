import java.io.*;
import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        try {
            File input = new File("Q1inp.txt");
            FileWriter output = new FileWriter("output.txt");
            Scanner sc = new Scanner(input);
            int max_cal = 0, max_cal_elf = 0, elf_sum = 0, elf_count = 0;
            while (sc.hasNextLine()) {
                String s = sc.nextLine();
                if (s.length() != 0) {
                    elf_sum += Integer.parseInt(s);
                } else {
                    elf_count++;
                    if (elf_sum > max_cal) {
                        max_cal = elf_sum;
                        max_cal_elf = elf_count;
                    }
                    output.write(elf_sum + "\n");
                    elf_sum = 0;
                }
            }

            elf_count++;
            if (elf_sum > max_cal) {
                max_cal = elf_sum;
                max_cal_elf = elf_count;
            }
            output.write(elf_sum + "\n");
            elf_sum = 0;

            output.close();
            sc.close();

            System.out.println("\n\n" + max_cal + " " + max_cal_elf);
        } catch (FileNotFoundException e ) {
            System.out.println("File not found!!");
        } catch (IOException e){
            System.out.println("File not found!!");
        }
    }
}
