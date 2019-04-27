import java.util.*;

/**
 * Practice1
 */
public class Practice1 {

  private static int[] pit(int arr[]) {
    int min = 0;
    int[] pitCombination = new int[3];
    ArrayList<int[]> list = new ArrayList<>();
    for (int p = 0; p < arr.length - 3; p++)
      for (int q = p + 1; q < arr.length - 2; q++) {
        if (arr[p] > arr[q]) {
          for (int r = q + 1; r < arr.length - 1; r++) {
            if (arr[r] > arr[q]) {
              min = Math.min(arr[p] - arr[q], arr[r] - arr[q]);
              pitCombination=[p,q,r];
              hs.put(pitCombination, min);
            }
          }
        }
      }
  }

  public static void main(String[] args) {
    int arr[] = { 0, 1, 3, -2, 0, 1, 0, -3, 2, 3 };
    pit(arr);
  }
}