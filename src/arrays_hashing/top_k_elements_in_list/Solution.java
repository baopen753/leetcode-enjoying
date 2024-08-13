package arrays_hashing.medium.top_k_elements_in_list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        System.out.println("Hello world");
    }

    public int[] topKFrequent(int[] nums, int k) {


        HashMap<Integer, Integer> frequencySet = getFrequencySet(nums, k);
        List<Integer> frequencyValues = getFrequenciesValue(frequencySet);
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            Integer temp = findMax(frequencyValues);
            Integer key = findKeyBasedOnValue(frequencySet, temp);
            result.add(key);
            frequencySet.remove(key);
            frequencyValues.remove(temp);
        }


        return result.stream().mapToInt(i -> i).toArray();
    }

    public Integer findKeyBasedOnValue(HashMap<Integer, Integer> frequencies, Integer value) {
        Integer key = null;
        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            if (entry.getValue().equals(value)) key = entry.getKey();
        }
        return key;
    }

    public List<Integer> getFrequenciesValue(HashMap<Integer, Integer> frequencies) {

        // int[] arr = new int[frequencies.size()];
        ArrayList<Integer> arr = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            arr.add(entry.getValue());
        }
        return arr;
    }

    public HashMap<Integer, Integer> getFrequencySet(int[] nums, int k) {
        // create a HashMap structure to keep track of the frequency of each element in nums[]
        HashMap<Integer, Integer> frequencies = new HashMap<Integer, Integer>();

        // fetch values from nums[] to the HashMap
        for (int i = 0; i < nums.length; i++) {
            frequencies.put(nums[i], frequencies.getOrDefault(nums[i], 0) + 1);
        }
        return frequencies;
    }

    public Integer findMax(List<Integer> nums) {
        int max = nums.get(0);
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) > max) max = nums.get(i);
        }
        return max;
    }


}

