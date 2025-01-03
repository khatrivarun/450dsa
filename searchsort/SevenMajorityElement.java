/*
 * Problem Link: https://www.geeksforgeeks.org/problems/majority-element-1587115620/1
 * Given an array arr. Find the majority element in the array. If no majority exists, return -1.
 * A majority element in an array is an element that appears strictly more than arr.size()/2 times in the array.
 */

public class SevenMajorityElement {

  static int majorityElement(int arr[]) {
    int flag = Integer.MIN_VALUE, count = 0;
    int length = arr.length;

    // Moore's Voting Algorithm
    // Already had solved a question
    // similar to this.
    for (int i = 0; i < arr.length; i++) {
      if (count == 0) {
        flag = arr[i];
        count = 1;
      } else if (arr[i] == flag)
        count += 1;
      else {
        count -= 1;
      }
    }

    count = 0;
    for (int i = 0; i < arr.length; i++) {
      if (flag == arr[i])
        count += 1;

      if (count > (length / 2))
        return flag;
    }

    return -1;
  }

}
