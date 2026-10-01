package Medium;

// https://leetcode.com/problems/rearrange-array-elements-by-sign/description/

class Solution {
    public int[] rearrangeArray(int[] nums) {
        
        int[] ans = new int[nums.length];
        int positive = 0;
        int negative = 1;

        for(int num : nums) {
            if (num > 0){
                // Positive numbers are at even indices
                ans[positive] = num;
                positive += 2;
            }
            else {
                // negative numbers are at odd indices
                ans[negative] = num;
                negative += 2;
            }
        }
        return ans;
    }
}