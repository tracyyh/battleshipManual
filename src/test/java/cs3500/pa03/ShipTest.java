package cs3500.pa03;

import static cs3500.pa03.Model.ShipType.CARRIER;
import static cs3500.pa03.Model.ShipType.SUBMARINE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa03.Model.Coord;
import cs3500.pa03.Model.Ship;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * tests the Ship class
 */
public class ShipTest {
  String[][] board;
  Ship ship;
  Ship another;
  Ship horShip;
  Coord coord;

  /**
   * sets up initial conditions
   */
  @BeforeEach
  public void setup() {
    board = new String[5][5];
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        board[i][j] = "0  ";
      }
    }
    coord = new Coord(0, 0);
    ship = new Ship(coord, SUBMARINE,  "vertical");
    horShip = new Ship(coord, SUBMARINE, "horizontal");
    another = new Ship(null, CARRIER, "horizontal");
  }

  /**
   * tests the method getLetter
   */
  @Test
  public void testGetLet() {
    assertEquals("S", ship.getLetter());
  }

  /**
   * tests the method checkNull
   */
  @Test
  public void testCheckNull() {
    assertTrue(!ship.checkNull());
    assertTrue(another.checkNull());
  }

  /**
   * tests the method isShot
   */
  @Test
  public void testIsShot() {
    assertTrue(!ship.isShot(board, coord));
  }

  /**
   * tests the method placeOnBoard
   */
  @Test
  public void testPlaceOnBoard() {
    assertEquals(vertAlter(), ship.placeOnBoard(board));
    assertEquals(horAlter(), horShip.placeOnBoard(board));
  }

  /**
   * vertically alters the board
   *
   * @return board with placed boat
   */
  public String[][] vertAlter() {
    board[0][0] = "S  ";
    board[1][0] = "S  ";
    board[2][0] = "S  ";
    return board;
  }

  /**
   * horizontally alters the board
   *
   * @return board with placed boat
   */
  public String[][] horAlter() {
    board[0][0] = "S  ";
    board[0][1] = "S  ";
    board[0][2] = "S  ";
    return board;
  }
}
