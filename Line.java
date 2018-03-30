/** A class that represents a line in 3-dimensional space
  * @author Tung Ho, Lin
  */
import java.lang.StringBuilder;

public class Line {
  
  /** the initial point of the line */
  private Point initialpt;
  
  /** the vector of the line */
  private Vector vector;
  
  /** a constructor that defines a line by two points where the points may be either type Point2D or type Point.
    * @param p1 the first input point
    * @param p2 the second input point
    */ 
  public Line (Point p1, Point p2) {
    this.vector = new Vector(p2.getX() - p1.getX(), p2.getY() - p1.getY(), p2.getZ() - p1.getZ());
    this.initialpt = p1;
  }
  
  /** a constructor that defines a line by a point and a Vector where the point may be either type Point2D or Point.
    * @param v1 the input vector
    * @param p1 the input point
    */ 
  public Line (Vector v1, Point p1) {
    this.vector = v1;
    this.initialpt = p1;
  }
  
  /** A method that returns the initial point of the line
    * @return the initial point of the line
    */
  public Point getInitialPt() {
    return this.initialpt;
  }
  
  /** A method that overrides the toString method from class Object and returns the String representation of the equation of the line
    * @return the String representation of the eqaution of the line
    */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();  //a StringBuilder instance to build the String
    //the reason for so many for-loops is to prevent the addition and minus sign from appearing together
    builder.append(initialpt.getX());  //writing the first parametric equation
    if (vector.getA() < 0) {           //if the difference in x is negative
      builder.append(" - ");
      builder.append(Math.abs(vector.getA()));
      builder.append("t, ");
    } 
    else {                             //if the difference in x is positive
      builder.append(" + ");         
      builder.append(vector.getA());
      builder.append("t, ");
    }
    builder.append(initialpt.getY());  //writing the second parametric equation
    if (vector.getB() < 0) {           //if the difference in y is negative
      builder.append(" - ");
      builder.append(Math.abs(vector.getB()));
      builder.append("t, ");
    }
    else {                             //if the difference in y is positive
      builder.append(" + ");
      builder.append(vector.getB());
      builder.append("t, ");
    }
    builder.append(initialpt.getZ());  //writing the third parametric equation
    if (vector.getC() < 0) {           //if the difference in z is negative
      builder.append(" - ");
      builder.append(Math.abs(vector.getC()));
      builder.append("t");
    }
    else {                             //if the difference in z is positive
      builder.append(" + ");
      builder.append(vector.getC());
      builder.append("t");
    }
    return builder.toString();
  }
  
  /** A method that overrides the equals method of class Object and determines whether the input line and this line represents the same line
    * @param l1 the input line
    * @return true if the input line is identical to this line
    */
  @Override
  public boolean equals(Object l1) {
    if (Line.isParallel(this, ((Line)l1))) {
      if (Line.isParallel(new Line(this.getInitialPt(), ((Line)l1).getInitialPt()), this))
        return true;
      else
        return false;
    }
    else
      return false;
  }
  
  /** A method that returns the vector of the line
    * @return the vector of the line
    */
  public Vector getVector() {
    return this.vector;
  }
  
  /** A static method that determines if the two input lines are parallel to each other
    * @param l1 the first input line
    * @param l2 the second input line
    * @return true if the two input lines are parallel to each other
    */
  public static boolean isParallel(Line l1, Line l2) {
    if (Vector.isParallel(l1.getVector(), l2.getVector()) == true)
      return true;
    else
      return false;
  }
  
  
  /** A static method that returns the intersection of the two input 2Dlines
    * @param l1 the first input 2Dline
    * @param l2 the second input 2Dline
    * @return the 2D point of intersection
    */
  public static Point2D intersection(Line2D l1, Line2D l2) {
    if (Line2D.isParallel(l1, l2) == true)
      return null;
    else {
      if (l1.equals(l2))
        return null;
      else if (l1.getB() == l1.getPP1().getY() && l2.getB() == 0.0) 
        return new Point2D(l2.getPP1().getX(), l1.getB());
      else if (l1.getB() == 0.0 && l2.getB() == l2.getPP1().getY())
        return new Point2D(l1.getPP1().getX(), l2.getB());
      else {
        double x = (l2.getB() - l1.getB())/(l1.getM() - l2.getM());        //stores the x coordinate of the intersection
        double y = l1.getM() * x + l1.getB();                           //stores the y coordinate of the intersection
        return new Point2D(x, y);
      }
    }
  }
  
  /** A static method that returns the intersection of the two input lines
    * @param l1 the first input line
    * @param l2 the second input line
    * @return the point of intersection
    */
  public static Point intersection(Line l1, Line l2) {
    Vector base = Vector.crossProduct(l1.getVector(), l2.getVector());          //the base value to be compared with value 1 and value 2
    Vector value1 = Vector.crossProduct(Point.subtractToVector(l1.getInitialPt(), l2.getInitialPt()), l1.getVector()); 
    //value1 is the value derived from the first input line and will be compared to base value to get a ratio
    Vector value2 = Vector.crossProduct(Point.subtractToVector(l1.getInitialPt(), l2.getInitialPt()), l2.getVector());
    //value2 is the value derived from the second input line and will be compared to base value to get a ratio
    double multiplier1 = Vector.divideVector(base, value1);
    //multiplier1 is the ratio derived from comparing base and value1
    double multiplier2 = Vector.divideVector(base, value2);
    //multiplier2 is the ratio derived from comparing base and value2
    Vector intersect1 = Vector.sum(new Vector(l1.getInitialPt()), Vector.scale(l1.getVector(), multiplier2));  
    //intersect1 is the intersection Point calculated from plugging in multiplier2 and is temporarily stored in a Vector form
    Vector intersect2 = Vector.sum(new Vector(l2.getInitialPt()), Vector.scale(l2.getVector(), multiplier1));
    //intersect2 is the intersection Point calculated from plugging in multiplier1 and is temporarily stored in a Vector form
      if (intersect1.equals(intersect2) == true)    //if both sides equal, then we have an intersection point
        return new Point(intersect1.getA(), intersect1.getB(), intersect1.getC());
      else
        return null;
  }

    
}