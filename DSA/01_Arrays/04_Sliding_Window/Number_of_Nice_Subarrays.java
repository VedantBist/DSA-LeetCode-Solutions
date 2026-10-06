
// https://leetcode.com/problems/count-number-of-nice-subarrays/description/

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        
        return atMost(nums, k) - atMost(nums, k-1);
    }

    public int atMost(int[] nums, int k) {

        int left = 0;
        int oddCount = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {

            if (nums[right] % 2 != 0) {
                oddCount++;
            }

            while (oddCount > k) {

                // Check if element leaving window is odd
                if (nums[left] % 2 != 0) {
                    oddCount--;
                }

                left++;
            }

            count = count + (right - left + 1);
        }
        return count;
    }
}