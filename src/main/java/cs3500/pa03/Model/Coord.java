package cs3500.pa03.Model;

/**
 * represents a coordinate
 */
public class Coord {
  public boolean isHit = false;
  private int col;
  private int row;

  /**
   * contructor
   *
   * @param col the column that the coordinate appears
   * @param row the row that the coordinate appears
   */
  public Coord(int col, int row) {
    this.col = col;
    this.row = row;
  }

  /**
   * places this coordinate on the given board vertically
   *
   * @param board the board to be updated
   * @param s     a String representing the ship type
   * @param i     a counter
   * @return updated board
   */
  public String[][] placeOnVertBoard(String[][] board, String s, int i) {
    board[col + i][row] = s + "  ";
    return board;
  }

  /**
   * places this coordinate on the given board horizontally
   *
   * @param board the board to be updated
   * @param s     a String representing the ship type
   * @param i     a counter
   * @return updated board
   */
  public String[][] placeOnHorBoard(String[][] board, String s, int i) {
    board[col][row + i] = s + "  ";
    return board;
  }

  /**
   * updates the hit status
   */
  public void updateHitStatus() {
    isHit = true;
  }

  /**
   * returns an updated board based on whether the coordinate is a hit or miss
   *
   * @param board board to be updated
   * @return updated board
   */
  public String[][] showResults(String[][] board) {
    if (isHit) {
      return showHit(board);
    } else {
      return showMiss(board);
    }
  }

  /**
   * returns an updated board based on the hit
   *
   * @param board board to be updated
   * @return updated board
   */
  public String[][] showHit(String[][] board) {
    board[col][row] = "H  ";
    return board;
  }

  /**
   * returns an updated board based on the miss
   *
   * @param board board to be updated
   * @return updated board
   */
  public String[][] showMiss(String[][] board) {
    board[col][row] = "M  ";
    return board;
  }

  /**
   * check if this shot is a hit
   *
   * @param board board to be checked
   * @return whether the shot is a hit
   */
  public boolean checkHit(String[][] board) {
    return board[this.col][this.row] == null;
  }

  /**
   * returns a sum of the hits
   *
   * @param sum counter
   * @return sum of hits
   */
  public int checkOngoing(int sum) {
    if (isHit) {
      return sum + 1;
    } else {
      return sum;
    }
  }
}
