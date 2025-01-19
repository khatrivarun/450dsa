
import java.util.Arrays;

/*
 * Problem Link: https://www.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1
 * Given an array arr containing only 0s, 1s, and 2s. Sort the array in ascending order.
 * 450 DSA Question Reference: Arrays ID: 3
 *
 * Expected Time Complexity: O(n)
 * Expected Auxiliary Space: O(1)
 *
 * Constraints:
 * 1 <= arr.size() <= 10^6
 * 1<= arr[i] <= 2
 *
 * Input: arr[] = [0, 1, 2, 0, 1, 2]
 * Output:  [0, 0, 1, 1, 2, 2]
 *
 * Input: arr[] = [0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1]
 * Output: [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2]
 */

public class FourSortZerosOnesTwos {

  /*
   * Helper function to swap elements in an array.
   */
  public void swap(int[] arr, int positionOne, int positionTwo) {

    int swap = arr[positionOne];
    arr[positionOne] = arr[positionTwo];
    arr[positionTwo] = swap;

  }

  /*
   * Actual method given for the problem
   */
  public void sort012(int[] arr) {

    /*
     * Thinking process: We can probably use pointers
     * to keep track of how much sorting is done by
     * swap 0s 1s and 2s ahead in the array, considering
     * each value at a time.
     */
    int zeroIndex = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == 0) {
        swap(arr, i, zeroIndex);
        zeroIndex += 1;
      }
    }

    /*
     * Thinking process: We now have a reference till where
     * 0s are sorted so lets continue with 1s.
     */
    int oneIndex = zeroIndex;

    for (int i = zeroIndex; i < arr.length; i++) {
      if (arr[i] == 1) {
        swap(arr, i, oneIndex);
        oneIndex += 1;
      }
    }

    /*
     * Thinking process: Same logic for 2s
     */
    int twoIndex = oneIndex;

    for (int i = oneIndex; i < arr.length; i++) {
      if (arr[i] == 2) {
        swap(arr, i, twoIndex);
        twoIndex += 1;
      }
    }

  }

  public static void main(String[] args) {

    FourSortZerosOnesTwos solution = new FourSortZerosOnesTwos();

    int arr[] = { 0, 1, 2, 0, 1, 2 };

    solution.sort012(arr);
    System.out.println(Arrays.toString(arr));

    int arr2[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };

    solution.sort012(arr2);
    System.out.println(Arrays.toString(arr2));

  }

}
