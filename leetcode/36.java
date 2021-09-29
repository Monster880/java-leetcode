class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] >= '0' && board[i][j] <= '9'){
                    if(!getEffective(i, j, board)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean getEffective(int i, int j, char[][] board){
        for(int k = 0; k < board[i].length; k++){
            if(board[i][k] == board[i][j] && k != j){
                return false;
            }
        }
        for(int k = 0; k < board.length; k++){
            if(board[k][j] == board[i][j] && k != i){
                return false;
            }
        }
        int row = (i / 3) * 3;
        int column = (j / 3) * 3;
        for(int k1 = row; k1 < row + 3; k1++){
            for(int k2 = column; k2 < column + 3; k2++){
                if((board[k1][k2] == board[i][j]) && (k1 != i && k2 != j)){
                    return false;
                }
            }
        }
        return true;
    }
}