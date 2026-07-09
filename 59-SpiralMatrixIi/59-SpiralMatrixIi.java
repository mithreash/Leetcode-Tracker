// Last updated: 7/9/2026, 3:09:05 PM
class Solution {
    public int[][] generateMatrix(int n) {
        // Result matrix
        int[][] spiralMatrix = new int[n][n];

        // Directions: right, down, left, up
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // Current direction index
        int index = 0;

        // Number to be filled in the matrix
        int num = 1;

        // Boundaries of the current spiral layer
        int maxRows = n - 1;
        int minRows = 0;
        int maxCols = n - 1;
        int minCols = 0;

        // Start from top-left corner
        for (int row = 0, col = 0;
             row >= minRows && col >= minCols && row <= maxRows && col <= maxCols; ) {

            // Fill current cell
            spiralMatrix[row][col] = num++;

            // If moving right and reached right boundary,
            // turn down and shrink top boundary
            if (index == 0 && col == maxCols) {
                index++;
                minRows++;
            }

            // If moving down and reached bottom boundary,
            // turn left and shrink right boundary
            if (index == 1 && row == maxRows) {
                index++;
                maxCols--;
            }

            // If moving left and reached left boundary,
            // turn up and shrink bottom boundary
            if (index == 2 && col == minCols) {
                index++;
                maxRows--;
            }

            // If moving up and reached top boundary,
            // turn right and shrink left boundary
            if (index == 3 && row == minRows) {
                index = 0;
                minCols++;
            }

            // Move to next cell based on current direction
            row += directions[index][0];
            col += directions[index][1];
        }

        return spiralMatrix;
    }
}