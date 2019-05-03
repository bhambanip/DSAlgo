
/**
 * minAbsSlice
 */

public class minAbsSlice {
  // Prints the array
  public static void printArray(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n; ++i)
      System.out.print(arr[i] + " ");
    System.out.println();
  }

  private static int Slice(int[] arr) {
    int min = Integer.MAX_VALUE;
    int sum;
    for (int i = 0; i < arr.length; i++) {
      sum = 0;
      for (int k = i; k < arr.length; k++) {
        sum = sum + arr[k];
        min = Math.min(min, Math.abs(sum));
      }
    }
    return min;
  }

  public static void main(String[] args) {
    int[] arr = { 2, -4, 6, -3, 9 };
    System.out.println(Slice(arr));
  }
}