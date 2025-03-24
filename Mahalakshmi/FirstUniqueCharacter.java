// Given a string s, find the first non-repeating character and return its index. If there is no non-repeating character, return -1.

// Example 1:
// Input: "leetcode"
// Output: 0

// Example 2:
// Input: "loveleetcode"
// Output: 2

// Example 3:
// Input: "aabb"
// Output: -1

import java.util.*;

public class FirstUniqueCharacter {
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (charCount.get(s.charAt(i)) == 1) {
                return i; 
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println("First non-repeating character index: " + firstUniqChar(s));
    }
}
