/** a class that represents a vector, which is a directed line segment that starts at the origin and ends at the x, y, and z coordinates of the point.
  * @author Tung Ho, Lin
  */

public class Vector {
  
  /** the x coordinate of the vector */
  private double a;
  
  /** the y coordinate of the vector */
  private double b;
  
  /** the z coordinate of the vector */
  private double c;
  
  /** a constructor that takes three double values: x, y, and z and creates a Vector with these coordinates.
    * @param a the x coordinate of the vector
    * @param b the y coordinate of the vector
    * @param c the z coordinate of the vector
    */ 
  public Vector (double a, double b, double c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }
  
  /** a constructor that takes a Point values and creates a vector with the same coordinates as the point.
    * @param p the point with the same coordinates with the vector
    */ 
  public Vector (Point p) {
    this.a = p.getX();
    this.b = p.getY();
    this.c = p.getZ();
  }
  
  /** a constructor that takes a Vector and double value and creates a Vector that is the same direction as the input Vector but with length equal to the input double.
    * @param v the input vector
    * @param length the length of the vector
    */ 
  public Vector (Vector v, double length) {
    this.a = (length/(Point.distance(new Point(0.0, 0.0, 0.0), new Point(v.getA(), v.getB(), v.getC())))) * v.getA(); 
    this.b = (length/(Point.distance(new Point(0.0, 0.0, 0.0), new Point(v.getA(), v.getB(), v.getC())))) * v.getB();
    this.c = (length/(Point.distance(new Point(0.0, 0.0, 0.0), new Point(v.getA(), v.getB(), v.getC())))) * v.getC();
    // the ratio of the new length and the length of the input vector is calculated and then multiplied to the input vector's coordinates to get the new coordinates of the new vector
  }
  
  /** a method that returns the x coordinate of the vector
    * @return the x coordinate of the vector
    */ 
  public double getA() {
    return this.a;
  }
  
  /** a method that returns the y coordinate of the vector
    * @return the y coordinate of the vector
    */ 
  public double getB() {
    return this.b;
  }
 
  /** a method that returns the z coordinate of the vector
    * @return the z coordinate of the vector
    */   
  public double getC() {
    return this.c;
  }
    
  /** a method that overrides the toString method of Object, returns the String representation of the Vector equation
    * @return the String representation of the Vector equation
    */     
  @Override
  public String toString() {
    return "<" + getA() + "," + getB() + "," + getC() + ">";
  }
  
  /** a method that overrides the equals method of class Object and determines if the input vector is identical to this vector
    * @param v1 the input vector
    * @return true if the input vector is identical to this vector
    */ 
  @Override
  public boolean equals(Object v1) {
    if (((Vector)v1).getA() == this.getA() && ((Vector)v1).getB() == this.getB() && ((Vector)v1).getC() == this.getC())
      return true;
    else
      return false;
  }

  /** a method that returns the magnitude of this vector
    * @return the magnitude of this vector
    */   
  public double magnitude() {
    return Math.sqrt(Math.pow(getA(), 2.0) + Math.pow(getB(), 2.0) + Math.pow(getC(), 2.0)); //vector length formula
  }
  
  /** a method that returns the unit vector of this vector
    * @return the unit vector
    */ 
  public Vector unitVector() {
    return new Vector(this, 1.0);  
  }
  
  /** a static method that returns the sum of the two input vectors
    * @param v1 the first input vector
    * @param v2 the second input vector
    * @return the sum of the two input vectors
    */ 
  public static Vector sum(Vector v1, Vector v2) {
    return new Vector((v1.getA() + v2.getA()), (v1.getB() + v2.getB()), (v1.getC() + v2.getC()));
  }
  
  /** a static method that returns the ratio of v2 to v1, provided v2 to v1 has a ratio
    * @param v1 the first input vector
    * @param v2 the second input vector
    * @return the ratio of v2 to v1
    */ 
  public static double divideVector(Vector v1, Vector v2) {
    return v2.getA()/v1.getA();
  }
  
  /** a static method that returns a new Vector scaled by the multiplier input
    * @param v1 the input vector
    * @param multiplier the scale multiplier
    * @return a new Vector scaled by the multiplier input
    */   
  public static Vector scale(Vector v1, double multiplier) {
    return new Vector((v1.getA() * multiplier), (v1.getB() * multiplier), (v1.getC() * multiplier));
  }
  
  /** a method that returns the dot product of the two input vectors
    * @param v1 the first input vector
    * @param v2 the second input vector
    * @return the dot product of the two input vectors
    */ 
  public static double dotProduct(Vector v1, Vector v2) {
    return (v1.getA() * v2.getA()) + (v1.getB() * v2.getB()) + (v1.getC() * v2.getC());  //dot product formula
  }
  
  /** a static method that returns the cross product of the two input vectors
    * @param v1 the first input vector
    * @param v2 the second input vector
    * @return the cross product of the two input vectors
    */ 
  public static Vector crossProduct(Vector v1, Vector v2) {
    double newa = v1.getB() * v2.getC() - v1.getC() * v2.getB();        //newa is the cross product of v1 and v2's new x coordinate
    double newb = v1.getA() * v2.getC() - v1.getC() * v2.getA();        //newb is the cross product of v1 and v2's new y coordinate
    double newc = v1.getA() * v2.getB() - v1.getB() * v2.getA();        //newc is the cross product of v1 and v2's new z coordinate
    return new Vector(newa, newb, newc);
  }
  
  /** a static method that returns the angle between the two input vectors
    * @param v1 the first input vector
    * @param v2 the second input vector
    * @return the angle between the two input vectors
    */ 
  public static double angle(Vector v1, Vector v2) {
    return Math.acos((Vector.dotProduct(v1, v2))/(Math.abs(v1.magnitude() * v2.magnitude())));  //vector angle formula
  }
  
  /** a static method that determines if the two input vectors are orthogonal
    * @param v1 the first input vector
    * @param v2 the second input vector
    * @return true if the two input vectors are orthogonal
    */ 
  public static boolean isOrthogonal(Vector v1, Vector v2) {
    if (Vector.dotProduct(v1, v2) == 0)          
      return true;
    else
      return false;
  }
  
  /** a static method that determines if the two input vectors are parallel
    * @param v1 the first input vector
    * @param v2 the second input vector
    * @return true if the two input vectors are parallel
    */
  public static boolean isParallel(Vector v1, Vector v2) {
    Vector v3 = Vector.crossProduct(v1, v2);                   //v3 is the crossProduct of the input vectors v1 and v2
    if (v3.getA() == 0 && v3.getB() == 0 && v3.getC() == 0)    //if v1 is parallel to v2, the cross product = 0
      return true;
    else
      return false;
  }
}
    
  
  
  
    