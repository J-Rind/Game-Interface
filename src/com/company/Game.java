package com.company;

import java.util.Scanner;

public class Game {
    private GameState state;
    private boolean isRunning = false;

    public Game() {
        this.state = GameState.STARTING;
    }

    public void start() {
        startGameLoop();
    }

    private void startGameLoop() {
        isRunning = true;
        do {
            playGame();
        } while(isRunning);
    }

    private void playGame() {
        switch (state) {
            case STARTING:
                startGame();
                break;
            case MENU:
                handleMenuState();
                break;
            case PLAYING:
                break;
            case STOPPED:
                stopGame();
                break;
            default:
                break;
        }
    }

    // Startup functions
    private void startGame() {
        printStartupMessages();
        // TODO: Init the pieces
        // TODO: Render the board
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
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.close();
        return choice;
    }

    private void handleChoice(int choice) {
        switch (choice) {
            case 1:
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

    // Stop functions
    private void stopGame() {
        printStopMessages();
        isRunning = false;
    }

    
    private void printStopMessages() {
        System.out.println("--- Thank you for playing! ---");
    }
}
