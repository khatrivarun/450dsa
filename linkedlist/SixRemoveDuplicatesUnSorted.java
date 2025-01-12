/*
 * Problem Link: https://www.geeksforgeeks.org/problems/remove-duplicates-from-an-unsorted-linked-list/1
 * Given an unsorted linked list. The task is to remove duplicate elements from this unsorted Linked List. When a value appears in multiple nodes, the node which appeared first should be kept, all other duplicates are to be removed.
 *
 * Examples:
 * Input: LinkedList: 5->2->2->4
 * Output: 5->2->4
 *
 * Input: LinkedList: 2->2->2->2->2
 * Output: 2
 */

import java.util.HashMap;

class Node {
  int data;
  Node next;

  Node(int d) {
    data = d;
    next = null;
  }
}

public class SixRemoveDuplicatesUnSorted {

  public Node removeDuplicates(Node head) {

    HashMap<Integer, Integer> cache = new HashMap<>();
    Node node = head;

    cache.put(node.data, node.data);

    // Check in HashMap for duplicates and if
    // present, delete the node itself
    while (node != null && node.next != null) {

      Integer data = node.next.data;

      if (cache.containsKey(data)) {
        node.next = node.next.next;
      } else {
        cache.put(data, data);
        node = node.next;
      }

    }

    return head;
  }

}
