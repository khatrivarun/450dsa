/*
 * Problem Link: https://www.geeksforgeeks.org/problems/quick-sort-on-linked-list/1
 * You are given a Linked List. Sort the given Linked List using quicksort.
 *
 * Examples:
 * Input: Linked list: 1->6->2
 * Output: 1->2->6
 *
 * Input: Linked list: 1->9->3->8
 * Output: 1->3->8->9
 */

class Node {
  int data;
  Node next;

  Node(int key) {
    data = key;
    next = null;
  }
}

public class ThirteenQuicksort {

  public static Node partition(Node head, Node tail) {
    // Select the head as pivot
    Node pivot = head;

    // Previous node marking the first half
    // after partitioning
    Node previousNode = head, currentNode = head;

    // Partition the list
    while (currentNode != tail.next) {

      if (currentNode.data < pivot.data) {
        int swap = currentNode.data;
        currentNode.data = previousNode.next.data;
        previousNode.next.data = swap;

        previousNode = previousNode.next;
      }

      currentNode = currentNode.next;

    }

    // Bring the pivot in between
    // after partitioning
    int swap = pivot.data;
    pivot.data = previousNode.data;
    previousNode.data = swap;

    return previousNode;
  }

  public static void runQuickSort(Node head, Node tail) {

    if (head == null || head == tail)
      return;

    // Get the pivot
    Node pivot = partition(head, tail);

    // And partition the left and right
    // halves of the list
    runQuickSort(head, pivot);
    runQuickSort(pivot.next, tail);

  }

  public static Node quickSort(Node node) {
    Node head = node, tail = head;

    while (tail.next != null)
      tail = tail.next;

    runQuickSort(head, tail);

    return node;
  }

}
