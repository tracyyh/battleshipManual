
package cs3500.pa03;

import static cs3500.pa03.Model.ShipType.BATTLESHIP;
import static cs3500.pa03.Model.ShipType.CARRIER;
import static cs3500.pa03.Model.ShipType.DESTROYER;
import static cs3500.pa03.Model.ShipType.SUBMARINE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa03.Model.AIPlayer;
import cs3500.pa03.Model.AbsPlayer;
import cs3500.pa03.Model.Coord;
import cs3500.pa03.Model.HumanPlayer;
import cs3500.pa03.Model.Ship;
import cs3500.pa03.Model.ShipType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * tests the AbsPlayer class
 */

public class AbsPlayerTest {
  AbsPlayer user;
  AbsPlayer ai;
  String[][] board;
  Coord coord1;
  Coord coord2;


  /**
   * sets initial conditions
   */

  @BeforeEach
  public void setup() {
    user = new HumanPlayer();
    ai = new AIPlayer();
    board = new String[6][6];
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 6; j++) {
        board[i][j] = "0";
      }
    }
    coord1 = new Coord(3, 3);
    coord2 = new Coord(2, 1);
  }


  /**
   * tests the method setHW
   */
  @Test
  public void testSethw() {
    user.setHeightWidth(6, 6);
    ai.setHeightWidth(7, 6);
    assertEquals(7, user.getHeight());
    assertEquals(6, user.getWidth());
  }

  /**
   * test the designateLoc method
   */
  @Test
  public void testDesignateLoc() {
    user.setAvailCoords(board);
    assertTrue(!user.designateLoc(1, 0).isHit);
    assertTrue(!user.designateLoc(5, 0).isHit);
  }

  /**
   * tests the method designateDir
   */
  @Test
  public void testDesignateDir() {
    assertEquals("horizontal", user.designateDir(1));
  }

  /*
  @Test
  public void testAddShip() {
    user.setAvailCoords(board);
    List<Coord> listShots = new ArrayList<>();
    listShots.add(coord1);
    listShots.add(coord2);
    List<Ship> list = user.setup(6, 6, makeSpecs());
    user = new HumanPlayer(2, 1, listShots, list);
    assertEquals(board, user.addShip(board));
  }*/

  /*
  public Map<ShipType, Integer> makeSpecs() {
    Map<ShipType, Integer> specs = new HashMap<>();
    specs.put(SUBMARINE, 1);
    return specs;
  } */
}


