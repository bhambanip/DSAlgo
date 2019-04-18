package app;

/**
 * SortingTest1
 */
public class SortingTest1 {
  // Prints the array
  public static void printArray(char arr[]) {
    int n = arr.length;
    System.out.print("\t");
    for (int i = 0; i < n; ++i)
      System.out.print(arr[i] + " ");
    System.out.println();
  }

  // if (start >= end)
  // return;
  // partition(balls, start, end);
  // dutch_flag_sort(balls, start, ((start + (end - start)) / 2) - 1);
  // dutch_flag_sort(balls, ((start + (end - start)) / 2) + 1, end);

  // private static void partition(char[] balls, int start, int end) {
  // }

  // R G B G B

  private static void dutch_flag_sort(char[] balls) {
    if (balls.length <= 1)
      return;
    int n = balls.length;
    int lt = 0, i = 0, gt = n - 1;

    // R B G G B R
    while (i < n) {

      if (balls[i] == 'R') {
        // arr[i] -> arr[lt]; lt++
        char temp = balls[lt];
        balls[lt] = balls[i];
        balls[i] = temp;
        lt++;
        i++;
      } else if (balls[i] == 'G') {
        i++;
      } else if (balls[i] == 'B') {
        // arr[i] -> arr[gt]; gt--
        char temp = balls[gt];
        balls[gt] = balls[i];
        balls[i] = temp;
        gt--;
      }
      System.out.println();
      printArray(balls);
    }
  }

  public static void main(String[] args) {
    // char[] balls = { 'B', 'R', 'G' };
    char[] balls = { 'R', 'R', 'G', 'G', 'G', 'G', 'B', 'B' };
    printArray(balls);
    dutch_flag_sort(balls);
    System.out.println("Sorted array");
    printArray(balls);
  }
}