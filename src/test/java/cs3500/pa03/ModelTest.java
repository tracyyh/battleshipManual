package cs3500.pa03;

import static cs3500.pa03.Model.ShipType.CARRIER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa03.Model.Coord;
import cs3500.pa03.Model.HumanPlayer;
import cs3500.pa03.Model.Model;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * tests the model class
 */
public class ModelTest {
  MockModel model;
  Model real;
  Model real2;
  String[][] board;
  Coord coord1;
  Coord coord2;

  /**
   * sets up the initial conditions
   */
  @BeforeEach
  public void setup() {
    model = new MockModel();
    real = new Model();
    real2 = new Model(6, 7);
    board = new String[15][15];
    for (int i = 0; i < 15; i++) {
      for (int j = 0; j < 15; j++) {
        board[i][j] = "0  ";
      }
    }
    coord1 = new Coord(3, 3);
    coord2 = new Coord(2, 1);
  }

  /**
   * tests the designateUserName method
   */
  @Test
  public void testUserName() {
    model.designateUserName("Name");
    assertEquals("Name", model.human.name());
  }

  /**
   * tests the generateOgBoard method
   */
  @Test
  public void testGenerate() {
    model = new MockModel(5, 5);
    model.generateOgBoard();
    assertEquals(0, model.aiBoard.length);
  }

  /**
   * tests the findSum method
   */
  @Test
  public void testFindSum() {
    model.findSum(CARRIER, 3);
    assertEquals(0, model.totalCoords);
  }

  /**
   * tests the sumOfHits method
   */
  @Test
  public void testSumHits() {
    List<Coord> list = new ArrayList<>();
    list.add(coord1);
    list.add(coord2);
    assertEquals(0, model.sumOfHits(list));
  }

  /**
   * tests the method placeShips
   */
  @Test
  public void testPlaceShips() {
    real.makeShips(0, 0, 0, 0);
    real.placeShips();
    assertEquals(0, real.userBoard.length);
  }

  /**
   * tests the method remainingShips
   */
  @Test
  public void testRemainingShips() {
    real.makeShips(0, 0, 0, 0);
    assertEquals(0, real.remainingShips());
  }

  /**
   * tests the method ongoing
   */
  @Test
  public void testOngoing() {
    assertTrue(!real.ongoing());
  }

  /**
   * tests the method checkNull
   */
  @Test
  public void testCheckNull() {
    real.makeShips(0, 0, 0, 0);
    assertTrue(!real.checkNull(real.userShips));
  }

  /**
   * tests the method checkLists
   */
  @Test
  public void testCheckLists() {
    real.makeShips(0, 0, 0, 0);
    assertTrue(!real.checkLists());
  }
}
