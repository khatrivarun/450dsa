package problems;

import java.util.ArrayList;
import java.util.Collections;

/*
 * Problem Link: https://www.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1
 * Given an array arr[] of positive integers, where each value represents the number of chocolates
 * in a packet. Each packet can have a variable number of chocolates. There are m students, the task
 * is to distribute chocolate packets among m students such that - 
 *
 * i. Each student gets exactly one packet.
 * ii. The difference between maximum number of chocolates given to a student and minimum number of
 *     chocolates given to a student is minimum and return that minimum possible difference.
 *
 * Examples:
 * Input: arr = [3, 4, 1, 9, 56, 7, 9, 12], m = 5
 * Output: 6
 *
 * Input: arr = [7, 3, 2, 4, 9, 12, 56], m = 3
 * Output: 2
 *
 * Input: arr = [3, 4, 1, 9, 56], m = 5
 * Output: 55
 */

public class ThirthiethChocolateDistribution {

  public int findMinDiff(ArrayList<Integer> arr, int m) {

    // First, we will apply
    // merge sort on the array
    Collections.sort(arr);

    int minimumDifference = Integer.MAX_VALUE;
    int length = arr.size();

    // Now we can implement a sliding window
    // here where the window will be the length
    // of m i.e. number of students
    //
    // since the array is now sorted
    // calculating min and max of the window
    // is easy
    //
    // we will check on each window whats the
    // minimum possible difference
    for (int i = 0; i < length; i++) {
      int windowMinimum = arr.get(i);

      if (i + (m - 1) >= length)
        break;

      int windowMaximum = arr.get(i + (m - 1));

      minimumDifference = Math.min(minimumDifference, windowMaximum - windowMinimum);
    }

    return minimumDifference;

  }

}
