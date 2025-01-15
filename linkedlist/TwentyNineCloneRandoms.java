/*
 * Problem Link:
 * https://www.geeksforgeeks.org/problems/clone-a-linked-list-with-next-and-
 * random-pointer/1
 * You are given a special linked list where each node has a next pointer
 * pointing to its next node. You are also given some random pointers, where you
 * will be given some pairs denoting two nodes a and b i.e. a->random = b
 * (random is a pointer to a random node).
 *
 * Construct a copy of the given list. The copy should consist of the same
 * number of new nodes, where each new node has its value set to the value of
 * its corresponding original node. Both the next and random pointer of the new
 * nodes should point to new nodes in the copied list such that the original and
 * copied list pointers represent the same list state. None of the pointers in
 * the new list should point to nodes in the original list.
 *
 * For example, if there are two nodes x and y in the original list, where
 * x->random = y, then for the corresponding two nodes xnew and ynew in the
 * copied list, xnew->random = ynew.
 * 
 * Return the head of the copied linked list.
 */

import java.util.HashMap;

class Node {
  int data;
  Node next, random;

  Node(int d) {
    data = d;
    next = random = null;

  }
}

public class TwentyNineCloneRandoms {

  Node cloneLinkedList(Node head) {
    HashMap<Node, Node> nodesCache = new HashMap<>();
    Node oldList = head;

    while (oldList != null) {
      Node newNode = new Node(oldList.data);
      nodesCache.put(oldList, newNode);

      oldList = oldList.next;
    }

    oldList = head;
    Node newList = new Node(Integer.MIN_VALUE);
    Node currentNode = newList;

    while (oldList != null) {
      Node newNode = nodesCache.get(oldList);
      newNode.random = nodesCache.get(oldList.random);

      currentNode.next = newNode;
      currentNode = currentNode.next;

      oldList = oldList.next;
    }

    return newList.next;
  }

}
