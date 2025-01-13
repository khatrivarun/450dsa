/*
 * Problem Link:
 * https://www.geeksforgeeks.org/problems/find-the-first-node-of-loop-in-linked-
 * list--170645/1
 * Given a singly linked list's head. Find the first node of the loop if the
 * linked list has a loop. If a loop is present return the node data of the
 * first node of the loop else return NULL.
 */

class Node {
  int data;
  Node next;

  Node(int x) {
    data = x;
    next = null;
  }
}

public class FourLoopStart {

  public static Node findFirstNode(Node head) {
    Node rabbitNode = head;
    Node tortoiseNode = head;

    // Step one: detect the loop
    while (rabbitNode != null && rabbitNode.next != null && tortoiseNode != null) {

      rabbitNode = rabbitNode.next.next;
      tortoiseNode = tortoiseNode.next;

      if (tortoiseNode == rabbitNode) {
        break;
      }

    }

    if (tortoiseNode != rabbitNode)
      return null;

    // Step two: reset tortoise to head
    tortoiseNode = head;

    // and increment both nodes by one
    // till they are the same
    while (tortoiseNode != rabbitNode) {
      tortoiseNode = tortoiseNode.next;
      rabbitNode = rabbitNode.next;
    }

    return rabbitNode;
  }

}
