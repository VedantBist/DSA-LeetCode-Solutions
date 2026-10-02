
//https://leetcode.com/problems/find-numbers-with-even-number-of-digits/description/
// Leetcode problem: 1295

class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (even(nums[i]))
            {
                count++;
            }
        }
        return count;
    }

    public boolean even(int n){
        int no_of_digits = digits(n);
        return no_of_digits % 2 == 0;
    }

    public int digits(int n)
    {
        if (n == 0){
            return 1;
        }
        if (n < 0){
            n = n * -1;
        }
        int ans = 0;
        while(n>0)
        {
            ans++;
            n = n/10;
        }
        return ans;
    }
}