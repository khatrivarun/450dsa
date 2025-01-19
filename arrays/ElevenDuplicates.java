
/*
 * Problem Link: https://leetcode.com/problems/find-the-duplicate-number/description/
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * There is only one repeated number in nums, return this repeated number.
 * You must solve the problem without modifying the array nums and using only constant extra space.
 *
 * Expected Time Complexity: O(n)
 * Expected Auxiliary Space: O(1)
 *
 * Constraints:
 * 1 ≤ n ≤ 10^5
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 *
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 *
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 *
 * Input: nums = [3,3,3,3,3]
 * Output: 3
 */

public class ElevenDuplicates {

  /*
   * Actual method given for the problem
   */
  public int findDuplicate(int[] nums) {

    /*
     * Thinking process: Couldn't solve this one
     * myself but found a relevant resource for this:
     * https://keithschwarz.com/interesting/code/?dir=find-duplicate
     *
     * TLDR, This can be solved using Floyd's
     * Cycle Detection Algorithm or also known
     * as Tortoise and Hair algorithm.
     *
     * Basically we have 2 pointers, tortoise
     * and hare, which are slow (1 step) and
     * fast (2 steps) pointers.
     **
     * In case of arrays here, we can treat each
     * value as a pointer to the next position.
     *
     * So for fast and slow pointers would mean
     * arr[arr[i]] and arr[i] respectively.
     *
     * Since we know duplicates exist then we can
     * run a while loop till we find the existence
     * of the duplicates/cycle.
     */

    int slow = nums[0];
    int fast = nums[0];

    do {
      slow = nums[slow];
      fast = nums[nums[fast]];
    } while (slow != fast);

    slow = nums[0];

    /*
     * Thinking process: Now we have an idea
     * that duplicates exist. To find the duplicate,
     * we slowly converge on the duplicate by increasing
     * both slow and fast pointers by one step till they
     * are the same value.
     */
    while (slow != fast) {
      slow = nums[slow];
      fast = nums[fast];
    }

    return slow;

  }

  public static void main(String[] args) {

    ElevenDuplicates solution = new ElevenDuplicates();

    int arr[] = { 1, 3, 4, 2, 2 };

    System.out.println(solution.findDuplicate(arr));

    int arr2[] = { 3, 1, 3, 4, 2 };

    System.out.println(solution.findDuplicate(arr2));

    int arr3[] = { 3, 3, 3, 3, 3 };

    System.out.println(solution.findDuplicate(arr3));
  }

}
