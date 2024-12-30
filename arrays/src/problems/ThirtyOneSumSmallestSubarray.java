package problems;

/*
 * Problem Link: https://www.geeksforgeeks.org/problems/smallest-subarray-with-sum-greater-than-x5651/1
 * Given a number x and an array of integers arr, find the smallest subarray with sum greater than the given value
 * If such a subarray do not exist return 0 in that case.
 *
 * Input: x = 51, arr[] = [1, 4, 45, 6, 0, 19]
 * Output: 3
 *
 * Input: x = 100, arr[] = [1, 10, 5, 2, 7]
 * Output: 0
 */

public class ThirtyOneSumSmallestSubarray {

  public static int smallestSubWithSum(int x, int[] arr) {
    int leastSizeSubarray = Integer.MAX_VALUE, currentSum = 0, startPointer = 0, endPointer = 0;

    // We are looping over the array
    // while trying to find all sorts of
    // subarrays which matches the
    // description
    while (endPointer < arr.length) {

      // increase right limit till we are
      // just above the required sum
      while (endPointer < arr.length && currentSum <= x) {

        currentSum += arr[endPointer];
        endPointer += 1;

      }

      // If we completed the loop from above
      // and are not over the required sum
      // we have exhausted all subarrays
      // or subarrays matching the condition
      // does not exist.
      if (endPointer == arr.length && currentSum <= x)
        break;

      // increasing the left limit
      // till we are at the minimum possible
      // current subarray
      while (startPointer < endPointer && currentSum - arr[startPointer] > x) {
        currentSum -= arr[startPointer];
        startPointer += 1;
      }

      // save the minimum possible subarray length
      leastSizeSubarray = Math.min(leastSizeSubarray, (endPointer - startPointer));

      // update the window and proceed
      // to the next window
      currentSum -= arr[startPointer];
      startPointer += 1;

    }

    return leastSizeSubarray == Integer.MAX_VALUE ? 0 : leastSizeSubarray;
  }

  public static void main(String[] args) {

    System.out.println(ThirtyOneSumSmallestSubarray.smallestSubWithSum(51, new int[] { 1, 4, 45, 6, 0, 19 }));

  }

}
