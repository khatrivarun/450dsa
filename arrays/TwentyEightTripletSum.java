
/*
 * Problem Link: https://www.geeksforgeeks.org/problems/triplet-sum-in-array-1587115621/1
 * Given an array arr[] and an integer target, determine if there exists a triplet in the 
 * array whose sum equals the given target.
 *
 * Return true if such a triplet exists, otherwise, return false.
 *
 * Examples:
 * Input: arr[] = [1, 4, 45, 6, 10, 8], target = 13
 * Output: true
 *
 * Input: arr[] = [1, 2, 4, 3, 6, 7], target = 10
 * Output: true
 *
 * Input: arr[] = [40, 20, 10, 3, 6, 7], target = 24
 * Output: false
 */

import java.util.Arrays;

public class TwentyEightTripletSum {

  /*
   * Actual method provided for solution
   */
  public static boolean hasTripletSum(int arr[], int target) {

    // Sort the array
    Arrays.sort(arr);

    // Loop over the array
    // Calculate a new target to reach for sum by
    // subtracting required target with arr[i]
    // and try to search for pairs to satisfy
    // the new target sum
    for (int i = 0; i < arr.length - 2; i++) {

      int newTarget = target - arr[i];

      int loopBegin = i + 1;
      int loopEnd = arr.length - 1;

      while (loopBegin < loopEnd) {

        if (newTarget == (arr[loopBegin] + arr[loopEnd])) {
          return true;
        }

        else if (newTarget < arr[loopBegin] + arr[loopEnd]) {
          loopEnd -= 1;
        } else {
          loopBegin += 1;
        }

      }

    }

    return false;

  }

  public static void main(String[] args) {

    int[] arr1 = { 1, 4, 45, 6, 10, 8 };
    System.out.println(TwentyEightTripletSum.hasTripletSum(arr1, 13));

    int[] arr2 = { 40, 20, 10, 3, 6, 7 };
    System.out.println(TwentyEightTripletSum.hasTripletSum(arr2, 24));

  }

}
