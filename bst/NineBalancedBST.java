// Problem Link: https://www.geeksforgeeks.org/problems/normal-bst-to-balanced-bst/1
// Given a root of a Binary Search Tree, modify and return the given BST such that
// it is balanced and has minimum possible height. If there is more than one answer
// return any of them.
//
// Note: The height of balanced BST returned by you will be compared with the
// expected height of the balanced tree.

import java.util.ArrayList;
import java.util.List;

class Node {
  int data;
  Node right, left;

  Node(int item) {
    data = item;
    left = right = null;
  }
}

public class NineBalancedBST {

  // Step 1: Convert the BST into a List using inorder traversal
  void inorderTraversal(Node node, List<Integer> traversal) {
    if (node == null)
      return;

    inorderTraversal(node.left, traversal);
    traversal.add(node.data);
    inorderTraversal(node.right, traversal);
  }

  // Step 2: In an inorder traversal list, the mid element is always the root
  // Then the left side of the mid can be used to recursively build the left
  // subtree and same for the right side and right subtree
  Node buildBalancedBst(List<Integer> traversal, int leftPointer, int rightPointer) {
    if (leftPointer > rightPointer)
      return null;

    int mid = (leftPointer + rightPointer) / 2;
    Node node = new Node(traversal.get(mid));

    node.left = buildBalancedBst(traversal, leftPointer, mid - 1);
    node.right = buildBalancedBst(traversal, mid + 1, rightPointer);

    return node;
  }

  Node balanceBST(Node root) {
    List<Integer> traversal = new ArrayList<>();
    inorderTraversal(root, traversal);

    return buildBalancedBst(traversal, 0, traversal.size() - 1);
  }

}
