/*
 * Problem Link: https://www.geeksforgeeks.org/problems/remove-duplicate-element-from-sorted-linked-list/1
 * Given a singly linked list. The task is to remove duplicates (nodes with duplicate values) from the given list (if it exists).
 *
 * Examples:
 * LinkedList: 2->2->4->5
 * Output: 2 -> 4 -> 5
 *
 * LinkedList: 2->2->2->2->2
 * Output: 2
 */

class Node {
  int data;
  Node next;

  Node(int d) {
    data = d;
    next = null;
  }
}

public class FiveSortedDuplicates {

  Node removeDuplicates(Node head) {
    Node previousNode = head;
    Node currentNode = previousNode.next;

    // since the list is sorted, we will maintain
    // a previous node to check against for duplicate
    while (previousNode != null && previousNode.next != null && currentNode != null) {

      if (previousNode.data == currentNode.data) {
        previousNode.next = currentNode.next;
        currentNode = currentNode.next;
      } else {
        previousNode = currentNode;
        currentNode = currentNode.next;
      }
    }

    return head;
  }

}
