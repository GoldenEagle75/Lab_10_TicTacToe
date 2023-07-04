public class TicTacToe {
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String[][] board = new String[ROW][COL];

    private static void clearBoard(){
        for (int row = 0; row < ROW; row++){
            for (int col = 0; col < COL; col++){
                board[row][col] = " ";
            }
        }
    }

    private static void display(){
        for (int row = 0; row < ROW; row++){
            for (int col=0;col<COL;col++){
                if (col==2&&row!=2){
                    System.out.println(board[row][col]);
                    System.out.println("-------");
                }
                else if (col == 2) {
                    System.out.println(board[row][col]);
                }
                else if (col==0){
                    System.out.print(" "+board[row][col]+"|");
                }
                else {
                    System.out.print(board[row][col]+"|");
                }
            }
        }
    }

    private static boolean isValidMove(int row, int col){
        if (board[row][col]==" "){
            return true;
        }
        return false;
    }

    private static boolean isColWin(String player){
        int win = 0;

        for (int row = 0; row<ROW;row++){
            for (int col = 0; col<COL; col++){
                if (board[col][row]==player){
                    win += 1;
                }
            }
            if (win == 3){
                return true;
            }
            else {
                win = 0;
            }
        }
        return false;
    }

    private static boolean isRowWin(String player){
        int win = 0;

        for (int col = 0; col<COL;col++){
            for (int row = 0; row<ROW; row++){
                if (board[col][row]==player){
                    win += 1;
                }
            }
            if (win == 3){
                return true;
            }
            else {
                win = 0;
            }
        }
        return false;
    }

    private static boolean isDiagonalWin(String player){
        int win = 0;

        for (int row = 0; row<ROW;row++){
            if (board[row][row]==player){
                win += 1;
            }
        }
        if (win == 3){
            return true;
        }
        else {
            win = 0;
        }
        int row = 3;
        for (int col = 0; col<COL;col++){
            row -= 1;
            //System.out.printf("board[col, %s][row, %s]%n",col,row);
            if (board[col][row]==player){
                win += 1;
            }
        }

        if (win == 3){
            return true;
        }
        else {
            win = 0;
        }

        return false;
    }

    private static boolean isTie(){
        int end = 0;
        for (int col = 0; col < COL; col ++){
            for (int row = 0; row < ROW; row++){
                if (board[col][row].equals(" ")){
                    end++;
                    if (end == 9){
                        return false;
                    }
                }
            }
        }

        for (int row = 0; row < ROW; row++) {
            if (board[row][0].equals("X") && board[row][1].equals("O") && board[row][2].equals("X")) {
                return false;
            }
            if (board[row][0].equals("O") && board[row][1].equals("X") && board[row][2].equals("O")) {
                return false;
            }
        }

        for (int col = 0; col < COL; col++) {
            if (board[0][col].equals("X") && board[1][col].equals("O") && board[2][col].equals("X")) {
                return false;
            }
            if (board[0][col].equals("O") && board[1][col].equals("X") && board[2][col].equals("O")) {
                return false;
            }
        }

        if (board[0][0].equals("X") && board[1][1].equals("O") && board[2][2].equals("X")) {
            return false;
        }
        if (board[0][0].equals("O") && board[1][1].equals("X") && board[2][2].equals("O")) {
            return false;
        }
        if (board[0][2].equals("X") && board[1][1].equals("O") && board[2][0].equals("X")) {
            return false;
        }
        if (board[0][2].equals("O") && board[1][1].equals("X") && board[2][0].equals("O")) {
            return false;
        }

        return true;
    }

    private static boolean isWin(String player){
        if (isColWin(player)||isRowWin(player)||isDiagonalWin(player)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        clearBoard();
        /*for (int col = 2; col > -1; col--){
            board[col][col] = "X";
        }*/

        for (int col = 0; col < COL; col ++){
            for (int row = 0; row < ROW; row++){
                board[row][col]="X";
            }
        }

        display();
        //System.out.println(isTie());
    }
}
