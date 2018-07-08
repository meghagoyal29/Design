package LeetCode.Design;

public class TicTacToe {
	int board[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
    public TicTacToe(int n) {
        board = new int[n][n];
        for(int row=0;row<n;row++) {
        	for(int col=0;col<n;col++) {
        		board[row][col]=0;
        	}
        }
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
    	board[row][col]=player;
        if(checkRow(row,player))return player;
        else if(checkCol(col,player))return player;
        else if(row==col&&checkLeftDiagonal(row,col,player)) return player;
        else if(row==(board.length-1-col)&&checkRightDiagonal(row,col,player)) return player;
        return 0;
        
    }
	private boolean checkRightDiagonal(int row, int col, int player) {
		for(int i=0;i<board.length;i++) {
			for(int j=board.length-1;j>=0;j--) {
				if(i==(board.length-1-j)&&!(board[i][j]==player)){
					return false;
				}
			}
		}
		return true;
	}
	private boolean checkLeftDiagonal(int row, int col, int player) {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board.length;j++) {
				if(i==j&&!(board[i][j]==player)){
					return false;
				}
			}
		}
		return true;
	}
	private boolean checkCol(int col, int player) {
		
		for(int row1=0;row1<board.length;row1++)
		{
			if(!(player==board[row1][col]))
				return false;
		}
		return true;
	}
	private boolean checkRow(int row, int player) {
		for(int col1=0;col1<board.length;col1++)
		{
			if(!(player==board[row][col1]))
				return false;
		}
		return true;
	}
}
