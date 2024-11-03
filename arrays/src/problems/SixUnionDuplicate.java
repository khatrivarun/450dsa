package problems;

import java.util.HashMap;

/*
 * Problem Link: https://www.geeksforgeeks.org/problems/union-of-two-arrays3538/1
 * Given two arrays a[] and b[], the task is to find the number of elements in the union between these two arrays.
 * The Union of the two arrays can be defined as the set containing distinct elements from both arrays.
 * If there are repetitions, then only one element occurrence should be there in the union.
 *
 * Expected Time Complexity: O(n + m)
 * Expected Auxiliary Space: O(n + m)
 *
 * Constraints:
 * 1 <= a.size(), b.size() <= 10^6
 * 0 ≤ a[i], b[i] ≤ 10^5
 *
 * Input: a[] = [1, 2, 3, 4, 5], b[] = [1, 2, 3]
 * Output: 5
 *
 * Input: a[] = [85, 25, 1, 32, 54, 6], b[] = [85, 2]
 * Output: 7
 */

public class SixUnionDuplicate {

  /*
   * Actual method given for the problem
   */
  public static int findUnion(int a[], int b[]) {

    /*
     * Thinking process: We can iterate the first array
     * and build a HashMap according to it so we can
     * check for existence of element quickly and increment
     * count on new HashMap insertion.
     */
    int unionCount = 0;
    HashMap<Integer, Integer> cache = new HashMap<>();

    for (int i : a) {
      if (!cache.containsKey(i)) {
        cache.put(i, i);

        unionCount += 1;
      }
    }

    /*
     * Thinking process: Same logic with the second array.
     */
    for (int i : b) {
      if (!cache.containsKey(i)) {
        cache.put(i, i);

        unionCount += 1;
      }
    }

    return unionCount;

  }

  public static void main(String[] args) {

    System.out.println(SixUnionDuplicate.findUnion(new int[] { 1, 2, 3, 4, 5 }, new int[] { 1, 2, 3 }));
    System.out.println(SixUnionDuplicate.findUnion(new int[] { 85, 25, 1, 32, 54, 6 }, new int[] { 85, 2 }));
    System.out.println(SixUnionDuplicate.findUnion(new int[] { 1, 2, 1, 1, 2 }, new int[] { 2, 2, 1, 2, 1 }));
  }

}
