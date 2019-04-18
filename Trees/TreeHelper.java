import java.util.Stack;

/**
 * TreeHelper
 */
public class TreeHelper {

  public static void pushLeft(Node n, Stack<E> s) {
    while (n != null) {
      s.push(n);
      n = n.left;
    }
  }
}