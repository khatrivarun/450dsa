/*
 * Problem Link: https://www.geeksforgeeks.org/problems/three-way-partitioning/1
 * Given an array and a range a, b. The task is to partition the array around 
 * the range such that the array is divided into three parts.
 *
 * 1) All elements smaller than a come first.
 * 2) All elements in range a to b come next.
 * 3) All elements greater than b appear in the end.
 *
 * The individual elements of three sets can appear in any order.
 * You are required to return the modified array.
 *
 * Example:
 * Input: arr[] = [1, 2, 3, 3, 4], a = 1, b = 2
 * Output: true
 *
 * Input: arr[] = [1, 4, 3, 6, 2, 1], a = 1, b = 3
 * Output: true
 */

public class ThirtyTwoPartition {

  public void threeWayPartition(int arr[], int a, int b) {

    int leftPointer = 0, rightPointer = arr.length - 1, currentPointer = 0;

    // Simple 2 pointer approach here for elements
    // less than A and elements greater than B
    //
    // The 2 pointers will be used to swap out
    // elements to.
    while (currentPointer <= arr.length) {
      if (arr[currentPointer] < a) {
        int swap = arr[currentPointer];
        arr[currentPointer] = arr[leftPointer];
        arr[leftPointer] = swap;

        leftPointer += 1;
        currentPointer += 1;
      }

      else if (arr[currentPointer] > b) {
        int swap = arr[currentPointer];
        arr[currentPointer] = arr[rightPointer];
        arr[rightPointer] = swap;

        rightPointer -= 1;
      }

      else {
        currentPointer += 1;
      }
    }

  }

}
