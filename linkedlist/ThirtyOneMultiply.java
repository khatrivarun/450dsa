/*
 * Problem Link:
 * https://www.geeksforgeeks.org/problems/multiply-two-linked-lists/1
 * Given elements as nodes of the two singly linked lists. The task is to
 * multiply these two linked lists, say L1 and L2.
 * Note: The output could be large take modulo 10^9+7.
 *
 * Examples:
 * Input: LinkedList L1 : 3->2 , LinkedList L2 : 2
 * Output: 64
 *
 * Input: LinkedList L1: 1->0->0 , LinkedList L2 : 1->0
 * Output: 1000
 */

class Node {
  int data;
  Node next;

  Node(int data) {
    this.data = data;
    this.next = null;
  }
}

public class ThirtyOneMultiply {

  public long multiplyTwoLists(Node first, Node second) {
    long modulo = 1000000007;
    long completeNumOne = 0, completeNumTwo = 0;

    // Convert both list to numbers
    // with modulo being considered too
    while (first != null || second != null) {
      if (first != null) {
        completeNumOne = ((completeNumOne * 10) + first.data) % modulo;
        first = first.next;
      }

      if (second != null) {
        completeNumTwo = ((completeNumTwo * 10) + second.data) % modulo;
        second = second.next;
      }
    }

    // Then we return the number, again modulo considered too
    return (completeNumOne * completeNumTwo) % modulo;
  }

}
