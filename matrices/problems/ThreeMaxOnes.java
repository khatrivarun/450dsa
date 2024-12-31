/*
 * Problem Link: https://www.geeksforgeeks.org/problems/row-with-max-1s0023/1
 * You are given a 2D binary array arr[][] consisting of only 1s and 0s.
 * Each row of the array is sorted in non-decreasing order. Your task 
 * is to find and return the index of the first row that contains 
 * the maximum number of 1s. If no such row exists, return -1.
 *
 * Examples:
 * Input: arr[][] = [[0,1,1,1], [0,0,1,1], [1,1,1,1], [0,0,0,0]]
 * Output: 2
 *
 * Input: arr[][] = [[0,0], [1,1]]
 * Output: 1
 *
 * Input: arr[][] = [[0,0], [0,0]]
 * Output: -1
 */

public class ThreeMaxOnes {

  // Same theory as the binary search algo
  // but even after finding the occurence
  // loop further and search for the first
  // occurence of 1
  private int binarySearchOneFirstOccurence(int[] arr) {

    int searchIndex = -1;

    int low = 0, high = arr.length - 1;

    while (low <= high) {

      int mid = low + (high - low) / 2;

      if (arr[mid] == 1) {
        searchIndex = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }

    }

    return searchIndex;

  }

  public int rowWithMax1s(int arr[][]) {
    int result = -1;
    int maxOnes = -1;
    int rightLimit = arr[0].length;

    // Go through each row and run binary
    // search and keep a track of max ones
    // and row with max ones
    for (int i = 0; i < arr.length; i++) {

      int search = this.binarySearchOneFirstOccurence(arr[i]);

      if (search != -1) {
        int ones = rightLimit - search;
        if (ones > maxOnes) {
          maxOnes = ones;
          result = i;
        }
      }

    }

    return result;
  }

  public static void main(String[] args) {

    ThreeMaxOnes threeMaxOnes = new ThreeMaxOnes();

    int[][] mat1 = {
        { 0, 1, 1, 1 },
        { 0, 0, 1, 1 },
        { 1, 1, 1, 1 },
        { 0, 0, 0, 0 }
    };

    System.out.println(threeMaxOnes.rowWithMax1s(mat1));

  }

}
