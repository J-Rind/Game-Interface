package com.company;

//import java.util.ArrayList;

public class Main { 
    public static void main(String[] args) {
        Game game = new Game();
        game.start();


        // Main is just for testing
        // I will update to gameLoop() at Game.java

        // ArrayList<Piece> currentPieces = new ArrayList<Piece>();
        // ArrayList<Piece> playerPieces = new ArrayList<Piece>();
        // Player whiteplyr = new Player(true, "whiteplayer");
        // Player blackplyr = new Player(false, "blackplayer");
        // Board mBoard = new Board();
        // Piece myPiece = new Piece();
        // Input whitePlayerInput = new Input(whiteplyr);
        // Input blackPlayerInput = new Input(blackplyr);

        // playerPieces.addAll(mBoard.blackPiece);
        // playerPieces.addAll(mBoard.whitePiece);

        // System.out.println(playerPieces.size());

        // currentPieces = mBoard.showBoard();
        // // whiteplayerking to keep track of the king
        // King whiteplayerking = new King(0, 0, "King", true);
        // King blackplayerking = new King(0, 0, "King", true);

        // // Loop to get current position of king 
        // for(Square[] p : mBoard.squares) {
        //     for(int i = 0; i < 8; i++){
        //         try {
        //             if(p[i].getPiece().getType().contains("King") && p[i].getPiece().getColor())
        //                 whiteplayerking = (King) p[i].getPiece();
        //             else if(p[i].getPiece().getType().contains("King") && p[i].getPiece().getColor())
        //                 blackplayerking = (King) p[i].getPiece();

                
        //         } catch (Exception e) {
        //             //System.out.println("test");
        //         }
                
        //     }

        // }


        //blackPlayerInput.getInput(playerPieces,mBoard,blackplayerking);

        //System.out.println(playerInput);

        /*
        for(Square[] p : mBoard.squares) {
            for(int i = 0; i < 8; i++){
                try {
                    if(p[i].getPiece().getType().contains("Rook") && (p[i].getPiece().getColor()== true))
                        myPiece = (Rook) p[i].getPiece();
                        break;
                
                } catch (Exception e) {
                    //System.out.println("test");
                }
                
            }

        }
        myPiece.print();
        myPiece.getRange(playerPieces);
        for (int[] coordinate : myPiece.range) {
            System.out.println(coordinate[0] + " " + coordinate[1]);
        }
        */

        // String playerInput = whitePlayerInput.getInput(playerPieces,mBoard,whiteplayerking);

        // System.out.println(playerInput);
        // whitePlayerInput.updateBoard(playerPieces, mBoard, whiteplayerking);

        // currentPieces = mBoard.showBoard();
        // myPiece = mBoard.squares[6][0].getPiece();
        // myPiece.print();

        // playerInput = whitePlayerInput.getInput(playerPieces,mBoard,whiteplayerking);

        // System.out.println(playerInput);
        // whitePlayerInput.updateBoard(playerPieces, mBoard, whiteplayerking);

        // currentPieces = mBoard.showBoard();
        // myPiece = mBoard.squares[6][0].getPiece();
        // myPiece.print();





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