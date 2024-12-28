package problems;

/*
 * Problem Link: https://www.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1
 *  Given an array arr[] of non-negative integers. Each array element represents the 
 *  maximum length of the jumps that an be made forward from that element.
 *  This means if arr[i] = x, then we can jump any distance y such that y ≤ x.
 *  Find the minimum number of jumps to reach the end of the array starting from the first element.
 *  If an element is 0, then you cannot move through that element.
 *
 *  Note:  Return -1 if you can't reach the end of the array.
 *
 *  Examples:
 *  Input: arr[] = [1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9]
 *  Output: 3
 *
 *  Input: arr = [1, 4, 3, 2, 6, 7]
 *  Output: 2
 *  
 *  Input: arr = [0, 10, 20]
 *  Output: -1
 *
 *  Constraints:
 *  2 ≤ arr.size() ≤ 10^6
 *  0 ≤ arr[i] ≤ 10^5
 */

public class TenMinimumJump {

  /*
   * Actual method provided for solution
   */
  static int minJumps(int[] arr) {

    // If the start of the array itself
    // is 0, return -1
    if (arr[0] == 0)
      return -1;

    int jumps = 1;
    int currentReach = arr[0];
    int currentLimit = arr[0];
    int goal = arr.length;

    for (int i = 1; i < arr.length; i++) {

      // If we have reached our goal
      // return the number of jumps
      if (currentLimit >= (goal - 1))
        return jumps;

      // if we are still under our hard limit
      if (i < currentLimit) {

        // Check what is the maximum possible reach if we
        // jump to i
        currentReach = Math.max(currentReach, i + arr[i]);

      }

      // if we have crossed our hard limit
      // need to make a jump and calculate
      // new reach and limit
      else {
        jumps += 1;
        currentLimit = Math.max(currentReach, i + arr[i]);
        currentReach = i + arr[i];

        // if we have hit our goal, return jumps
        if (currentLimit >= (goal - 1))
          return jumps;

      }

      // if we cannot reach our goal
      // return -1
      if (i >= currentReach)
        return -1;
    }

    return jumps;

  }

  public static void main(String[] args) {

    System.out.println(TenMinimumJump.minJumps(new int[] { 1, 3, 5, 8, 9, 2, 6,
        7, 6, 8, 9 }));
    System.out.println(TenMinimumJump.minJumps(new int[] { 1, 4, 3, 2, 6, 7 }));
    System.out.println(TenMinimumJump.minJumps(new int[] { 0, 10, 20 }));
    System.out.println(TenMinimumJump.minJumps(new int[] { 9, 10, 1, 2, 3, 4, 8,
        0, 0, 0, 0, 0, 0, 0, 1 }));
    System.out.println(TenMinimumJump.minJumps(new int[] { 1, 2, 0, 0, 0, }));

  }

}
