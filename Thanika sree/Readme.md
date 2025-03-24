# Subarray Sum Equals K

## Problem Statement
Given an array of integers `nums` and an integer `k`, find the total number of contiguous subarrays whose sum equals `k`.

## Example
```java
Input: nums = [1,1,1], k = 2
Output: 2

Input: nums = [1,2,3], k = 3
Output: 2
```

## Approach
To efficiently find the count of subarrays that sum to `k`, we use the **prefix sum with HashMap** approach.

### Steps:
1. Initialize a HashMap to store prefix sums and their frequencies.
2. Maintain a running sum (`sum`) as we iterate through `nums`.
3. At each step, check if `sum - k` exists in the HashMap.
   - If it exists, add the frequency of `sum - k` to the count.
4. Store and update the current `sum` in the HashMap.
5. Return the total count of valid subarrays.

## Complexity Analysis
- **Time Complexity**: `O(n)`, since we traverse the array once.
- **Space Complexity**: `O(n)`, for storing prefix sums in the HashMap.

## Java Implementation
```java
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
```

## Why is this an Important Interview Question?
- **Tests understanding of HashMap usage in prefix sum problems**.
- **Common in real-world applications** (e.g., finding patterns in financial data, logs, or streaming data).
- **Efficient compared to brute-force `O(n²)` approaches**.

## Edge Cases to Consider
- The array contains negative numbers.
- The array has only one element.
- The target sum `k` is zero.
- Large input sizes to test efficiency.

## Related Problems
- **Two Sum**
- **Longest Subarray with Sum K**
- **Maximum Size Subarray Sum Equals k**

