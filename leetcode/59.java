class Solution {
    public int[][] generateMatrix(int n) {
        int maxNum = n * n;
        int curNum = 1;
        int[][] matrix = new int[n][n];
        int row = 0, column = 0;
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; //右下左上
        int directionIndex = 0;
        while(curNum <= maxNum){
            matrix[row][column] = curNum;
            curNum++;
            int nextRow = row + direction[directionIndex][0], nextColumn = column + direction[directionIndex][1];
            if(nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n || matrix[nextRow][nextColumn] != 0){
                directionIndex = (directionIndex + 1) % 4;
            }
            row = row + direction[directionIndex][0];
            column = column + direction[directionIndex][1];
        }
        return matrix;
    }
}