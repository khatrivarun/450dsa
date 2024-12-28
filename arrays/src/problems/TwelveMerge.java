package problems;

/*
 * Problem Link: https://www.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1
 * Given two sorted arrays a[] and b[] of size n and m respectively, the task is to merge them
 * in sorted order without using any extra space. Modify a[] so that it contains the first n 
 * elements and modify b[] so that it contains the last m elements.
 *
 * Examples:
 * Input: a[] = [2, 4, 7, 10], b[] = [2, 3]
 * Output:
 * 2 2 3 4
 * 7 10
 *
 * Input: a[] = [1, 5, 9, 10, 15, 20], b[] = [2, 3, 8, 13]
 * Output:
 * 1 2 3 5 8 9
 * 10 13 15 20
 *
 * Input: a[] = [0, 1], b[] = [2, 3]
 * Output:
 * 0 1
 * 2 3
 */

import java.util.Arrays;

public class TwelveMerge {

  public void swap(int firstArray[], int secondArray[], int firstArrayCounter, int secondArrayCounter) {

    int swap = firstArray[firstArrayCounter];
    firstArray[firstArrayCounter] = secondArray[secondArrayCounter];
    secondArray[secondArrayCounter] = swap;

  }

  /*
   * Actual method provided for solution
   */
  public void mergeArrays(int a[], int b[]) {

    int firstArrayLimit = 0;
    int secondArrayLimit = b.length;

    int firstArrayCounter = a.length - 1;
    int secondArrayCounter = 0;

    // Loop over the 2 arrays, in reverse order for the first array and in straight
    // order for the second array and compare the elements and swap to make them fit
    // the narrative.
    while (firstArrayCounter >= firstArrayLimit && secondArrayCounter < secondArrayLimit) {

      if (a[firstArrayCounter] > b[secondArrayCounter]) {
        swap(a, b, firstArrayCounter, secondArrayCounter);
        firstArrayCounter -= 1;
        secondArrayCounter += 1;
      } else {
        break;
      }

    }

    // Sort the arrays again after swap so they're in proper format
    Arrays.sort(a);
    Arrays.sort(b);
  }

  public static void main(String[] args) {

    TwelveMerge twelveMerge = new TwelveMerge();

    int a1[] = { 2, 4, 7, 10 };
    int b1[] = { 2, 3 };

    twelveMerge.mergeArrays(a1, b1);
    System.out.println(Arrays.toString(a1));
    System.out.println(Arrays.toString(b1));

    int a2[] = { 1, 5, 9, 10, 15, 20 };
    int b2[] = { 2, 3, 8, 13 };

    twelveMerge.mergeArrays(a2, b2);
    System.out.println(Arrays.toString(a2));
    System.out.println(Arrays.toString(b2));

    int a3[] = { 0, 1 };
    int b3[] = { 2, 3 };

    twelveMerge.mergeArrays(a3, b3);
    System.out.println(Arrays.toString(a3));
    System.out.println(Arrays.toString(b3));

  }

}
