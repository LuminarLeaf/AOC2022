import java.io.*;
import java.util.*;

class Q10 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("D:\\Programming\\AOC2022\\Q10inp.txt"));
        int cycle = 1, X = 1, sum = 0;
        Q10 q10 = new Q10();
        while(sc.hasNextLine()){
            String[] line = sc.nextLine().split(" ");
            if(line[0].equals("noop")){
                cycle++;
                sum += q10.checkCycle(cycle, X);
            } else if(line[0].equals("addx")){
                cycle++;
                sum += q10.checkCycle(cycle, X);
                cycle++;
                X += Integer.parseInt(line[1]);
                sum += q10.checkCycle(cycle, X);
            }
        }
        System.out.println(sum);
    }

    public int checkCycle(int cycle, int X){
        int arr[] = {20, 60, 100, 140, 180, 220};
        if(Arrays.binarySearch(arr, cycle) >= 0){
            return X*cycle;
        } else {
            return 0;
        }
    }

}