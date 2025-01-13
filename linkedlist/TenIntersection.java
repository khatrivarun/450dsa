/*
 * Problem Link: https://www.geeksforgeeks.org/problems/intersection-of-two-sorted-linked-lists/1
 * Given that two linked lists are sorted in increasing order, create a new linked list representing the intersection of the two linked lists. The new linked list should be made without changing the original lists.
 * Note: The elements of the linked list are not necessarily distinct.
 *
 * Examples:
 * Input: LinkedList1 = 1->2->3->4->6, LinkedList2 = 2->4->6->8
 * Output: 2->4->6
 *
 * Input: LinkedList1 = 10->20->40->50, LinkedList2 = 15->40
 * Output: 40
 */

class Node {
  int data;
  Node next;

  Node(int d) {
    data = d;
    next = null;
  }
}

public class TenIntersection {

  public static Node findIntersection(Node head1, Node head2) {

    int previousNode = -1;
    Node intersectionNode = new Node(-1), addNode = intersectionNode;
    Node nodeOne = head1, nodeTwo = head2;

    // Idea is to preserve a history of addition
    // and check if nodes are same, check against
    // the history and then it in the intersection
    // list.
    //
    // else since they are sorted, increase first
    // linked list or the second based on whose
    // currently smaller.
    while (nodeOne != null && nodeTwo != null) {

      if (nodeOne.data == nodeTwo.data) {

        if (nodeOne.data != previousNode) {
          previousNode = nodeOne.data;
          Node newNode = new Node(previousNode);

          addNode.next = newNode;
          addNode = newNode;

          nodeOne = nodeOne.next;
          nodeTwo = nodeTwo.next;
        }

      } else if (nodeOne.data > nodeTwo.data) {
        nodeTwo = nodeTwo.next;
      } else {
        nodeOne = nodeOne.next;
      }

    }

    return intersectionNode.next;

  }

}
