
// https://leetcode.com/problems/4sum/description/

import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> ans = new ArrayList<>();

        // Step - 1] Sort the Array 
        Arrays.sort(nums);

        // Step - 2] Fix the 2 nos a and b

        for (int i = 0; i < nums.length - 3; i++) {
            // Duplicate checking for i

            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {
                // Duplicate checking for j

                if (j > i + 1 && nums[j] == nums[j-1]) {
                    continue;
                }

                // Step - 3] use Two pointers to find c and d
                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    // Use long to prevent int overflow

                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum < target) {
                        left++;
                    }
                    else if (sum > target) {
                        right--;
                    }
                    else {
                        // Add ans to the list
                        ans.add(Arrays.asList(
                            nums[i],
                            nums[j],
                            nums[left],
                            nums[right]
                        ));

                        left++;
                        right--;

                        // Check duplicates for left
                        while (left < right && nums[left] == nums[left-1]) {
                            left++;
                        }

                        // Check dupliactes for right
                        while (left < right && nums[right] == nums[right+1]) {
                            right--;
                        }
                    }
                }
            }
        }

        return ans;
    }
}
