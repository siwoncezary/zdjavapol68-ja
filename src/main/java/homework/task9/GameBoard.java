package homework.task9;

import java.util.Arrays;

public class GameBoard {
    private PlayerMark[][] board;
    private final PlayerMark markOne;
    private final PlayerMark markTwo;

    public GameBoard(String playerOneName, String playerTwoName) {
        this.board = new PlayerMark[3][3];
        this.markOne = new PlayerMark(playerOneName,"X");
        this.markTwo = new PlayerMark(playerTwoName, "O");
    }

    /**
     * Metoda wstawia na planszy gry znacznik gracza
     * @param player
     * @param row
     * @param column
     */
    public void markAt(PlayerMark player, int row, int column){
        board[row][column] = player;
    }

    public PlayerMark[] getMarks() {
        return new PlayerMark[]{markOne, markTwo};
    }

    public void printPlayersMark(){
        for(PlayerMark[] row: board){
            for(PlayerMark cell: row){
                if (cell != null)
                System.out.print(cell.getName()+"\t\t");
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(PlayerMark[] row: board){
            for(PlayerMark cell: row){
                if (cell == null) {
                    sb.append("_");
                    sb.append(" ");
                } else {
                    sb.append(cell.toString());
                    sb.append(" ");
                }
            }
            sb.append("\b");
            sb.append("\n");
        }
        return sb.toString();
    }
}
