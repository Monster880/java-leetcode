n * m 矩阵 顺时针打印 输入 int

import java.util.*;

class Main{
    private static direction = new int[]{{0,1}, {1,0}, {0,-1}, {-1,0}}; //右下左上
    public int[] Matrix(int[][] matrix){
        int m = matrix.length, n = matrix[0].length
        int length = m * n;
        int index = 0;
        int directionIndex = 0;
        int x = 0, y =0;
        int[] res = new int[length];
        while(index < length){
            int dx = direction[directionIndex][0], dy = direction[directionIndex];
            int newx = x + dx, newy = y + dy;
            if(newx < 0 || newx >= m || newy < 0 || newy >= n || matrix[newx][newy] != -1){
                directionIndex++;
            }
            res[index++] = matrix[x][y];
            matrix[x][y] = -1;
            x = newx, y = newy;
        }
        return res;
    }
}
