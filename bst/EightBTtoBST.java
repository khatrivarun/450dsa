// Problem Link: https://www.geeksforgeeks.org/problems/binary-tree-to-bst/1
// Given a Binary Tree, convert it to Binary Search Tree in such a way that
// keeps the original structure of Binary Tree intact.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Node {
  int data;
  Node left, right;

  Node(int item) {
    data = item;
    left = right = null;
  }
}

public class EightBTtoBST {

  // Inorder traversal to convert BT to a list
  void inorderTraversal(Node node, List<Integer> traversal) {
    if (node == null)
      return;

    inorderTraversal(node.left, traversal);
    traversal.add(node.data);
    inorderTraversal(node.right, traversal);
  }

  // Inorder traversal to convert the BT to BST
  void inorderTraversal(Node node, List<Integer> fixedTraversal, int[] index) {
    if (node == null)
      return;

    inorderTraversal(node.left, fixedTraversal, index);

    node.data = fixedTraversal.get(index[0]);
    index[0] += 1;

    inorderTraversal(node.right, fixedTraversal, index);
  }

  // Step 1: Get the present Inorder Traversal
  // Step 2: Sort the inorder array
  // Step 3: Visit each node vua inorder traversal
  // and fix the nodes using the sorted array
  Node binaryTreeToBST(Node root) {
    List<Integer> traversal = new ArrayList<>();

    inorderTraversal(root, traversal);
    Collections.sort(traversal);

    inorderTraversal(root, traversal, new int[] { 0 });

    return root;
  }

}
