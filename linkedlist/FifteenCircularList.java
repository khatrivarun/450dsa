/*
 * Problem Link: https://www.geeksforgeeks.org/problems/circular-linked-list/1
 * Given the head, the head of a singly linked list, Returns true if the linked
 * list is circular & false if it is not circular.
 * A linked list is called circular if it is not NULL terminated and all nodes
 * are connected in the form of a cycle.
 * Note: The linked list does not contain any inner loop.
 */

class Node {
  int data;
  Node next;

  Node(int d) {
    data = d;
    next = null;
  }
}

public class FifteenCircularList {

  boolean isCircular(Node head) {

    Node currentNode = head.next;

    while (currentNode != null) {
      if (currentNode == head) {
        return true;
      }

      currentNode = currentNode.next;
    }

    return false;
  }

}
