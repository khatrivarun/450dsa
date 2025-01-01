/*
 * Problem Link: https://www.geeksforgeeks.org/problems/sorted-matrix2333/1
 * Given an NxN matrix Mat. Sort all elements of the matrix.
 *
 * Examples:
 * Input:
 * N=4
 * Mat=[[10,20,30,40],
 * [15,25,35,45] 
 * [27,29,37,48] 
 * [32,33,39,50]]
 * Output:
 * 10 15 20 25 
 * 27 29 30 32
 * 33 35 37 39
 * 40 45 48 50
 *
 * Input:
 * N=3
 * Mat=[[1,5,3],[2,8,7],[4,6,9]]
 * Output:
 * 1 2 3 
 * 4 5 6
 * 7 8 9
 */

import java.util.Collections;
import java.util.LinkedList;

public class TwoSortedMatrix {

  int[][] sortedMatrix(int N, int Mat[][]) {
    int[][] resultMatrix = new int[N][N];

    LinkedList<Integer> linkedList = new LinkedList<>();

    // Insert all elements in a 1D
    // linked list
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        linkedList.add(Mat[i][j]);
      }
    }

    // Sort the list
    Collections.sort(linkedList);

    // Insert all the sorted
    // elements in a NxN matrix
    int counter = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        resultMatrix[i][j] = linkedList.get(counter);

        counter += 1;
      }
    }

    return resultMatrix;

  }

}
