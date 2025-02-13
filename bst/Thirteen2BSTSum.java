// Problem Link: https://www.geeksforgeeks.org/problems/brothers-from-different-root/1
// Given two BSTs containing N1 and N2 distinct nodes respectively and given a value x,
// your task is to complete the function countPairs(), that returns the count of all
// pairs of (a, b), where a belongs to one BST and b belongs to another BST, such that
// a + b = x.

import java.lang.annotation.Target;
import java.util.ArrayList;

class Node {
  int data;
  Node left, right;

  Node(int val) {
    data = val;
    left = right = null;
  }
}

public class Thirteen2BSTSum {

  public static void inorderTraversal(Node node, ArrayList<Integer> traversal) {
    if (node == null)
      return;

    inorderTraversal(node.left, traversal);
    traversal.add(node.data);
    inorderTraversal(node.right, traversal);
  }

  public static int countPairs(Node root1, Node root2, int x) {

    ArrayList<Integer> traversalOne = new ArrayList<>();
    ArrayList<Integer> traversalTwo = new ArrayList<>();

    int result = 0;

    inorderTraversal(root1, traversalOne);
    inorderTraversal(root2, traversalTwo);

    int leftPointer = 0, rightPointer = traversalTwo.size() - 1;

    while (leftPointer < traversalOne.size() && rightPointer >= 0) {
      int sum = traversalOne.get(leftPointer) + traversalTwo.get(rightPointer);

      if (sum == x) {
        result += 1;

        leftPointer += 1;
        rightPointer -= 1;
      } else if (sum > x)
        rightPointer -= 1;
      else
        leftPointer += 1;
    }

    return result;

  }

}
