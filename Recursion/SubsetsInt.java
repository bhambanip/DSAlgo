/**
 * SubsetsInt
 */
public class SubsetsInt {

  public static void main(String[] args) {
    Integer[] arr = { 1, 2, 3 };
    Integer[] curr = new Integer[3];
    subsets(arr, 0, curr, 0);
  }

  public static void subsets(Integer[] arr, int i, Integer[] curr, int j) {
    if (i == arr.length) {
      Helper.printToJ(curr, j);
      return;
    }
    subsets(arr, i + 1, curr, j);
    curr[j] = arr[i];
    subsets(arr, i + 1, curr, j + 1);
  }
}