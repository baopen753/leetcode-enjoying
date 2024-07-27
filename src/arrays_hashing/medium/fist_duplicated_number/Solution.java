package arrays_hashing.medium.fist_duplicated_number;


// Question: return the first duplicated number
// Given an array: [2,5,1,2,3,5,1,2,4]
// It should return: 2

// Given an array = [2,1,1,2,3,5,1,2,4]
// It should return: 1

// Given an array = [2,3,4,5]
// It should return: undefined

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {

        int[] numns = new int[]{2,5,1,2,3,5,1,2,4};
        int result = firstDuplicatedNumberC2(numns);
        System.out.println(result);  // 2

    }

    // c1: using a nested loop
    // time complexity: O(n^2) - quadratic
    // space complexity: O(2) - constant
    public static Integer firstDuplicatedNumberC1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return null;
    }

    /* c2: using Set data structure
     *  here is why: the word 'first' makes me coming up with looping. But how do we loop ?
     *  The 'bottleneck' of this problem is to identify when a number existed in second time.
     *  There are two states of an existing number: first presence & second presence
     *  By that way, I think the most appropriate data structure is SET,
     *  because SET isn't able to store 2 duplicated numbers
     */

    // time complexity: O(n)
    // space complexity: O(n)
    public static Integer firstDuplicatedNumberC2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num))  // O(1)
                return num;
            else
                set.add(num);
        }
        return null;
    }


}
