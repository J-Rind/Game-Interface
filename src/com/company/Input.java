package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Input {
    private String input;
    public Scanner scan;
    Piece piece;
    Player player;

    public Input(Player player){
        this.player = player;
    }
    public Input(){
    }
    public String getInput(ArrayList<Piece> arr, Board board, King myKing) {
        scan = new Scanner(System.in);
        System.out.print(this.player.getName() +" User Input: ");
        this.input = scan.nextLine();
        boolean validCheck = false;
        boolean validMove = false;
        validCheck = validInput(this.input);
        if(validCheck){
            validMove = isValidMove(arr, board, this.input, myKing);
        }
        while(!validCheck || !validMove){
            System.out.print(this.player.getName() +" User Input: ");
            this.input = scan.nextLine();
            validCheck = validInput(this.input);
            if(validCheck){
                validMove = isValidMove(arr, board, this.input, myKing);
            }
            
        }
        
        return input;
    }
    public void setInput(String input) {
        this.input = input;
    }
    

    public boolean validInput(String input) {
        if (input.equals("save")) {
            return true;
        }

        //testing if length of input is not equal to 4 (should be coord 1 then coord 2, aka e2e4 a2c3, etc), OR if the letters are not between a and h, OR if the numbers are not between 1 and 8
        if (input.length() != 4){
            System.out.print("\nInvalid Input\n\n");
            return false;
        }
        //using ascii code for this part
        else if (input.charAt(0) < 97 || input.charAt(0) > 104 || input.charAt(1) < 49 || input.charAt(1) > 56 || input.charAt(2) < 97 || input.charAt(2) > 104 || input.charAt(3) < 49 || input.charAt(3) > 56){
            System.out.print("\nInvalid Input\n\n");
            return false;
        }
        else {
            //printing out coords
            //System.out.print("\nX COORD 1: " + (input.charAt(0) - 97) + "\nY COORD 1: " + (input.charAt(1) - 49) + "\nX COORD 2: " + (input.charAt(2) - 97) + "\nY COORD 2: " + (input.charAt(3) - 49) + "\n");
            return true;
        }
    }

    public boolean isValidMove(ArrayList<Piece> arr, Board board, String input, King myKing){
        if (input.equals("save")) {
            return true;
        }

        int[] inverseBoard = new int[]{7,6,5,4,3,2,1,0};

        System.out.println(input);
        int value1 = input.charAt(0) - 97;
        int value2 = input.charAt(1) - 49;
        int value3 = input.charAt(2) - 97;
        int value4 = input.charAt(3) - 49;
        System.out.println(value1+" " + value2 +" "+ value3 +" "+ value4);

        Boolean valid = false;
        // Initial location of the piece
        int xCoordOne = inverseBoard[value2];
        int yCoordOne = value1;
        // Final location of the piece
        int xCoordTwo = inverseBoard[value4];
        int yCoordTwo = value3;
        System.out.println(xCoordOne +" "+ yCoordOne +" "+ xCoordTwo +" "+ yCoordTwo);

        // Finding the piece
        Piece myPiece = new Piece();
        myPiece = board.squares[xCoordOne][yCoordOne].getPiece();

        myPiece.updateRange(arr);

        for (int[] coordinate : myPiece.range) {
            if (coordinate[0] == xCoordTwo && coordinate[1] == yCoordTwo) {
                if(board.squares[xCoordOne][yCoordOne].getPiece().getColor() == this.player.getIsWhite())
                    valid = true;
                else{System.out.println("Not your piece");}
                
            }
        }
        myPiece.updateRange(arr);

        if (myKing.kingCheck(arr) == true)
        {
            System.out.println("Invalid move, king will be in check");
            valid = false;
        }
        if(board.whitePiece.contains(piece)){

        }

        if(valid == false){
            System.out.println("move not in range");
        }
        return valid;
    }

    public void updateBoard(ArrayList<Piece> arr, Board board, King myKing){
        // Initial location of the piece
        int xCoordOne = input.charAt(0) - 97;
        int yCoordOne = input.charAt(1) - 49;
        // Final location of the piece
        int xCoordTwo = input.charAt(2) - 97;
        int yCoordTwo = input.charAt(3) - 49;

        // Finding the piece
        Piece myPiece = new Piece();
        myPiece = board.squares[xCoordOne][yCoordOne].getPiece();

        // Changing the name of selected piece to update with moved location coordinates
        String newName = updateName(myPiece);
        myPiece.setName(newName);

        // Check to see if a piece is there and if it should be taken or not
        if (checkForPieceOnSquare(board, myPiece, xCoordTwo, yCoordTwo)) {
            myPiece.moveTo(xCoordTwo, yCoordTwo, myKing, arr);
            board.setPieceOnSquare(myPiece, xCoordTwo, yCoordTwo);
        }
    }

    public String updateName(Piece myPiece){
        char[] chararr = new char[12];
        // --B-rk1-A-8- is the naming style
        // To change A-8 to desired location remove the last 4 characters and update them
        for(int i = 0; i < myPiece.getName().length()-4; i++){
            chararr[i] = myPiece.getName().charAt(i);
        }
        chararr[myPiece.getName().length()-4] = (char) (input.charAt(2) - 32);
        chararr[myPiece.getName().length()-3] = '-';
        chararr[myPiece.getName().length()-2] = input.charAt(3);
        chararr[myPiece.getName().length()-1] = '-';
        String changeString = new String(chararr);
        return changeString;
    }

    public boolean checkForPieceOnSquare(Board board, Piece piece, int xCoord, int yCoord){
        Piece tempPiece = board.getSquares()[xCoord][yCoord].getPiece(); // temp variables for checking if there is a piece on the square
        // getPiece returns a 1 for white, a 2 for black, and a 0 for empty piece
        // if piece your piece is white, and the piece on square is white then error message
        // if your piece is the opposite color of the piece on the square, move your piece and take enemy piece
        if (piece.getColor() == tempPiece.getColor()){
            System.out.println("You cannot move there, that is your piece.");
            return false;
        }
        if (!tempPiece.getName().equals("__" + xCoord + "-" + yCoord + "__")){
            board.removePieceOnSpace(xCoord,yCoord);
            tempPiece.setIsAlive(false);
        }
        return true;
    }
}