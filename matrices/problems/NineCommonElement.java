/*
 * Problem Link: https://www.geeksforgeeks.org/problems/find-distinct-elements2054/1
 * Given a N x N matrix M. Write a program to find count of all the distinct elements
 * common to all rows of the matrix. Print count of such elements.
 *
 * Examples:
 * Input:
 * N = 4
 * M = 
 * {{2, 1, 4, 3},
 * {1, 2, 3, 2},
 * {3, 6, 2, 3},
 * {5, 2, 5, 3}}
 * Output: 2
 */

import java.util.HashMap;

public class NineCommonElement {

  static int distinct(int M[][], int N) {
    HashMap<Integer, Integer> cache = new HashMap<>();

    // Idea is to use a hashmap
    // to store frequencies
    //
    // Also use an intermediate
    // hashmap to keep track
    // of duplicates in a row
    for (int i = 0; i < N; i++) {
      HashMap<Integer, Integer> intermediateCache = new HashMap<>();

      for (int j = 0; j < N; j++) {

        if (!intermediateCache.containsKey(M[i][j])) {

          intermediateCache.put(M[i][j], -1);
          cache.put(M[i][j], cache.getOrDefault(M[i][j], 0) + 1);

        }

      }

    }

    // Iterate over the hashmap
    // and count frequencies
    // which match up to the number
    // of rows
    int result = 0;
    for (Integer element : cache.keySet()) {

      int frequency = cache.get(element);
      if (frequency >= N) {
        result += 1;
      }

    }

    return result;
  }

}
