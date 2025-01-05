/*
 * Problem Link: https://www.geeksforgeeks.org/problems/first-and-last-occurrences-of-x3116/1
 * Given a sorted array arr with possibly some duplicates, the task is to find the first
 * and last occurrences of an element x in the given array.
 *
 * Note: If the number x is not found in the array then return both the indices as -1.
 */

import java.util.ArrayList;

public class ZeroFirstLast {

  ArrayList<Integer> find(int arr[], int x) {
    ArrayList<Integer> result = new ArrayList<>();
    result.add(-1);
    result.add(-1);

    int leftPointer = 0, rightPointer = arr.length - 1;

    // Since the array is sorted,
    // we can search from start and end
    // at once to arrive at the first occuring
    // instances from start and end
    while (leftPointer <= rightPointer) {

      if (arr[leftPointer] == x && arr[rightPointer] == x) {
        result.add(0, leftPointer);
        result.add(1, rightPointer);

        break;
      }

      if (arr[leftPointer] < x) {
        leftPointer += 1;
      }

      if (arr[rightPointer] > x) {
        rightPointer -= 1;
      }

    }

    return result;

  }

}
