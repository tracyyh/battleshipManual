package cs3500.pa03;

import static cs3500.pa03.Model.GameResult.WIN;
import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa03.Model.GameResult;
import org.junit.jupiter.api.Test;

/**
 * tests the GameResult enumeration
 */
public class GameResultTest {
  GameResult result;

  /**
   * tests the creation of the GameResult enumeration
   */
  @Test
  public void createEnum() {
    result = WIN;
    assertEquals(WIN, result);
  }
}
