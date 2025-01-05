/*
 * Problem Link: https://www.geeksforgeeks.org/problems/count-triplets-with-sum-smaller-than-x5549/1
 * Given an array arr[] of distinct integers of size n and a value sum, the task is to find the count 
 * of triplets (i, j, k), having (i<j<k) with the sum of (arr[i] + arr[j] + arr[k]) smaller than the 
 * given value sum.
 *
 * Examples:
 * Input: n = 4, sum = 2, arr[] = {-2, 0, 1, 3}
 * Output:  2
 *
 * Input: n = 5, sum = 12, arr[] = {5, 1, 3, 4, 7}
 * Output: 4
 */

import java.util.Arrays;

public class TwelveSmallTripletSum {

  long countTriplets(int n, int sum, long arr[]) {

    Arrays.sort(arr);
    long result = 0;

    // idea is simple, same as other triplet sums
    // approach but we are only concerned with
    // less than and greater than target sums.
    for (int i = 0; i < arr.length; i++) {
      int leftPointer = i + 1, rightPointer = n - 1;

      while (leftPointer < rightPointer) {
        long currentSum = arr[i] + arr[leftPointer] + arr[rightPointer];

        if (currentSum < sum) {
          result += rightPointer - leftPointer;
          leftPointer += 1;
        } else {
          rightPointer -= 1;
        }
      }
    }

    return result;

  }

}
