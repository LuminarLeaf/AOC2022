import java.util.*;

public class DirNode<T> {
    T data;
    long size = 0;
    DirNode<T> parent;
    List<DirNode<T>> children;
    List<String> files = new ArrayList<String>();
    List<Long> sizes = new ArrayList<Long>();

    public DirNode(T data) {
        this.data = data;
        this.children = new ArrayList<DirNode<T>>();
    }

    public void addChild(T child) {
        DirNode<T> childNode = new DirNode<T>(child);
        childNode.parent = this;
        this.children.add(childNode);
    }

    public void addFile(String file, long size) {
        this.files.add(file);
        this.sizes.add(size);
        CalculateSize();
    }

    public Long CalculateSize() {
        long size = 0;
        for (int i = 0; i < this.files.size(); i++) {
            size += this.sizes.get(i);
        }
        for (int i = 0; i < this.children.size(); i++) {
            size += this.children.get(i).size;
        }
        this.size = size;
        if (this.parent != null)
            this.parent.CalculateSize();
        return size;
    }

    public void printTree(DirNode<T> current, int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print(" ");
        }
        System.out.println("Dir " + current.data + " " + current.size);
        for (int i = 0; i < current.children.size(); i++) {
            printTree(current.children.get(i), depth + 1);
        }
        for (int i = 0; i < current.files.size(); i++) {
            for (int j = 0; j < depth + 1; j++) {
                System.out.print(" ");
            }
            System.out.println(current.files.get(i) + " " + current.sizes.get(i));
        }
    }

    public void findSmallDirs(DirNode<T> current, List<String> smallDirs, List<Long> smallSizes) {
        if (current.size < 100000) {
            smallDirs.add((String) current.data);
            smallSizes.add(current.size);
        }
        for (int i = 0; i < current.children.size(); i++) {
            findSmallDirs(current.children.get(i), smallDirs, smallSizes);
        }
    }

    public void DeleteNode(DirNode<T> current) {
        if (current.parent != null) {
            current.files.clear();
            current.sizes.clear();
            for (int i = 0; i < current.children.size(); i++) {
                DeleteNode(current.children.get(i));
            }
            current.parent.children.remove(current);
            current.parent.CalculateSize();
            current = null;
        }
    }

    public void DeleteFile(DirNode<T> current, String file) {
        for (int i = 0; i < current.files.size(); i++) {
            if (current.files.get(i).equals(file)) {
                current.files.remove(i);
                current.sizes.remove(i);
                current.CalculateSize();
                break;
            }
        }
    }

    public void findDirs(DirNode<T> current, List<String> Dirs, List<Long> Sizes) {
        Dirs.add((String) current.data);
        Sizes.add(current.size);
        for (int i = 0; i < current.children.size(); i++) {
            findDirs(current.children.get(i), Dirs, Sizes);
        }
    }
}