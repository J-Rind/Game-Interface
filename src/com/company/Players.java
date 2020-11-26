
public class Player {
    private boolean turn = false;
    boolean white, black;
    boolean won;


    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public boolean isWon() {
        return won;
    }

    public void setWon(boolean won) {
        this.won = won;
    }

    //colors, true or false
    public Player(boolean color) {
        if (color){
            white = true;
            black = false;
        }else{
            black = true;
            white = false;
        }
    }

    public void whoseTurn(){
        turn = !turn;
    }

    //constructor
    public Player() {
    }
}

//get info from user
//validate input
//game over, check or checkmate : status, datatype isinchek isincheckmate

//error handling