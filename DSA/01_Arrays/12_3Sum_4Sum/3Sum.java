
// https://leetcode.com/problems/3sum/description/

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();

        // Step - 1] Sort the Array
        Arrays.sort(nums);

        // Step - 2] Fix the nums[i]
        for (int i = 0; i < nums.length - 2; i++) {

            // Check for duplicate i's
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            // Step - 3] Use two pointers to find the 2 nos that will make the sum 0
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum < 0) {
                    left++;
                }
                else if (sum > 0) {
                    right--;
                }
                else{
                    ans.add(Arrays.asList(
                        nums[i],
                        nums[left],
                        nums[right]
                    ));
                    //Move to new pairs
                    left++;
                    right--;

                    // Step - 4] Check for dupliacte left 
                    while (left < right && nums[left] == nums[left-1]){
                        left++;
                    }

                    // Step - 5] Check for duplicate right
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
        return ans;
    }
}
