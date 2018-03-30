import org.junit.*;
import static org.junit.Assert.*;

/** 
 * Test class Point2D
 * @author Tung Ho, Lin
 */ 

public class Point2DTester {

  /**
   * Test toString method
   */ 
  @Test
  public void testtoString() {
    assertEquals(new Point2D(0.0, 0.0).toString(), "(0.0, 0.0)");        //test 0
    assertEquals(new Point2D(6.0, 10.0).toString(), "(6.0, 10.0)");      //test random numbers
    assertEquals(new Point2D(-2.0, -5.0).toString(), "(-2.0, -5.0)");    //test random negative numbers
  }
  
   /**
   * All other methods are tested by PointTester
   */
  
}