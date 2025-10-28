package proguard.classfile.constant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class DoubleConstantDiffblueTest {
  /**
   * Method under test: {@link DoubleConstant#getTag()}
   */
  @Test
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(6, (new DoubleConstant(10.0d)).getTag());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DoubleConstant#equals(Object)}
   *   <li>{@link DoubleConstant#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    DoubleConstant doubleConstant2 = new DoubleConstant(10.0d);

    // Act and Assert
    assertEquals(doubleConstant, doubleConstant2);
    int expectedHashCodeResult = doubleConstant.hashCode();
    assertEquals(expectedHashCodeResult, doubleConstant2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DoubleConstant#equals(Object)}
   *   <li>{@link DoubleConstant#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);

    // Act and Assert
    assertEquals(doubleConstant, doubleConstant);
    int expectedHashCodeResult = doubleConstant.hashCode();
    assertEquals(expectedHashCodeResult, doubleConstant.hashCode());
  }

  /**
   * Method under test: {@link DoubleConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DoubleConstant doubleConstant = new DoubleConstant(0.5d);

    // Act and Assert
    assertNotEquals(doubleConstant, new DoubleConstant(10.0d));
  }

  /**
   * Method under test: {@link DoubleConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DoubleConstant(10.0d), null);
  }

  /**
   * Method under test: {@link DoubleConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DoubleConstant(10.0d), "Different type to DoubleConstant");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DoubleConstant#DoubleConstant()}
   *   <li>{@link DoubleConstant#setValue(double)}
   *   <li>{@link DoubleConstant#toString()}
   *   <li>{@link DoubleConstant#getValue()}
   *   <li>{@link DoubleConstant#isCategory2()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    DoubleConstant actualDoubleConstant = new DoubleConstant();
    actualDoubleConstant.setValue(10.0d);
    String actualToStringResult = actualDoubleConstant.toString();
    double actualValue = actualDoubleConstant.getValue();
    boolean actualIsCategory2Result = actualDoubleConstant.isCategory2();

    // Assert that nothing has changed
    assertEquals("Double(10.0)", actualToStringResult);
    assertEquals(0, actualDoubleConstant.getProcessingFlags());
    assertEquals(10.0d, actualValue, 0.0);
    assertTrue(actualIsCategory2Result);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DoubleConstant#DoubleConstant(double)}
   *   <li>{@link DoubleConstant#setValue(double)}
   *   <li>{@link DoubleConstant#toString()}
   *   <li>{@link DoubleConstant#getValue()}
   *   <li>{@link DoubleConstant#isCategory2()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange and Act
    DoubleConstant actualDoubleConstant = new DoubleConstant(10.0d);
    actualDoubleConstant.setValue(10.0d);
    String actualToStringResult = actualDoubleConstant.toString();
    double actualValue = actualDoubleConstant.getValue();
    boolean actualIsCategory2Result = actualDoubleConstant.isCategory2();

    // Assert that nothing has changed
    assertEquals("Double(10.0)", actualToStringResult);
    assertEquals(0, actualDoubleConstant.getProcessingFlags());
    assertEquals(10.0d, actualValue, 0.0);
    assertTrue(actualIsCategory2Result);
  }
}
