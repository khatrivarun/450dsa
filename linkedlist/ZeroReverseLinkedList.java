/*
 * Problem Link: https://www.geeksforgeeks.org/problems/reverse-a-linked-list/1
 * Given the head of a linked list, the task is to reverse this list and return the reversed head.
 *
 * Examples:
 * Input: Linked list: 1->2->3->4->5->6
 * Output: 6->5->4->3->2->1
 *
 * Input: Linked list: 2->7->10->9->8
 * Output: 8->9->10->7->2
 *
 * Input: Linked List: 10
 * Output: 10
 */

class Node {
  int data;
  Node next;

  Node(int value) {
    this.data = value;
  }
}

public class ZeroReverseLinkedList {
  Node reverseList(Node head) {

    // To keep track of the "next"
    // node of the reversed list
    Node previousNode = null;

    while (head != null) {

      // keep track of the next node
      // and update next to previous
      Node nextNode = head.next;
      head.next = previousNode;

      // update pointers
      previousNode = head;
      head = nextNode;

    }

    return previousNode;
  }
}
