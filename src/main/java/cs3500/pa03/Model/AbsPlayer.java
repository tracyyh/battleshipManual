package cs3500.pa03.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * represents a player
 */
abstract public class AbsPlayer implements Player {
  private Random rand = new Random();
  private List<Ship> listOfShips;
  static int h;
  static int w;
  private static String[][] availCoords;
  private int tries;
  private GameResult result;
  private String reason;

  /**
   * sets the players available coordinates
   *
   * @param availCoords coordinates to be set
   */
  public void setAvailCoords(String[][] availCoords) { // Add this method
    this.availCoords = availCoords;
  }

  /**
   * sets the height and width of the board
   *
   * @param height of the board
   * @param width  of the board
   */
  public void setHeightWidth(int height, int width) {
    h = height;
    w = width;
  }

  /**
   * sets up the list of ships
   *
   * @param height         the height of the board, range: [6, 15] inclusive
   * @param width          the width of the board, range: [6, 15] inclusive
   * @param specifications a map of ship type to the number of occurrences each ship should
   *                       appear on the board
   * @return the list of ships for this player
   */
  @Override
  public List<Ship> setup(int height, int width, Map<ShipType, Integer> specifications) {
    listOfShips = new ArrayList<>();
    specifications.forEach((ShipType, Integer) -> makeShips(ShipType, Integer));
    return listOfShips;
  }

  /**
   * makes a ship of the given type for a num amount of times
   *
   * @param type type of ship
   * @param num  occurences of this ship type
   */
  public void makeShips(ShipType type, Integer num) {
    tries = 0;
    for (int i = 0; i < num; i++) {
      int randDirection = rand.nextInt(2);
      Ship s = new Ship(designateLoc(type.toSize(), randDirection), type,
          designateDir(randDirection));
      listOfShips.add(s);
    }
  }

  /**
   * designates the location of the ship randomly
   *
   * @param size of the ship
   * @param dir  direction the ship is facing
   * @return the coordinate of the ship
   */
  public Coord designateLoc(int size, int dir) {
    boolean isAvail = true;
    int x;
    int y;

    if (dir == 0) {
      if ((h - size) == 0) {
        y = 0;
      } else {
        y = rand.nextInt(h - size);
      }
      x = rand.nextInt(w);
      isAvail = checkAvailability(y, x, size, 0);
    } else {
      if ((w - size) == 0) {
        x = 0;
      } else {
        x = rand.nextInt(w - size);
      }
      y = rand.nextInt(h);
      isAvail = checkAvailability(y, x, size, 1);
    }

    if (isAvail) {
      updateAvailability(y, x, size, dir);
      return new Coord(y, x);
    } else {
      tries++;
      if (tries < 200) {
        return designateLoc(size, dir);
      } else {
        return null;
      }
    }
  }

  /**
   * adds the ship onto the board
   *
   * @param board where the ship will be placed
   * @return updated board
   */
  public String[][] addShip(String[][] board) {
    for (Ship ship : listOfShips) {
      board = ship.placeOnBoard(board);
    }
    return board;
  }

  /**
   * checks the availability of a coordinate
   *
   * @param y    coordinate
   * @param x    coordinate
   * @param size of the ship
   * @param dir  direction the ship is facing
   * @return whether the ship can be placed on the board
   */
  private boolean checkAvailability(int y, int x, int size, int dir) {
    for (int k = 0; k < size; k++) {
      if (dir == 0 && availCoords[y + k][x] == null) {
        return false;
      }
      if (dir == 1 && availCoords[y][x + k] == null) {
        return false;
      }
    }
    return true;
  }

  /**
   * updates the availability of the coordinates
   *
   * @param y    coordinate
   * @param x    coordinate
   * @param size of the ship
   * @param dir  direction the ship is facing
   */
  private void updateAvailability(int y, int x, int size, int dir) {
    for (int j = 0; j < size; j++) {
      if (dir == 0) {
        availCoords[y + j][x] = null;
      } else {
        availCoords[y][x + j] = null;
      }
    }
  }

  /**
   * designates the direction of the ship
   *
   * @param dir previously randomly generated int, 0 or 1
   * @return direction of the ship
   */
  public String designateDir(int dir) {
    if (dir == 0) {
      return "vertical";
    } else {
      return "horizontal";
    }
  }

  /**
   * returns a list of updated coordinates and if they were a success
   *
   * @param opponentShotsOnBoard the opponent's shots on this player's board
   * @return a list of updated coordinates and if they were a success
   */
  @Override
  public List<Coord> reportDamage(List<Coord> opponentShotsOnBoard) {
    List<Coord> shots = new ArrayList<>();
    for (Ship s : getListOfShips()) {
      for (Coord shot : opponentShotsOnBoard) {
        if (s.isShot(availCoords, shot)) {
          if (!shots.contains(shot)) {
            shot.updateHitStatus();
            shots.add(shot);
          }
        } else {
          shots.add(shot);
        }
      }
    }
    return shots;

  }

  /**
   * gets the list of ships for this player
   *
   * @return the list of ships for this player
   */
  public abstract List<Ship> getListOfShips();

  /**
   * changes the board to reflect the successful and missed hits
   *
   * @param shotsThatHitOpponentShips the list of shots that successfully hit the opponent's ships
   */
  @Override
  public abstract void successfulHits(List<Coord> shotsThatHitOpponentShips);

  /**
   * Notifies the player that the game is over.
   * Win, lose, and draw should all be supported
   *
   * @param result if the player has won, lost, or forced a draw
   * @param reason the reason for the game ending
   */
  @Override
  public void endGame(GameResult result, String reason) {
    this.result = result;
    this.reason = reason;
  }

  /**
   * returns the reason the game ended
   *
   * @return the reason the game ended
   */
  public String returnReason() {
    return reason;
  }

  /**
   * returns the height of the board
   *
   * @return height of the board
   */
  public int getHeight() {
    return h;
  }


  /**
   * returns the width of the board
   *
   * @return width of the board
   */
  public int getWidth() {
    return w;
  }
}


