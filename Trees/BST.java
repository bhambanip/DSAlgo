import java.util.Stack;

/**
 * BST
 */
public class BST {
  Node root;

  public BST() {
    this.root = null;
  }

  public void inOrderTraversal(Node n) {
    if (n == null) {
      return;
    }
    inOrderTraversal(n.left);
    System.out.println(n.value);
    inOrderTraversal(n.right);
  }


  public void inOrderTraversalStack(Node n) {
    if (n == null) {
      return;
    }
    Stack<Node> s = new Stack<Node>();
    System.out.println(n.value);
    inOrderTraversal(n.right);
  }

  public void printKLevel(Node root, int k) {
    if (root == null)
      return;
    if (k == 1) {
      System.out.println(root.value);
      return;
    }
    printKLevel(root.left, k - 1);
    printKLevel(root.right, k - 1);
  }

  public static void main(String[] args) {
    BST bt = new BST();
    bt.root = new Node(1);
    bt.root.left = new Node(2);
    bt.root.right = new Node(3);
    bt.root.left.left = new Node(4);
    bt.root.left.right = new Node(5);
    // bt.inOrderTraversal(bt.root);
    bt.printKLevel(bt.root, 2);
  }
}