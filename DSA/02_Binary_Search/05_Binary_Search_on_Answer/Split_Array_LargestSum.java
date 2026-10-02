
// https://leetcode.com/problems/split-array-largest-sum/description/

class Solution {
    public int splitArray(int[] nums, int k) {
        
        int start = 0;
        int end = 0;
        
        for (int i=0;i<nums.length;i++) {
            if (nums[i]>start){
                start = nums[i];
            }
            end = end + nums[i];
        }
        
        while(start<end) {
            int mid = start + (end-start)/2;

            int sum = 0;
            int pieces = 1;
             
             for (int num:nums) {
                if (sum + num > mid){
                    sum = num;
                    pieces++;
                }
                else{
                    sum = sum + num;
                }
             }

             if (pieces > k) {
                start = mid + 1;
             }
             else{
                end = mid;
             }
        }
        return end;
    }
}
