public class Board {

	private final int NUM_OF_COLUMNS = 7;
	private final int NUM_OF_ROW = 6;
	private char[][] board;

	/* 
	 * The board object must contain the board state in some manner.
	 * You must decide how you will do this.
	 * 
	 * You may add addition private/public methods to this class is you wish.
	 * However, you should use best OO practices. That is, you should not expose
	 * how the board is being implemented to other classes. Specifically, the
	 * Player classes.
	 * 
	 */

	public Board() {
		 //Board state is held in a 2d array.
		 board = new char[NUM_OF_ROW][NUM_OF_COLUMNS];
		 reset();
	}

	public void printBoard() {
		for(int i = 0; i < NUM_OF_ROW; i++){
			for(int j = 0; j < NUM_OF_COLUMNS; j++){
				if(i + 1 == NUM_OF_ROW && board[i][j] == ' '){
					System.out.print("|_");
				}
				else {
					System.out.print("|" + board[i][j]);
				}
			}
			System.out.println("|");
		}
	}

	public boolean containsWin() {

		//Horizontal check
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length - 3; j++){
				if(board[i][j] != ' '){
					if(board[i][j] == board[i][j + 1] && board[i][j + 1] == board[i][j + 2] && board[i][j + 2] == board[i][j + 3]){
						return true;
					}
				}
			}
		}

		//Vertical check
		for(int i = 0; i < board[0].length; i++){
			for(int j = 0; j < board.length - 3; j++){
				if(board[j][i] != ' '){
					if(board[j][i] == board[j + 1][i] && board[j + 1][i] == board[j + 2][i] && board[j + 2][i] == board[j + 3][i]){
						return true;
					}
				}
			}
		}

		//Diagonal check

		// Going "\"
		for(int i = 0; i < board.length - 3; i++){
			for(int j = 0; j < board[0].length - 3; j++){
				if(board[i][j] != ' '){
					if(board[i][j] == board[i + 1][j + 1] && board[i + 1][j + 1] == board[i + 2][j + 2] && board[i + 2][j + 2] == board[i + 3][j + 3]){
						return true;
					}
				}
			}
		}

		// Going "/"
		for(int i = 3; i < board.length; i++){
			for(int j = 0; j < board[0].length - 3; j++){
				if(board[i][j] != ' '){
					if(board[i][j] == board[i - 1][j + 1] && board[i - 1][j + 1] == board[i - 2][j + 2] && board[i - 2][j + 2] == board[i - 3][j + 3]){
						return true;
					}
				}
			}
		}

		return false;
	}

	//Assuming a tie is when all slots are filled and no winner has been declared.
	public boolean isTie() {
		//Counts all moves made, compares it to size of 2d array. If equal, the board is in a tie state.
		int moves = 0;
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				if(board[i][j] != ' '){
					moves++;
				}
			}
		}
		if(board[0].length * board.length == moves){
			return true;
		}
		else{
			return false;
		}
	}

	public void reset() {
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				board[i][j] = ' ';
			}
		}
	}

	public void move(char symbol, int move){
		//Makes move as made in Connect Four game.
		for(int i = board.length - 1; i >= 0; i--){
			if(board[i][move - 1] == ' '){
				board[i][move - 1] = symbol;
				return;
			}
		}
	}

	//Checks if a specific column has been filled. Useful for checking prior to making a move in that column.
	public boolean columnFilled(int move){
		for(int i = 0; i < board.length; i++){
			if(board[i][move - 1] == ' '){
				return false;
			}
		}
		return true;
	}

	//Checks if a win is available for both players.
	public int winAvailable(char symbol){
		for(int i = 0; i < board[0].length; i++){
			char[][] temp = new char[board.length][board[0].length];

			for(int x = 0; x < board.length; x++){
				for(int y = 0; y < board[0].length; y++){
					temp[x][y] = board[x][y];
				}
			}

			for(int j = temp.length - 1; j > 0; j--){
				if(temp[j][i] == ' '){
					temp[j][i] = symbol;
					break;
				}
			}

			if(arrayContainsWin(temp)){
				System.out.println("Making a winning move.");
				return i + 1;
			}
		}

		//Switching symbol to see if opponent has a win available.
		symbol = getOtherSymbol(symbol);
		if(symbol != 0) {

			for (int i = 0; i < board[0].length; i++) {
				char[][] temp = new char[board.length][board[0].length];

				for (int x = 0; x < board.length; x++) {
					for (int y = 0; y < board[0].length; y++) {
						temp[x][y] = board[x][y];
					}
				}

				for (int j = temp.length - 1; j > 0; j--) {
					if (temp[j][i] == ' ') {
						temp[j][i] = symbol;
						break;
					}
				}

				if (arrayContainsWin(temp)) {
					System.out.println("Blocking a winning move.");
					return i + 1;
				}
			}
		}

		return 0;
	}

	//Checks if a board has a win available.
	private boolean arrayContainsWin(char[][] board) {

		//Horizontal check
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length - 3; j++){
				if(board[i][j] != ' '){
					if(board[i][j] == board[i][j + 1] && board[i][j + 1] == board[i][j + 2] && board[i][j + 2] == board[i][j + 3]){
						return true;
					}
				}
			}
		}

		//Vertical check
		for(int i = 0; i < board[0].length; i++){
			for(int j = 0; j < board.length - 3; j++){
				if(board[j][i] != ' '){
					if(board[j][i] == board[j + 1][i] && board[j + 1][i] == board[j + 2][i] && board[j + 2][i] == board[j + 3][i]){
						return true;
					}
				}
			}
		}

		//Diagonal check

		// Going "\"
		for(int i = 0; i < board.length - 3; i++){
			for(int j = 0; j < board[0].length - 3; j++){
				if(board[i][j] != ' '){
					if(board[i][j] == board[i + 1][j + 1] && board[i + 1][j + 1] == board[i + 2][j + 2] && board[i + 2][j + 2] == board[i + 3][j + 3]){
						return true;
					}
				}
			}
		}

		// Going "/"
		for(int i = 3; i < board.length; i++){
			for(int j = 0; j < board[0].length - 3; j++){
				if(board[i][j] != ' '){
					if(board[i][j] == board[i - 1][j + 1] && board[i - 1][j + 1] == board[i - 2][j + 2] && board[i - 2][j + 2] == board[i - 3][j + 3]){
						return true;
					}
				}
			}
		}

		return false;
	}

	public int getBoardWidth(){
		return NUM_OF_COLUMNS;
	}

	//Returns the other symbol present on the board if there is one.
	private char getOtherSymbol(char symbol){
		//Switching the symbol
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				if(board[i][j] != symbol && board[i][j] != ' '){
					return board[i][j];
				}
			}
		}
		return 0;
	}
}
