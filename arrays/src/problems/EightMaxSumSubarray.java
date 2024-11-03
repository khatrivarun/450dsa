package problems;

/*
 * Problem Link: https://www.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1
 * Given an integer array arr[]. You need to find and return the maximum sum possible from all the subarrays.
 *
 * Expected Time Complexity: O(n)
 * Expected Auxiliary Space: O(1)
 *
 * Constraints:
 * 1 <= arr.size() <= 10^5
 * -10^7 ≤ arr[i] ≤ 10^7
 *
 * Input: arr = [1, 2, 3, -2, 5]
 * Output: 9
 *
 * Input: arr = [-1, -2, -3, -4]
 * Output: -1
 *
 * Input: arr[] = [5, 4, 7]
 * Output: 16
 */

public class EightMaxSumSubarray {

  /*
   * Actual method given for the problem
   */
  int maxSubarraySum(int[] arr) {

    /*
     * Thinking process: Couldn't solve this one
     * myself but this problem expects to use
     * the Kadane's Algorithm.
     *
     * Calculate the current sum and check if its
     * more than global max. If it is, update global
     * max.
     *
     * If current sum is negative, start over with 0
     */
    int currentSum = 0;
    int maxSum = Integer.MIN_VALUE;

    for (int i = 0; i < arr.length; i++) {
      currentSum = currentSum + arr[i];
      maxSum = Math.max(maxSum, currentSum);

      if (currentSum < 0)
        currentSum = 0;

    }
    return maxSum;

  }

  public static void main(String[] args) {

    EightMaxSumSubarray solution = new EightMaxSumSubarray();

    int arr[] = { 1, 2, 3, -2, 5 };

    System.out.println(solution.maxSubarraySum(arr));

    int arr2[] = { -1, -2, -3, -4 };

    System.out.println(solution.maxSubarraySum(arr2));

    int arr3[] = { 5, 4, 7 };

    System.out.println(solution.maxSubarraySum(arr3));
  }

}
