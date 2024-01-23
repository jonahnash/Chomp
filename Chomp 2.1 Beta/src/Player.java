import java.awt.*;
import java.util.ArrayList;

public class Player {

    public Chip[][] gameBoard;
    public  ArrayList<Boards> ABL = new ArrayList<Boards>();


    public Player(){
        List myList = new List();
        ABL= myList.AB;
    }
    public Point move(Chip[][] pBoard){

        gameBoard = pBoard;
        Point myMove = new Point(0,0);
        //return a random move in the form of x, y or row, column



            int randomCol;
            int randomRow;

            do {
                randomRow = (int) (Math.random() * 10);
                randomCol = (int) (Math.random() * 10);
            }while(!gameBoard[randomRow][randomCol].isAlive);

            myMove = new Point(randomRow,randomCol);


        return myMove;
    }



}
