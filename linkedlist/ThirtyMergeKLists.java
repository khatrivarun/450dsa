/*
 * Problem Link: https://www.geeksforgeeks.org/problems/merge-k-sorted-linked-lists/1
 *
 * Given an array arr[] of n sorted linked lists of different sizes. The task is to merge them in such a way that after merging they will be a single sorted linked list, then return the head of the merged linked list.
 *
 * Examples:
 * Input: arr[] = [1 -> 2 -> 3, 4 -> 5, 5 -> 6, 7 -> 8]
 * Output: 1 -> 2 -> 3 -> 4 -> 5 -> 5 -> 6 -> 7 -> 8
 *
 * Input: arr[] = [1 -> 3, 8, 4 -> 5 -> 6]
 * Output: 1 -> 3 -> 4 -> 5 -> 6 -> 8
 */

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Node {
  int data;
  Node next;

  Node(int key) {
    data = key;
    next = null;
  }
}

public class ThirtyMergeKLists {

  Node mergeKLists(List<Node> arr) {

    // We will save all heads in a min heap
    // so when we poll the heap, we get the minimum possible head node.
    PriorityQueue<Node> minHeap = new PriorityQueue<>((Node nodeOne, Node nodeTwo) -> nodeOne.data - nodeTwo.data);

    for (Node node : arr) {
      minHeap.add(node);
    }

    Node resultList = new Node(-1), resultReference = resultList;

    // Poll till the heap is empty
    // and form the result list
    //
    // while polling, check for next
    // and insert in the heap
    while (!minHeap.isEmpty()) {

      Node minNode = minHeap.poll();
      int minData = minNode.data;

      resultReference.next = new Node(minData);
      resultReference = resultReference.next;

      if (minNode.next != null) {
        minHeap.add(minNode.next);
      }

    }

    return resultList.next;

  }

}
