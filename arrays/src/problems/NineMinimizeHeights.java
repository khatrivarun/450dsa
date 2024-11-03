package problems;

import java.util.Arrays;

/*
 * Problem Link: https://www.geeksforgeeks.org/problems/minimize-the-heights3351/1
 * Given an array arr[] denoting heights of N towers and a positive integer K.
 *
 * For each tower, you must perform exactly one of the following operations exactly once.
 * - Increase the height of the tower by K
 * - Decrease the height of the tower by K
 * Find out the minimum possible difference between the height of the shortest and tallest
 * towers after you have modified each tower.
 *
 * Note: It is compulsory to increase or decrease the height by K for each tower.
 * After the operation, the resultant array should not contain any negative integers.
 *
 * Expected Time Complexity: O(nlogn)
 * Expected Auxiliary Space: O(n)
 *
 * Constraints:
 * 1 ≤ k ≤ 10^7
 * 1 ≤ n ≤ 10^5
 * 1 ≤ arr[i] ≤ 10^7
 *
 * Input: k = 2, arr[] = {1, 5, 8, 10}
 * Output: 5
 *
 * Input: k = 3, arr[] = {3, 9, 12, 16, 20}
 * Output: 11
 */

public class NineMinimizeHeights {

  /*
   * Actual method given for the problem
   */
  public int getMinDiff(int k, int[] arr) {

    /*
     * Thinking process: Couldn't solve this one
     * myself but this is a greedy algorithm question
     * where each tower has its height increased/
     * decreased at every iteration to check if
     * it produces the minimum difference.
     */

    int length = arr.length;

    /*
     * Thinking process: Sorting will help us to get
     * an additional idea about initial difference
     * and help with handling small and large values.
     */
    Arrays.sort(arr);

    int minDiff = arr[arr.length - 1] - arr[0];

    for (int i = 1; i < arr.length; i++) {

      /*
       * Thinking process: arr[i-1] had its height removed
       * in a previous iteration and in the present
       * iteration has its height increased.
       */
      int maxHeight = Math.max(arr[i - 1] + k, arr[length - 1] - k);

      /*
       * Thinking process: arr[i] will have its
       * height removed in the next iteration
       * and in the present iteration willl have
       * its height decreased.
       */
      int minHeight = Math.min(arr[0] + k, arr[i] - k);

      minDiff = Math.min(minDiff, maxHeight - minHeight);
    }

    return minDiff;

  }

}
