
/*
 * Problem Link: https://www.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1
 *
 * Given an array arr[] with non-negative integers representing the height of blocks.
 * If the width of each block is 1, compute how much water can be trapped between
 * the blocks during the rainy season.
 *
 * Examples:
 * Input: arr[] = [3, 0, 0, 2, 0, 4]
 * Output: 10
 *
 * Input: arr[] = [7, 4, 0, 9]
 * Output: 10
 *
 * Input: arr[] = [6, 9, 9]
 * Output: 0
 */

public class TwentyNineTrappingRainWater {

  public int trappingWater(int arr[]) {
    int trappedWater = 0;

    int leftPointer = 1, rightPointer = arr.length - 2;
    int leftMaxBarrier = arr[leftPointer - 1], rightMaxBarrier = arr[rightPointer + 1];

    // Was not able to crack this one
    // Good infographic explanation here:
    // https://www.geeksforgeeks.org/trapping-rain-water/#best-approach-using-two-pointers-on-time-and-o1-space
    while (leftPointer <= rightPointer) {

      rightMaxBarrier = Math.max(rightMaxBarrier, arr[rightPointer]);

      if (leftMaxBarrier < rightMaxBarrier) {

        trappedWater += Math.max(0, leftMaxBarrier - arr[leftPointer]);

        leftMaxBarrier = Math.max(leftMaxBarrier, arr[leftPointer]);

        leftPointer += 1;

      } else {

        trappedWater += Math.max(0, rightMaxBarrier - arr[rightPointer]);

        rightMaxBarrier = Math.max(rightMaxBarrier, arr[rightPointer]);

        rightPointer -= 1;

      }

    }

    return trappedWater;
  }

}
