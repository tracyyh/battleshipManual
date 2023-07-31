package cs3500.pa03.Model;

/**
 * represents a ship
 */
public class Ship {
  private Coord location;
  public ShipType type;
  private String direction;

  /**
   * constructor
   *
   * @param location  of the ship
   * @param type      of ship
   * @param direction of the ship
   */
  public Ship(Coord location, ShipType type, String direction) {
    this.location = location;
    this.type = type;
    this.direction = direction;
  }

  /**
   * returns the letter associated with the ship's type
   *
   * @return the letter
   */
  public String getLetter() {
    return this.type.toString().substring(0, 1);
  }

  /**
   * places this ship of the given board
   *
   * @param board the board to be updated
   * @return updated board
   */
  public String[][] placeOnBoard(String[][] board) {
    for (int i = 0; i < type.toSize(); i++) {
      if (direction.equals("vertical")) {
        board = location.placeOnVertBoard(board, this.getLetter(), i);
      } else {
        board = location.placeOnHorBoard(board, this.getLetter(), i);
      }
    }
    return board;
  }

  /**
   * checks whether the location of the ship is null
   *
   * @return whether the location of the ship is null
   */
  public boolean checkNull() {
    return this.location == null;
  }

  /**
   * returns whether the ship is shot
   *
   * @param board the board the ship appears on
   * @param shot  the shot
   * @return whether the ship is shot
   */
  public boolean isShot(String[][] board, Coord shot) {
    return shot.checkHit(board);
  }
}
