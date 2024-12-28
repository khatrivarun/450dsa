package problems;

/**
 * Problem Link: https://www.geeksforgeeks.org/problems/overlapping-intervals--170633/1
 * Given an array of Intervals arr[][], where arr[i] = [starti, endi]. The task is to merge all of the overlapping Intervals.
 *
 * Examples:
 * Input: arr[][] = [[1,3],[2,4],[6,8],[9,10]]
 * Output: [[1,4], [6,8], [9,10]]
 *
 * Input: arr[][] = [[6,8],[1,9],[2,4],[4,7]]
 * Output: [[1,9]]
 */

import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

public class FourteenMergeIntervals {

  /*
   * Actual method provided for the solution
   */
  public List<int[]> mergeOverlap(int[][] arr) {

    /*
     * Thinking process: Lets first sort the intervals
     * by their first intervals.
     */
    Arrays.sort(arr, (arrayOne, arrayTwo) -> arrayOne[0] - arrayTwo[0]);

    /*
     * Thinking process: We will place all our final
     * intervals in a separate array.
     */
    List<int[]> array = new LinkedList<>();

    // Reference to the first interval.
    int lowerLimitFlag = arr[0][0];
    int higherLimitFlag = arr[0][1];

    for (int i = 0; i < arr.length; i++) {

      /*
       * Thinking process: We will check if the
       * lower limit of the current interval is lesser
       * than the higher limit of the global interval.
       *
       * If it is, we will calculate the new higher limit
       * for the merge and continue till we reach the limit
       * add it to the result array.
       *
       * Else we will add the global interval to the result array
       * as it is and make the current interval as the new global
       * interval.
       */
      int lowerLimit = arr[i][0];
      int higherLimit = arr[i][1];

      if (lowerLimit <= higherLimitFlag) {
        higherLimitFlag = Math.max(higherLimitFlag, higherLimit);
      } else {

        array.add(new int[] { lowerLimitFlag, higherLimitFlag });

        lowerLimitFlag = arr[i][0];
        higherLimitFlag = arr[i][1];

      }

    }

    array.add(new int[] { lowerLimitFlag, higherLimitFlag });

    return array;

  }

  public static void main(String[] args) {
    FourteenMergeIntervals fourteenMergeIntervals = new FourteenMergeIntervals();

    int arr1[][] = { { 1, 3 }, { 2, 4 }, { 6, 8 }, { 9, 10 } };
    fourteenMergeIntervals.mergeOverlap(arr1).forEach((interval) -> System.out.println(Arrays.toString(interval)));

    int arr2[][] = { { 6, 8 }, { 1, 9 }, { 2, 4 }, { 4, 7 } };
    fourteenMergeIntervals.mergeOverlap(arr2).forEach((interval) -> System.out.println(Arrays.toString(interval)));

  }

}
