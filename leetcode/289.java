class Solution {
    public void gameOfLife(int[][] board) {
        int[] neighbors = {0, 1, -1};
        for(int row=0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                int liveNeighbors = 0;
                for(int i=0; i<3;i++){
                    for(int j=0; j<3; j++){
                        if(!(neighbors[i] == 0 && neighbors[j] == 0)){
                            int newr = row + neighbors[i];
                            int newc = col + neighbors[j];
                            if((newr < board.length && newr >= 0) && (newc < board[0].length && newc >=0) && (Math.abs(board[newr][newc]) == 1)){
                                liveNeighbors++;
                            }
                        }
                    }
                }
                if((board[row][col] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)){
                    board[row][col] = -1;
                }
                if(board[row][col] == 0 && liveNeighbors == 3){
                    board[row][col] = 2;
                }
            }
        }
        for(int row = 0; row < board.length; row++){
            for(int col =0; col < board[0].length; col++){
                if(board[row][col] > 0){
                    board[row][col] = 1;
                }else{
                    board[row][col] = 0;
                }
            }
        }
    }
}