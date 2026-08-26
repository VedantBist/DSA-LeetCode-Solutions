package Medium;

//https://leetcode.com/problems/search-a-2d-matrix-ii/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int column = matrix[0].length - 1;

        while (row < matrix.length && column >= 0) {

            if (target > matrix[row][column]) {
                row++;
            }
            else if (target < matrix[row][column]) {
                column--;
            }
            else{
                return true;
            }
        }
        return false;
    }
}