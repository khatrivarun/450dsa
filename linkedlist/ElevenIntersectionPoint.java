/*
 * Problem Link: https://www.geeksforgeeks.org/problems/intersection-point-in-y-shapped-linked-lists/1
 * Given the head of two singly linked lists, return the point where these two linked lists intersect.
 * Note: It is guaranteed that the intersected node always exists.
 *
 * Examples:
 * Input: head1[] : 4->4->4->4->4, head2[] : 4->4->4
 * Output: 4
 *
 * Input: head1[] : 4->1->8->4->5, head2[] : 5->6->1->8->4->5
 * Output: 8
 */

import java.util.Stack;

class Node {
  int data;
  Node next;

  Node(int d) {
    data = d;
    next = null;
  }
}

public class ElevenIntersectionPoint {

  // Idea is to use stacks
  // Push nodes into it for both lists
  // and pop till they are not the same
  static Node intersectPoint(Node head1, Node head2) {

    Stack<Node> llOneStack = new Stack<>();
    Stack<Node> llTwoStack = new Stack<>();

    while (head1 != null) {
      llOneStack.push(head1);
      head1 = head1.next;
    }

    while (head2 != null) {
      llTwoStack.push(head2);
      head2 = head2.next;
    }

    Node commonPoint = llOneStack.peek();

    while (true) {

      Node elementOne = llOneStack.pop();
      Node elementTwo = llTwoStack.pop();

      if (elementOne == elementTwo) {
        commonPoint = elementOne;
      } else {
        break;
      }

    }

    return commonPoint;

  }

}
