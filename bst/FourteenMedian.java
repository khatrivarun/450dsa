// Problem Link: https://www.geeksforgeeks.org/problems/median-of-bst/1
// Given a Binary Search Tree, find the Median of its Node values.
//
// Examples:
// Input: root = [6, 3, 8, 1, 4, 7, 9]
// Output: 6
//
// Input: root = [6, 3, 8, 1, 4, 7, N]
// Output: 5
//
// Input: root = [18, 16, 20, 7]
// Output: 17

import java.util.ArrayList;
import java.util.List;

public class FourteenMedian {

  // Inorder traversal, convert to list
  // and apply the median formula
  public static float findMedian(Node root) {
    List<Integer> traversal = new ArrayList<>();
    inOrderTraversal(root, traversal);

    int size = traversal.size();

    if (size % 2 == 0)
      return (float) (traversal.get(size / 2) + traversal.get((size / 2) - 1)) / 2;
    else
      return (float) traversal.get(size / 2);
  }

  static void inOrderTraversal(Node node, List<Integer> traversal) {
    if (node == null)
      return;

    inOrderTraversal(node.left, traversal);
    traversal.add(node.data);
    inOrderTraversal(node.right, traversal);
  }

}

class Node {
  int data;
  Node left, right;

  public Node(int d) {
    data = d;
    left = right = null;
  }
}
