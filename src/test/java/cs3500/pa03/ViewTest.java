package cs3500.pa03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * tests the view class
 */
public class ViewTest {
  private View view;
  private String[][] aiBoard;
  private String[][] userBoard;
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  /**
   * sets up the initial conditions
   */
  @BeforeEach
  public void setup() {
    aiBoard = new String[5][5];
    userBoard = new String[5][5];
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        aiBoard[i][j] = "0";
        userBoard[i][j] = "0";
      }
    }
    view = new View();
    System.setOut(new PrintStream(outContent));
  }

  /**
   * test the method printWelcome
   */
  @Test
  public void testWelcome() {
    view.printWelcome();
    assertEquals("Hello! Welcome to the OOD BattleSalvo Game! Please enter your name."
        + "\n------------------------------------------------------\n", outContent.toString());
  }

  /**
   * tests the method askHeightWidth
   */
  @Test
  public void testHeightWidth() {
    view.askHeightWidth();
    assertEquals("Please enter a valid height and width below:"
        + "\n------------------------------------------------------\n", outContent.toString());
  }

  /**
   * tests the method printInvDim
   */
  @Test
  public void testPrintInvDim() {
    view.printInvDim();
    assertEquals("Uh Oh! You've entered invalid dimensions. Please remember that the "
        + "height and width\nof the game must be in the range (6, 15), inclusive. Try again!"
        + "\n------------------------------------------------------\n", outContent.toString());
  }

  /**
   * tests the method askFleetAmnts
   */
  @Test
  public void testFleetAmnts() {
    view.askFleetAmnts(5);
    assertEquals("Please enter your fleet in the order [Carrier, Battleship, Destroyer, "
        + "Submarine].\nRemember, your fleet may not exceed size 5."
        + "\n------------------------------------------------------\n", outContent.toString());
  }

  /**
   * tests the method printInvFlts
   */
  @Test
  public void testInvFlts() {
    view.printInvFlts();
    assertEquals("Uh Oh! You've entered invalid fleet sizes.\n", outContent.toString());
  }

  /**
   * tests the method printGame
   */
  @Test
  public void testPrintGame() {
    view.printGame(aiBoard, userBoard);
    assertEquals("Opponent Board Data:\n"
        + "00000\n" + "00000\n" + "00000\n" + "00000\n" + "00000\n"
        + "\nYour Board:\n" + "00000\n" + "00000\n" + "00000\n" + "00000\n" + "00000\n",
        outContent.toString());
  }

  /**
   * tests the method askShots
   */
  @Test
  public void testAskShots() {
    view.askShots(5);
    assertEquals("Please enter 5 shots:"
        + "\n------------------------------------------------------\n", outContent.toString());
  }

  /**
   * tests the method retryDims
   */
  @Test
  public void testRetry() {
    view.retryDims();
    assertEquals("Could not make unique board with given dimensions. Try larger"
        + " dimensions or provide less larger-sized fleets.\n", outContent.toString());
  }

  /**
   * tests the method showWinner
   */
  @Test
  public void testShow() {
    view.showWinner("Loss");
    assertEquals("Loss\n", outContent.toString());
  }

  /**
   * tests the method printInvShots
   */
  @Test
  public void testInvShots() {
    view.printInvShots(6, 5);
    assertEquals("You've entered an invalid shot. For the x-coordinate, "
        + "please enter a value 0 (inclusive) - 6 and  0 (inclusive) - 5 "
        + "(exclusive) respectively."
        + "\n------------------------------------------------------\n", outContent.toString());
  }

}
