import java.util.Stack;

/**
 * Tree
 */
public class Tree {
  TNode root;

  public Tree() {
    this.root = null;
  }

  public void inOrderTraversal(TNode n) {
    if (n == null) {
      return;
    }
    inOrderTraversal(n.left);
    System.out.println(n.value);
    inOrderTraversal(n.right);
  }

  public void inOrderTraversalStack(TNode n) {
    if (n == null) {
      return;
    }
    Stack<TNode> s = new Stack<TNode>();
    TreeHelper.pushLeft(n, s);
    while (!s.empty()) {
      TNode t = s.pop();
      System.out.println(t.value);
      TreeHelper.pushLeft(t.right, s);
    }
  }

  public void printKLevel(TNode root, int k) {
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
    bt.root = new TNode(1);
    bt.root.left = new TNode(2);
    bt.root.right = new TNode(3);
    bt.root.left.left = new TNode(4);
    bt.root.left.right = new TNode(5);
    // bt.inOrderTraversal(bt.root);
    // bt.printKLevel(bt.root, 2);
    bt.inOrderTraversalStack(bt.root);
  }

}