package cs3500.pa03;

import java.io.StringReader;

/**
 * a mock of the control class
 */
public class MockControl implements IControl {
  private final Appendable log;
  Control real;
  Readable input;

  /**
   * contructor
   *
   * @param log a log of the output
   */
  public MockControl(Appendable log) {
    this.log = log;
    input = new StringReader(log.toString());
    real = new Control(input);
  }

  /**
   * runs the program
   */
  public void run() {
    real.run();
  }

  /**
   * begins the game
   */
  public void beginGame() {
    real.beginGame();
  }

  /**
   * makes the board and ships
   */
  public void runValidDims() {
    real.runValidDims();
  }

  /**
   * places the ships and prints the game
   */
  public void proceedVal() {
  }

  /**
   * shows the result of user and ai shots
   */
  public void takeShots() {
  }

  /**
   * takes user's shots
   */
  public void takeInput() {
  }

  /**
   * checks if dimensions are valid
   *
   * @return whether dimensions valid
   */
  public boolean checkValidDims() {
    return real.checkValidDims();
  }
}
