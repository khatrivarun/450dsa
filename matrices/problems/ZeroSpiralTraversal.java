/*
 * Problem Link: https://www.geeksforgeeks.org/problems/spirally-traversing-a-matrix-1587115621/1
 * You are given a rectangular matrix mat[][] of size n x m, and your task is to return an array
 * while traversing the matrix in spiral form.
 *
 * Input: mat[][] = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 16]]
 * Output: [1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]
 *
 * Input: mat[][] = [[1, 2, 3, 4, 5, 6], [7, 8, 9, 10, 11, 12], [13, 14, 15, 16, 17, 18]]
 * Output: [1, 2, 3, 4, 5, 6, 12, 18, 17, 16, 15, 14, 13, 7, 8, 9, 10, 11]
 *
 * Input: mat[][] = [[32, 44, 27, 23], [54, 28, 50, 62]]
 * Output: [32, 44, 27, 23, 62, 50, 28, 54]
 */

import java.util.ArrayList;

public class ZeroSpiralTraversal {

  public ArrayList<Integer> spirallyTraverse(int mat[][]) {
    ArrayList<Integer> arrayList = new ArrayList<>();

    int topLimit = 0, bottomLimit = mat.length - 1, leftLimit = 0, rightLimit = mat[0].length - 1;

    // idea here is to physically iterate
    // throughout the matrix spirally
    // and set limits for each iteration
    //
    // not sure how i can optimize this
    while (topLimit <= bottomLimit && leftLimit <= rightLimit) {

      // ------------>
      for (int i = leftLimit; i <= rightLimit; i++) {
        arrayList.add(mat[topLimit][i]);
      }

      topLimit += 1;

      // |
      // |
      // |
      // |
      // |
      // v
      for (int i = topLimit; i <= bottomLimit; i++) {
        arrayList.add(mat[i][rightLimit]);
      }

      rightLimit -= 1;

      // <---------------
      if (topLimit <= bottomLimit) {
        for (int i = rightLimit; i >= leftLimit; i--) {
          arrayList.add(mat[bottomLimit][i]);
        }

        bottomLimit -= 1;
      }

      // ^
      // |
      // |
      // |
      // |
      // |
      if (leftLimit <= rightLimit) {
        for (int i = bottomLimit; i >= topLimit; i--) {
          arrayList.add(mat[i][leftLimit]);
        }

        leftLimit += 1;
      }

    }

    return arrayList;
  }

  public static void main(String[] args) {

    ZeroSpiralTraversal zeroSpiralTraversal = new ZeroSpiralTraversal();

    int[][] mat1 = {
        { 1, 2, 3, 4 },
        { 5, 6, 7, 8 },
        { 9, 10, 11, 12 },
        { 13, 14, 15, 16 }
    };

    System.out.println(zeroSpiralTraversal.spirallyTraverse(mat1));

  }

}
