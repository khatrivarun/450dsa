/*
 * Problem Link: https://www.geeksforgeeks.org/problems/median-of-2-sorted-arrays-of-different-sizes/1
 * Given two sorted arrays a[] and b[], find and return the median of the combined array after merging them into a single sorted array.
 *
 * Examples:
 * Input: a[] = [-5, 3, 6, 12, 15], b[] = [-12, -10, -6, -3, 4, 10]
 * Output: 3
 *
 * Input: a[] = [2, 3, 5, 8], b[] = [10, 12, 14, 16, 18, 20]
 * Output: 11
 *
 * Input: a[] = [], b[] = [2, 4, 5, 6]
 * Output: 4.5
 */

public class ThirtyFiveMedianDiffLength {

  public double medianOf2(int a[], int b[]) {

    int n = a.length, m = b.length;

    if (n > m)
      return medianOf2(b, a);

    int low = 0, high = n;

    // Sort of similar to binary search in theory
    // but the condition we are trying to sort out
    // is left1 <= right2 and left2 <= right1
    // instead of merging the 2 arrays and then
    // calculating the median
    while (low <= high) {

      int mid1 = (low + high) / 2;
      int mid2 = (n + m + 1) / 2 - mid1;

      int left1 = (mid1 == 0) ? Integer.MIN_VALUE : a[mid1 - 1];
      int left2 = (mid2 == 0) ? Integer.MIN_VALUE : b[mid2 - 1];

      int right1 = (mid1 == n) ? Integer.MAX_VALUE : a[mid1];
      int right2 = (mid2 == m) ? Integer.MAX_VALUE : b[mid2];

      if (left1 <= right2 && left2 <= right1) {

        if ((n + m) % 2 == 0)
          return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;

        else
          return Math.max(left1, left2);

      }

      if (left1 > right2)
        high = mid1 - 1;
      else
        low = mid1 + 1;

    }

    return 0;

  }

}
