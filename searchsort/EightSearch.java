/*
 * Problem Link:
 * https://www.geeksforgeeks.org/problems/searching-in-an-array-where-adjacent-
 * differ-by-at-most-k0456/1
 * Given a step array arr[], its step value k, and a key x, we need to find the
 * index of key x in the array arr[]. If multiple occurrences of key x exist,
 * return the first occurrence of the key. In case of no occurrence of key x
 * exists return -1.
 *
 * Note: A step array is an array of integers where the difference between
 * adjacent elements is at most k. For example: arr[] = [4, 6, 7, 9] and k = 2
 * is a step array as the difference between the adjacent elements in the arr[]
 * is at most 2.
 *
 * Examples:
 * Input: arr[] = [4, 5, 6, 7, 6] , k = 1 , x = 6
 * Output: 2
 *
 * Input: arr[] = [20, 40, 50], k = 20 , x = 70
 * Output: -1
 */

public class EightSearch {

  public int findStepKeyIndex(int[] arr, int k, int x) {
    int index = Integer.MAX_VALUE;

    // Min index, thats it
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == x) {
        index = Math.min(index, i);
      }
    }

    return index == Integer.MAX_VALUE ? -1 : index;
  }

}
