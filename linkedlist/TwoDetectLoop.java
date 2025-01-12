/*
 * Problem Link:
 * https://www.geeksforgeeks.org/problems/detect-loop-in-linked-list/1
 * Given the head of a singly linked list, the task is to check if the linked
 * list has a loop. A loop means that the last node of the linked list is
 * connected back to a node in the same list. So if the next of the last node is
 * null. then there is no loop.
 *
 * Examples:
 * Input: LinkedList: 1->3->4
 * Output: true
 *
 * Input: LinkedList: 1->8->3->4
 * Output: false
 *
 * Input: LinkedList: 1->2->3->4
 * Output: true
 */

class Node {
  int data;
  Node next;

  Node(int d) {
    data = d;
    next = null;
  }
}

public class TwoDetectLoop {

  public static boolean detectLoop(Node head) {

    Node rabbitNode = head, turtleNode = head;

    // Classic hare and tortoise story
    while (rabbitNode != null && rabbitNode.next != null && turtleNode != null) {

      rabbitNode = rabbitNode.next.next;
      turtleNode = turtleNode.next;

      if (rabbitNode == turtleNode) {
        return true;
      }

    }

    return false;

  }

}
