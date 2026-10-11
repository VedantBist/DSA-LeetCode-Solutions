
// https://leetcode.com/problems/sum-of-squares-of-special-elements/description/

class Solution {
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                ans = ans + (nums[i-1] * nums[i-1]);
            }
        }
        return ans;
    }
}