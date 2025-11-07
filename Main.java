package tictactoe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        Board board = new Board();

        System.out.println(board);
        while (!board.isEnded()) {

            int player = board.getCurrentPlayer();
            int row = 0;
            int col = 0;
            boolean invalidRow = false;
            boolean invalidCol = true;
            do{
                System.out.print("Player " + player + " enter row number:");
                try{row = Integer.valueOf(reader.nextLine());
                    invalidRow = false;
                }catch(NumberFormatException e){
                    System.out.println("Invalid row number");
                    invalidRow = true;}

            }while(invalidRow);

            do{
                System.out.print("Player " + player + " enter column number:");
                try {col = Integer.valueOf(reader.nextLine());
                    invalidCol = false;
                }catch (NumberFormatException e){
                    System.out.println("Invalid column number");
                    invalidCol = true;}
            }while (invalidCol);

            try {
                board.move(row, col);
                System.out.println(board);
            }catch (InvalidMoveException e){
                System.out.println(e.getMessage());
            }


        }


        reader.close();
    }


}