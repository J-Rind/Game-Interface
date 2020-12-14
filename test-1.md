# Testing round 1 - Main Branch

## Classes
- Main
- Game
- Player
- Game State

## Logic to test
- Main creates an instance of game and allows users to enter input. As of now, the players can select play and quit on the main menu. When they hit play, they can enter their names on the screen. The playing state does not do anything except print player names yet.
- To test game, you just create a new instance of it and call the start() method. This will begin the game loop
- The player class is very simple. As of right now, we have 3 constructors to create players. The contstructors are a default with no params, one with a boolean for color, and one with a boolean for color and a string for name. Getters and setters can all be tested on there as well.
