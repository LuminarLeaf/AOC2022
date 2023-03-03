import java.io.*;
import java.util.*;

class Q10p2 {
    int count = 0;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("D:\\Programming\\AOC2022\\Q10inp.txt"));
        int cycle = 0, X = 1;
        Q10p2 q10 = new Q10p2();
        while(sc.hasNextLine()){
            String[] line = sc.nextLine().split(" ");
            if(line[0].equals("noop")){
                cycle++;
                q10.printpixel(cycle, X);
                // System.out.println(cycle%40 + "n\t" + X);
            } else if(line[0].equals("addx")){
                cycle++;
                q10.printpixel(cycle, X);
                // System.out.println(cycle%40 +"w\t" + X);
                cycle++;
                q10.printpixel(cycle, X);
                X += Integer.parseInt(line[1]);
                // System.out.println(cycle%40  + "a\t" + X + "\t" + Integer.parseInt(line[1]));
            }
        }
    }

    public void printpixel(int cycle, int X){
        int arr[] = {X-1, X, X+1};
        if(Arrays.binarySearch(arr, this.count) >= 0){
            System.out.print("#");
        } else {
            System.out.print(".");
        }
        if(cycle%40 == 0){
            System.out.println();
            this.count = 0;
        } else
            this.count++;
    }

}