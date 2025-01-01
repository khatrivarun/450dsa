/*
 * Problem Link: https://www.geeksforgeeks.org/problems/kth-element-in-matrix/1
 * Given a N x N matrix, where every row and column is sorted in non-decreasing
 * order. Find the kth smallest element in the matrix.
 *
 * Examples:
 * Input:
 * N = 4
 * mat[][] =
 * {{16, 28, 60, 64},
 * {22, 41, 63, 91},
 * {27, 50, 87, 93},
 * {36, 78, 87, 94 }}
 * K = 3
 * Output: 27
 */

import java.util.PriorityQueue;

public class EightKthSmallest {

  public static int kthSmallest(int[][] mat, int n, int k) {
    // Can use priority queue to preserve
    // the sorted order we prefer for this
    // problem in 1D
    PriorityQueue<Integer> queue = new PriorityQueue<>();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        queue.add(mat[i][j]);
      }
    }

    int currentSmallestCounter = 0;

    // Poll queue till we reach
    // the kth smallest element.
    while (!queue.isEmpty()) {

      int currentSmallest = queue.poll();
      currentSmallestCounter += 1;

      if (currentSmallestCounter == k)
        return currentSmallest;

    }

    return -1;
  }

}
