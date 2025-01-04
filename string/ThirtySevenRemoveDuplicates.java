/*
 * Problem Link: https://www.geeksforgeeks.org/problems/consecutive-elements2306/1
 * You are given a string s, consisting of lowercase alphabets. Your task is to 
 * remove consecutive duplicate characters from the string.
 *
 * Input: s = "aabb"
 * Output:  "ab"
 *
 * Input:s = "aabaa"
 * Output: "aba"
 *
 * Input: s = "abcddcba"
 * Output: "abcdcba"
 */

public class ThirtySevenRemoveDuplicates {

  public String removeConsecutiveCharacter(String s) {
    StringBuilder resultBuilder = new StringBuilder("");
    Character history = 'X';

    // Idea is to check against one bit
    // history and push it to string builder
    // and update history
    for (int i = 0; i < s.length(); i++) {
      Character character = s.charAt(i);

      if (!character.equals(history)) {
        history = character;
        resultBuilder.append(character);
      }
    }

    return resultBuilder.toString();
  }

}
