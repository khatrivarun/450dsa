
/*
 * Problem Link: https://www.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1
 * Given an integer array arr, return all the unique pairs [arr[i], arr[j]] such that i != j and arr[i] + arr[j] == 0.
 *
 * Note: The pairs must be returned in sorted order, the solution array should also be sorted,
 * and the answer must not contain any duplicate pairs.
 *
 * Examples:
 *
 * Input: arr = [-1, 0, 1, 2, -1, -4]
 * Output: [[-1, 1]]
 *
 * Input: arr = [6, 1, 8, 0, 4, -9, -1, -10, -6, -5]
 * Output: [[-6, 6],[-1, 1]]
 *
 * Expected Time Complexity: O(n log n)
 * Expected Auxiliary Space: O(n).
 *
 * Constraints:
 * 3 <= arr.size <= 10^5
 * -10^5 <= arr[i] <= 10^5
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

public class EighteenZeroSum {

  /*
   * Actual method given for the problem
   */
  public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {

    /*
     * Thinking process: What we can do here is store all elements
     * in a HashMap cache so checking for existing pairs is greatly
     * reduced.
     */
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    HashMap<Integer, Integer> cache = new HashMap<>();

    /*
     * Thinking process: Sorting the array will help us fetch
     * the overall result array to be sorted
     */
    Arrays.sort(arr);

    for (int i = 0; i < arr.length; i++) {

      /*
       * Thinking process: Calculate what element do we require here.
       */
      int required = 0 - arr[i];

      /*
       * Thinking Process: Check for existence of the polar opposite.
       */
      int findRequiredIndex = Arrays.binarySearch(arr, required);

      /*
       * Thinking process: If the opposite exists and if its
       * not the same element (in case of a 0), check if
       * the pairing exists in cache.
       *
       * If not, add it in the cache and result array.
       */
      if (findRequiredIndex >= 0 && findRequiredIndex != i) {
        int minimum = Math.min(required, arr[i]);
        int maximum = Math.max(required, arr[i]);

        if (!cache.containsKey(minimum)) {
          cache.put(minimum, maximum);

          ArrayList<Integer> integers = new ArrayList<>();
          integers.add(minimum);
          integers.add(maximum);

          result.add(integers);
        }
      }
    }

    return result;

  }

  public static void main(String[] args) {
    System.out.println(EighteenZeroSum.getPairs(new int[] { -1, 0, 1, 2, -1, -4 }));
    System.out.println(EighteenZeroSum.getPairs(new int[] { 6, 1, 8, 0, 4, -9, -1, -10, -6, -5 }));
  }

}
