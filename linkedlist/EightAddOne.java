/*
 * Problem Link: https://www.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1
 * You are given a linked list where each element in the list is a node and have an integer data. You need to add 1 to the number formed by concatinating all the list node numbers together and return the head of the modified linked list.
 * Note: The head represents the first element of the given array.
 *
 * Examples:
 * Input: LinkedList: 4->5->6
 * Output: 457
 *
 * Input: LinkedList: 1->2->3
 * Output: 124
 */

class Node {
  int data;
  Node next;

  Node(int x) {
    data = x;
    next = null;
  }
}

public class EightAddOne {

  int carryAdd(Node node) {

    if (node == null) {
      return 1;
    }

    int sum = node.data + carryAdd(node.next);
    node.data = sum % 10;
    return sum / 10;

  }

  public Node addOne(Node head) {
    int carryOver = carryAdd(head);

    if (carryOver > 0) {
      Node newNode = new Node(carryOver);
      newNode.next = head;

      return newNode;
    }

    return head;
  }

}
