
// https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/description/

class Solution {
    public int[] replaceElements(int[] arr) {
        int maxSeen = -1;

        for (int i = arr.length - 1; i >= 0; i--) {
            int current = arr[i];
            arr[i] = maxSeen;
            maxSeen = Math.max(maxSeen, current);  
        }
        return arr;
    }
}