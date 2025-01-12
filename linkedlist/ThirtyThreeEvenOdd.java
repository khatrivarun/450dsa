/*
 * Problem Link: https://www.geeksforgeeks.org/problems/segregate-even-and-odd-nodes-in-a-linked-list5035/1
 * Given a link list, modify the list such that all the even numbers appear before all the odd numbers in the modified list. The order of appearance of numbers within each segregation should be the same as that in the original list.
 * NOTE: Don't create a new linked list, instead rearrange the provided one.
 *
 * Examples:
 * Input: Linked list: 17->15->8->9->2->4->6
 * Output: 8->2->4->6->17->15->9
 *
 * Input: Linked List: 1 -> 3 -> 5 -> 7
 * Output: 1->3->5->7
 */

class Node {
  int data;
  Node next;

  Node(int x) {
    data = x;
    next = null;
  }
}

public class ThirtyThreeEvenOdd {

  Node divide(Node head) {

    Node evenNode = new Node(-1);
    Node oddNode = new Node(-1);

    Node currentNode = head, copyOdd = oddNode, copyEven = evenNode;

    // Simply dividing the list into
    // odds and evens and combing them
    while (currentNode != null) {
      if (currentNode.data % 2 == 0) {
        evenNode.next = currentNode;
        evenNode = evenNode.next;

        currentNode = currentNode.next;
        evenNode.next = null;
      } else {
        oddNode.next = currentNode;
        oddNode = oddNode.next;

        currentNode = currentNode.next;
        oddNode.next = null;
      }
    }

    evenNode.next = copyOdd.next;
    return copyEven.next;

  }

}
