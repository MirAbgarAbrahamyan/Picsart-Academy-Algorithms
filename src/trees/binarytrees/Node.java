package trees.binarytrees;

public class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "service=" + data +
                '}';
    }
}
