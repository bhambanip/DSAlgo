import java.util.ArrayList;

/**
 * printPath
 */

/**
 * path
 */
class path {
  int[] fountPath = new int[100];
  int noNodes = 0;
}

public class printPath {
  path pt = new path();

  public void paths(TNode n, int... k) {
    int path[] = new int[1000];
    if (k.length != 0) {
      ArrayList<Integer> arr = new ArrayList<>();
      pathKRec(n, k[0], arr);
      for (int i = arr.size() - 1; i >= 0; i--)
        System.out.print(arr.get(i) + " ");
    } else {
      pathRec(n, path, 0);
    }
  }

  public boolean pathKRec(TNode n, int k, ArrayList<Integer> arr) {
    if (n == null)
      return false;
    if (n.left == null && n.right == null) {
      if (n.value == k) {
        arr.add(n.value);
        return true;
      }
      return false;
    }

    if (pathKRec(n.left, k, arr) || pathKRec(n.right, k, arr)) {
      arr.add(n.value);
      return true;
    }
    return false;
  }

  public void pathRec(TNode n, int[] path, int i) {
    if (n == null)
      return;
    path[i++] = n.value;
    if (n.left == null && n.right == null) {
      for (int k = 0; k < i; k++) {
        System.out.print(path[k] + " ");
      }
      System.out.println();
    }
    pathRec(n.left, path, i);
    pathRec(n.right, path, i);
  }

  public static void main(String[] args) {
    printPath pp = new printPath();
    BST bt = new BST();
    bt.addNode(8);
    bt.addNode(3);
    bt.addNode(10);
    bt.addNode(1);
    bt.addNode(6);
    bt.addNode(14);
    bt.addNode(4);
    bt.addNode(7);
    bt.addNode(9);
    pp.paths(bt.root, 4);
  }
}