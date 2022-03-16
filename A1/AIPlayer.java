import java.util.Random;

public class AIPlayer extends Player{

    public AIPlayer(char symbol, Board board, String name){
        super(symbol, board, name);
    }

    public void makeMove(Board board){

        if (board.winAvailable(symbol) != 0){
            //Checks if a win is available for AIPlayer and makes it. In the case the opponent has a winning move available,
            //AIPlayer blocks that move.
            board.move(symbol, board.winAvailable(symbol));
        }
        else{
            //Makes a random move if there is no winning or win blocking move available.
            Random rand = new Random();
            board.move(symbol, rand.nextInt(board.getBoardWidth()) + 1);
        }

    }

}