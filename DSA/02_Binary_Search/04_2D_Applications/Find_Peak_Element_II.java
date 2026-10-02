
// https://leetcode.com/problems/find-a-peak-element-ii/description/

class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int start = 0;
        int end = mat.length - 1;

        while (start <= end) {

            // Binary search on rows
            int mid = start + (end - start) / 2;
            int row = mid;

            // Find maximum element in the current row
            int column = 0;
            int peak = mat[row][0];

            for (int i = 1; i < mat[0].length; i++) {
                if (mat[row][i] > peak) {
                    peak = mat[row][i];
                    column = i;
                }
            }

            // Handle top and bottom boundaries
            int top = (row == 0) ? -1 : mat[row - 1][column];
            int bottom = (row == mat.length - 1) ? -1 : mat[row + 1][column];

            // Current element is greater than both vertical neighbours
            // Since it is already the maximum of its row,
            // it is also greater than left and right.
            if (peak > top && peak > bottom) {
                return new int[] { row, column };
            }

            // Bottom is greater -> search lower half
            else if (bottom > peak) {
                start = mid + 1;
            }

            // Top is greater -> search upper half
            else {
                end = mid - 1;
            }
        }

        return new int[] { -1, -1 };
    }
}