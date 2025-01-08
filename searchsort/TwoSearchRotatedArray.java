/*
 * Problem Link: https://www.geeksforgeeks.org/problems/search-in-a-rotated-array4618/1
 * Given a sorted and rotated array arr[] of distinct elements, the task is to find the index of a target key. Return -1 if the key is not found.
 *
 * Examples:
 * Input: arr[] = [5, 6, 7, 8, 9, 10, 1, 2, 3], key = 3
 * Output: 8
 *
 * Input: arr[] = [3, 5, 1, 2], key = 6
 * Output: -1
 *
 * Input: arr[] = [33, 42, 72, 99], key = 42
 * Output: 1
 */

import java.util.Arrays;

public class TwoSearchRotatedArray {

  int findPivotPoint(int[] arr) {

    int low = 0, high = arr.length - 1;

    while (low < high) {

      // if values at low
      // and high are as expected to be
      // in sorted order
      //
      // we arrived at pivot because
      // this is the sorted subarray
      // and low is start of the
      // sorted subarray
      if (arr[low] <= arr[high])
        return low;

      int mid = (low + high) / 2;

      // if values at mid is greater
      // than at high, pivot is more
      // at right side of the array
      //
      // else left side of the array
      if (arr[mid] > arr[high]) {
        low = mid + 1;
      } else {
        high = mid;
      }

    }

    return low;

  }

  int search(int[] arr, int key) {

    // Get the pivot point
    int pivot = findPivotPoint(arr);

    // Run binary search at both subarrays
    int leftIndex = Arrays.binarySearch(arr, 0, pivot + 1, key);
    int rightIndex = Arrays.binarySearch(arr, pivot, arr.length, key);

    // and return index
    // accordingly
    if (leftIndex > 0)
      return leftIndex;

    if (rightIndex > 0)
      return rightIndex;

    return -1;

  }

}
