/*
 * Problem Link:
 * https://www.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1
 * Given a string s. The task is to return a vector of string of all unique
 * permutations of the given
 * string, s that may contain duplicates in lexicographically sorted order.
 */

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class TenPermutations {

  void swapChars(StringBuilder stringBuilder, int indexOne, int indexTwo) {
    // Swap characters
    Character swap = stringBuilder.charAt(indexOne);
    stringBuilder.setCharAt(indexOne, stringBuilder.charAt(indexTwo));
    stringBuilder.setCharAt(indexTwo, swap);
  }

  void generatePermutation(StringBuilder stringBuilder, Set<String> result, int index) {

    // we have reached the last index
    // add to the set.
    if (index == stringBuilder.length()) {
      result.add(stringBuilder.toString());
      return;
    }

    // we swap characters and recurse to swap
    // further and add it to the set
    //
    // we swap back to return back to the original
    // state of the string for further computations
    for (int i = index; i < stringBuilder.length(); i++) {
      swapChars(stringBuilder, index, i);

      generatePermutation(stringBuilder, result, index + 1);

      swapChars(stringBuilder, index, i);
    }

  }

  public List<String> findPermutation(String s) {

    Set<String> resultSet = new HashSet<>();

    generatePermutation(new StringBuilder(s), resultSet, 0);

    List<String> result = new LinkedList<>(resultSet);

    Collections.sort(result);

    return result;

  }

}
