
// https://leetcode.com/problems/missing-number/description/

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int num : nums) {
            sum = sum + num;
        }
        int ans = (n * (n+1)) / 2;
        return ans - sum;
    }
}