/**
 * PracticeTest
 */
public class PracticeTest {

  private static int castles(int arr[]) {
    if (arr.length == 0)
      return 0;
    int castles = 0;
    boolean hillBool = false, valleyBool = false;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > arr[i - 1] && !valleyBool) {
        castles++;
        valleyBool = true;
        hillBool = false;
      } else if (arr[i] < arr[i - 1] && !hillBool) {
        castles++;
        valleyBool = false;
        hillBool = true;
      }
    }
    return castles + 1;
  }

  public static void main(String[] args) {
    // int arr[] = { 2, 2, 3, 4, 3, 3, 2, 2, 1, 1, 2, 5 };
    int arr[] = { 1, 2, 1, 2 };
    System.out.println(castles(arr));
  }
}