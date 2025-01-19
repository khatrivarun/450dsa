
import java.util.HashMap;

/**
 * Problem Link:
 * https://www.geeksforgeeks.org/problems/longest-consecutive-subsequence2449/1
 * Given an array arr[] of non-negative integers. Find the length of the longest
 * sub-sequence
 * such that elements in the subsequence are consecutive integers, the
 * consecutive numbers
 * can be in any order.
 *
 * Examples:
 * Input: arr[] = [2, 6, 1, 9, 4, 5, 3]
 * Output: 6
 *
 * Input: arr[] = [1, 9, 3, 10, 4, 20, 2]
 * Output: 4
 *
 * Input: arr[] = [15, 13, 12, 14, 11, 10, 9]
 * Output: 7
 */

public class TwentyFourLongestSubsequence {

  // Actual method provided for the solution
  public int longestConsecutive(int[] arr) {
    HashMap<Integer, Integer> cache = new HashMap<>();
    int maxValue = Integer.MIN_VALUE, minValue = Integer.MAX_VALUE;

    // For this problem, we will store
    // all elements in the map for fast
    // retrieval
    //
    // While doing this, we will store the max
    // and min values of the array
    for (int i : arr) {
      cache.put(i, -1);

      minValue = Math.min(minValue, i);
      maxValue = Math.max(maxValue, i);
    }

    // Counters for tracking global and current
    // sequence lengths
    int maximumSubsequence = 0, currentSubSequence = 0;

    // We will iterate from min to max and check
    // if it exists in the cache
    //
    // if it does, increment currentSubSequence
    // else make currentSubSequence 0
    //
    // at every loop check for max maximumSubsequence
    for (int i = minValue; i <= maxValue; i++) {
      if (cache.containsKey(i)) {
        currentSubSequence += 1;
      } else {
        currentSubSequence = 0;
      }

      maximumSubsequence = Math.max(maximumSubsequence, currentSubSequence);
    }

    return maximumSubsequence;
  }

  public static void main(String[] args) {

    TwentyFourLongestSubsequence twentyFourLongestSubsequence = new TwentyFourLongestSubsequence();

    int arr1[] = { 2, 6, 1, 9, 4, 5, 3 };
    System.out.println(twentyFourLongestSubsequence.longestConsecutive(arr1));

    int arr2[] = { 1, 9, 3, 10, 4, 20, 2 };
    System.out.println(twentyFourLongestSubsequence.longestConsecutive(arr2));

    int arr3[] = { 15, 13, 12, 14, 11, 10, 9 };
    System.out.println(twentyFourLongestSubsequence.longestConsecutive(arr3));

  }

}
