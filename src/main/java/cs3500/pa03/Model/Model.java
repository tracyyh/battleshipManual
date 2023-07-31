package cs3500.pa03.Model;

import static cs3500.pa03.Model.GameResult.DRAW;
import static cs3500.pa03.Model.GameResult.LOSS;
import static cs3500.pa03.Model.GameResult.WIN;
import static cs3500.pa03.Model.ShipType.BATTLESHIP;
import static cs3500.pa03.Model.ShipType.CARRIER;
import static cs3500.pa03.Model.ShipType.DESTROYER;
import static cs3500.pa03.Model.ShipType.SUBMARINE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * represents the model of the program
 */
public class Model {
  private AIPlayer ai;
  private HumanPlayer human;
  private static String[][] aiBoard;
  public static String[][] userBoard;
  public static String[][] guessedBoard;
  private static String[][] availUserCoords;
  private static String[][] availAiCoords;
  public List<Ship> userShips;
  private List<Ship> aiShips;
  private String reason;
  private Random rand = new Random();
  private int h;
  private int w;
  static private List<Coord> humanShots = new ArrayList<>();
  static private List<Coord> aiShots = new ArrayList<>();
  static private List<Coord> humanIsHit = new ArrayList<>();
  static private List<Coord> aiIsHit = new ArrayList<>();
  static private int totalCoords = 0;

  /**
   * constructor
   */
  public Model() {
  }

  /**
   * constructor
   *
   * @param height of the board
   * @param width  of the board
   */
  public Model(int height, int width) {
    this.h = height;
    this.w = width;
  }

  /**
   * designates the name to the user
   *
   * @param name the name of the user
   */
  public void designateUserName(String name) {
    human = new HumanPlayer(name);
  }

  /**
   * generates the starter boards
   */
  public void generateOgBoard() {
    aiBoard = new String[h][w];
    userBoard = new String[h][w];
    availUserCoords = new String[h][w];
    availAiCoords = new String[h][w];
    guessedBoard = new String[h][w];
    for (int j = 0; j < aiBoard.length; j++) {
      for (int i = 0; i < aiBoard[j].length; i++) {
        aiBoard[j][i] = "0  ";
        availUserCoords[j][i] = "0  ";
        availAiCoords[j][i] = "0  ";
        userBoard[j][i] = "0  ";
        guessedBoard[j][i] = "0  ";
      }
    }
  }

  /**
   * makes the ships given the amount of desired fleets
   *
   * @param car number of carriers
   * @param bat number of battleships
   * @param des number of destroyers
   * @param sub number of submarines
   */
  public void makeShips(int car, int bat, int des, int sub) {
    userShips = new ArrayList<>();
    aiShips = new ArrayList<>();
    Map<ShipType, Integer> specs = new HashMap<>();
    specs.put(CARRIER, car);
    specs.put(BATTLESHIP, bat);
    specs.put(DESTROYER, des);
    specs.put(SUBMARINE, sub);
    sumTotalCoords(specs);

    ai = new AIPlayer();
    human = new HumanPlayer();
    ai.setHeightWidth(h, w);
    human.setHeightWidth(h, w);
    ai.setAvailCoords(availAiCoords);
    human.setAvailCoords(availUserCoords);
    userShips = human.setup(h, w, specs);
    aiShips = ai.setup(h, w, specs);
  }

  /**
   * finds the sum of the coordinates that are taken by ships
   *
   * @param specs a map of the ship types and their occurrences
   */
  public void sumTotalCoords(Map<ShipType, Integer> specs) {
    specs.forEach((ShipType, Integer) -> findSum(ShipType, Integer));
  }

  /**
   * updates the total coordinates
   *
   * @param type the ship type
   * @param num  the amount of times the ship type occurs
   */
  public void findSum(ShipType type, Integer num) {
    totalCoords = totalCoords + (type.toSize() * num);
  }

  /**
   * places the ships onto the board
   */
  public void placeShips() {
    userBoard = human.addShip(userBoard);
    aiBoard = ai.addShip(aiBoard);
  }

  /**
   * checks whether the lists of ships are null
   *
   * @return whether the lists of ships are null
   */
  public boolean checkLists() {
    return checkNull(userShips) || checkNull(aiShips);
  }

  /**
   * checks whether the given list of ships is null
   *
   * @param list the list to be checked
   * @return whether the given list of ships is null
   */
  public boolean checkNull(List<Ship> list) {
    boolean check = false;
    for (Ship s : list) {
      check = s.checkNull();
      if (check) {
        break;
      }
    }
    return check;
  }

  /**
   * the number of remaining ships
   *
   * @return the size of the list of ships
   */
  public int remainingShips() {
    return userShips.size();
  }

  /**
   * inputs the user's shots
   *
   * @param col the column the shot appears in
   * @param row the row the shot appears in
   */
  public void takeUserShots(int col, int row) {
    human = new HumanPlayer(row, col, humanShots, userShips);
    humanShots = human.takeShots();
  }

  /**
   * takes the ai's shots
   */
  public void takeAiShots() {
    ai = new AIPlayer(aiShots, aiShips);
    aiShots = ai.takeShots();
  }

  /**
   * shows the result of the hits
   */
  public void reportDamage() {
    humanIsHit = human.reportDamage(aiShots);
    for (Coord shot : humanIsHit) {
      userBoard = shot.showResults(userBoard);
    }
    aiIsHit = ai.reportDamage(humanShots);
    ai = new AIPlayer(guessedBoard);
    ai.successfulHits(aiIsHit);
  }

  /**
   * checks whether the ships have sunk
   *
   * @return whether the ship has sunk
   */
  public boolean ongoing() {
    return (sumOfHits(humanIsHit) < totalCoords) && (sumOfHits(aiIsHit) < totalCoords);
  }

  /**
   * returns the sum of the hits
   *
   * @param list the list of shots
   * @return the sum of hits
   */
  public int sumOfHits(List<Coord> list) {
    int sum = 0;
    for (Coord shot : list) {
      sum = shot.checkOngoing(sum);
    }
    return sum;
  }

  /**
   * appends the messages from the human and the ai
   *
   * @return the reason the game ended
   */
  public String appendReason() {
    reason = human.returnReason() + ai.returnReason();
    return reason;
  }

  /**
   * tells the user and ai that the game has ended and why
   */
  public void endGame() {
    if (sumOfHits(humanIsHit) > sumOfHits(aiIsHit)) {
      human.endGame(LOSS, human.name() + " loses! ");
      ai.endGame(WIN, "Ai wins!");
    } else if (sumOfHits(humanIsHit) < sumOfHits(aiIsHit)) {
      human.endGame(WIN, human.name() + " wins! ");
      ai.endGame(LOSS, "Ai loses!");
    } else {
      human.endGame(DRAW, "It's a draw!");
    }
    appendReason();
  }
}