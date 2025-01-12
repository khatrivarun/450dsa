/*
 * Problem Link:
 * https://www.geeksforgeeks.org/problems/flattening-a-linked-list/1
 * Given a Linked List, where every node represents a sub-linked-list and
 * contains two pointers:
 * (i) a next pointer to the next node,
 * (ii) a bottom pointer to a linked list where this node is head.
 * Each of the sub-linked lists is in sorted order.
 * Flatten the Link List so all the nodes appear in a single level while
 * maintaining the sorted order.
 */

import java.util.Collections;
import java.util.LinkedList;

class Node {

  int data;
  Node next;
  Node bottom;

  Node(int x) {
    data = x;
    next = null;
    bottom = null;
  }

}

public class TwentySevenFlatten {

  Node flatten(Node root) {

    LinkedList<Integer> linkedList = new LinkedList<>();
    Node referenceNode = root;

    // Idea is to push all elements in a
    // single Java list and sort them
    // to build the flattened linked list
    // again
    while (referenceNode != null) {

      linkedList.add(referenceNode.data);

      Node bottomNode = referenceNode.bottom;

      while (bottomNode != null) {

        linkedList.add(bottomNode.data);
        bottomNode = bottomNode.bottom;

      }

      referenceNode = referenceNode.next;

    }

    Collections.sort(linkedList);

    Node newNode = new Node(linkedList.get(0));
    Node currentNode = newNode;

    for (int i = 1; i < linkedList.size(); i++) {
      Node newChildNode = new Node(linkedList.get(i));

      currentNode.bottom = newChildNode;
      currentNode = currentNode.bottom;
    }

    return newNode;

  }

}
