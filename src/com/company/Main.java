package com.company;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Game game = new Game();
        // game.start();

        ArrayList<Piece> currentPieces = new ArrayList<Piece>();

        ArrayList<Piece> playerPieces = new ArrayList<Piece>();


        

        Piece myPiece = new Piece();


        Player whiteplyr = new Player(true, "cyrone");
        Player blackplyr = new Player(false, "cyrus");
        Board mBoard = new Board();


        currentPieces = mBoard.showBoard();

        playerPieces.addAll(mBoard.blackPiece);
        playerPieces.addAll(mBoard.whitePiece);

        System.out.println(playerPieces.size());
        // System.out.println(currentPieces.get(0));
        // currentPieces.get(0).getRange();

        // mBoard.blackPiece.get(8).print();
        // mBoard.blackPiece.get(1).print();
        // mBoard.blackPiece.get(2).print();
        // mBoard.whitePiece.get(0).print();
        // System.out.println(mBoard.whitePiece.get(1).getName());

        
        
        mBoard.setPieceOnSquare(mBoard.blackPiece.get(8), 4, 4);
        mBoard.blackPiece.get(8).setX(4);
        mBoard.blackPiece.get(8).setY(4);
        mBoard.removePieceOnSpace(0, 1);

        mBoard.squares[1][0].getPiece().print();

        currentPieces = mBoard.showBoard();

        
        myPiece = playerPieces.get(0);

        myPiece.getRange(playerPieces);
        //currentPieces.get(0).print();
        myPiece.print();
        System.out.println(myPiece.range.size());




       // System.out.println(mBoard.squares[0][0].getPiece().getName());
        //Rook rookTest = new Rook(0, 0, "Rook", false);
        
        //System.out.println(mBoard.squares[0][0].getPiece().range.get(0));
        // for(Piece p : mBoard.blackPiece){
        //     System.out.println(p);
        // }
       
        //System.out.println(mBoard.blackPiece.get(0).range.size());


        // int turn = 0;
        // Input whitePlayerInput = new Input(whiteplyr.getName());
        // Input blackPlayerInput = new Input(blackplyr.getName());
        // while(!whiteplyr.isWon() && !blackplyr.isWon()){
        //     // If turn is even, turn is white
        //     if(turn % 2 == 0){
        //         whitePlayerInput.getInput();
        //         }
        //     else{
        //         blackPlayerInput.getInput();
        //     }

        //     if(turn == 10){
        //         whiteplyr.setWon(true);
        //     }
        //     currentPieces = mBoard.showBoard();

        //     turn++;
        // }



               
    


    }
}