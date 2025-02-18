// Problem Link: https://www.geeksforgeeks.org/problems/merge-two-bst-s/1
// Given two BSTs, return elements of merged BSTs in sorted form.
//
// Examples:
// Input: root1 = [5, 3, 6, 2, 4] root2 = [2, 1, 3, N, N, N, 7, 6, N]
// Output: [1, 2, 2, 3, 3, 4, 5, 6, 6, 7]
//
// Input: root1 = [12, 9, N, 6, 11] root2 = [8, 5, 10, 2]
// Output: [2, 5, 6, 8, 9, 10, 11, 12]

import java.util.ArrayList;
import java.util.Collections;

class Node {
  int data;
  Node left, right;

  public Node(int d) {
    data = d;
    left = right = null;
  }
}

public class TenMerge {

  public void inOrderTraversal(Node node, ArrayList<Integer> traversal) {
    if (node == null)
      return;

    inOrderTraversal(node.left, traversal);
    traversal.add(node.data);
    inOrderTraversal(node.right, traversal);
  }

  // Inorder and then sort
  public ArrayList<Integer> merge(Node root1, Node root2) {
    ArrayList<Integer> traversal = new ArrayList<>();

    inOrderTraversal(root1, traversal);
    inOrderTraversal(root2, traversal);

    Collections.sort(traversal);

    return traversal;

  }

}
