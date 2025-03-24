# First Non-Repeating Character in a String

## Problem Statement
Given a string `s`, find the first non-repeating character and return its index. If there is no non-repeating character, return `-1`.

## Example
### Example 1:
```
Input: "leetcode"
Output: 0
```

### Example 2:
```
Input: "loveleetcode"
Output: 2
```

### Example 3:
```
Input: "aabb"
Output: -1
```

## Approach
1. Use a **HashMap** to store the frequency of each character in the string.
2. Iterate through the string again and check which character appears only once.
3. Return the index of the first such character.
4. If no unique character exists, return `-1`.

## Code Implementation (Java)
```java
import java.util.*;

public class FirstUniqueCharacter {
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> charCount = new HashMap<>();

        // Step 1: Count occurrences of each character
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Step 2: Find the first character with count == 1
        for (int i = 0; i < s.length(); i++) {
            if (charCount.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1; // No unique character found
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println("First non-repeating character index: " + firstUniqChar(s));
    }
}
```

## Complexity Analysis
- **Time Complexity:** `O(N)`, where `N` is the length of the string.
- **Space Complexity:** `O(1)`, since the maximum unique characters are limited (26 lowercase English letters).

## Why This Question Is Important?
- Tests **string manipulation** skills.
- Evaluates knowledge of **HashMaps** for **frequency counting**.
- Demonstrates an efficient approach compared to a brute-force `O(N²)` solution.

## Additional Enhancements
- **Optimize using an array instead of a HashMap** for fixed character set.
- **Extend the solution for Unicode characters** if needed.

## Related Questions
- "Find the First Unique Word in a Sentence"
- "Find the Most Frequent Character in a String"

