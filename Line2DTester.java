import org.junit.*;
import static org.junit.Assert.*;

/** 
 * Test class Line2D
 * @author Tung Ho, Lin
 */ 

public class Line2DTester {
  
  /**
   * Test toString method
   */
  @Test
  public void testtoString() {
    assertEquals(new Line2D(new Point2D(3.0, 4.0), new Point2D(-5.0, -6.0)).toString(), "y = 1.25x + 0.25");    //test random points with positive y-intercept B
    assertEquals(new Line2D(new Point2D(3.0, 4.0), new Point2D(3.0, 2.0)).toString(), "x = 3.0");               //test when the line is vertical
    assertEquals(new Line2D(new Point2D(3.0, 4.0), new Point2D(-5.0, 4.0)).toString(), "y = 4.0");              //test when the line is horizontal
    assertEquals(new Line2D(new Point2D(6.0, 4.0), new Point2D(-2.0, -6.0)).toString(), "y = 1.25x - 3.5");     //test random points with negative y-intercept B
  }
  
  /**
   * Test equals method
   */
  public void testequals() {
    assertTrue(new Line2D(new Point2D(-3.0, 3.0), new Point2D(0.0, 3.0)).equals(new Line2D(new Point2D(6.0, 3.0), new Point2D(9.0, 3.0))));   //test true for two random 2D lines segments that represents the same line
    assertFalse(new Line2D(new Point2D(-3.0, 4.0), new Point2D(0.0, 4.0)).equals(new Line2D(new Point2D(6.0, 3.0), new Point2D(9.0, 3.0))));  //test false for two random 2D lines segments that don't represent the same line
  }
  
  /**
   * Test isParallel method
   */
  public void testisParallel() {
    assertTrue(Line2D.isParallel(new Line2D(new Point2D(0.0, 3.0), new Point2D(3.0, 3.0)), new Line2D(new Point2D(-1.0, 0.0), new Point2D(2.0, 3.0))));    //test true for two random 2D line segments that are parallel to each other
    assertFalse(Line2D.isParallel(new Line2D(new Point2D(0.0, 3.0), new Point2D(5.0, 3.0)), new Line2D(new Point2D(1.0, 0.0), new Point2D(1.0, 4.0))));    //test false for two perpendicular lines
    assertFalse(Line2D.isParallel(new Line2D(new Point2D(0.0, 3.0), new Point2D(5.0, 3.0)), new Line2D(new Point2D(-1.0, 3.0), new Point2D(9.0, 3.0))));   //test false for two lines that represents the same line
    assertFalse(Line2D.isParallel(new Line2D(new Point2D(-3.0, 3.0), new Point2D(0.0, 6.0)), new Line2D(new Point2D(6.0, 0.0), new Point2D(9.0, -2.0))));  //test false for two random 2D line segments that are not parallel to each other
  }
  
  /**
   * intersection method tested in Line because Line2D extends Line
   */

  
}
  