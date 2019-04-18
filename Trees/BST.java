import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * BST
 */
public class BST {
  TNode root;

  public BST() {
    this.root = null;
  }

  public void addNode(int value) {
    this.root = addNodeRec(this.root, value);
  }

  public TNode addNodeRec(TNode n, int value) {
    if (n == null) {
      return new TNode(value);
    }

    if (n.value > value) {
      n.left = addNodeRec(n.left, value);
    } else {
      n.right = addNodeRec(n.right, value);
    }
    return n;
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

  public void BFT(TNode n) {
    if (n == null) {
      return;
    }
    Queue<TNode> q = new LinkedList<TNode>();
    q.add(n);
    while (!q.isEmpty()) {
      TNode t = q.poll();
      System.out.println(t.value);
      if (t.left != null) {
        q.add(t.left);
      }
      if (t.right != null) {
        q.add(t.right);
      }
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
    bt.addNode(5);
    bt.addNode(3);
    bt.addNode(7);
    bt.addNode(2);
    bt.addNode(4);
    bt.addNode(6);
    bt.addNode(8);
    bt.addNode(1);
    // bt.inOrderTraversal(bt.root);
    // bt.printKLevel(bt.root, 2);
    // bt.inOrderTraversalStack(bt.root);
    bt.BFT(bt.root);
  }
}
