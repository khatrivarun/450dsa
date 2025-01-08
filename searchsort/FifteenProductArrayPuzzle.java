/*
 * Problem Link:
 * https://www.geeksforgeeks.org/problems/product-array-puzzle4525/1
 * Given an array, arr[] construct a product array, res[] where each element in
 * res[i] is the product of all elements in arr except arr[i]. Return this
 * resultant array, res[].
 * Note: Each element is res[] lies inside the 32-bit integer range.
 */

public class FifteenProductArrayPuzzle {

  public static int[] productExceptSelf(int arr[]) {
    int[] resultArray = new int[arr.length];

    int cumulativeProduct = 1, numZeros = 0, zeroIndex = -1;

    // Get cumulativeProduct and count zeros
    // and keep track of the zero index
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == 0) {
        numZeros += 1;
        zeroIndex = i;
      } else {
        cumulativeProduct *= arr[i];
      }
    }

    // if number of zeros is >= 2
    // all products will be 0
    if (numZeros < 2) {
      if (numZeros == 1) {

        // if only 1 zero present
        // the index where 0 is present
        // will be cumulativeProduct
        resultArray[zeroIndex] = cumulativeProduct;
      } else {

        // else normally divide arr[i] from
        // cumulativeProduct
        for (int i = 0; i < arr.length; i++) {
          resultArray[i] = cumulativeProduct / arr[i];
        }
      }
    }

    return resultArray;
  }

}
