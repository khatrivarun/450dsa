// Problem Link: https://www.geeksforgeeks.org/problems/minimum-swap-required-to-convert-binary-tree-to-binary-search-tree/1
// Given an array arr[] which represents a Complete Binary Tree i.e, if index i is the parent, index 2*i + 1 is the left child
// and index 2*i + 2 is the right child. The task is to find the minimum number of swaps required to convert it into a Binary
// Search Tree.
//
// Examples:
// Input: arr[] = [5, 6, 7, 8, 9, 10, 11]
// Output: 3
//
// Input: arr[] = [1, 2, 3]
// Output: 1

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TwentyMinSwapsBST {

  // Inorder traversal to store elements in the list
  public static void inorderTraversal(int[] tree, int index, List<Integer> traversal) {
    if (index > tree.length)
      return;

    inorderTraversal(tree, 2 * index + 1, traversal);
    traversal.add(tree[index]);
    inorderTraversal(tree, 2 * index + 2, traversal);
  }

  public static int minSwaps(int[] arr) {
    int minimumSwaps = 0;

    // Step 1: Convert the tree into an array
    // by inorder traversal
    List<Integer> traversal = new ArrayList<>();
    inorderTraversal(arr, 0, traversal);

    // Step 2: Store the array in a list with its
    // indices and values in one space and sort
    // the array by value as this is the inorder
    // traversal expected out of a BST
    List<IndicesPair> sortedTraversal = new ArrayList<>();
    for (int i = 0; i < traversal.size(); i++)
      sortedTraversal.add(new IndicesPair(i, traversal.get(i)));
    Collections.sort(sortedTraversal, (pairOne, pairTwo) -> pairOne.value - pairTwo.value);

    // Step 3: Loop over the sorted array and
    // swap out wrong indices to reach the min
    // swaps condition
    for (int i = 0; i < traversal.size(); i++) {
      IndicesPair correctPair = sortedTraversal.get(i);
      int correctIndex = correctPair.index;

      if (correctIndex != i) {
        Collections.swap(sortedTraversal, i, correctIndex);
        minimumSwaps += 1;
        i -= 1;
      }
    }

    return minimumSwaps;
  }

}

// Data structure to store
// indices and values in a
// list
class IndicesPair {
  public int index;
  public int value;

  public IndicesPair(int index, int value) {
    this.index = index;
    this.value = value;
  }

  @Override
  public String toString() {
    return "Index = " + index + " Value = " + value;
  }

}
