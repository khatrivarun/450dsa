/*
 * Problem Link: https://www.geeksforgeeks.org/problems/move-last-element-to-front-of-a-linked-list/1
 * You are given the head of a Linked List. You have to move the last element to the front of the Linked List and return the head the modified linked list.
 *
 * Examples:
 * Input: Linked List: 2->5->6->2->1
 * Output: 1->2->5->6->2
 *
 * Input: Linked List: 2
 * Output: 2
 */

class Node {
  int data;
  Node next;

  Node(int x) {
    data = x;
    next = null;
  }
}

public class SevenMoveLast {

  public static Node moveToFront(Node head) {

    if (head.next == null)
      return head;

    Node previousNode = head, currentNode = previousNode.next;

    // self explanatory
    while (currentNode.next != null) {
      previousNode = currentNode;
      currentNode = currentNode.next;
    }

    currentNode.next = head;
    previousNode.next = null;

    return currentNode;
  }

}
