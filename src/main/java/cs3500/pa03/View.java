package cs3500.pa03;

/**
 * represents the view of the program
 */
public class View {

  /**
   * prints the welcome and asks for the name
   */
  public void printWelcome() {
    System.out.println("Hello! Welcome to the OOD BattleSalvo Game! Please enter your name.");
    lineBreak();
  }

  /**
   * prints a request for the height and width
   */
  public void askHeightWidth() {
    System.out.println("Please enter a valid height and width below:");
    lineBreak();
  }

  /**
   * prints a line break
   */
  public void lineBreak() {
    System.out.println("------------------------------------------------------");
  }

  /**
   * prints a message that the inputted dimensions are invalid
   */
  public void printInvDim() {
    System.out.println(
        "Uh Oh! You've entered invalid dimensions. Please remember that the height and width\n" +
            "of the game must be in the range (6, 15), inclusive. Try again!");
    lineBreak();
  }

  /**
   * prints a request for the amount of fleets
   *
   * @param max the maximum amount of fleets
   */
  public void askFleetAmnts(int max) {
    System.out.println(
        "Please enter your fleet in the order [Carrier, Battleship, Destroyer, Submarine].\n" +
            "Remember, your fleet may not exceed size " + max + ".");
    lineBreak();
  }

  /**
   * prints a message saying that the fleet amounts are invalid
   */
  public void printInvFlts() {
    System.out.println("Uh Oh! You've entered invalid fleet sizes.");
  }

  /**
   * prints the boards
   *
   * @param aiBoard   the ai's board
   * @param userBoard the user's board
   */
  public void printGame(String[][] aiBoard, String[][] userBoard) {
    System.out.println("Opponent Board Data:");
    printBoard(aiBoard);
    System.out.println("\nYour Board:");
    printBoard(userBoard);
  }

  /**
   * prints the given board
   *
   * @param board board to be printed
   */
  public void printBoard(String[][] board) {
    for (String[] row : board) {
      for (String s : row) {
        System.out.print(s);
      }
      System.out.println("");
    }
  }

  /**
   * prints a request for shots
   *
   * @param shots the number of shots to be taken
   */
  public void askShots(int shots) {
    System.out.println("Please enter " + shots + " shots:");
    lineBreak();
  }

  /**
   * prints a message requesting different dimensions or fleet amounts
   */
  public void retryDims() {
    System.out.println("Could not make unique board with given dimensions. Try larger" +
        " dimensions or provide less larger-sized fleets.");
  }

  /**
   * prints the winner and loser
   *
   * @param reason the reason why the game ended
   */
  public void showWinner(String reason) {
    System.out.println(reason);
  }

  /**
   * prints a message saying that the inputted shot is invalid
   *
   * @param width  max x-coordinate value
   * @param height max y-coordinate value
   */
  public void printInvShots(int width, int height) {
    System.out.println("You've entered an invalid shot. For the x-coordinate, " +
        "please enter a value 0 (inclusive) - " + width + " and  0 (inclusive) - " + height + " " +
        "(exclusive) respectively.");
    lineBreak();
  }
}
