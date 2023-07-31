package cs3500.pa03;

public interface IControl {
  void run();
  void beginGame();
  void runValidDims();
  void proceedVal();
  void takeShots();
  void takeInput();
  boolean checkValidDims();
}
