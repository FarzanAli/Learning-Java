import java.util.Scanner;

public class HumanPlayer extends Player{

    public HumanPlayer(char symbol, Board board, String name){
        super(symbol, board, name);
    }

    public void makeMove(Board board){
        Scanner scanner = new Scanner(System.in);
        System.out.print(getName() + ", please enter your move: ");

        int move = scanner.nextInt();
        //Takes valid move input.
        while(move < 1 || move > 7 || board.columnFilled(move) && !board.isTie()){
            System.out.println("Invalid input.");
            System.out.print(getName() + ", please enter your move: ");
            move = scanner.nextInt();
        }
        board.move(symbol, move);
    }

}
