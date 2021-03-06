/**
 * A class that represents a 2-dimensional point on a plane with two coordinates
 * @author Tung Ho, Lin
 */

public class Point2D extends Point {
  
  /** A constructor that takes two double values that represent the x and y coordinates and it creates a point with those coordinates
    * @param x the x coordinate
    * @param y the y coordinate
    */
  public Point2D (double x, double y) {
    super(x, y, 0.0);
  }
  
  /** A method that overrides the toString method in class Point: to return the String representation of the 2D Point
    * @return the String of the Point2D representation
    */
  @Override
  public String toString() {
    return "(" + getX() + ", " + getY() + ")";
  }
}
  
  