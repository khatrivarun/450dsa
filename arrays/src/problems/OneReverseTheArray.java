package problems;

import java.util.Arrays;

/*
 * Problem Link: https://www.geeksforgeeks.org/problems/reverse-an-array/1
 * 450 DSA Question Reference: Arrays ID: 0
 *
 * Problem Description:
 * You are given an array of integers arr . Your task is to reverse the given array and return the reversed array.
 *
 * Expected Time Complexity: O(n)
 * Expected Space Complexity: O(1)
 *
 * Constraints:
 * 1<=arr.size()<=10^5
 * 0<=arr[i]<=10^5
 *
 * Input: arr = [1, 2, 3, 4]
 * Output: [4, 3, 2, 1]
 *
 * Input: arr = [1]
 * Output: [1]
 */

public class OneReverseTheArray {

  /*
   * Actual function given for the problem
   */
  public void reverseArray(int arr[]) {

    /*
     * Thinking process: Swap Arr[i] and Arr[len - i]
     * till we reach the mid point of the array
     */
    for (int i = 0; i < (arr.length / 2); i++) {

      int swap = arr[i];
      arr[i] = arr[arr.length - i - 1];
      arr[arr.length - i - 1] = swap;

    }

  }

  /*
   * Testing the solution
   */
  public static void main(String[] args) {

    int arr[] = { 1, 2, 3, 4, 5 };

    OneReverseTheArray oneReverseTheArray = new OneReverseTheArray();

    oneReverseTheArray.reverseArray(arr);

    System.out.println(Arrays.toString(arr));

  }

}
