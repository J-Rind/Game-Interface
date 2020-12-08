package com.company;
import java.util.ArrayList;


public class Rook extends Piece {

    public Rook(int x, int y, String t, Boolean white) {
        super(x, y, t, white);
        ArrayList<Piece> pieces = new ArrayList<>();
        super.getRange(pieces);
    }


    public void getRange(ArrayList<Piece> arr){
        for (int x = this.getX() + 1, y = this.getY(); x < 8; x++) {
            if (getPiece(x,y, arr) == 0) {
                range.add(new int[] {x,y});
            }
            else if (getPiece(x,y, arr) == 1) {
                break;
            }
            else if (getPiece(x,y, arr) == 2) {
                range.add(new int[] {x,y});
                break;
            }
        }

        for (int x = this.getX() - 1, y = this.getY(); x > -1; x--) {
            if (getPiece(x,y,arr) == 0) {
                range.add(new int[] {x,y});
            }
            else if (getPiece(x,y,arr) == 1) {
                break;
            }
            else if (getPiece(x,y,arr) == 2) {
                range.add(new int[] {x,y});
                break;
            }
        }

        for (int x = this.getX(), y = this.getY() + 1; y < 8; y++) {
            if (getPiece(x,y,arr) == 0) {
                range.add(new int[] {x,y});
            }
            else if (getPiece(x,y,arr) == 1) {
                break;
            }
            else if (getPiece(x,y,arr) == 2) {
                range.add(new int[] {x,y});
                break;
            }
        }

        for (int x = this.getX(), y = this.getY() - 1; y > -1; y--) {
            if (getPiece(x, y,arr) == 0) {
                range.add(new int[]{x, y});
            } else if (getPiece(x, y,arr) == 1) {
                break;
            } else if (getPiece(x, y,arr) == 2) {
                range.add(new int[]{x, y});
                break;
            }
        }
    }

    public void moveTo(int x, int y, King myKing, ArrayList<Piece> arr){

        int[] myCoords = new int[]{this.getX(), this.getY()};
        int moved = 0;


        for (int[] coordinate : this.range) {
            if (coordinate[0] == x && coordinate[1] == y)
            {
                this.setX(x);
                this.setY(y);
                System.out.println("Piece Moved to: (" + x + "," + y + ")");

                moved++;
                break;
            }
        }

        if(moved != 1)
        {
            System.out.println("piece not moved, not in range");
        }

    }
}