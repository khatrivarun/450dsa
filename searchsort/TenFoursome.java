/*
 * Problem Link:
 * https://www.geeksforgeeks.org/problems/find-all-four-sum-numbers1732/1
 * Given an array arr[] of integers and another integer target. Find all unique
 * quadruples
 * from the given array that sums up to target.
 *
 * Note: All the quadruples should be internally sorted, ie for any quadruple
 * [q1, q2, q3, q4] it should be : q1 <= q2 <= q3 <= q4.
 *
 * Examples:
 * Input: arr[] = [0, 0, 2, 1, 1], target = 3
 * Output: [0, 0, 1, 2]
 *
 * Input: arr[] = [10, 2, 3, 4, 5, 7, 8], target = 23
 * Output: [[2, 3, 8, 10], [2, 4, 7, 10], [3, 5, 7, 8]]
 *
 * Input: arr[] = [0, 0, 2, 1, 1], target = 2
 * Output: [0, 0, 1, 1]
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class TenFoursome {

  public List<List<Integer>> fourSum(int[] arr, int target) {
    List<List<Integer>> result = new LinkedList<>();
    HashMap<String, Integer> cache = new HashMap<>();

    Arrays.sort(arr);

    // Idea is similar to other subarray sums
    // concerning duets and triplets
    //
    // the only addition is nested for loop
    // and then a while loop comparing sums
    for (int i = 0; i < arr.length; i++) {
      for (int leftPointer = i + 1; leftPointer < arr.length; leftPointer++) {
        int midPointer = leftPointer + 1;
        int rightPointer = arr.length - 1;

        while (midPointer < rightPointer) {
          int sum = arr[i] + arr[leftPointer] + arr[midPointer] + arr[rightPointer];

          if (sum == target) {
            List<Integer> foursome = new LinkedList<>();
            foursome.add(arr[i]);
            foursome.add(arr[leftPointer]);
            foursome.add(arr[midPointer]);
            foursome.add(arr[rightPointer]);

            if (!cache.containsKey(foursome.toString())) {
              result.add(foursome);
              cache.put(foursome.toString(), 1);
            }

            midPointer += 1;
            rightPointer -= 1;
          } else if (sum > target) {
            rightPointer -= 1;
          } else {
            midPointer += 1;
          }
        }
      }
    }

    return result;
  }
}
