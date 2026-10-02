import java.util.*;

// https://leetcode.com/problems/longest-consecutive-sequence/description/


class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set) {
            // Check for predecessor

            if (!set.contains(num - 1)) {
                int current = num;
                int length = 1;

                while (set.contains(current + 1)) {
                    current++;
                    length ++;
                }
                longest = Math.max(longest, length);
            }
        } 
        return longest;
    }
}