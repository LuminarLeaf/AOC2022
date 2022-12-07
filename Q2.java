//take input from file in string array

import java.io.*;
import java.util.*;

public class Q2{
    public static void main(String args[]) {
        String [] input = new String[2500];
        File file = new File("Q2inp.txt");

        char om, mm;

        int score = 0;

        try{
            Scanner sc = new Scanner(file);
            int i = 0;
            for(i = 0; i < 2500; ){
                input[i] = sc.nextLine();
                System.out.println(i+input[i]);
                om = input[i].charAt(0);
                mm = input[i].charAt(2);
                
                if(mm == 'X'){
                    score += 1;
                    if(om == 'A'){
                        score += 3;
                    }
                    else if(om == 'B'){
                        score += 0;
                    }
                    else if(om == 'C'){
                        score += 6;
                    }
                }
                else if(mm == 'Y'){
                    score += 2;
                    if(om == 'A'){
                        score += 6;
                    }
                    else if(om == 'B'){
                        score += 3;
                    }
                    else if(om == 'C'){
                        score += 0;
                    }
                }
                else if(mm == 'Z'){
                    score += 3;
                    if(om == 'A'){
                        score += 0;
                    }
                    else if(om == 'B'){
                        score += 6;
                    }
                    else if(om == 'C'){
                        score += 3;
                    }
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