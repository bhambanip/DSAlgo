/**
 * levenshtein
 */
public class Levenshtein {
  public static void print2DArray(int arr[][]) {
    int n = arr.length;
    int m = arr[0].length;
    for (int i = 0; i < n; ++i) {
      System.out.println();
      for (int j = 0; j < m; ++j)
        System.out.print(arr[i][j] + " ");
    }
    System.out.println();
  }

  public static int levenshteinDistance(String strWord1, String strWord2) {
    int m = strWord1.length();
    int n = strWord2.length();
    int table[][] = new int[m + 1][n + 1];
    for (int i = m; i >= 0; i--) {
      for (int j = n; j >= 0; j--) {
        if (i == m)
          table[i][j] = n - j;
        else if (j == n)
          table[i][j] = m - i;
        else if (strWord1.charAt(i) == strWord2.charAt(j))
          table[i][j] = table[i + 1][j + 1];
        else
          table[i][j] = 1 + Math.min(Math.min(table[i][j + 1], table[i + 1][j]), table[i + 1][j + 1]);
      }
    }
    print2DArray(table);
    return table[0][0];
  }

  public static void main(String[] args) {
    String strWord1 = "cat";
    String strWord2 = "bat";
    System.out.println(levenshteinDistance(strWord1, strWord2));
  }
}