
// https://leetcode.com/problems/subarray-sums-divisible-by-k/

import java.util.*;
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();

        // Remainder 0 has a count of 1
        map.put(0,1);

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum = sum + num;

            int remainder = ((sum % k) + k) % k;

            if(map.containsKey(remainder)) {
                // Adding the frequency
                count = count + map.get(remainder);
            }

            map.put(remainder, map.getOrDefault(remainder,0) + 1);
        }

        return count;
    }
}