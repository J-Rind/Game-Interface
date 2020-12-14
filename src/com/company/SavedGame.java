package com.company;

import java.util.ArrayList;

public class SavedGame {
    private Board board;
    private Player whitePlayer;
    private Player blackPlayer;
    private ArrayList<Piece> pieces;

    public Board getBoard() {
        return board;
    }

    public Player getWhitePlayer() {
        return whitePlayer;
    }

    public Player getBlackPlayer() {
        return blackPlayer;
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public savedGame(Board board, Player whitePlayer, Player blackPlayer, ArrayList<Piece> pieces){
        this.board = board;
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        this.pieces = pieces;
    }
}
