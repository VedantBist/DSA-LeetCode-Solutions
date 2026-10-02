
//https://leetcode.com/problems/search-a-2d-matrix/description/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int totalRows = matrix.length;
        int totalColumns = matrix[0].length;

        //Calculating the total no of elements
        int n = totalRows * totalColumns;
        int start = 0;
        int end = n - 1;

        while(start <= end) {
            int mid = start + (end - start)/2;

            int rowIndex = mid / totalColumns;
            int columnIndex = mid % totalColumns;

            if (target > matrix[rowIndex][columnIndex]) {
                start = mid + 1;
            }
            else if (target < matrix[rowIndex][columnIndex]){
                end = mid - 1;
            }
            else {
                return true;
            }
        }
        return false; 
    }
}