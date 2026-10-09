
// https://leetcode.com/problems/merge-intervals/description/

import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        
        // Step - 1] Sort the Array by starting number

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        List<int[]> merged = new ArrayList<>();

        for (int[] current : intervals) {

            // Case - 1] When the merged list is empty or doesn't overlap
            if (merged.isEmpty() || merged.get(merged.size()-1)[1] < current[0]) {
                merged.add(current);
            }
            else {
                // Case - 2] When the merged overlaps with current
                int[] last = merged.get(merged.size() - 1);
                last[1] = Math.max(last[1], current[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
