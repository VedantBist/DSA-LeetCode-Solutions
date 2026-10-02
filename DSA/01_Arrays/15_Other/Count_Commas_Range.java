
// https://leetcode.com/problems/count-commas-in-range/description/?envType=daily-question&envId=2026-09-08

class Solution {
    public int countCommas(int n) {
        return (n >= 1000) ? (n - 999) : 0;
    }
}