import java.io.*;
import java.util.*;

public class Q8p2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("Q8inp.txt"));
        List<String> input = new ArrayList<String>();
        while (sc.hasNextLine())
            input.add(sc.nextLine());
        int max_ScenicScore = 0, curr_ScenicScore;
        for (int i = 1; i < input.size() - 1; i++) {
            for (int j = 1; j < input.get(0).length() - 1; j++) {
                curr_ScenicScore = 1;
                //check up
                boolean flag = false;
                for(int k = i-1; k >= 0; k--) {
                    if(input.get(k).charAt(j) >= input.get(i).charAt(j)) {
                        curr_ScenicScore *= (i-k);
                        flag = true;
                        break;
                    }
                }
                if(!flag) {
                    curr_ScenicScore *= i;
                }
                //check down
                flag = false;
                for(int k = i+1; k < input.size(); k++) {
                    if(input.get(k).charAt(j) >= input.get(i).charAt(j)) {
                        curr_ScenicScore *= (k-i);
                        flag = true;
                        break;
                    }
                }
                if(!flag) {
                    curr_ScenicScore *= (input.size()-i-1);
                }
                //check left
                flag = false;
                for(int k = j-1; k >= 0; k--) {
                    if(input.get(i).charAt(k) >= input.get(i).charAt(j)) {
                        curr_ScenicScore *= (j-k);
                        flag = true;
                        break;
                    }
                }
                if(!flag) {
                    curr_ScenicScore *= j;
                }
                //check right
                flag = false;
                for(int k = j+1; k < input.get(0).length(); k++) {
                    if(input.get(i).charAt(k) >= input.get(i).charAt(j)) {
                        curr_ScenicScore *= (k-j);
                        flag = true;
                        break;
                    }
                }
                if(!flag) {
                    curr_ScenicScore *= (input.get(0).length()-j-1);
                }
                if(curr_ScenicScore > max_ScenicScore) {
                    max_ScenicScore = curr_ScenicScore;
                }
            }
        }
        System.out.println(max_ScenicScore);
    }
}