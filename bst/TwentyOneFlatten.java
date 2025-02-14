// Problem Link: https://www.geeksforgeeks.org/problems/flatten-bst-to-sorted-list--111950/1
// You are given a Binary Search Tree (BST) with n nodes, each node has a distinct value
// to it. The goal is to flatten the tree such that, the left child of each element points
// to nothing (NULL), and the right child points to the next element in the sorted list of
// elements of the BST (look at the examples for clarity). You must accomplish this without
// using any extra storage, except for recursive calls, which are allowed.

import javax.management.PersistentMBean;

class Node {
  int data;
  Node left;
  Node right;

  Node(int data) {
    this.data = data;
    left = null;
    right = null;
  }
}

public class TwentyOneFlatten {

  static Node previousNode;

  // Previous Node concept here to keep track
  // and we basically do inorder traversal
  // and as we visit nodes, we flatten the tree
  public void inOrderTraversal(Node currentNode) {
    if (currentNode == null)
      return;

    inOrderTraversal(currentNode.left);

    previousNode.left = null;
    previousNode.right = currentNode;
    previousNode = currentNode;

    inOrderTraversal(currentNode.right);
  }

  public Node flattenBST(Node root) {
    Node dummyNode = new Node(-1);
    previousNode = dummyNode;

    inOrderTraversal(root);

    previousNode.left = null;
    previousNode.right = null;

    return dummyNode.right;
  }
}
