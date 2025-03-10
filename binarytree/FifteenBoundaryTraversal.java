// Problem Link: https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
// Given a Binary Tree, find its Boundary Traversal. The traversal should be in the following order:
// 1. Left Boundary: This includes all the nodes on the path from the root to the leftmost leaf node.
// You must prefer the left child over the right child when traversing. Do not include leaf nodes in this section.
//
// 2. Leaf Nodes: All leaf nodes, in left-to-right order, that are not part of the left or right boundary.
//
// 3. Reverse Right Boundary: This includes all the nodes on the path from the rightmost leaf node to the root,
// traversed in reverse order. You must prefer the right child over the left child when traversing.
// Do not include the root in this section if it was already included in the left boundary.
//
// Examples:
// Input: root[] = [1, 2, 3, 4, 5, 6, 7, N, N, 8, 9, N, N, N, N]
// Output: [1, 2, 4, 8, 9, 6, 7, 3]
//
// Input: root[] = [1, 2, N, 4, 9, 6, 5, N, 3, N, N, N, N 7, 8]
// Output: [1, 2, 4, 6, 5, 7, 8]
//
// Input: root[] = [1, N, 2, N, 3, N, 4, N, N]
// Output: [1, 4, 3, 2]

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

class Node {
  int data;
  Node left, right;

  public Node(int d) {
    data = d;
    left = right = null;
  }
}

public class FifteenBoundaryTraversal {

  // Left Boundary Traversal, no leaf nodes
  void fetchLeftBoundary(Set<Integer> traversal, Node node) {
    if (node == null || (node.left == null && node.right == null))
      return;

    traversal.add(node.data);

    if (node.left != null)
      fetchLeftBoundary(traversal, node.left);
    else if (node.right != null)
      fetchLeftBoundary(traversal, node.right);
  }

  // Right Boundary Traversal, in reverse order
  // no leaf nodes
  void fetchRightBoundary(Set<Integer> traversal, Node node) {
    if (node == null || (node.left == null && node.right == null))
      return;

    if (node.right != null)
      fetchRightBoundary(traversal, node.right);
    else if (node.left != null)
      fetchRightBoundary(traversal, node.left);

    traversal.add(node.data);
  }

  // Leaf nodes only
  void fetchLeafNodes(Set<Integer> traversal, Node node) {
    if (node == null)
      return;

    if (node.left == null && node.right == null)
      traversal.add(node.data);

    fetchLeafNodes(traversal, node.left);
    fetchLeafNodes(traversal, node.right);
  }

  ArrayList<Integer> boundaryTraversal(Node node) {
    Set<Integer> traversal = new LinkedHashSet<>();
    traversal.add(node.data);

    // Left boundary strictly for left subtree
    fetchLeftBoundary(traversal, node.left);

    fetchLeafNodes(traversal, node);

    // Right boundary strictly for right subtree
    fetchRightBoundary(traversal, node.right);

    return new ArrayList<>(traversal);
  }

}
