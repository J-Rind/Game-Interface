package com.company;
import java.util.ArrayList;


public class Pawn extends Piece {


    public Pawn(int x, int y, String t, Boolean white) {
        super(x, y, t, white);
    }

    @Override
    public void getRange(ArrayList<Piece> arr){
        this.range.clear();

        int X = this.getX();
        int Y = this.getY();
        int moved = 0;

        // Moving 2 spaces for first move
        if (moved != 0){                //??If piece has not been moved
            if (this.getColor()) {
                for (int x = X, y = Y + 1; y <= y + 2; y++) {
                    if (getPiece(x, y, arr) == 0) {
                        this.range.add(new int[]{x, y});
                    } else if (getPiece(x, y, arr) == 1 || getPiece(x, y, arr) == 2) {
                        break;
                    }
                }
            }else if (this.getColor() == false) {
                for (int x = X, y = Y; y <= y - 2; y-- ) {
                    if (getPiece(x, y, arr) == 0) {
                        this.range.add(new int[]{x, y});
                    } else if (getPiece(x, y, arr) == 1 || getPiece(x, y, arr) == 2) {
                        break;
                    }
                }
            }
        }
        else {
            if (this.getColor()){
                // Up-Right
                if (this.getPiece(X + 1, Y + 1, arr) == 2){
                    this.range.add (new int [] {X, Y});
                }
                // Up-Left
                if (this.getPiece(X - 1, Y + 1, arr) == 2){
                    this.range.add (new int [] {X, Y});
                }
                // Up
                if (this.getPiece(X, Y + 1, arr) == 0){
                    this.range.add (new int [] {X, Y});
                }
            }
            else if (!this.getColor()){
                // Down-Right
                if (this.getPiece(X + 1, Y - 1, arr) == 2){
                    this.range.add (new int [] {X, Y});
                }
                // Down-Left
                if (this.getPiece(X - 1, Y - 1, arr) == 2){
                    this.range.add (new int [] {X, Y});
                }
                // Down
                if (this.getPiece(X, Y + 1, arr) == 0){
                    this.range.add (new int [] {X, Y});
                }
            }
        }

    }
}