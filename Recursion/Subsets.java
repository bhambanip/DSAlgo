/**
 * Subsets
 */
public class Subsets {

  public static void main(String[] args) {
    String arr = "abc";
    String curr = "";
    subsets(arr, 0, curr);
  }

  public static void subsets(String arr, int i, String curr) {
    if (i == arr.length()) {
      System.out.println(curr);
      return;
    }
    subsets(arr, i + 1, curr + arr.charAt(i));
    subsets(arr, i + 1, curr);
  }
}