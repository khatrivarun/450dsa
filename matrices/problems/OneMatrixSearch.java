/*
 * Problem Link: https://www.geeksforgeeks.org/problems/search-in-a-matrix17201720/1
 * Given a 2D integer matrix mat[][] of size n x m, where every row and column is 
 * sorted in increasing order and a number x, the task is to find whether element 
 * x is present in the matrix.
 *
 * Examples:
 * Input: mat[][] = [[3, 30, 38],[20, 52, 54],[35, 60, 69]], x = 62
 * Output: false
 *
 * Input: mat[][] = [[18, 21, 27],[38, 55, 67]], x = 55
 * Output: true
 *
 * Input: mat[][] = [[1, 2, 3],[4, 5, 6],[7, 8, 9]], x = 3
 * Output: true
 */

import java.util.Arrays;

public class OneMatrixSearch {

  public static boolean matSearch(int mat[][], int x) {

    // Since all the rows and columns are sorted
    // we can get away with binary search on each row
    for (int i = 0; i < mat.length; i++) {
      int search = Arrays.binarySearch(mat[i], x);

      if (search >= 0)
        return true;
    }

    return false;

  }

}
