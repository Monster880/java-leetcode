class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int n = matrix.length, m = matrix[0].length;
        int row = 0, column = m-1;
        while(row < n && column >= 0){
            int temp = matrix[row][column];
            if(temp == target){
                return true;
            }else if(temp > target){
                column--;
            }else if(temp < target){
                row++;
            }
        }
        return false;
    }
}