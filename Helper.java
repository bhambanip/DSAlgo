/**
 * Helper
 */
public class Helper {
  public static <T> void print(T[] arr) {
    for (T val : arr) {
      System.out.print(val + " ");
    }
    System.out.println();
  }

  public static <T> void printToJ(T[] arr, int j) {
    for (int i = 0; i < j; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void swap(int[] arr, int no1, int no2) {
    int temp = arr[no1];
    arr[no1] = arr[no2];
    arr[no2] = temp;
  }
}