package problems;

/*
 * Problem Link: https://www.geeksforgeeks.org/problems/next-permutation5226/1
 * Given an array of integers arr[] representing a permutation, implement the next permutation that rearranges the
 * numbers into the lexicographically next greater permutation. If no such permutation exists, rearrange the numbers
 * into the lowest possible order (i.e., sorted in ascending order).
 *
 * Note - A permutation of an array of integers refers to a specific arrangement of its elements in a sequence or linear order.
 *
 * Examples:
 *
 * Input: arr = [2, 4, 1, 7, 5, 0]
 * Output: [2, 4, 5, 0, 1, 7]
 *
 * Input: arr = [3, 2, 1]
 * Output: [1, 2, 3]
 *
 * Input: arr = [3, 4, 2, 5, 1]
 * Output: [3, 4, 5, 1, 2]
 *
 * Constraints:
 * 1 ≤ arr.size() ≤ 10^5
 * 0 ≤ arr[i] ≤ 10^5
 */

import java.util.Arrays;

public class FifteenNextPermutation {

  void swap(int[] arr, int indexOne, int indexTwo) {
    int swap = arr[indexOne];
    arr[indexOne] = arr[indexTwo];
    arr[indexTwo] = swap;
  }

  void reverseArray(int arr[]) {

    for (int i = 0; i < arr.length / 2; i++) {
      swap(arr, i, arr.length - i - 1);
    }

  }

  /*
   * Actual method for the solution
   */
  void nextPermutation(int[] arr) {

    /**
     * Thinking process: To arrive at the next permutation
     * We will first iterate from the last element of the array
     * because one observation we can make is that if we iterate
     * from the last element, its sorted in an increasing order
     * until a specific point.
     *
     * We will mark that point as marker.
     */
    int marker = -1;

    for (int i = arr.length - 1; i > 0; i--) {
      if (arr[i - 1] < arr[i]) {
        marker = i - 1;
        break;
      }
    }

    /**
     * Thinking process: If the marker is still as its default
     * value (i.e. -1) we will reverse the array and return it
     * since it is at its last permutation.
     */

    if (marker == -1) {
      reverseArray(arr);
      return;
    }

    /**
     * Thinking Process: Next operation we are going to perform
     * is that find the next minimum possible value to swap our marker
     * with. This is to arrive at the next possible permutation.
     */
    int nextMinimumIndex = marker + 1;
    int nextMinimumDifference = arr[marker + 1] - arr[marker];

    for (int i = marker + 2; i < arr.length; i++) {
      if (arr[i] > arr[marker]) {
        if (arr[i] - arr[marker] < nextMinimumDifference) {
          nextMinimumIndex = i;
          nextMinimumDifference = arr[i] - arr[marker];
        }
      }
    }

    swap(arr, marker, nextMinimumIndex);

    /**
     * Thinking process: At the last, we are going to
     * sort the array after marker till the end of the array
     * to arrive at the very next permutation.
     */
    Arrays.sort(arr, marker + 1, arr.length);

  }

  public static void main(String[] args) {

    FifteenNextPermutation fifteenNextPermutation = new FifteenNextPermutation();

    int arr1[] = { 2, 4, 1, 7, 5, 0 };

    fifteenNextPermutation.nextPermutation(arr1);

    System.out.println(Arrays.toString(arr1));

    int arr2[] = { 3, 2, 1 };

    fifteenNextPermutation.nextPermutation(arr2);

    System.out.println(Arrays.toString(arr2));

    int arr3[] = { 3, 4, 2, 5, 1 };

    fifteenNextPermutation.nextPermutation(arr3);

    System.out.println(Arrays.toString(arr3));

  }

}
