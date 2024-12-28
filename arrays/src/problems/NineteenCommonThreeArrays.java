package problems;

/*
 * Problem Link: https://www.geeksforgeeks.org/problems/common-elements1132/1
 * You are given three arrays sorted in increasing order. Find the elements that are common in all three arrays.
 * If there are no such elements return an empty array. In this case, the output will be -1.
 *
 * Examples :
 * Input: arr1 = [1, 5, 10, 20, 40, 80] , arr2 = [6, 7, 20, 80, 100] , arr3 = [3, 4, 15, 20, 30, 70, 80, 120]
 * Output: [20, 80]
 *
 * Input: arr1 = [1, 2, 3, 4, 5] , arr2 = [6, 7] , arr3 = [8,9,10]
 * Output: [-1]
 *
 * Input: arr1 = [1, 1, 1, 2, 2, 2], B = [1, 1, 2, 2, 2], arr3 = [1, 1, 1, 1, 2, 2, 2, 2]
 * Output: [1, 2]
 *
 * Expected Time Complexity: O(n)
 * Expected Auxiliary Space: O(n)
 *
 * Constraints:
 * 1 <= arr1.size(), arr2.size(), arr3.size() <= 10^5
 * -10^5 <= arr1i , arr2i , arr3i <= 10^5
 */

import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Collections;
import java.util.HashSet;

/**
 * NineteenCommonThreeArrays
 */
public class NineteenCommonThreeArrays {

  /*
   * Actual method provided for solution
   */
  public List<Integer> commonElements(List<Integer> arr1, List<Integer> arr2,
      List<Integer> arr3) {

    /*
     * Thinking process: We can iterate over all three
     * arrays and store their frequencies in a map.
     */
    List<Integer> resultList = new LinkedList<>();
    HashMap<Integer, Integer> counters = new HashMap<>();

    for (Integer integer : new HashSet<>(arr1)) {

      counters.put(integer, counters.getOrDefault(integer, 0) + 1);

    }

    for (Integer integer : new HashSet<>(arr2)) {

      counters.put(integer, counters.getOrDefault(integer, 0) + 1);

    }

    for (Integer integer : new HashSet<>(arr3)) {

      counters.put(integer, counters.getOrDefault(integer, 0) + 1);

    }

    /*
     * Thinking process: After we have calculated all the frequencies,
     * then we can check what elements have more than 3 frequencies
     */
    counters.forEach((integer, counter) -> {
      if (counter >= 3) {
        resultList.add(integer);
      }
    });

    /*
     * Thinking Process: if no elements exist in all 3
     * arrays, return [-1]
     */
    if (resultList.size() == 0) {
      resultList.add(-1);
    } else {
      Collections.sort(resultList);
    }

    return resultList;

  }

  public static void main(String[] args) {

  }

}
