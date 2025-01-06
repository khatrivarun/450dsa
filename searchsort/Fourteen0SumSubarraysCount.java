/*
 * Problem Link: https://www.geeksforgeeks.org/problems/zero-sum-subarrays1825/1
 * You are given an array arr[] of integers. Find the total count of subarrays
 * with their sum equal to 0.
 */

import java.util.HashMap;

public class Fourteen0SumSubarraysCount {

  public int findSubarray(int[] arr) {
    int subarraysCount = 0, cumulativeSum = 0;
    HashMap<Integer, Integer> cumulativeSumHistory = new HashMap<>();
    cumulativeSumHistory.put(0, 1);

    // Idea is simple:
    // 1. Calculate cumulative sum
    // 2. Check for the current sum frequency in history
    // 3. Update the frequencies for the current sum
    for (int i = 0; i < arr.length; i++) {
      cumulativeSum += arr[i];
      subarraysCount += cumulativeSumHistory.getOrDefault(cumulativeSum, 0);
      cumulativeSumHistory.put(cumulativeSum, cumulativeSumHistory.getOrDefault(cumulativeSum, 0) + 1);
    }

    return subarraysCount;
  }

}
