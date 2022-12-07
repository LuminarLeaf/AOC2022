import java.util.*;
import java.io.*;

class Q7p2 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Q7inp.txt");
        Scanner sc = new Scanner(file);
        NodeQ7<String> root = new NodeQ7<String>("/");
        root.parent = null;
        NodeQ7<String> current = root;
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
        List<String> Dirs = new ArrayList<String>();
        List<Long> Sizes = new ArrayList<Long>();
        root.findDirs(root, Dirs, Sizes);
        final long DriveSize = 70000000L;
        final long RequiredFreeSpace = 30000000L;
        long currentSize = root.size;
        long currentFreeSpace = DriveSize - currentSize;
        int index = 0;
        for (int i = 0; i < Sizes.size(); i++) {
            if(currentFreeSpace + Sizes.get(i) >= RequiredFreeSpace) {
                if (Sizes.get(i) < Sizes.get(index)) {
                    index = i;
                }
            }
        }
        System.out.println("Required free space: " + currentFreeSpace);
        System.out.println("Directory to delete: " + Dirs.get(index) + " " + Sizes.get(index));
    }
}