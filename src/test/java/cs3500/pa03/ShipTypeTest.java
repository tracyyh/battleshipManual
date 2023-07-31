package cs3500.pa03;

import static cs3500.pa03.Model.ShipType.CARRIER;
import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa03.Model.ShipType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * tests the shiptype enumeration
 */
public class ShipTypeTest {
  ShipType type;

  /**
   * sets initial conditions
   */
  @BeforeEach
  public void setup() {
    type = CARRIER;
  }

  /**
   * tests the method toSize
   */
  @Test
  public void testToSize() {
    assertEquals(6, type.toSize());
  }
}
