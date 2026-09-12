package Medium;

// https://leetcode.com/problems/container-with-most-water/description/

class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, max = 0;

        while (left < right) {
            int width = right - left;
            int h = Math.min(height[left], height[right]);

            max = Math.max(max, width * h);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}
