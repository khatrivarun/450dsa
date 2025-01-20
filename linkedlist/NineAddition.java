/*
 * Problem Link:
 * https://www.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-
 * lists/1
 * Given two numbers, num1, and num2, represented by linked lists. The task is
 * to return the head of the linked list representing the sum of these two
 * numbers.
 *
 * For example, the number 190 will be represented by the linked list,
 * 1->9->0->null, similarly 25 by 2->5->null. Sum of these two numbers is 190 +
 * 25 = 215, which will be represented by 2->1->5->null. You are required to
 * return the head of the linked list 2->1->5->null.
 *
 * Note: There can be leading zeros in the input lists, but there should not be
 * any leading zeros in the output list.
 *
 * Examples:
 * Input: num1 = 45 (4->5->null), num2 = 345 (3->4->5->null)
 * Output: 3->9->0->null
 *
 * Input: num1 = 0063 (0->0->6->3->null), num2 = 07 (0->7->null)
 * Output: 7->0->null
 */

class Node {
  int data;
  Node next;

  Node(int d) {
    data = d;
    next = null;
  }
}

public class NineAddition {

  static Node reverseList(Node head) {

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

  static Node addTwoLists(Node num1, Node num2) {
    Node sumList = new Node(-1), sumReference = sumList;

    // Step 1: Reverse both the lists
    // So we can process least significant
    // digits first
    Node num1Reversed = reverseList(num1);
    Node num2Reversed = reverseList(num2);

    // Carry over
    int carryOver = 0;

    // Step 2: Consider the carry over
    // as the initial sum, add elements
    // from both the list and append result
    // mod 10 to the new list and store
    // carry over as divided by 10
    while (num1Reversed != null || num2Reversed != null || carryOver != 0) {

      int sum = carryOver;

      if (num1Reversed != null) {
        sum += num1Reversed.data;
        num1Reversed = num1Reversed.next;
      }

      if (num2Reversed != null) {
        sum += num2Reversed.data;
        num2Reversed = num2Reversed.next;
      }

      sumReference.next = new Node(sum % 10);
      sumReference = sumReference.next;

      carryOver = sum / 10;

    }

    // Reverse the list again to form
    // the proper list
    return reverseList(sumList.next);
  }

}
