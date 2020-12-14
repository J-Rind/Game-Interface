package com.company;

import java.util.ArrayList;
import java.util.Scanner;


public class Game {
    // Top level variables
    private GameState state;
    private Player playerWhite;
    private Player playerBlack;

    private Scanner scanner = new Scanner(System.in);

    public Game() {
        this.state = GameState.STARTING;
    }

    public void start() {
        startGameLoop();
    }

    private void startGameLoop() {
        do {
            startGame();
        } while (state != GameState.STOPPED);
    }

    private void startGame() {
        switch (state) {
            case STARTING:
                initializeGame();
                break;
            case MENU:
                handleMenuState();
                break;
            case PLAYING:
                runGameLoop();
                break;
            case STOPPED:
                stopGame();
                break;
            default:
                break;
        }
    }

    // Startup functions
    private void initializeGame() {
        printStartupMessages();
        state = GameState.MENU;
    }

    private void printStartupMessages() {
        System.out.println("--- Welcome to Chess! ---");
    }

    // Menu functions
    private void handleMenuState() {
        printMenuOptions();
        int choice = getMenuChoice();
        handleChoice(choice);
    }

    private void printMenuOptions() {
        System.out.println("1. New Game");
        System.out.println("2. Load Game");
        System.out.println("3. Exit");
    }

    private int getMenuChoice() {
        System.out.print("Please select a menu option (1-3): ");
        String input = scanner.nextLine();
        return parseInputMenuChoice(input);
    }

    private int parseInputMenuChoice(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            return -1;
        }
    }

    private void handleChoice(int choice) {
        switch (choice) {
            case 1:
                newGame();
                break;
            case 2:
                loadGame();
                break;
            case 3:
                stopGame();
                break;
            default:
                handleInvalidMenuChoice();
                break;
        }
    }

    private void handleInvalidMenuChoice() {
        System.out.println("Invalid menu option entered!");
    }

    // Playing functions
    private void startPlayingGame() {
        initializePlayers();
        welcomePlayers();
        state = GameState.PLAYING;

        System.out.println("Beginning play state (control+c to stop)");
    }

    private void initializePlayers() {
        // TODO: Create new players or load from a file
        System.out.println("Player 1, please enter your name:");
        String playerWhiteName = getPlayerName();
        this.playerWhite = new Player(true, playerWhiteName);
        
        System.out.println("Player 2, please enter your name:");
        String playerBlackName = getPlayerName();
        this.playerBlack = new Player(false, playerBlackName);
    }

    private void welcomePlayers() {
        System.out.println("Welcome " + playerWhite.getName() + " and " + playerBlack.getName() + "!");
    }

    private String getPlayerName() {
        return scanner.nextLine();
    }

    // New game
    private void newGame() {
        startPlayingGame();
    }

    // Load game
    private void loadGame() {
        System.out.println("This loads the game");
    }

    // Stop functions
    private void stopGame() {
        printStopMessages();
        scanner.close();
        state = GameState.STOPPED;
    }

    private void printStopMessages() {
        System.out.println("--- Thank you for playing! ---");
    }

    private void runGameLoop(){
        // Initialization
        int turn = 0;
        ArrayList<Piece> playerPieces = new ArrayList<Piece>();
        Board mBoard = new Board();
        Input whitePlayerInput = new Input(this.playerWhite);
        Input blackPlayerInput = new Input(this.playerBlack);
        King whitePlayerKing = findKing(playerWhite, mBoard);
        King blackPlayerKing = findKing(playerBlack, mBoard);
        // Loops if no player has won
        while(!playerWhite.isWon() && !playerBlack.isWon()){
            // Prints the board
            playerPieces = mBoard.showBoard();
            // If turn is even, white's turn.
            if(turn % 2 == 0){
                whitePlayerInput.getInput(playerPieces,mBoard,whitePlayerKing);
                whitePlayerInput.updateBoard(playerPieces, mBoard, whitePlayerKing);
            }
            else{
                blackPlayerInput.getInput(playerPieces,mBoard,blackPlayerKing);
                blackPlayerInput.updateBoard(playerPieces, mBoard, blackPlayerKing);

            }
            // Checkmate class goes here
            // If black is checkmated, playerWhite.setWon(true)
            // if white is checkmated, playerBlack.setWon(true)

            turn++;
        }
        state = GameState.STOPPED;
    }
    private King findKing(Player player, Board mBoard){
        King myKing = new King(0,0,"kg",false);
        // Loop to get current position of kings
        for(Square[] p : mBoard.squares) {
            for(int i = 0; i < 8; i++){
                try {
                    if(p[i].getPiece().getName().contains("kg") && p[i].getPiece().getColor() == player.getIsWhite())
                        myKing = (King) p[i].getPiece();
                } catch (Exception e) {
                    //System.out.println("Null");
                }   
            }
        }
        return myKing;
    }
}