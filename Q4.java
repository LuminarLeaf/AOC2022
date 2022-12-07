import java.util.*;
import java.io.*;

public class Q4{
    public static void main(String[] args) {
        try{
            File file = new File("C:\\Users\\Aryan\\Downloads\\input.txt");
            Scanner sc = new Scanner(file);
            int count = 0;
            int e1s, e1e, e2s, e2e;
            String line;
            while(sc.hasNextLine()){
                line = sc.nextLine();
                e1s = Integer.parseInt(line.substring(0, line.indexOf('-')));
                line = line.substring(line.indexOf('-') + 1);
                e1e = Integer.parseInt(line.substring(0, line.indexOf(',')));
                line = line.substring(line.indexOf(',') + 1);
                e2s = Integer.parseInt(line.substring(0, line.indexOf('-')));
                line = line.substring(line.indexOf('-') + 1);
                e2e = Integer.parseInt(line);
                if(e1s <= e2s && e1e >= e2e){
                    count++;
                }
                else if(e2s <= e1s && e2e >= e1e){
                    count++;
                }
            }
            System.out.println(count);
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!!");
        }
    }
}