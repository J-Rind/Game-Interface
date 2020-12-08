package com.company;
import java.util.ArrayList;

public class Piece {
    private int X;
    private int Y;
    private String type;
    private Boolean isAlive;
    private Boolean isWhite;
    // Added name variable and set/get methods
    private String name;

    public ArrayList<int[]> range = new ArrayList<>();

    Piece(int x, int y, String t, Boolean white)
    {
        X = x;
        Y = y;
        type = t;
        isAlive = Boolean.TRUE;
        isWhite = white;
        range = new ArrayList<>();
    }

    Piece()
    {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    /*public void moveTo(int x, int y, King king, ArrayList<Piece> arr){
        if (range.contains()) //TO DO: fix contains function
        {
            if(king.kingCheck(arr) == false)
                {
                    setX(x);
                    setY(y);
                    System.out.println("Piece Moved to: (" + x + "," + y + ")");
                }
        }else{System.out.println("Invalid move");}
    } //function should change piece coordinates after error checking*/



    public void getRange (ArrayList<Piece> pieces){} //return type tbd, function should return the current range of movement for each piece, assuming empty board

    public boolean kingCheck(){return true;} //returns if this move will place the current player's king in check.

    public void print(){
        System.out.println("Coordinate: (" + X + "," + Y + ")");
        System.out.println("isWhite: " + isWhite);
        System.out.println("Type: " + type);
        System.out.println("Status: " + isAlive);



    }

    public int getPiece(int dX, int dY,ArrayList<Piece> arr)
    {
        for (int i =0; i < arr.size(); i++){
            if (arr.get(i).getX() == dX && arr.get(i).getY() == dY )
            {
                if (arr.get(i).getColor() == this.isWhite)
                {return 1;}
                else {return 2;}
            }


        }
        return 0;

    }

    public int getX(){return X;}
    public int getY(){return Y;}
    public String getType(){return type;}
    public Boolean getAlive(){return isAlive;}
    public Boolean getColor(){return isWhite;}

    public void setX(int x){X = x;}
    public void setY(int y){Y = y;}
    public void setType(String tipe){type = tipe;}
    public void setIsAlive(Boolean s){isAlive = s;}
    public void setIsWhite(Boolean a){isWhite = a;}
}