/*
 * Problem Link: https://www.geeksforgeeks.org/problems/find-pair-given-difference1559/1
 * Given an array, arr[] and an integer x, return true if there exists a pair
 * of elements in the array whose absolute difference is x, otherwise, return false.
 *
 * Examples:
 * Input: arr[] = [5, 20, 3, 2, 5, 80], x = 78
 * Output: true
 *
 * Input: arr[] = [90, 70, 20, 80, 50], x = 45
 * Output: false
 *
 * Input: arr[] = [1], x = 1
 * Output: false
 */

import java.util.Arrays;

public class NinePairDiff {

  public boolean findPair(int[] arr, int x) {
    Arrays.sort(arr);
    int leftPointer = 0, rightPointer = 1, length = arr.length;

    // the conditions for updating left and right pointers
    // are flipped in case of differences and the right pointer
    // instead of being at the end, is the next element of
    // left pointer initially
    while (leftPointer < length && rightPointer < length) {

      int diff = arr[rightPointer] - arr[leftPointer];

      if (diff == x) {
        return true;
      } else if (diff > x) {
        leftPointer += 1;
      } else {
        rightPointer += 1;
      }

    }

    return false;

  }

}
