
import java.util.Arrays;

/*
 * Problem Link: https://www.geeksforgeeks.org/problems/cyclically-rotate-an-array-by-one2614/1
 * Given an array arr, rotate the array by one position in clock-wise direction.
 *
 * Expected Time Complexity: O(n)
 * Expected Auxiliary Space: O(n)
 *
 * Constraints:
 * 1 <= arr.size() <= 10^5
 * 0 ≤ arr[i] ≤ 10^5
 *
 * Input: arr = [1, 2, 3, 4, 5]
 * Output: [5, 1, 2, 3, 4]
 *
 * Input: arr = [9, 8, 7, 6, 4, 2, 1, 3]
 * Output: [3, 9, 8, 7, 6, 4, 2, 1]
 */

public class SevenRotateByOne {

  /*
   * Actual method given for the problem
   */
  public void rotate(int[] arr) {

    int memory = arr[arr.length - 1];

    for (int i = 0; i < arr.length; i++) {
      int history = arr[i];
      arr[i] = memory;
      memory = history;
    }

  }

  public static void main(String[] args) {
    SevenRotateByOne solution = new SevenRotateByOne();

    int arr[] = { 1, 2, 3, 4, 5 };

    solution.rotate(arr);
    System.out.println(Arrays.toString(arr));

    int arr2[] = { 9, 8, 7, 6, 4, 2, 1, 3 };

    solution.rotate(arr2);
    System.out.println(Arrays.toString(arr2));
  }

}
