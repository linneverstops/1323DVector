import org.junit.*;
import static org.junit.Assert.*;

/** 
 * Test class Vector
 * @author Tung Ho, Lin
 */ 

public class VectorTester {
  
  /**
   * Test toString method
   */ 
  @Test 
  public void testtoString() {
    assertEquals(new Vector(0.0, 0.0, 0.0).toString(), "<0.0,0.0,0.0>");      //test 0
    assertEquals(new Vector(3.0, 5.0, 7.0).toString(), "<3.0,5.0,7.0>");      //test random positive
    assertEquals(new Vector(-3.0, 5.0, -7.0).toString(), "<-3.0,5.0,-7.0>");  //test random negative/positive
  }
  
  /**
   * Test equals method
   */ 
  @Test 
  public void testequals() {     
    assertTrue(new Vector(7.0, 9.0, 10.0).equals(new Vector(7.0, 9.0, 10.0)));         //test true positive
    assertTrue(new Vector(7.0, -9.0, -10.0).equals(new Vector(7.0, -9.0, -10.0)));     //test true positive
    assertFalse(new Vector(-7.0, 9.0, -10.0).equals(new Vector(7.0, -9.0, -10.0)));    //test false positive/negative
  }
  
  /**
   * Test magnitude method
   */ 
  @Test 
  public void testmagnitude() {
    assertEquals(new Vector(0.0, 0.0, 0.0).magnitude(), 0.0, 0.0);         //test 0
    assertEquals(new Vector(2.0, 2.0, 1.0).magnitude(), 3.0, 0.0);         //test positive vector
    assertEquals(new Vector(-2.0, -2.0, -1.0).magnitude(), 3.0, 0.0);      //test negative vector
  }
  
  /**
   * Test unitVector method
   */ 
  @Test 
  public void testunitVector() {           
    assertEquals(new Vector(2.0, 2.0, 1.0).unitVector(), new Vector(new Vector(2.0, 2.0, 1.0), 1.0));          //test random vector
  }
  
  /**
   * Test sum method
   */ 
  @Test 
  public void testsum() {   
    assertEquals(Vector.sum(new Vector(0.0, 0.0, 0.0), new Vector(0.0, 0.0, 0.0)), new Vector(0.0, 0.0, 0.0));     //test 0
    assertEquals(Vector.sum(new Vector(1.0, 3.0, 4.0), new Vector(5.0, 6.0, 3.0)), new Vector(6.0, 9.0, 7.0));     //test positive vectors
    assertEquals(Vector.sum(new Vector(-1.0, 3.0, 4.0), new Vector(5.0, -6.0, -3.0)), new Vector(4.0, -3.0, 1.0)); //test positive/negative vectors
  }
  
  /**
   * Test dotProduct method
   */ 
  @Test 
  public void testdotProduct() {
    assertEquals(Vector.dotProduct(new Vector(0.0, 0.0, 0.0), new Vector(0.0, 0.0, 0.0)), 0.0, 0.0);         //test 0
    assertEquals(Vector.dotProduct(new Vector(1.0, 3.0, 4.0), new Vector(5.0, 6.0, 3.0)), 35.0, 0.0);       //test positive vectors
    assertEquals(Vector.dotProduct(new Vector(-1.0, 3.0, 4.0), new Vector(5.0, -6.0, -3.0)), -35.0, 0.0); //test positive/negative vectors
  }
  
  /**
   * Test crossProduct method
   */ 
  @Test 
  public void testcrossProduct() {
    assertEquals(Vector.crossProduct(new Vector(0.0, 0.0, 0.0), new Vector(0.0, 0.0, 0.0)), new Vector(0.0, 0.0, 0.0));            //test 0
    assertEquals(Vector.crossProduct(new Vector(1.0, 3.0, 4.0), new Vector(5.0, 6.0, 3.0)), new Vector(-15.0, -17.0, -9.0));       //test positive vectors
    assertEquals(Vector.crossProduct(new Vector(-1.0, 3.0, 4.0), new Vector(5.0, -6.0, -3.0)), new Vector(15.0, -17.0, -9.0));     //test positive/negative vectors
  }
  
  /**
   * Test angle method
   */ 
  @Test 
  public void testangle() {
    assertEquals(Vector.angle(new Vector(1.0, 1.0, 1.0), new Vector(5.0, 6.0, 3.0)), Math.acos(14/(new Vector(1.0, 1.0, 1.0).magnitude() * new Vector(5.0, 6.0, 3.0).magnitude())), 0.0);              //test positive vectors
    assertEquals(Vector.angle(new Vector(-1.0, 3.0, -4.0), new Vector(-5.0, -6.0, -3.0)), Math.acos(-1/(new Vector(-1.0, 3.0, -4.0).magnitude() * new Vector(-5.0, -6.0, -3.0).magnitude())), 0.0);    //test positive/negative vectors
  }
  
  /**
   * Test isOrthogonal method
   */ 
  @Test 
  public void testisOrthogonal() {
    assertTrue(Vector.isOrthogonal(new Vector(7.0, 9.0, -10.0), new Vector(4.0, -2.0, 1.0)));      //test true with two orthogonal Vectors
    assertFalse(Vector.isOrthogonal(new Vector(8.0, 9.0, 12.0), new Vector(4.0, -2.0, -1.0)));     //test false with two non-orthogonal Vectors
  }
  
  /**
   * Test isParallel method
   */ 
  @Test 
  public void testisParallel() {
    assertTrue(Vector.isParallel(new Vector(8.0, 8.0, 8.0), new Vector(5.0, 5.0, 5.0)));         //test true with two parallel Vectors
    assertFalse(Vector.isParallel(new Vector(8.0, 9.0, 12.0), new Vector(4.0, -2.0, -1.0)));     //test false with two non-parallel Vectors
  }
  
}


  
  
  
  
  