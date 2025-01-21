/*
 * Problem Link: https://www.geeksforgeeks.org/problems/sort-a-linked-list/1
 * Given a pointer/reference to the head of the linked list, the task is to sort
 * the given linked list using Merge Sort.
 * Note: If the length of the linked list is odd, then the extra node should go
 * into the first list while splitting.
 *
 * Examples:
 * Input: LinkedList: 3->5->2->4->1
 * Output: 1->2->3->4->5
 *
 * Input: LinkedList: 9->15->0
 * Output: 0->9->15
 */

class Node {
  int data;
  Node next;

  Node(int key) {
    data = key;
    next = null;
  }
}

public class TwelveMergeSort {

  // Split the linked list into 2
  // slightly modified
  static Node splitLinkedList(Node head) {
    Node rabbitNode = head;
    Node tortoiseNode = head;

    while (rabbitNode != null && rabbitNode.next != null) {
      rabbitNode = rabbitNode.next.next;

      if (rabbitNode != null)
        tortoiseNode = tortoiseNode.next;
    }

    Node splitNode = tortoiseNode.next;
    tortoiseNode.next = null;
    return splitNode;
  }

  // Merge function
  static Node merge(Node firstHalf, Node secondHalf) {

    // if either half is emply
    // return the other half
    //
    // aka the second while
    // loop when the first
    // is done
    if (firstHalf == null)
      return secondHalf;
    if (secondHalf == null)
      return firstHalf;

    // the next value should be the smaller
    // value, choose between the 2 halves
    if (firstHalf.data < secondHalf.data) {
      firstHalf.next = merge(firstHalf.next, secondHalf);
      return firstHalf;
    } else {
      secondHalf.next = merge(firstHalf, secondHalf.next);
      return secondHalf;
    }

  }

  // Actual merge sort
  static Node mergeSort(Node head) {
    if (head == null || head.next == null)
      return head;

    // Step 1: split the linked list
    Node firstHalf = head;
    Node secondHalf = splitLinkedList(head);

    firstHalf = mergeSort(firstHalf);
    secondHalf = mergeSort(secondHalf);

    // step 2: merge while sorting
    return merge(firstHalf, secondHalf);
  }

}
