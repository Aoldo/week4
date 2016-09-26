package samples;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 *  TicTacToe using a class for the board.
 *
 *
 */
public class TicTacToeWithBoardClass {

    public static void main(String[] args) {
        new TicTacToeWithBoardClass().program();
    }

    final Random rand = new Random();

    void program() {
        // Comment out all below if testing
        String[] players = {"olle", "pelle"};
        char[] marks = {'X', 'O'};                       // Olle has X and pelle O
        int winner = -1;

        TicTacToeBoard board = new TicTacToeBoard();

        out.println("Welcome to Tic Tac Toe, board is ...");
        plotBoard(board);
        int actual = rand.nextInt(players.length);

        while (!board.isFull()) {
            // -- Input ----------
            int index = getPlayerSelection(players[actual], marks[actual]);

            // --- Process ----------
            if (board.isEmpty(index)) {
                board.positions[index] = marks[actual];
                if (board.hasWinner(marks[actual])) {
                    winner = actual;
                    break;
                }
            }
            // -- Output --------
            plotBoard(board);

            // Book keeping
            actual = (actual + 1) % players.length;
        }

        out.println("Game over!");
        plotBoard(board);
        if (winner >= 0) {
            out.println("Winner is " + players[winner]);
        } else {
            out.println("Draw");
        }
    }

    // --- Input/output is outside class
    int getPlayerSelection(String name, char mark) {
        out.println("Player is " + name + "(" + mark + ")");
        Scanner sc = new Scanner(in);
        out.print("Select position to put mark > ");
        return sc.nextInt();
    }

    void plotBoard(TicTacToeBoard b) {
        for (int i = 0; i < b.positions.length; i++) {
            out.print(b.positions[i] + " ");
            if ((i + 1) % 3 == 0) {
                out.println();
            }
        }
    }

    // ------- Boards class ----------------

    class TicTacToeBoard {

        char[] positions = {'-', '-', '-', '-', '-', '-', '-', '-', '-'}; // Logical positions

        // Instance methods below
        // Can't place any more marks if true
        boolean isFull() {
            for (int i = 0; i < positions.length; i++) {
                if (positions[i] == '-') {
                    return false;
                }
            }
            return true;
        }

        boolean hasWinner(char mark) {
            return hasUpDiagonal(mark) || hasDownDiagonal(mark)
                    || hasFullRow(mark) || hasFullColumn(mark);
        }

        boolean hasFullColumn(char mark) {
            for (int i = 0; i < 3; i++) {
                if (positions[i] == mark && positions[i + 3] == mark
                        && positions[i + 6] == mark) {
                    return true;
                }
            }
            return false;
        }

        boolean hasUpDiagonal(char mark) {
            return positions[6] == mark && positions[4] == mark
                    && positions[2] == mark;
        }

        boolean hasDownDiagonal(char mark) {
            return positions[0] == mark && positions[4] == mark
                    && positions[8] == mark;
        }

        boolean hasFullRow(char mark) {
            for (int i = 0; i < 3; i++) {
                if (positions[i * 3] == mark && positions[i * 3 + 1] == mark
                        && positions[i * 3 + 2] == mark) {
                    return true;
                }
            }
            return false;
        }

        // Is position "index" empty
        boolean isEmpty(int index) {
            return positions[index] == '-';
        }

    }
}