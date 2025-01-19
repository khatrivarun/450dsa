
import java.util.LinkedList;
import java.util.List;

/*
 * Problem Link: https://www.geeksforgeeks.org/problems/majority-vote/1
 * You are given an array of integer arr[] where each number represents a vote to a candidate.
 * Return the candidates that have votes greater than one-third of the total votes, 
 * If there's not a majority vote, return an empty array.
 *
 * Examples:
 * Input: arr[] = [2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6]
 * Output: [5, 6]
 *
 * Input: arr[] = [1, 2, 3, 4, 5]
 * Output: []
 */

public class TwentyFiveNByK {

  // couldn't figure this one out
  // using Boyer-Moore’s Voting Algorithm
  // Illustration used to write code for:
  // https://www.geeksforgeeks.org/find-all-array-elements-occurring-more-than-%E2%8C%8An-3%E2%8C%8B-times/#expected-approach-moores-voting-algorithm-on-time-and-o1-space
  public List<Integer> findMajority(int[] nums) {
    List<Integer> resultList = new LinkedList<>();
    int n = nums.length;

    int candidateOne = -1, candidateTwo = -1, votesOne = 0, votesTwo = 0;

    for (Integer element : nums) {

      if (candidateOne == element) {
        votesOne += 1;
      } else if (candidateTwo == element) {
        votesTwo += 1;
      } else if (votesOne == 0) {
        candidateOne = element;
        votesOne += 1;
      } else if (votesTwo == 0) {
        candidateTwo = element;
        votesTwo += 1;
      } else {
        votesOne -= 1;
        votesTwo -= 1;
      }

    }

    votesOne = 0;
    votesTwo = 0;

    for (Integer element : nums) {
      if (element == candidateOne)
        votesOne += 1;
      if (element == candidateTwo)
        votesTwo += 1;
    }

    if (candidateOne < candidateTwo) {
      if (votesOne > n / 3)
        resultList.add(candidateOne);
      if (votesTwo > n / 3 && candidateOne != candidateTwo)
        resultList.add(candidateTwo);
    } else {
      if (votesTwo > n / 3)
        resultList.add(candidateTwo);
      if (votesOne > n / 3 && candidateOne != candidateTwo)
        resultList.add(candidateOne);
    }

    return resultList;
  }

}
