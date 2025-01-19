/*
 * Problem Link: https://www.geeksforgeeks.org/problems/minimum-swaps-required-to-bring-all-elements-less-than-or-equal-to-k-together4847/1
 * Given an array arr and a number k. One can apply a swap operation on the array any number of times,
 * i.e choose any two index i and j (i < j) and swap arr[i] , arr[j] . Find the minimum number of 
 * swaps required to bring all the numbers less than or equal to k together, i.e. make them a 
 * contiguous subarray.
 *
 * Examples:
 * Input: arr[] = [2, 1, 5, 6, 3], k = 3
 * Output: 1
 *
 * Input: arr[] = [2, 7, 9, 5, 8, 7, 4], k = 6
 * Output: 2
 *
 * Input: arr[] = [2, 4, 5, 3, 6, 1, 8], k = 6
 * Output: 0
 */

public class ThirtyThreeMinimumSwaps {

  int minSwap(int[] arr, int k) {

    // Couldn't figure out this one but here's the adviced approach:
    //
    // first we will keep a track of all "good" numbers which are less
    // than or equal to K.
    //
    // This will serve as the base/worst point of minimum number of swaps
    // in case that we have to swap all "good" numbers near to K.
    int good = 0;
    for (int i : arr) {
      if (i <= k)
        good += 1;
    }

    int minimumSwaps = good, bad = 0;

    // Then over here, we will create a sliding window of
    // length "good" and check for "bad" numbers which are
    // greater than K
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > k)
        bad += 1;

      // if we are at the end of the window
      // we have number of bad numbers that
      // are required to be swapped out of the
      // window
      //
      // hence minimum swaps will be dependant
      // on number of bad numbers
      if (i == good - 1)
        minimumSwaps = Math.min(minimumSwaps, bad);

      // if we are past the window
      // move the window by 1 slot and
      // check if the previous window start
      // was also a bad number because
      // we need not consider it in the new
      // window
      else if (i >= good) {
        if (arr[i - good] > k)
          bad -= 1;
        minimumSwaps = Math.min(minimumSwaps, bad);

      }
    }

    return minimumSwaps;
  }

}
