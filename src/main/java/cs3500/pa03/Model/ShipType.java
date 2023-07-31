package cs3500.pa03.Model;

/**
 * represents ship types
 */
public enum ShipType {
  CARRIER(6),
  BATTLESHIP(5),
  DESTROYER(4),
  SUBMARINE(3);

  private int size;

  /**
   * constructor
   *
   * @param size
   */
  ShipType(int size) {
    this.size = size;
  }

  /**
   * returns the size of the ship
   *
   * @return size of the ship
   */
  public int toSize() {
    return size;
  }
}
