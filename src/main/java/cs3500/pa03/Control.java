package cs3500.pa03;

import cs3500.pa03.Model.HumanPlayer;
import cs3500.pa03.Model.Model;
import java.util.Objects;
import java.util.Scanner;

/**
 * represents the controller
 */
public class Control implements IControl {
  private Model model;
  private View view = new View();
  private Scanner scanner;
  private final Readable input;
  private int height;
  private int width;

  /**
   * constructor
   *
   * @param input by the user
   */
  public Control(Readable input) {
    this.input = Objects.requireNonNull(input);
    scanner = new Scanner(input);
  }

  /**
   * runs the program
   */
  public void run() {
    view.printWelcome();
    String name = scanner.nextLine();
    model = new Model();
    model.designateUserName(name);
    view.askHeightWidth();
    beginGame();
  }

  /**
   * begins the game
   */
  public void beginGame() {
    height = scanner.nextInt();
    width = scanner.nextInt();
    if (checkValidDims()) {
      runValidDims();
    } else {
      view.printInvDim();
      beginGame();
    }
  }

  /**
   * makes the board and ships
   */
  public void runValidDims() {
    view.askFleetAmnts(Math.min(height, width));
    int car = scanner.nextInt();
    int bat = scanner.nextInt();
    int des = scanner.nextInt();
    int sub = scanner.nextInt();
    if ((car + bat + des + sub) <= Math.min(height, width)) {
      model = new Model(height, width);
      model.generateOgBoard();
      model.makeShips(car, bat, des, sub);
      proceedVal();
    } else {
      view.printInvFlts();
      runValidDims();
    }
  }

  /**
   * places the ships and prints the game
   */
  public void proceedVal() {
    if (model.checkLists()) {
      view.retryDims();
      view.askHeightWidth();
      beginGame();
    } else {
      model.placeShips();
      view.printGame(model.guessedBoard, model.userBoard);
      while (model.ongoing()) {
        takeShots();
      }
      model.endGame();
      String reason = model.appendReason();
      view.showWinner(reason);
    }
  }

  /**
   * shows the result of user and ai shots
   */
  public void takeShots() {
    view.askShots(model.remainingShips());
    for (int i = 0; i < model.remainingShips(); i++) {
      takeInput();
    }
    model.reportDamage();
    view.printGame(model.guessedBoard, model.userBoard);
  }

  /**
   * takes user's shots
   */
  public void takeInput() {
    int x;
    int y;
    x = scanner.nextInt();
    y = scanner.nextInt();
    if (x < width && y < height) {
      model.takeUserShots(y, x);
      model.takeAiShots();
    } else {
      view.printInvShots(width, height);
      takeInput();
    }
  }

  /**
   * checks if dimensions are valid
   *
   * @return whether dimensions valid
   */
  public boolean checkValidDims() {
    return ((height >= 6) && (height <= 15)) && ((width >= 6) && (width <= 15));
  }
}
