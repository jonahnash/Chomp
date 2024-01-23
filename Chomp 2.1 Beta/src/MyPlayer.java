import java.awt.*;
import java.util.ArrayList;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;
    public ArrayList<Boards> AB2 = new ArrayList<Boards>();


    public MyPlayer() {
        columns = new int[10];
        List myList = new List();
        AB2=List.AB;
    }

    //add your code to return the row and the column of the chip you want to take.
    //you'll be returning a data type called Point which consists of two integers.
    public Point move(Chip[][] pBoard) {

        System.out.println("make a move");
        gameBoard = pBoard;
        convCol();
        int column = 0;
        int row = 0;

        //row = 1;
       // column =
        System.out.println(columns[0] +" " + columns[1] + " " +columns[2]);
        for(int x=0;x<AB2.size();x++){
          //  AB2.get(x).print();
            if(Integer.parseInt(String.valueOf(AB2.get(x).col.charAt(0)))==columns[0]&&Integer.parseInt(String.valueOf(AB2.get(x).col.charAt(1)))==columns[1]&&Integer.parseInt(String.valueOf(AB2.get(x).col.charAt(2)))==columns[2]){
                System.out.println("found match ");
                row=AB2.get(x).y;
                column=AB2.get(x).x;
            }
        }
        System.out.println("row= "+row+"col "+column);
        Point myMove = new Point(row, column);
        return myMove;
    }
    public void convCol(){
        for (int a = 0; a<= columns.length-1; a++){
            columns[a] = 0;
        }
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (gameBoard[r][c].isAlive) {
                    columns[c]++;
                }
            }
        }

    }

}
