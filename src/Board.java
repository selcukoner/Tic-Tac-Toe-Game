public class Board {
    public static final int SIZE =3;
    private static Board boardInstance;
    private char[][] allCells =new char[SIZE][SIZE];
    private Board(){
        for(int i = 0; i< SIZE; i++){
            for(int j = 0; j< SIZE; j++){
                allCells[i][j]='-';
            }
        }
    }
    public static Board getInstance(){
        if(boardInstance ==null){
            boardInstance =new Board();
        }
        return boardInstance;
    }

    public boolean isValidCoordinates(int x,int y){
        if(x>=0 && x< SIZE && y>=0 && y< SIZE && allCells[x][y] =='-'){
            return true;
        }
        return false;
    }

    public boolean markCell(int x, int y, char markSymbol ) {
        if(isValidCoordinates(x,y)){
            allCells[x][y] = markSymbol;
            return true;
        }
        return false;
    }
    public char[][] getAllCells(){
        return allCells;
    }
    public void displayBoard(){
        System.out.print(" ");
        for(int i = 0; i< SIZE; i++){
            System.out.print(" "+i);
        }

        System.out.println();
        int j=0;
        for(char rows[]: allCells){
            System.out.print(j+" ");
            for(char columns: rows){
                System.out.print(columns+" ");
            }
            System.out.println();
            j++;
        }
        System.out.println();
    }

}
