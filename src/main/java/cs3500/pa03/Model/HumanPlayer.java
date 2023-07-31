package cs3500.pa03.Model;

import java.util.List;

/**
 * represents a human player
 */
public class HumanPlayer extends AbsPlayer {
  static private int x;
  static private int y;
  static private List<Coord> shots;
  static private String name;
  List<Ship> listOfShips;

  /**
   * constructor
   *
   * @param name name of the player
   */
  public HumanPlayer(String name) {
    this.name = name;
  }

  /**
   * constructor
   *
   * @param x     x-coordinate of the shot
   * @param y     y-coordinate of the shot
   * @param shots list of shots
   * @param ships list of ships
   */
  public HumanPlayer(int x, int y, List<Coord> shots, List<Ship> ships) {
    this.x = x;
    this.y = y;
    this.shots = shots;
    this.listOfShips = ships;
  }

  /**
   * constructor
   */
  public HumanPlayer() {
  }

  /**
   * returns the user's list of ships
   *
   * @return the user's list of ships
   */
  @Override
  public List<Ship> getListOfShips() {
    return listOfShips;
  }

  /**
   * returns the user's name
   *
   * @return the user's name
   */
  @Override
  public String name() {
    return name;
  }

  /**
   * adds the shot to the list of shots
   *
   * @return the updated list of shots
   */
  @Override
  public List<Coord> takeShots() {
    shots.add(new Coord(y, x));
    return shots;
  }

  /**
   * Reports to this player what shots in their previous volley returned from takeShots()
   * successfully hit an opponent's ship.
   *
   * @param shotsThatHitOpponentShips the list of shots that successfully hit the opponent's ships
   */
  @Override
  public void successfulHits(List<Coord> shotsThatHitOpponentShips) {
  }
}
