package trees.binarytrees;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTrees {
    private BinarySearchTrees() {

    }

    private static void preOrderr(Node root) {
        System.out.println(root.data);
        if (root.left != null) {
            preOrderr(root.left);
        }
        if (root.right != null) {
            preOrderr(root.right);
        }
    }

    private static void inOrderr(Node root) {
        if (root.left != null) {
            inOrderr(root.left);
        }
        System.out.println(root.data);
        if (root.right != null) {
            inOrderr(root.right);
        }
    }

    private static void postOrderr(Node root) {
        if (root.left != null) {
            postOrderr(root.left);
        }
        if (root.right != null) {
            postOrderr(root.right);
        }
        System.out.println(root.data);
    }

    static void preOrder(Node root) {
        System.out.println("PRE-ORDER:");
        preOrderr(root);
    }

    static void inOrder(Node root) {
        System.out.println("IN-ORDER:");
        inOrderr(root);
    }

    static void postOrder(Node root) {
        System.out.println("POST-ORDER:");
        postOrderr(root);
    }

    static Node treeSearchRecursive(Node root, int data) {
        if (root == null || data == root.data) {
            return root;
        }
        if (data < root.data) {
            return treeSearchRecursive(root.left, data);
        }
        return treeSearchRecursive(root.right, data);
    }

    static Node treeSearchIterative(Node root, int data) {
        while (root != null && root.data != data) {
            if (data < root.data) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return root;
    }

    static Node treeMinimum(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    static Node treeMaximum(Node root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    static Node treeSuccessor(Node root, int data) {
        Node node = treeSearchIterative(root, data);
        if (node == null) {
            return null;
        }
        if (node.right != null)
            return treeMinimum(node.right);
        return treeMinimum(node);
    }

    static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        Node current;
        if (data <= root.data) {
            current = insert(root.left, data);
            root.left = current;
        } else {
            current = insert(root.right, data);
            root.right = current;
        }
        return root;
    }

    static int height(Node root) {
        if (root == null) {
            return -1;
        }
        int left = 1;
        int right = 1;
        left += height(root.left);
        right += height(root.right);
        return left >= right ? left : right;
    }

    static Node delete(Node root, int data) {
        if (root == null) {
            return null;
        }
        if (data < root.data) {
            root.left = delete(root.left, data);
        } else if (data > root.data) {
            root.right = delete(root.right, data);
        } else {
            if (root.left != null && root.right != null) {
                // predecessor
                int leftMax = treeMaximum(root.left).data;
                root.data = leftMax;
                root.left = delete(root.left, leftMax);
                return root;
            } else if (root.left != null) {
                return root.left;
            } else if (root.right != null) {
                return root.right;
            } else {
                return null;
            }
        }
        return root;
    }

    static void levelOrder(Node root) {
        System.out.println("LEVEL-ORDER:");
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
            while (!queue.isEmpty()) {
                Node temp = queue.poll();
                System.out.print(temp.data + " ");
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
    }
}
