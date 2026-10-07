
// https://leetcode.com/problems/subarrays-with-k-different-integers/description/

import java.util.*;

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        
        return atMost(nums, k) - atMost(nums, k-1);
    }

    public int atMost(int[] nums, int k) {

        if (k < 0){
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int distinct = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {

            // Add the element
            int freq = map.getOrDefault(nums[right],0);

            if (freq == 0) {
                distinct++;
            }

            map.put(nums[right], freq + 1);

            // Shrink if window size exceeds k
            while (distinct > k) {

                int value = nums[left];

                map.put(value, map.get(value)-1);

                if (map.get(value) == 0) {
                    map.remove(value);
                    distinct--;
                }

                left++;
            }

            count = count + (right - left + 1);
        }

        return count;
    }
}
