import java.util.Scanner;

public class Game {
    public void startGame(){
        Board board= Board.getInstance();
        Player player1= new Player('X',PlayerType.HUMAN);
        Player player2= new Player('O',PlayerType.COMPUTER);
        Scanner sc = new Scanner(System.in);

        board.displayBoard();
        while(true){
            player2.play();
            board.displayBoard();
            if(player2.hasWonGame()){
                System.out.println("Computer won the game");
                break;
            }
            if(isGameOver()){break;}

            player1.play();
            board.displayBoard();
            if(player1.hasWonGame()){
                System.out.println("You won the game");
                break;
            }
            if(isGameOver()){break;}
        }
    }
    private boolean isGameOver(){
        Board board = Board.getInstance();
        char[][] locations =board.getAllCells();
        for(char rows[]: locations){
            for(char column:rows){
                if(column == '-') return false;
            }
        }
        System.out.println("Game Over");
        return true;
    }
}
