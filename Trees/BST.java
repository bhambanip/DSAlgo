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

  public void delete(int value) {
    this.root = deleteRec(this.root, value);
  }

  public TNode deleteRec(TNode n, int value) {
    if (n == null) {
      return n;
    }

    if (value < n.value) {
      n.left = deleteRec(n.left, value);
    } else if (value > n.value) {
      n.right = deleteRec(n.right, value);
    } else {
      if (n.left == null) {
        return n.right;
      } else if (n.right == null) {
        return n.left;
      }
      n.value = min(n.right);
      n.right = deleteRec(n.right, n.value);
    }
    return n;
  }

  public int min(TNode n) {
    int min = n.value;
    while (n != null) {
      min = n.value;
      n = n.left;
    }
    return min;
  }

  public boolean isItBST(TNode root) {
    return isItBSTRec(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  public boolean isItBSTRec(TNode root, int min, int max) {
    if (root == null) {
      return true;
    }
    if (root.value > max || root.value < min) {
      // System.out.println(root.value + " " + max + " " + min);
      return false;
    }
    return isItBSTRec(root.left, min, root.value) && isItBSTRec(root.right, root.value, max);
  }

  public void inOrderTraversal(TNode n) {
    if (n == null) {
      return;
    }
    inOrderTraversal(n.left);
    System.out.println(n.value);
    inOrderTraversal(n.right);
  }

  // public TNode KMinRec(TNode n, int k, TNode returnValue) {
  // if (n == null) {
  // return null;
  // }

  // returnValue = KMinRec(n.left, k, returnValue);
  // if (returnValue != null || k == 1) {
  // returnValue = n;
  // return returnValue;
  // }
  // if (returnValue != null)
  // System.out.println(returnValue.value);
  // k--;
  // returnValue = KMinRec(n.right, k, returnValue);
  // return returnValue;
  // }

  public void makeBST(int[] arr) {
    this.root = makeBSTRec(arr, 0, arr.length - 1);
  }

  public TNode makeBSTRec(int[] arr, int l, int h) {
    if (l > h) {
      return null;
    }
    int mid = l + (h - l) / 2;
    TNode node = new TNode(arr[mid]);
    node.left = makeBSTRec(arr, l, mid - 1);
    node.right = makeBSTRec(arr, mid + 1, h);
    return node;
  }

  public void postOrderTraversal(TNode n) {
    if (n == null) {
      return;
    }
    postOrderTraversal(n.left);
    postOrderTraversal(n.right);
    System.out.print(n.value + " ");
  }

  public void inOrderTraversalStack(TNode n) {
    if (n == null) {
      return;
    }
    Stack<TNode> s = new Stack<TNode>();
    TreeHelper.pushLeft(n, s);
    while (!s.empty()) {
      TNode t = s.pop();
      System.out.print(t.value + " ");
      TreeHelper.pushLeft(t.right, s);
    }
  }

  public void postOrderTraversalStack(TNode n) {
    if (n == null) {
      return;
    }
    Stack<TNode> s = new Stack<TNode>();
    TreeHelper.pushLeft(n, s);
    TNode prev = null;
    while (!s.empty()) {
      TNode t = s.peek();
      if (t.right != null && t.right != prev) {
        TreeHelper.pushLeft(t.right, s);
      } else {
        t = s.pop();
        System.out.println(t.value);
      }
      prev = t;
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

  public int kMin(TNode n, int k) {
    Stack<TNode> s = new Stack<TNode>();
    TreeHelper.pushLeft(n, s);
    int numNodes = 0;
    while (!s.empty()) {
      TNode t = s.pop();
      numNodes++;
      if (numNodes == k) {
        return t.value;
      }
      TreeHelper.pushLeft(t.right, s);
    }
    return -1;
  }

  public static void main(String[] args) {
    BST bt = new BST();
    // int[] arr = { 8, 10, 12, 15 };
    // bt.makeBST(arr);
    // bt.inOrderTraversal(bt.root);
    // System.out.println(bt.root.value);
    // System.out.println(bt.root.left.value);
    // System.out.println(bt.root.right.value);
    bt.addNode(8);
    bt.addNode(3);
    bt.addNode(10);
    bt.addNode(1);
    bt.addNode(6);
    bt.addNode(14);
    bt.addNode(4);
    bt.addNode(7);
    bt.addNode(13);
    // System.out.println(bt.KMinRec(bt.root, 2, null).value);
    // tree.root = new TNode(1);
    // tree.root.left = new TNode(2);
    // tree.root.right = new TNode(3);
    // tree.root.left.left = new TNode(4);
    // tree.root.left.right = new TNode(5);
    // tree.root.right.left = new TNode(6);
    // tree.root.right.right = new TNode(7);
    // bt.postOrderTraversal(bt.root);
    // bt.postOrderTraversalStack(bt.root);
    // bt.root.left = new TNode(8);

    // bt.delete(7);
    // Practice.deleteSingleNode(bt.root, 1);
    // bt.inOrderTraversal(bt.root);
    // bt.printKLevel(bt.root, 2);
    // bt.inOrderTraversalStack(bt.root);
    // bt.BFT(bt.root);
    System.out.println(bt.isItBST(bt.root));
  }
}
