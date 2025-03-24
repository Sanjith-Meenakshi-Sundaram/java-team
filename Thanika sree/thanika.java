// Problem: Subarray Sum Equals K
// Question
// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals k.

// Example

// Input: nums = [1,1,1], k = 2
// Output: 2

// Input: nums = [1,2,3], k = 3
// Output: 2

import java.util.HashMap;

public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1);
        
        int count = 0, sum = 0;
        
        for (int num : nums) {
            sum += num;
            if (prefixSumMap.containsKey(sum - k)) {
                count += prefixSumMap.get(sum - k);
            }
            prefixSumMap.put(sum, prefixSumMap.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 3;
        System.out.println("Total subarrays with sum " + k + ": " + subarraySum(nums, k));
    }
}
