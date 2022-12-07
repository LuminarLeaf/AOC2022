import java.util.*;
import java.io.*;

class Q7 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Q7inp.txt");
        Scanner sc = new Scanner(file);
        DirNode<String> root = new DirNode<String>("/");
        root.parent = null;
        DirNode<String> current = root;
        while (sc.hasNextLine()) {
            String[] input = sc.nextLine().split(" ");
            if (input[0].equals("$")) {
                if (input[1].equals("cd")) {
                    if (input[2].equals("..")) {
                        current = current.parent;
                    } else if (input[2].equals("/")) {
                        current = root;
                    } else {
                        for (int i = 0; i < current.children.size(); i++) {
                            if (current.children.get(i).data.equals(input[2])) {
                                current = current.children.get(i);
                                break;
                            }
                        }
                    }
                } else if (input[1].equals("ls")) {
                    continue;
                }
            } else if (input[0].equals("dir")) {
                current.addChild(input[1]);
            } else {
                current.addFile(input[1], Long.parseLong(input[0]));
            }
        }
        sc.close();
        root.printTree(root, 0);
        List<String> smallDirs = new ArrayList<String>();
        List<Long> smallSizes = new ArrayList<Long>();
        root.findSmallDirs(root, smallDirs, smallSizes);
        System.out.println("Directories with size < 100,000:");
        for (int i = 0; i < smallDirs.size(); i++) {
            System.out.println(smallDirs.get(i) + " " + smallSizes.get(i));
        }
        Long sum = 0L;
        for (int i = 0; i < smallSizes.size(); i++) {
            sum += smallSizes.get(i);
        }
        System.out.println("Sum of sizes of directories with size < 100,000: " + sum);
    }
}