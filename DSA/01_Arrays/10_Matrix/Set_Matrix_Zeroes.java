
// https://leetcode.com/problems/set-matrix-zeroes/description/

class Solution {
    public void setZeroes(int[][] matrix) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Step - 1] Remember orignal states of 1st Row
        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Step - 2] Remember orignal states of 1st Column
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // Step - 3] Create markers using first row and first column
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // Mark row marker
                    matrix[0][j] = 0; // Mark column marker
                }
            }
        }

        // Step - 4] Use markers to mark inner matrix -> 0
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                     matrix[i][j] = 0;
                }
            }
        }

        // Step - 5] Zero first row if it originally had zero
        if (firstRowZero) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }

        // Step - 6] Zero first column if it originally had zero
        if (firstColZero) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
