package Medium;

//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/

class Solution {
    public int findMin(int[] nums) {
        int pivot = findPivot(nums);
        if (pivot == -1) {
            return nums[0];
        }

        return nums[pivot + 1];
    }

    public int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
            int mid = start + (end-start)/2;

            //Case 1] mid is the pivot element
            if(mid<end && arr[mid] > arr[mid+1]){
                return mid;
            }
            //Case 2] mid - 1 is the pivot element
            if(start<mid && arr[mid-1]>arr[mid]) {
                return mid - 1;
            }
            //Case 3] Pivot is in left half
            if (arr[mid] >= arr[start]) {
                start = mid+1;
            }
            else {
                end = mid - 1;
            }
        }
        return -1;
    }
}