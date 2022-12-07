//take input from file in string array

import java.io.*;
import java.util.*;

public class Q2p2{
    public static void main(String args[]) {
        String [] input = new String[2500];
        File file = new File("Q2inp.txt");

        char op_move, dout;

        //op_move A = rock, B = paper, C = scissors
        //desired_outcome X = lose, Y = draw, Z = win

        //my move rock = 1, paper = 2, scissors = 3

        int score = 0;

        try{
            Scanner sc = new Scanner(file);
            int i = 0;
            for(i = 0; i < 2500; ){
                input[i] = sc.nextLine();
                System.out.println(i+input[i]);
                op_move = input[i].charAt(0);
                dout = input[i].charAt(2);
                
                if(op_move == 'A'){ //rock
                    score += (dout == 'Z') ? 6+2 : ((dout == 'Y') ? 3+1 : ((dout == 'X') ? 0+3 : 0));
                    // score += (dout == 'Y') ? 3+1 : 0;
                    // score += (dout == 'X') ? 0+3 : 0;
                }else if(op_move == 'B'){ //paper
                    score += (dout == 'Z') ? 6+3 : ((dout == 'Y') ? 3+2 : ((dout == 'X') ? 0+1 : 0));
                    // score += (dout == 'Y') ? 3+2 : 0;
                    // score += (dout == 'X') ? 0+1 : 0;
                }else if(op_move == 'C'){ //scissors
                    score += (dout == 'Z') ? 6+1 : ((dout == 'Y') ? 3+3 : ((dout == 'X') ? 0+2 : 0));
                    // score += (dout == 'Y') ? 3+3 : 0;
                    // score += (dout == 'X') ? 0+2 : 0;
                }
                i++;
            }

            System.out.println("Score: " + score);
            
            sc.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }
    }
}