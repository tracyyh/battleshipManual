package cs3500.pa03;

import java.io.InputStreamReader;

/**
 * This is the main driver of this project.
 */
public class Driver {
  /**
   * Project entry point
   *
   * @param args - no command line args required
   */
  public static void main(String[] args) {
    Readable input = new InputStreamReader(System.in);
    IControl con = new Control(input);
    con.run();
  }
}