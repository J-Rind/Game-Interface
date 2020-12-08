package com.company;

import java.util.ArrayList;

class King extends Piece {
    public King(int x, int y, String t, Boolean white) {
        super(x, y, t, white);
    }

    // Added King constructor 
    public King(){}

    // Params:
    // ArrayList<Piece> pieces: An ArrayList of all the pieces on the board
    // Returns:
    // boolean check: true = in-check; false = out-of-check
    public boolean kingCheck(ArrayList<Piece> pieces) {
        boolean check = false;
        int[] kingCoords = new int[]{this.getX(), this.getY()};

        for (Piece piece : pieces) {
            if (piece.getColor() != this.getColor()) {
                for (int[] coordinate : piece.range) {
                    if (coordinate[0] == kingCoords[0] && coordinate[1] == kingCoords[1]) {
                        check = true;
                        break;
                    }
                }
            }
        }
        return check;
    }
}
