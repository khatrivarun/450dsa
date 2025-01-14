/*
 * Problem Link: https://www.geeksforgeeks.org/problems/check-if-linked-list-is-pallindrome/1
 * Given a singly linked list of integers. The task is to check if the given linked list is palindrome or not.
 *
 * Examples:
 * Input: LinkedList: 1->2->1->1->2->1
 * Output: true
 *
 * Input: LinkedList: 1->2->3->4
 * Output: false
 */

class Node {
  int data;
  Node next;

  Node(int d) {
    data = d;
    next = null;
  }
}

public class SeventeenPalindrome {
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

  boolean isPalindrome(Node head) {

    Node rabbitNode = head, tortoiseNode = head;

    while (rabbitNode.next != null && rabbitNode.next.next != null) {
      rabbitNode = rabbitNode.next.next;
      tortoiseNode = tortoiseNode.next;
    }

    Node reverseList = reverseList(tortoiseNode.next);
    tortoiseNode.next = null;

    Node traverseList = head;

    while (reverseList != null && traverseList != null) {

      if (reverseList.data == traverseList.data) {

        reverseList = reverseList.next;
        traverseList = traverseList.next;

      } else {
        return false;
      }

    }

    return true;

  }

}
