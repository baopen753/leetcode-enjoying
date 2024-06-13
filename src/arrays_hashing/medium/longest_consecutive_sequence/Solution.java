package arrays_hashing.medium.longest_consecutive_sequence;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;
// Continue optimizing


/*
* Scenario: Given an array of integers nums, return the length of the longest consecutive sequence of elements.
A consecutive sequence is a sequence of elements in which each element is exactly 1 greater than the previous element.
You must write an algorithm that runs in O(n) time.

Example 1:
Input: nums = [2,20,4,10,3,4,5]
Output: 4
*
*/


class Solution {

// I. Analyze: with algorithm runs in O(n) time  --->  can be understood that: using only 1 loop

    // 1. with the array: nums
    // + find Max
    // + find Min

    // 2. In ideal potential case:
    //   longest consecutive sequence:
    //   min, min + 1, min + 2 ,..., max -1, max
    //  --> length: max - min + 1

    // 3. eg: nums = [2,20,4,10,3,4,5]
    // min = 2, max = 20
    // --> ideal potential longest sequence:  2,3,4,5,...,18,19,20
    // --> real longest sequence:             2,3,4,5

    // Logic: Because we found the Max and the Min, that means we know the boundary of the longest consecutive
    // In worst case, the number of expected sequence(real) is equal with the length ideally (max-min+1)
    //  --> mean each number is a singleton sequence
    //  --> there is no consecutive sequence as well


    // Come up with an idea:
    // + fetch num[] into an Array:  by taking advantage of function: contains() - to check existence

    // + create a HashMap with   + key: starter value
    //                           + value: counting sequence number  - by checking contains() above


// II. Implementing

    public static void main(String[] args) {

        int[] nums = {0,3,2,5,4,6,1,1};

        // find max, min
        int min = findMin(nums);
        int max = findMax(nums);

        // convert nums[] into List
        List<Integer> numsList = fetchIntoArray(nums);

        // create List<Integer> with range [min,max]
        List<Integer> idealLongestSequence = IntStream.range(min, max + 1).boxed().toList();  // 2-20


        // create HashMap to keep track how long the sequence
        HashMap<Integer, Integer> trackingNums = new HashMap<Integer, Integer>();


        for (int i = 0; i < numsList.size(); i++) {
            if (numsList.contains(idealLongestSequence.get(i)) || numsList.contains(idealLongestSequence.get(i) + 1))
                trackingNums.put(idealLongestSequence.get(i), trackingNums.getOrDefault(idealLongestSequence.get(i), 0) + 1);
        }


        trackingNums.forEach((key, value) -> System.out.println("Key-value: " + key + " " + value));


    }

    public int longestConsecutive(int[] nums) {

        return 0;
    }

    public static List<Integer> fetchIntoArray(int[] nums) {
        return Arrays.stream(nums).boxed().toList();
    }

    public static int findMax(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) max = nums[i];
        }
        return max;
    }

    public static int findMin(int[] nums) {
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) min = nums[i];
        }
        return min;
    }


}
