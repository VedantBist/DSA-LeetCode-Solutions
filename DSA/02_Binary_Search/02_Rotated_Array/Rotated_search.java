
// https://leetcode.com/problems/search-in-rotated-sorted-array/description/

class Solution {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);

        if (pivot == -1) {
            return binarySearch(nums, target, 0, nums.length - 1);
        }

        if (nums[pivot] == target){
            return pivot;
        }

        if(target >= nums[0]){
            //Then definitely it will lie b/w 0 -> pivot-1
            return binarySearch(nums, target, 0, pivot-1);
        }

        //If above cases doesn't satisfy then definitely target lies b/w p+1 -> end
        return binarySearch(nums, target, pivot+1, nums.length-1);
    }

    public int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start)/2;
        //case 1] Pivot found and mid is the largest element
            if (mid<end && arr[mid]>arr[mid+1]){
                return mid;
            }
        //case 2] Pivot found and mid - 1 is the largest element
            if(start<mid && arr[mid-1]>arr[mid]) {
                return mid - 1; 
            }
        //case 3] Pivot is in the right half
            if(arr[mid] >= arr[0]){
                start = mid + 1;
            }
        //case 4] Pivot is in the left half
            else {
                end = mid - 1;
            }
        }
        return -1;
    }
    

    public int binarySearch(int[] arr, int target, int start, int end){

        while(start <= end) {
            int mid = start + (end-start)/2;

            if (target > arr[mid]){
                start = mid + 1;
            }
            else if (target < arr[mid]) {
                end = mid - 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
}

