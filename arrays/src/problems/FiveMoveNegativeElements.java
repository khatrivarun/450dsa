package problems;

import java.util.Arrays;

/*
 * Problem Link: https://www.geeksforgeeks.org/problems/move-all-negative-elements-to-end1813/1
 * Given an unsorted array arr[ ] having both negative and positive integers. The task is to place all negative elements
 * at the end of the array without changing the order of positive elements and negative elements.
 * 450 DSA Question Reference: Arrays ID: 2
 *
 * Expected Time Complexity: O(n)
 * Expected Auxiliary Space: O(n)
 *
 * Constraints:
 * 1 <= arr.size() <= 10^6
 * -10^9 ≤ arr[i] ≤ 10^9
 *
 * Input: arr[] = [1, -1, 3, 2, -7, -5, 11, 6 ]
 * Output: [1, 3, 2, 11, 6, -1, -7, -5]
 *
 * Input: arr[] = [-5, 7, -3, -4, 9, 10, -1, 11]
 * Output: [7, 9, 10, 11, -5, -3, -4, -1]
 */

public class FiveMoveNegativeElements {

  /*
   * Actual method given for the problem
   */
  public void segregateElements(int[] arr) {

    int counter = 0;
    int[] segregatedArray = new int[arr.length];

    /*
     * Thinking process: Looking at space complexity
     * we can create another array and copy all
     * the non negative elements first
     */
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] >= 0) {
        segregatedArray[counter] = arr[i];
        counter += 1;
      }
    }

    /*
     * Thinking process: And then copy all the
     * negative elements into the new array.
     */
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < 0) {
        segregatedArray[counter] = arr[i];
        counter += 1;
      }
    }

    /*
     * Thinking process: Since we need return the same
     * array, overwrite the existing array with the new array.
     */
    for (int i = 0; i < arr.length; i++) {
      arr[i] = segregatedArray[i];
    }

  }

  public static void main(String[] args) {

    FiveMoveNegativeElements solution = new FiveMoveNegativeElements();

    int arr[] = { 1, -1, 3, 2, -7, -5, 11, 6 };

    solution.segregateElements(arr);
    System.out.println(Arrays.toString(arr));

    int arr2[] = { -5, 7, -3, -4, 9, 10, -1, 11 };

    solution.segregateElements(arr2);
    System.out.println(Arrays.toString(arr2));

  }

}
