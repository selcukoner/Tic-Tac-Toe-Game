import java.util.InputMismatchException;
import java.util.Scanner;

public  class Player {
    char markSymbol;
    PlayerType playerType;// Human or Computer
    boolean[][] isMarkedCell = new boolean[Board.SIZE][Board.SIZE];
    //initializes marks of player on spots
    //set all false as no spot at the beginning 
    {
      for(int i=0; i<Board.SIZE;i++){
          for(int j=0;j<Board.SIZE;j++){
              isMarkedCell[i][j]=false;
          }
      }
    }
    Player(char markSymbol,PlayerType playerType){
        this.markSymbol=markSymbol;
        this.playerType=playerType;
    }

    public void markCell(int x, int y){
        Board.getInstance().markCell(x,y,markSymbol);
        isMarkedCell[x][y] =true;
    }

    //checks if player won the Game
    public boolean hasWonGame(){
        boolean rowCheck;
        boolean columnCheck;
        boolean firstDiagonalCheck=true; //  "\"
        boolean secondDiagonalCheck=true;//  "/"

        for(int i =0;i<Board.SIZE;i++){
            rowCheck=true;
            columnCheck=true;

            for(int j=0;j<Board.SIZE;j++){
                rowCheck =rowCheck && isMarkedCell[i][j];
                columnCheck=columnCheck && isMarkedCell[j][i];
            }
            firstDiagonalCheck = firstDiagonalCheck && isMarkedCell[i][i];
            secondDiagonalCheck =secondDiagonalCheck && isMarkedCell[(Board.SIZE-1)-i][i];

            if(rowCheck || columnCheck) return true;
        }
        return firstDiagonalCheck || secondDiagonalCheck;
    }

    public void play(){
        Scanner sc = new Scanner(System.in);
        int x=0,y=0;
        Board board =Board.getInstance();

        System.out.println(playerType +"'s turn.");
        if(playerType ==PlayerType.COMPUTER){
            do{
                x =(int)(Math.random()*Board.SIZE);
                y =(int)(Math.random()*Board.SIZE);
            }while (!board.isValidCoordinates(x,y));
        }else{ // if (playerType ==PlayerType.HUMAN)
            boolean isInputValid=false;
            while(!isInputValid || (!board.isValidCoordinates(x,y))){
                try{
                    System.out.println("Please enter valid coordinates.Numbers between 0 and 2. Also cell must be empty");
                    x=sc.nextInt();
                    y= sc.nextInt();
                    isInputValid=true;
                }catch (InputMismatchException e){
                    System.out.println("Input is not an int");
                }
                finally {
                    sc.nextLine(); // cleans up \n
                }
            }
        }

        this.markCell(x,y);
        board.displayBoard();

    }

}

