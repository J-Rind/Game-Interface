package com.company;

import java.util.Scanner;

public class Input {
    private String input;
    public Scanner scan;
    private String playerName;
    Piece piece;
    Player player;
    public Input(String pName){
        this.playerName = pName;
    }
    public Input(){

    }
    public String getInput() {
        scan = new Scanner(System.in);
        System.out.print(this.playerName +" User Input: ");
        this.input = scan.nextLine();
        boolean validCheck = false;
        validCheck = validInput(this.input);
        while(!validCheck){
            System.out.print(this.playerName +" User Input: ");
            this.input = scan.nextLine();
            validCheck = validInput(this.input);
        }
        return input;
    }
    public void setInput(String input) {
        this.input = input;
    }
    

    public boolean validInput(String input) {
        //testing if length of input is not equal to 4 (should be coord 1 then coord 2, aka e2e4 a2c3, etc), OR if the letters are not between a and h, OR if the numbers are not between 1 and 8
        if (input.length() != 4){
            System.out.print("\nInvalid Input\n\n");
            return false;
        }
        //using ascii code for this part
        else if (input.charAt(0) < 97 || input.charAt(0) > 104 || input.charAt(1) < 49 || input.charAt(1) > 56 || input.charAt(2) < 97 || input.charAt(2) > 104 || input.charAt(3) < 49 || input.charAt(3) > 56){
            System.out.print("\nInvalid Input\n\n");
            return false;
        }
        else {
            //printing out coords
            //System.out.print("\nX COORD 1: " + (input.charAt(0) - 97) + "\nY COORD 1: " + (input.charAt(1) - 49) + "\nX COORD 2: " + (input.charAt(2) - 97) + "\nY COORD 2: " + (input.charAt(3) - 49) + "\n");
            return true;
        }
    }

    public boolean validMove(Board board, String input){
       int xCoordOne = (input.charAt(0) - 97);
       int yCoordOne = (input.charAt(0) - 49);
       int xCoordTwo = (input.charAt(0) - 97);
       int yCoordTwo = (input.charAt(0) - 49);
       

        return false;
    }
}