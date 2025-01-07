/*
 * Problem Link:
 * https://www.geeksforgeeks.org/problems/find-missing-and-repeating2512/1
 * Given an unsorted array arr of positive integers. One number a from the set
 * [1, 2,....,n] is missing and one number b occurs twice in the array. Find
 * numbers a and b.
 * Note: The test cases are generated such that there always exists one missing
 * and one repeating number within the range [1,n].
 *
 * Examples:
 * Input: arr[] = [2, 2]
 * Output: [2, 1]
 *
 * Input: arr[] = [1, 3, 3]
 * Output: [3, 2]
 *
 * Input: arr[] = [4, 3, 6, 2, 1, 1]
 * Output: [1, 5]
 */

import java.util.ArrayList;

public class SixMissingRepeating {

  ArrayList<Integer> findTwoElement(int arr[]) {
    ArrayList<Integer> result = new ArrayList<>();
    int n = arr.length;

    // Check whats the expected sum.
    long expectedSumTillN = (n * (n + 1)) / 2;
    long actualSumTillN = 0;

    // Check whats the actual sum.
    for (long number : arr) {
      actualSumTillN += number;
    }

    // For repeated, we'll just turning every
    // arr[arr[n]] negative, so if an element
    // is repeated, it will already be negative
    // for the second time
    for (int i = 0; i < arr.length; i++) {

      int absIndex = Math.abs(arr[i]) - 1;

      if (arr[absIndex] < 0) {
        result.add(0, absIndex + 1);
        break;
      } else {
        arr[absIndex] = -arr[absIndex];
      }
    }

    // For the missing number, it will be actual sum
    // minus the repeated number which will be
    // subtracted from expected sum
    result.add(1, (int) (expectedSumTillN - (actualSumTillN - result.get(0))));

    return result;
  }

}
