package com.company;

public boolean isCheckMate(King white, King black, ArrayList<Piece> pieces){
    if (white.kingCheck(pieces))
        return true;
    if(black.kingCheck(pieces))
        return true;  
    return false;  
}

