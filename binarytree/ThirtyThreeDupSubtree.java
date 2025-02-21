// Problem Link: https://www.geeksforgeeks.org/problems/duplicate-subtrees/1
// Given a binary tree, your task is to find all duplicate subtrees from the
// given binary tree.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

public class ThirtyThreeDupSubtree {

  // Serialize the subtree, add it in the cache
  // and check if the cache already exists for a subtree
  //
  // if it exists, its a duplicate subtree
  String inOrderDuplicateChecker(Node node, HashMap<String, Integer> cache, List<Node> duplicateHeads) {
    if (node == null)
      return "N";

    StringBuilder builder = new StringBuilder();

    builder
        .append(inOrderDuplicateChecker(node.left, cache, duplicateHeads))
        .append(" ")
        .append(node.data)
        .append(inOrderDuplicateChecker(node.right, cache, duplicateHeads));

    if (cache.getOrDefault(builder.toString(), 0) == 1)
      duplicateHeads.add(node);

    cache.put(builder.toString(), cache.getOrDefault(builder.toString(), 0) + 1);

    return builder.toString();
  }

  public List<Node> printAllDups(Node root) {
    HashMap<String, Integer> cache = new HashMap<>();
    List<Node> duplicateHeads = new ArrayList<>();

    inOrderDuplicateChecker(root, cache, duplicateHeads);

    return duplicateHeads;
  }

}
