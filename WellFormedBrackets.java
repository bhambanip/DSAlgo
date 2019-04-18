
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

  public static void main(String[] args) {
    int n = 3;
    char arr[] = new char[2 * n];
    wellFormedBrackets(arr, n, 0, 0, 0);
  }

  public static void wellFormedBrackets(char[] arr, int n, int i, int open, int close) {
    if (i == 2 * n) {
      print(arr);
      return;
    }

    if (open > close) {
      arr[i] = '}';
      wellFormedBrackets(arr, n, i + 1, open, close + 1);
    }
    if (open < n) {
      arr[i] = '{';
      wellFormedBrackets(arr, n, i + 1, open + 1, close);
    }
  }

  public static void print(char[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i]);
    }
    System.out.println();
  }

  public static String swap(String str, int x, int y) {
    char arr[] = str.toCharArray();
    char tmp = arr[x];
    arr[x] = arr[y];
    arr[y] = tmp;

    return new String(arr);
  }
}