
/*
 * Problem Link: https://www.geeksforgeeks.org/problems/maximum-product-subarray3604/1
 * Given an array arr[] that contains positive and negative integers (may contain 0 as well).
 * Find the maximum product that we can get in a subarray of arr[].
 *
 * Note: It is guaranteed that the output fits in a 32-bit integer.
 *
 * Examples:
 * Input: arr[] = [-2, 6, -3, -10, 0, 2]
 * Output: 180
 *
 * Input: arr[] = [-1, -3, -10, 0, 6]
 * Output: 30
 *
 * Input: arr[] = [2, 3, 4]
 * Output: 24
 */

public class TwentyThreeMaxProductSubarray {

  int maxProduct(int[] arr) {
    int maxProduct = arr[0], minCurrentProduct = arr[0], maxCurrentProduct = arr[0];

    // loop over the array calculating
    // max product subarrays
    for (int i = 1; i < arr.length; i++) {

      // if the current element is negative
      // the minimum current product can
      // become max (if it was negative)
      //
      // vice versa for max current product
      // so we swap them both
      if (arr[i] < 0) {
        int swap = maxCurrentProduct;
        maxCurrentProduct = minCurrentProduct;
        minCurrentProduct = swap;
      }

      // Check if max and min current product
      // can be carry forwarded from previous
      // subarray or better to start a new
      // subarray
      maxCurrentProduct = Math.max(arr[i], maxCurrentProduct * arr[i]);
      minCurrentProduct = Math.min(arr[i], minCurrentProduct * arr[i]);

      // keep track of max global product
      maxProduct = Math.max(maxProduct, maxCurrentProduct);
    }

    return maxProduct;
  }

}
