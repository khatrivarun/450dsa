// Problem Link:
// https://www.geeksforgeeks.org/problems/maximum-sum-of-non-adjacent-nodes/1
// Given a binary tree with a value associated with each node, we need to choose
// a subset of these nodes such that the sum of chosen nodes is maximum under a
// constraint that no two chosen nodes in the subset should be directly
// connected that is, if we have taken a node in our sum then we can’t take its
// any children or parents in consideration and vice versa

import javax.sound.midi.MetaEventListener;

class Node {
  int data;
  Node left, right;

  Node(int data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }
}

class SumPair {
  int firstSum, secondSum;

  SumPair(int firstSum, int secondSum) {
    this.firstSum = firstSum;
    this.secondSum = secondSum;
  }
}

public class TwentyEightSumNotAdjacent {

  static SumPair runMaxSum(Node node) {
    if (node == null)
      return new SumPair(0, 0);

    SumPair leftPair = runMaxSum(node.left);
    SumPair rightPair = runMaxSum(node.right);

    // Return a sum pair where you swap the second and first sums
    // and while doing that include the root's data in one of the
    // sums.
    SumPair finalSum = new SumPair(leftPair.secondSum + rightPair.secondSum + node.data,
        Math.max(leftPair.firstSum, leftPair.secondSum) + Math.max(rightPair.firstSum, rightPair.secondSum));

    return finalSum;
  }

  static int getMaxSum(Node root) {
    SumPair sumPair = runMaxSum(root);

    return Math.max(sumPair.firstSum, sumPair.secondSum);
  }

}
