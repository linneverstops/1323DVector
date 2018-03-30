/** A class that represents a line in 2-dimensional space
  * @author Tung Ho, Lin
  */

public class Line2D extends Line {
  
  /** the slope of the line */
  private double m;
  
  /** the y-intercept of the line */
  private double b;
  
  /** the initial point of the line */
  private Point2D pp1;
  
  /** the ending point of the line */
  private Point2D pp2;
  
  /** a constructor that takes two input values that are each type Point2D. The new Line2D is defined by the two points.
    * @param p1 the first input point
    * @param p2 the second input point
    */ 
  public Line2D (Point2D p1, Point2D p2) {
    super(p1, p2);
    this.pp1 = p1;
    this.pp2 = p2;
    if (p1.getX() == p2.getX()) {     //when the line is vertical
      this.m = 0.0;
      this.b = 0.0;              //the line will not intersect the y axis
    }
    else if (p1.getY() == p2.getY()) {    //when the line is horizontal
      this.m = 0.0;
      this.b = p1.getY();           
    }
    else {                          //when the line is neither vertical and horizontal
      this.m = (p2.getY() - p1.getY())/(p2.getX() - p1.getX());
      this.b = p1.getY() - m * p1.getX();
    }
  }
  
  /** a method that returns the slope of the line 
    * @return the slope of the line 
    */
  public double getM() {
    return this.m;
  }
  
  /** a method that returns the y-intercept of the line
    * @return the y-intercept of the line
    */ 
  public double getB() {
    return this.b;
  }
  
  /** a method that returns the initial point of the line
    * @return the initial point of the line
    */ 
  public Point getPP1() {
    return this.pp1;
  }
  
  /** a method that returns the ending point of the line
    * @return the ending point of the line
    */ 
  public Point getPP2() {
    return this.pp2;
  }
  
  /** a method that overrides the toString method in class Line, returns the String representation of the equation of the line
    * @return the String representation of the equation of the line
    */
  @Override
  public String toString() {
    if (getPP1().getX() == getPP2().getX()) {      //if the line is vertical
      return "x = " + getPP1().getX();
    }
    else if (getPP1().getY() == getPP2().getY()) {  //if the line is horizontal
      return "y = " + getPP1().getY();
    }
    else {      
      if (this.getB() < 0)           //to prevent the plus and minus sign from appearing together
        return "y = " + this.getM() + "x - " + Math.abs(this.getB());
      else
        return "y = " + this.getM() + "x + " + this.getB();
    }
  }
  
  /** a method that overrides the equals method of class Object and determines whether the input line and this line represents the same line
    * @param l1 the input line
    * @return true if the input line is identical to this line
    */
  @Override
  public boolean equals(Object l1) {
    double testptx = 11.2;    //a testing point x coordinate to plug into the equation of both lines
    double testpty = -6.8;    //a testing point y coordinate to plug into the equation of both lines
    if (this.getM() == ((Line2D)l1).getM()) {
      if ((testpty - this.getB())/testptx == (testpty-((Line2D)l1).getB())/testptx)
        return true;
      else
        return false;
    }
    else
      return false;
  }
  
  /** a static method that determines whether the two input lines are parallel
    * @param l1 the first input line
    * @param l2 the second input line
    * @return true if the two input lines are parallel
    */
  public static boolean isParallel(Line2D l1, Line2D l2) {
    if (l1.getM() == 0.0 && l2.getM() == 0.0)
      return false;
    else if (l1.getM() == l2.getM())
      return true;
    else
      return false;
  }
}
