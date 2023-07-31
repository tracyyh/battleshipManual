package cs3500.pa03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa03.Control;
import cs3500.pa03.Model.Model;
import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * tests the control class
 */
public class ControlTest {
  MockControl control;
  Control real;
  Appendable appendable;
  private static final String VALUE = "input";

  @BeforeEach
  public void setup() {
    this.appendable = new StringBuilder();
    control = new MockControl(appendable);
  }
  /*
  @Test
  public void testWelcome() {
    assertEquals("", this.appendable.toString());
    control.run();
    try {
      appendable.append(VALUE);
    } catch (IOException e) {
      throw new RuntimeException(e.getMessage());
    }
    assertEquals(VALUE, this.appendable.toString());
  }

  @Test
  public void testRunValidDims() {
    assertEquals("", this.appendable.toString());
    control.runValidDims();
    try {
      appendable.append(VALUE);
    } catch (IOException e) {
      throw new RuntimeException(e.getMessage());
    }
    assertEquals(VALUE, this.appendable.toString());
  }

  @Test
  public void testCheckValidDims() {
    assertTrue(!control.checkValidDims());
    control.beginGame();
    assertTrue(control.checkValidDims());
  } */
}
