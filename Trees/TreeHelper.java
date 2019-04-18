import java.util.Stack;

/**
 * TreeHelper
 */
public class TreeHelper {

  public static void pushLeft(TNode n, Stack<TNode> s) {
    while (n != null) {
      s.push(n);
      n = n.left;
    }
  }
}