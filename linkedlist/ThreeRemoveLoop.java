/*
 * Problem Link: https://www.geeksforgeeks.org/problems/remove-loop-in-linked-list/1
 * Given the head of a linked list that may contain a loop.  A loop means that the last node of the linked list is connected back to a node in the same list.  So if the next of the previous node is null. then there is no loop.  Remove the loop from the linked list, if it is present (we mainly need to make the next of the last node null). Otherwise, keep the linked list as it is.
 *
 * Examples:
 * Input: Linked list: 1->3->4, pos = 2
 * Output: true
 *
 * Input: Linked list: 1->8->3->4, pos = 0
 * Output: true
 *
 * Input: Linked list: 1->2->3->4, pos = 1
 * Output: true
 */

public class ThreeRemoveLoop {

  public static void removeLoop(Node head) {

    Node rabbitNode = head, turtleNode = head;

    rabbitNode = rabbitNode.next.next;
    turtleNode = turtleNode.next;

    // Step 1: Discover the loop
    while (rabbitNode != null && rabbitNode.next != null && turtleNode != null) {
      if (rabbitNode == turtleNode) {
        break;
      }

      turtleNode = turtleNode.next;
      rabbitNode = rabbitNode.next.next;
    }

    if (turtleNode == rabbitNode) {

      turtleNode = head;

      // Step 2, arrive at the point
      // where the loop is getting created.
      if (turtleNode != rabbitNode) {

        while (turtleNode.next != rabbitNode.next) {

          rabbitNode = rabbitNode.next;
          turtleNode = turtleNode.next;

        }

        rabbitNode.next = null;

      } else {

        while (rabbitNode.next != turtleNode)
          rabbitNode = rabbitNode.next;

        rabbitNode.next = null;

      }
    }

  }

}
