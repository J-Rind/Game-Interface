package com.company;

import java.util.ArrayList;

public class GameLoader {
    private Board board;
    private Player whitePlayer;
    private Player blackPlayer;
    private ArrayList<Piece> pieces;

    public GameLoader() { }

    public void loadGameFromFile(String path) {
        try {

        } catch(Exception ex) {

        }
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

    public ArrayList<Piece> getPieces() {
        return pieces;
    }
}
