import org.junit.*;
import static org.junit.Assert.*;

/** 
 * Test class Point
 * @author Tung Ho, Lin
 */ 

public class PointTester {
  
  /**
   * Test getX method
   */
   @Test
  public void testgetX() {
    assertEquals(new Point(0.0, 0.0, 0.0).getX(), 0.0, 0.0);              //test 0
    assertEquals(new Point(39.0, 45.0, 55.0).getX(), 39.0, 0.0);          //test random number
    assertEquals(new Point(-90.0, -32.0, -109.0).getX(), -90.0, 0.0);     //test negative number
    //the third double input of assertEquals() is the epsilon, representing the allowed error
  }
   
  /**
   * Test getY method
   */
  @Test
  public void testgetY() {
    assertEquals(new Point(0.0, 0.0, 0.0).getY(), 0.0, 0.0);            //test 0
    assertEquals(new Point(39.0, 45.0, 55.0).getY(), 45.0, 0.0);        //test random number
    assertEquals(new Point(-90.0, -32.0, -109.0).getY(), -32.0, 0.0);   //test negative number
  }
  
   /**
   * Test getZ method
   */
  @Test
  public void testgetZ() {
    assertEquals(new Point(0.0, 0.0, 0.0).getZ(), 0.0, 0.0);               //test 0
    assertEquals(new Point(39.0, 45.0, 55.0).getZ(), 55.0, 0.0);           //test random number
    assertEquals(new Point(-90.0, -32.0, -109.0).getZ(), -109.0, 0.0);     //test negative number
  }
  
  /**
   * Test toString method
   */ 
  @Test
  public void testtoString() {
    assertEquals(new Point(0.0, 0.0, 0.0).toString(), "(0.0, 0.0, 0.0)");                  //test 0
    assertEquals(new Point(60.0, 45.0, 13.0).toString(), "(60.0, 45.0, 13.0)");            //test random numbers
    assertEquals(new Point(-15.0, -56.0, -198.0).toString(), "(-15.0, -56.0, -198.0)");    //test negative numbers
  }
  
  /**
   * Test equals method
   */
  @Test
  public void testequals() {
    assertTrue(new Point(0.0, 0.0, 0.0).equals(new Point(0.0, 0.0, 0.0)));              //test true 0
    assertTrue(new Point(40.0, 60.0, 80.0).equals(new Point(40.0, 60.0, 80.0)));        //test true random numbers
    assertTrue(new Point(-10.0, -45.0, -75.0).equals(new Point(-10.0, -45.0, -75.0)));  //test true negative numbers
    assertFalse(new Point(3.0, 4.0, 7.0).equals(new Point(5.0, 6.0, 4.0)));             //test different random Points
    assertFalse(new Point(-30.0, 60.0, -90.0).equals(new Point(30.0, 60.0, 90.0)));     //test different random Points with negative numbers
  }
  
  /**
   * Test distance method
   */
  @Test
  public void testdistance() {
    assertEquals(Point.distance(new Point(5.0, 5.0, 5.0), new Point(5.0, 5.0, 5.0)), 0.0, 0.0);        //test 0
    assertEquals(Point.distance(new Point(3.0, 4.0, 6.0), new Point(20.0, 5.0, 7.0)), Math.sqrt(Math.pow(20.0-3.0, 2.0) + Math.pow(5.0-4.0, 2.0) + Math.pow(7.0-6.0, 2.0)), 0.0);  //test non-zero
    assertEquals(Point.distance(new Point(-5.0, 13.0, 0.0), new Point(5.0, -8.0, -70.0)), Math.sqrt(Math.pow(5.0-(-5.0), 2.0) + Math.pow((-8.0-13.0), 2.0) + Math.pow((-70.0)-0.0, 2.0)), 0.0);     //test negative coordinates
  }

  
}