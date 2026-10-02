package Medium;

// https://leetcode.com/problems/koko-eating-bananas/

  class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;  
        int max = 0;
        for (int i = 0; i < piles.length; i++) {
        max = Math.max(max, piles[i]);
        }
        int end = max; 

        int ans = end;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (canFinish(piles, h, mid)) {
                ans = mid;     
                end = mid - 1;
            } else {
                start = mid + 1; 
            }
        }
        return ans;
    }

    public boolean canFinish(int[] piles, int h, int k) {
        long hours = 0;
        for (int pile : piles) {
            hours = hours + pile / k;
            if (pile % k != 0) {
                hours++;
            }
        }
        return hours <= h;
    }
}
