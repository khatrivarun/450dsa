/*
 * Problem Link:
 * https://www.geeksforgeeks.org/problems/finding-middle-element-in-a-linked-
 * list/1
 * Given the head of a linked list, the task is to find the middle. For example,
 * the middle of 1-> 2->3->4->5 is 3. If there are two middle nodes (even
 * count), return the second middle. For example, middle of 1->2->3->4->5->6 is
 * 4.
 *
 * Examples:
 * Input: Linked list: 1->2->3->4->5
 * Output: 3
 *
 * Input: Linked list: 2->4->6->7->5->1
 * Output: 7
 */

public class FourteenMiddle {

  int getMiddle(Node head) {
    Node rabbitNode = head, tortoiseNode = head;

    while (rabbitNode != null && rabbitNode.next != null) {
      rabbitNode = rabbitNode.next.next;
      tortoiseNode = tortoiseNode.next;
    }

    return tortoiseNode.data;
  }

}
