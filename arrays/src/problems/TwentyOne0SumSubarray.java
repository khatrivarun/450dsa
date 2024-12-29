package problems;

import java.util.HashMap;

/*
 * Problem Link: https://www.geeksforgeeks.org/problems/subarray-with-0-sum-1587115621/1
 * Given an array of integers, arr[]. Find if there is a subarray (of size at least one) with 0 sum.
 * Return true/false depending upon whether there is a subarray present with 0-sum or not.
 *
 * Examples:
 * Input: arr[] = [4, 2, -3, 1, 6]
 * Output: true
 *
 * Input: arr = [4, 2, 0, 1, 6]
 * Output: true
 *
 * Input: arr = [1, 2, -1]
 * Output: false
 */

public class TwentyOne0SumSubarray {

  // Actual method provided for solution
  static boolean findsum(int arr[]) {

    HashMap<Integer, Integer> cumulativeSumHistory = new HashMap<>();
    cumulativeSumHistory.put(0, Integer.MIN_VALUE);

    int cumulativeSum = 0;

    // We will maintain a history of all
    // sums so we can check while looping
    for (int i = 0; i < arr.length; i++) {

      // Case 1: If the arr[i] itself is 0
      if (arr[i] == 0)
        return true;

      cumulativeSum += arr[i];

      // Case 2: if the cumulative sum turns out to be 0
      if (cumulativeSum == 0)
        return true;

      // Case 3: if the cumulative sum has been seen before
      // this indicates there is a subarray in between
      // which resulted in 0 not caught by the above 2 cases.
      if (cumulativeSumHistory.containsKey(cumulativeSum))
        return true;

      cumulativeSumHistory.put(cumulativeSum, i);

    }

    return false;
  }

  public static void main(String[] args) {
    System.out.println(TwentyOne0SumSubarray.findsum(new int[] { 4, 2, -3, 1, 6 }));
    System.out.println(TwentyOne0SumSubarray.findsum(new int[] { 4, 2, 0, 1, 6 }));
    System.out.println(TwentyOne0SumSubarray.findsum(new int[] { 1, 2, -1 }));
  }

}
