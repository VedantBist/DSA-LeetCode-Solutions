
import java.util.*;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();     

        int left = 0;
        int ans = 0;

        for (int right=0; right<s.length(); right++) {
            
            // Add the incoming right element
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right),0)+1);

            // When the loop is invalid
            while(map.get(s.charAt(right)) > 1) {
                int frequency = map.get(s.charAt(left));

                if (frequency == 1){
                    map.remove(s.charAt(left));
                }
                else{
                    map.put(s.charAt(left), frequency-1);
                }
                left++;
            }

            // Update the answer
            ans = Math.max(ans, right-left+1);
        }
        return ans;
    }
}
