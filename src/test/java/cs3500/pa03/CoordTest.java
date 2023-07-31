package cs3500.pa03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa03.Model.Coord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * tests the Coord class
 */
public class CoordTest {
  Coord hitCoord;
  Coord nullCoord;
  String[][] board;

  /**
   * sets up initial conditions
   */
  @BeforeEach
  public void setup() {
    board = new String[5][5];
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        board[i][j] = "0";
      }
    }
    board[3][3] = null;
    hitCoord = new Coord(0, 1);
    nullCoord = new Coord(3, 3);
  }

  /**
   * tests the method updateHitStatus
   */
  @Test
  public void testHitStatus() {
    hitCoord.updateHitStatus();
    assertTrue(hitCoord.isHit);
  }

  /**
   * tests the method checkOngoing
   */
  @Test
  public void testOngoing() {
    assertEquals(0, hitCoord.checkOngoing(0));
    hitCoord.updateHitStatus();
    assertEquals(1, hitCoord.checkOngoing(0));
  }

  /**
   * tests the method showResults
   */
  @Test
  public void testShowResults() {
    assertEquals(showMiss(), hitCoord.showResults(board));
    hitCoord.updateHitStatus();
    assertEquals(showHit(), hitCoord.showResults(board));
  }

  /**
   * alters the board to show a hit
   *
   * @return the updated board
   */
  public String[][] showHit() {
    board[0][1] = "H  ";
    return board;
  }

  /**
   * alters the board to show a miss
   *
   * @return the updated board
   */
  public String[][] showMiss() {
    board[0][1] = "M  ";
    return board;
  }

  /**
   * tests the method checkHit
   */
  @Test
  public void testCheckHit() {
    assertTrue(!hitCoord.checkHit(board));
    assertTrue(nullCoord.checkHit(board));
  }
}
