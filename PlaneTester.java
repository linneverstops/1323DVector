import org.junit.*;
import static org.junit.Assert.*;

/** 
 * Test class Plane
 * @author Tung Ho, Lin
 */ 

public class PlaneTester {
  
  /**
   * Test getNormal method
   */ 
  @Test
  public void testgetNormal() {
    assertEquals(new Plane(new Point(2.0, 5.0, 6.0), new Vector(5.0, 6.0, 8.0)).getNormal(), new Vector(5.0, 6.0, 8.0));         //test positive vector
    assertEquals(new Plane(new Point(-2.0, 5.0, -6.0), new Vector(5.0, -6.0, -8.0)).getNormal(), new Vector(5.0, -6.0, -8.0));   //test negative vector
  }
  
  /**
   * Test toString method
   */ 
  @Test 
  public void testtoString() {
    assertEquals(new Plane(new Point(2.0, 5.0, 6.0), new Vector(5.0, 6.0, 8.0)).toString(), "5.0x + 6.0y + 8.0z - 88.0");         //test positive vector
    assertEquals(new Plane(new Point(-2.0, 5.0, -6.0), new Vector(5.0, -6.0, -8.0)).toString(), "5.0x - 6.0y - 8.0z - 8.0");      //test negative x, y and z values
    assertEquals(new Plane(new Point(-2.0, 5.0, -6.0), new Vector(5.0, -6.0, 8.0)).toString(), "5.0x - 6.0y + 8.0z + 88.0");      //test 
  }
  
  /**
   * Test equals method
   */
  @Test
  public void testequals() {
    assertTrue(new Plane(new Point(2.0, 3.0, 4.0), new Vector(3.3, 3.3, 3.3)).equals(new Plane(new Point(2.0, 3.0, 4.0), new Vector(5.0, 5.0, 5.0))));   //test true for two random plane that represents the same plane
    assertTrue(new Plane(new Point(2.0, 3.0, 4.0), new Vector(5.0, 5.0, 5.0)).equals(new Plane(new Point(2.0, 3.0, 4.0), new Vector(5.0, 5.0, 5.0))));   //test true for the input plane as the same as this plane
    assertFalse(new Plane(new Point(4.0, 3.0, 4.0), new Vector(3.3, 5.3, 3.3)).equals(new Plane(new Point(2.0, 3.0, 4.0), new Vector(5.0, 5.0, 5.0))));  //test false for two planes that do not equal to each other
  }
  
  /**
   * Test contains method
   */
  @Test
  public void testcontains() {
    assertTrue(new Plane(new Point(2.0, 3.0, 4.0), new Vector(3.3, 3.3, 3.3)).contains(new Point(2.0, 3.0, 4.0)));    //test true for a point that is in the plane
    assertFalse(new Plane(new Point(4.0, 3.0, 4.0), new Vector(3.3, 5.3, 3.3)).contains(new Point(2.0, 3.0, 4.0)));   //test false for a point that is not in the plane
  }
  
  /**
   * Test isParallel method
   */
  @Test
  public void testisParallel() {
    assertTrue(Plane.isParallel(new Plane(new Point(2.0, 3.0, 4.0), new Vector(5.0, 3.0, 4.0)), new Plane(new Point(2.0, 3.0, 4.0), new Vector(5.0, 3.0, 4.0))));   //test true for the input plane the same as this plane
    assertTrue(Plane.isParallel(new Plane(new Point(2.0, 3.0, 4.0), new Vector(5.0, 3.0, 4.0)), new Plane(new Point(2.0, 3.0, 4.0), new Vector(2.5, 1.5, 2.0))));   //test true for two parallel planes
    assertFalse(Plane.isParallel(new Plane(new Point(2.0, 3.0, 4.0), new Vector(5.0, 3.0, 4.0)), new Plane(new Point(2.0, 3.0, 4.0), new Vector(6.0, 4.0, 4.0))));  //test false for two non-parallel planes
  }
  
  /**
   * Test isOrthogonal method
   */
  @Test 
  public void testisOrthogonal() {
    assertTrue(Plane.isOrthogonal(new Plane(new Point(2.0, 3.0, 4.0), new Vector(1.0, 3.0, 4.0)), new Plane(new Point(2.0, 3.0, 4.0), new Vector(1.0, 1.0, -1.0))));         //test true for two orthogonal planes
    assertFalse(Plane.isOrthogonal(new Plane(new Point(2.0, 3.0, 4.0), new Vector(7.0, 9.0, -10.0)), new Plane(new Point(2.0, 3.0, 4.0), new Vector(7.0, 9.0, -10.0))));     //test false for the input plane as the same as this plane
    assertFalse(Plane.isOrthogonal(new Plane(new Point(2.0, 3.0, 4.0), new Vector(7.0, 9.0, 10.0)), new Plane(new Point(2.0, 3.0, 4.0), new Vector(4.0, -2.0, 1.0))));       //test true for the input plane as the same as this plane
  }
}