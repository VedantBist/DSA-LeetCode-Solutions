
// https://leetcode.com/problems/sqrtx/description/

class Solution {
    public int mySqrt(int x) {
        int start = 1;
        int end = x;
        int ans = -1;

        if (x == 0){
            return 0;
        }

        while (start <= end ) {
            int mid = start + (end - start)/2;

            if (mid > x/mid) {
                end = mid - 1;
            }
            else if (mid == x/mid) {
                return mid;
            }
            else{
                ans = mid;
                start = mid + 1;
            }
        }
        return ans;
    }
}
