package com.company;

import java.util.ArrayList;

public class SavedGame {
    private Board board;
    private int turn;
    private Player whitePlayer;
    private Player blackPlayer;
    private King whiteKing;
    private King blackKing;
    private ArrayList<Piece> pieces;

    public int getTurn() {
        return turn;
    }

    public Board getBoard() {
        return board;
    }

    public Player getWhitePlayer() {
        return whitePlayer;
    }

    public Player getBlackPlayer() {
        return blackPlayer;
    }

    public King getWhiteKing() {
        return whiteKing;
    }

    public King getBlackKing() {
        return blackKing;
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public SavedGame(Board board, int turn, Player whitePlayer, Player blackPlayer, King whiteKing, King blackKing, ArrayList<Piece> pieces){
        this.board = board;
        this.turn = turn;
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        this.whiteKing = whiteKing;
        this.blackKing = blackKing;
        this.pieces = pieces;
    }
}
