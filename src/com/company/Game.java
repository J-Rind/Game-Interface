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
                // 1. Print board
                gameLoop();
                // 2. Accept input
                // 3. Handle input
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
        System.out.println("1. Start Game");
        System.out.println("2. Exit");
    }

    private int getMenuChoice() {
        System.out.print("Please select a menu option (1-2): ");
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
                startPlayingGame();
                break;
            case 2:
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

    // Stop functions
    private void stopGame() {
        printStopMessages();
        scanner.close();
        state = GameState.STOPPED;
    }

    private void printStopMessages() {
        System.out.println("--- Thank you for playing! ---");
    }

    private void gameLoop(){
        int turn = 0;
        ArrayList<Piece> currentPieces = new ArrayList<Piece>();
        ArrayList<Piece> playerPieces = new ArrayList<Piece>();
        Board mBoard = new Board();
        Input whitePlayerInput = new Input(this.playerWhite);
        Input blackPlayerInput = new Input(this.playerBlack);

        King whiteplayerking = new King(0, 0, "King", true);
        King blackplayerking = new King(0, 0, "King", true);

        // Loop to get current position of kings
        for(Square[] p : mBoard.squares) {
            for(int i = 0; i < 8; i++){
                try {
                    if(p[i].getPiece().getType().contains("King") && p[i].getPiece().getColor())
                        whiteplayerking = (King) p[i].getPiece();
                    else if(p[i].getPiece().getType().contains("King") && !(p[i].getPiece().getColor()))
                        blackplayerking = (King) p[i].getPiece();

                
                } catch (Exception e) {
                    //System.out.println("test");
                }
                
            }

        }
        playerPieces.addAll(mBoard.blackPiece);
        playerPieces.addAll(mBoard.whitePiece);


        while(!playerWhite.isWon() && !playerBlack.isWon()){
            // Prints the board
            currentPieces = mBoard.showBoard();
            // If turn is even, white's turn.
            if(turn % 2 == 0){
                whitePlayerInput.getInput(playerPieces,mBoard,whiteplayerking);
                whitePlayerInput.updateBoard(playerPieces, mBoard, whiteplayerking);
            }
            else{
                blackPlayerInput.getInput(playerPieces,mBoard,blackplayerking);
                blackPlayerInput.updateBoard(playerPieces, mBoard, whiteplayerking);

            }

            if(turn == 10)
                playerWhite.setWon(true);
            turn++;
        }
        state = GameState.STOPPED;
    }
}