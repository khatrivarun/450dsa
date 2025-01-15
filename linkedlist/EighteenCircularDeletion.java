/*
 * Problem Link:
 * https://www.geeksforgeeks.org/problems/deletion-and-reverse-in-linked-list/1
 * Given a Circular Linked List. The task is to delete the given node, key in
 * the circular linked list, and reverse the circular linked list.
 *
 * Examples:
 * Input: Linked List: 2->5->7->8->10, key = 8
 * Output: 10->7->5->2
 *
 * Input: Linked List: 1->7->8->10, key = 8
 * Output: 10->7->1
 *
 * Input: Linked List: 3->6->4->10, key = 9
 * Output: 10->4->6->3
 */

class Node {
  int data;
  Node next;

  Node(int d) {
    data = d;
    next = null;
  }
}

public class EighteenCircularDeletion {

  Node reverse(Node head) {
    Node previousNode = null;
    Node currentNode = head;
    Node nextNode = currentNode.next;

    while (nextNode != head) {
      currentNode.next = previousNode;
      previousNode = currentNode;
      currentNode = nextNode;
      nextNode = nextNode.next;
    }

    currentNode.next = previousNode;
    nextNode.next = currentNode;

    return currentNode;
  }

  Node deleteNode(Node head, int key) {

    if (head.data == key) {
      Node temp = head.next;

      while (temp.next != head) {
        temp = temp.next;
      }

      temp.next = head.next;
      return head.next;
    }

    Node previousNode = head, currentNode = previousNode.next;
    boolean deleted = false;

    while (previousNode != null && previousNode.next != head) {

      if (currentNode.data == key && !deleted) {
        previousNode.next = previousNode.next.next;
        deleted = true;
      }

      previousNode = currentNode;
      currentNode = previousNode.next;

    }

    return head;
  }

}
