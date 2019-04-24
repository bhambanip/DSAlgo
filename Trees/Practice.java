/**
 * Practice
 */
public class Practice {

  public static TNode deleteSingleNode(TNode root, int value) {
    if (root == null) {
      return root;
    }

    if (value > root.value) {
      root.right = deleteSingleNode(root.right, value);
    } else if (value < root.value) {
      root.left = deleteSingleNode(root.left, value);
    } else {
      if (root.left == null) {
        return root.right;
      } else if (root.right == null) {
        return root.left;
      }
    }
    return root;

  }
}