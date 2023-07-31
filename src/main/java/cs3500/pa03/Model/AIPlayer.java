package cs3500.pa03.Model;

import java.util.List;
import java.util.Random;

/**
 * represents an AI player
 */
public class AIPlayer extends AbsPlayer {
  private static List<Coord> shots;
  private String[][] board;
  List<Ship> listOfShips;

  /**
   * contructor
   */
  public AIPlayer() {
  }

  /**
   * contructor
   *
   * @param board this player's board
   */
  public AIPlayer(String[][] board) {
    this.board = board;
  }

  /**
   * contructor
   *
   * @param shots list of this player's shots
   * @param ships list of this player's ships
   */
  public AIPlayer(List<Coord> shots, List<Ship> ships) {
    this.shots = shots;
    this.listOfShips = ships;
  }

  /**
   * returns the ai's name
   *
   * @return the ai's name
   */
  @Override
  public String name() {
    return "AI";
  }

  /**
   * returns the ai's list of ships
   *
   * @return
   */
  @Override
  public List<Ship> getListOfShips() {
    return listOfShips;
  }

  /**
   * takes random shots
   *
   * @return the list of shots taken
   */
  @Override
  public List<Coord> takeShots() {
    Random rand = new Random();
    int x = rand.nextInt(w);
    int y = rand.nextInt(h);
    Coord shot = new Coord(y, x);
    if (!shots.contains(shot)) {
      shots.add(shot);
    } else {
      takeShots();
    }
    return shots;
  }

  /**
   * shows the successful hits that the user shot on the ai
   *
   * @param shotsThatHitOpponentShips the list of shots that successfully hit the opponent's ships
   */
  @Override
  public void successfulHits(List<Coord> shotsThatHitOpponentShips) {
    for (Coord shot : shotsThatHitOpponentShips) {
      board = shot.showResults(board);
    }
  }
}
