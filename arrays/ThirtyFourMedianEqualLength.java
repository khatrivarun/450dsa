/*
 * Problem Link:
 * https://www.geeksforgeeks.org/problems/median-of-2-sorted-arrays-of-same-size
 * /1
 * Given two sorted arrays a[] and b[] of equal size, find and return the median
 * of the combined array after merging them into a single sorted array.
 *
 * Examples:
 * Input: a[] = [-5, 3, 6, 12, 15], b[] = [-12, -10, -6, -3, 4]
 * Output: 0
 *
 * Input: a[] = [2, 3, 5, 7], b[] = [10, 12, 14, 16]
 * Output: 8.5
 *
 * Input: a[] = [-5], b[] = [-6]
 * Output: -5.5
 */

public class ThirtyFourMedianEqualLength {

  public double medianOf2(int a[], int b[]) {

    int length = a.length;
    int low = 0, high = a.length;

    // Sort of similar to binary search in theory
    // but the condition we are trying to sort out
    // is left1 <= right2 and left2 <= right1
    // instead of merging the 2 arrays and then
    // calculating the median
    while (low <= high) {

      int mid1 = (low + high) / 2, mid2 = length - mid1;

      int left1 = (mid1 == 0 ? Integer.MIN_VALUE : a[mid1 - 1]);
      int right1 = (mid1 == length ? Integer.MAX_VALUE : a[mid1]);

      int left2 = (mid2 == 0 ? Integer.MIN_VALUE : b[mid2 - 1]);
      int right2 = (mid2 == length ? Integer.MAX_VALUE : b[mid2]);

      if (left1 <= right2 && left2 <= right1) {
        return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
      }

      if (left1 > right2)
        high = mid1 - 1;
      if (left2 > right1)
        low = mid1 + 1;

    }

    return 0;

  }

}
