package cs3500.pa03;

import cs3500.pa03.Model.AIPlayer;
import cs3500.pa03.Model.Coord;
import cs3500.pa03.Model.HumanPlayer;
import cs3500.pa03.Model.Model;
import cs3500.pa03.Model.Ship;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * a mock model class
 */
public class MockModel extends Model {
  public AIPlayer ai;
  public static int height;
  public static int width;
  public HumanPlayer human = new HumanPlayer();
  public String[][] aiBoard = new String[height][width];
  public static String[][] userBoard;
  public static String[][] guessedBoard;
  public static String[][] availUserCoords;
  public static String[][] availAiCoords;
  public List<Ship> userShips;
  public List<Ship> aiShips;
  public String reason;
  public Random rand = new Random();
  public static List<Coord> humanShots = new ArrayList<>();
  public static List<Coord> aiShots = new ArrayList<>();
  public static List<Coord> humanIsHit = new ArrayList<>();
  public static List<Coord> aiIsHit = new ArrayList<>();
  public static int totalCoords = 0;

  public MockModel() {}

  public MockModel(int height, int width) {
    this.height = height;
    this.width = width;
  }
}
