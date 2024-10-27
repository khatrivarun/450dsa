package problems;

import java.util.Arrays;

/*
 * Problem Link: Given an array arr[] and an integer k where k is smaller than the size of the array,
 * the task is to find the kth smallest element in the given array.
 * 450 DSA Question Reference: Arrays ID: 2
 *
 * Follow up: Don't solve it using the inbuilt sort function.
 *
 * Expected Time Complexity: O(n+(max_element) )
 * Expected Auxiliary Space: O(max_element)
 *
 * Constraints:
 * 1 <= arr.size <= 10^6
 * 1<= arr[i] <= 10^6
 * 1 <= k <= n
 *
 * Input: arr[] = [7, 10, 4, 3, 20, 15], k = 3
 * Output:  7
 *
 * Input: arr[] = [2, 3, 1, 20, 15], k = 4
 * Output: 15
 */

public class ThreeKthSmallestInteger {

  /*
   * Actual method given for the problem
   */
  public static int kthSmallest(int[] arr, int k) {

    /*
     * Thinking process: The expected space gives me a hint that
     * I probably will have to create an array of length MAX_VALUE of the array.
     *
     * So we will first calculate the max value present in the array.
     */

    int max = arr[0];

    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }

    /*
     * Thinking process: Now that we have the max value of the array,
     * lets create that array and fill it with -1 because difference
     * with a max value should result in at most 0 so -1 can be an empty flag.
     */

    int[] diffs = new int[max + 1];

    Arrays.fill(diffs, -1);

    /*
     * Thinking process: So what I thought over here was,
     * lets calculate all the differences between the
     * elements of the array and the max element and
     * store the index of the element in consideration
     * in the new array with its index being the
     * difference value.
     */

    for (int j = 0; j < arr.length; j++) {

      int diff = max - arr[j];

      diffs[diff] = j;
    }

    /*
     * Thinking process: Now, in the difference array,
     * the more and more difference grows, it tends to be
     * near the end of the array.
     *
     * So to get the Kth smallest integer, we can traverse
     * the array in reverse order with a counter to check
     * if we reached the Kth smallest integer!
     *
     * The same logic can be used for Kth largest element
     * where you will traverse the array in straight order
     * rather than reverse.
     */

    int counter = 0;

    for (int i = (max - 1); i >= 0; i--) {

      if (diffs[i] != -1) {
        counter += 1;

        if (counter == k)
          return arr[diffs[i]];
      }
    }

    // Default return value
    return -1;

  }

  /*
   * Testing the solution
   */
  public static void main(String[] args) {

    int arr[] = { 7, 10, 4, 3, 20, 15 };

    System.out.println(ThreeKthSmallestInteger.kthSmallest(arr, 3));

    int arr2[] = { 2, 3, 1, 20, 15 };

    System.out.println(ThreeKthSmallestInteger.kthSmallest(arr2, 4));
  }

}
