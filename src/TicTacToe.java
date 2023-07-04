import java.util.Scanner;

public class TicTacToe {
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String[][] board = new String[ROW][COL];

    private static void clearBoard(){
        //cycles through both rows and columns, setting them to a space
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
                    //small line between so it looks more like a grid
                }
                else if (col == 2) {
                    System.out.println(board[row][col]);
                    //if it's on the third column, we need a newline
                }
                else if (col==0){
                    System.out.print(" " + board[row][col] + "|");
                    //small space before each leftmost one and also |
                }
                else {
                    System.out.print(board[row][col] + "|");
                }
            }
        }
    }

    private static boolean isValidMove(int row, int col){
        //if there's a blank space it returns true
        return board[row][col].equals(" ");
    }

    private static boolean isColWin(String player){
        int win = 0;

        for (int row = 0; row < ROW; row++){
            for (int col = 0; col < COL; col++){
                if (board[col][row].equals(player)){
                    win += 1;
                }//cycles through columns and rows, adding 1 to the win variable if there's an X or O there
            }
            if (win == 3){
                return true; //3 in a row
            }
            else {
                win = 0;
            }
        }
        return false;
    }

    private static boolean isRowWin(String player){
        int win = 0;

        for (int col = 0; col < COL; col++){
            for (int row = 0; row < ROW; row++){
                if (board[col][row].equals(player)){
                    win += 1;
                }//cycles through row + column
            }
            if (win == 3){
                return true;//3 in a row
            }
            else {
                win = 0;
            }
        }
        return false;
    }

    private static boolean isDiagonalWin(String player){
        int win = 0;

        for (int row = 0; row < ROW; row++){
            if (board[row][row].equals(player)){
                win += 1;
            }
        } //first checks if it's a left to right diagonal
        if (win == 3){
            return true;
        }
        else {
            win = 0;
        }
        int row = 3;
        for (int col = 0; col<COL;col++){
            row -= 1;
            //then right to left, row variable added because for loop was not needed
            if (board[col][row].equals(player)){
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

    private static boolean isTie() {
        boolean xFound;
        boolean oFound;

        // checks rows
        for (int row = 0; row < ROW; row++) {
            xFound = false;
            oFound = false;
            for (int col = 0; col < COL; col++) {
                if (board[row][col].equals("X")) {
                    xFound = true;
                } else if (board[row][col].equals("O")) {
                    oFound = true;
                }
            } //sees if rows have both x and o
            if (!xFound || !oFound) {
                return false;
            }
        }

        // checks if columns have both x and o
        for (int col = 0; col < COL; col++) {
            xFound = false;
            oFound = false;
            for (int row = 0; row < ROW; row++) {
                if (board[row][col].equals("X")) {
                    xFound = true;
                } else if (board[row][col].equals("O")) {
                    oFound = true;
                }
            }
            if (!xFound || !oFound) {
                return false;
            }
        }
        //checks if diagonals have both x and o
        xFound = false;
        oFound = false;
        for (int i = 0; i < ROW; i++) {
            if (board[i][i].equals("X")) {
                xFound = true;
            } else if (board[i][i].equals("O")) {
                oFound = true;
            }
        }
        if (!xFound || !oFound) {
            return false;
        }

        xFound = false;
        oFound = false;
        for (int i = 0; i < ROW; i++) {
            if (board[i][ROW - 1 - i].equals("X")) {
                xFound = true;
            } else if (board[i][ROW - 1 - i].equals("O")) {
                oFound = true;
            }
        }
        return xFound && oFound;
    }


    private static boolean isWin(String player) {
        return isColWin(player) || isRowWin(player) || isDiagonalWin(player); //cycles through all possible wins
    }


    public static void main(String[] args) {
/*
assuming that the pseudocode is only for outlining the main method and thus the other methods I've made will be used in the pseudocode

boolean done = false
num playerColMove
num playerRow Move
clearBoard()
String layer = "X"
boolean completed = false
do
    do
        do
            display()
            output "Enter a row for " + player
            input playerColMove
            output "Enter a column for " + player
            input playerRowMove
            if isValidMove(playerColMove, playerRowMove) then
                done = true
            else
                output "Enter a valid move to an unoccupied space."
                done = false
            end if
        while !done
        board[playerColMove][playerRowMove]=player
        if player = "X" then
            player = "O"
        else
            player = "X"
        end if
        if isWin("X") || isWin("O") || isTie() then
            completed = true
            if isWin("X") then
                output "X wins!"
            else if isWin("Y") then
                output "Y wins!"
            else if isTie() then
                output "A tie!"
            end if
        end if
    while !completed
while SafeInput.getYNConfirm(in, "Would you like to play again?")
 */
        //init variables
        boolean done;
        Scanner in = new Scanner(System.in);
        int playerColMove;
        int playerRowMove;
        clearBoard();
        String player="X";
        boolean completed = false;

        do {
            do {
                do {
                    display();
                    //gets input
                    playerColMove = SafeInput.getRangedInt(in,"Enter a row for " + player,1,3)-1;
                    playerRowMove = SafeInput.getRangedInt(in,"Enter a column for " + player,1,3)-1;
                    if (isValidMove(playerColMove, playerRowMove)){ //validity check
                        done = true;
                    }
                    else {
                        System.out.println("Enter a valid move to an unoccupied space.");
                        done = false;
                    }
                } while(!done);

                board[playerColMove][playerRowMove]=player;
                if (player.equals("X")) { //switch players
                    player = "O";
                }
                else {
                    player = "X";
                }

                if(isWin("X")||isWin("O")||isTie()){ //check for end of game
                    completed=true;
                    if (isWin("X")) {
                        System.out.println("X wins!");
                    }
                    else if (isWin("O")){
                        System.out.println("O wins!");
                    }
                    else if (isTie()){
                        System.out.println("A tie!");
                    }
                    display();
                }

            } while(!completed);
            clearBoard();
            completed = false;
            player = "X"; //reset variables
        } while(SafeInput.getYNConfirm(in,"Would you like to play again?"));
    }
}
