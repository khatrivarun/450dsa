// Problem Link: https://www.geeksforgeeks.org/problems/preorder-to-postorder4423/1
// Given an array arr[] of N nodes representing preorder traversal of some BST.
// You have to build the BST  from the given preorder traversal.
//
// In Pre-Order traversal, the root node is visited before the left child and
// right child nodes.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Node {
  int data;
  Node left, right;

  Node(int d) {
    data = d;
    left = right = null;
  }
}

public class SevenBuildPreorder {

  // In a preorder array, the first element is always the root and the first
  // element more than the root comes under the right tree. We can use that to
  // build left subtree recursively(from root + 1 to that pivot) and right subtree
  // recursively(pivot to end)
  public Node buildBstFromPreorderTraversal(List<Integer> traversal, int leftPointer, int rightPointer) {
    if (leftPointer > rightPointer)
      return null;

    Node node = new Node(traversal.get(leftPointer));

    if (leftPointer == rightPointer)
      return node;

    int mid = leftPointer + 1;
    for (; mid <= rightPointer; mid++) {
      if (traversal.get(mid) > node.data) {
        break;
      }
    }

    node.left = buildBstFromPreorderTraversal(traversal, leftPointer + 1, mid - 1);
    node.right = buildBstFromPreorderTraversal(traversal, mid, rightPointer);

    return node;
  }

  public Node Bst(int pre[], int size) {
    List<Integer> traversal = new ArrayList<>();
    for (Integer integer : pre)
      traversal.add(integer);

    return buildBstFromPreorderTraversal(traversal, 0, traversal.size() - 1);
  }

}
