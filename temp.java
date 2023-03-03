import java.io.*;
import java.util.*;

class temp {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input.txt"));
        // list of queues
        ArrayList<Queue<Long>> Monkey_Inv = new ArrayList<Queue<Long>>();
        int[] Monkey_Test = { 23, 19, 13, 17 };
        int[] Monkey_Test_True = { 2, 2, 1, 0 };
        int[] Monkey_Test_False = { 3, 0, 3, 1 };
        long[] Monkey_insp = { 0, 0, 0, 0 };
        String op[] = { "* 19", "+ 6", "old", "+ 3" };

        int abc = 0;
        while (sc.hasNextLine()) {
            int inp[] = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            Monkey_Inv.add(new LinkedList<Long>());
            for (int j = 0; j < inp.length; j++) {
                Monkey_Inv.get(abc).add((long)inp[j]);
            }
            abc++;
        }

        Long worry;
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 4; j++) {
                while (Monkey_Inv.get(j).size() > 0) {
                    worry = Monkey_Inv.get(j).remove();
                    String[] op_split = op[j].split(" ");
                    if (op_split[0].equals("*")) {
                        worry *= Integer.parseInt(op_split[1]);
                    } else if (op_split[0].equals("+")) {
                        worry += Integer.parseInt(op_split[1]);
                    } else if (op_split[0].equals("old")) {
                        worry *= worry;
                    }
                    // worry = worry / 3;
                    worry = worry % (23 * 19 * 13 * 17);
                    if (worry % Monkey_Test[j] == 0) {
                        Monkey_Inv.get(Monkey_Test_True[j]).add(worry);
                    } else {
                        Monkey_Inv.get(Monkey_Test_False[j]).add(worry);
                    }
                    Monkey_insp[j]++;
                }
            }
        }
        // Arrays.sort(Monkey_insp);
        System.out.println(Arrays.toString(Monkey_insp));
    }
}
