
// https://leetcode.com/problems/binary-subarrays-with-sum/description/

class Solution {
    public int numSubarraysWithSum(int[] nums, int k) {
        
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    public int atMost(int[] nums, int k) {

        if (k < 0) {
            return 0;
        }

        int left = 0;
        int sum = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {

            sum = sum + nums[right];

            while (sum > k) {
                sum = sum - nums[left];
                left++;
            }

            count = count + (right - left + 1);
        }
        return count;
    }
}