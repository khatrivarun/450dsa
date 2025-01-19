
/*
 * Problem Link: https://www.geeksforgeeks.org/problems/find-minimum-and-maximum-element-in-an-array4428/1
 * 450 DSA Question Reference: Arrays ID: 1
 *
 * Problem Description: Given an array arr. Your task is to find the minimum and maximum elements in the array.
 *
 * Note: Return an array that contains two elements the first one will be a minimum element and the second 
 * will be a maximum of an array.
 *
 * Expected Time Complexity: O(n)
 * Expected Auxiliary Space: O(1)
 *
 * Constraints:
 * 1 <= arr.size() <= 10^5
 * 1 <= arr[i] <=10^12
 *
 * Input: arr = [3, 2, 1, 56, 10000, 167]
 * Output: 1 10000
 *
 * Input: arr = [1, 345, 234, 21, 56789]
 * Output: 1 56789
 *
 * Input: arr = [56789]
 * Output: 56789 56789
 */

class Pair<K, V> {
  private final K key;
  private final V value;

  public Pair(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public K getKey() {
    return key;
  }

  public V getValue() {
    return value;
  }
}

public class TwoMinAndMax {

  /*
   * Actual method given for the problem
   */
  public Pair<Long, Long> getMinMax(int[] arr) {
    Long min = Long.valueOf(arr[0]);
    Long max = Long.valueOf(arr[0]);

    /*
     * Thinking process: just iterate through the array
     * and check if its eiher max or min element
     */
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > max) {
        max = Long.valueOf(arr[i]);
      }

      if (arr[i] < min) {
        min = Long.valueOf(arr[i]);
      }
    }

    return new Pair<Long, Long>(min, max);

  }

  /*
   * Testing the solution
   */
  public static void main(String[] args) {

    int arr[] = { 3, 2, 1, 56, 10000, 167 };

    TwoMinAndMax twoMinAndMax = new TwoMinAndMax();

    Pair<Long, Long> result = twoMinAndMax.getMinMax(arr);

    System.out.println(result.getKey() + " " + result.getValue());

  }

}
