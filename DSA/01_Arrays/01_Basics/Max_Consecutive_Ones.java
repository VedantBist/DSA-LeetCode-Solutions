
// https://leetcode.com/problems/max-consecutive-ones/description/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int count = 0;

        for(int num : nums) {
            if (num == 0) {
                count = 0;
            }
            else {
                count ++;
            }

            if(ans < count) {
                ans = count;
            }
        }
        return ans;
    }
}
