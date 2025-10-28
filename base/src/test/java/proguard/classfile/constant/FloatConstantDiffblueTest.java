package proguard.classfile.constant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class FloatConstantDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FloatConstant#equals(Object)}
   *   <li>{@link FloatConstant#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FloatConstant floatConstant = new FloatConstant(10.0f);
    FloatConstant floatConstant2 = new FloatConstant(10.0f);

    // Act and Assert
    assertEquals(floatConstant, floatConstant2);
    int expectedHashCodeResult = floatConstant.hashCode();
    assertEquals(expectedHashCodeResult, floatConstant2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FloatConstant#equals(Object)}
   *   <li>{@link FloatConstant#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FloatConstant floatConstant = new FloatConstant(10.0f);

    // Act and Assert
    assertEquals(floatConstant, floatConstant);
    int expectedHashCodeResult = floatConstant.hashCode();
    assertEquals(expectedHashCodeResult, floatConstant.hashCode());
  }

  /**
   * Method under test: {@link FloatConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    FloatConstant floatConstant = new FloatConstant(0.5f);

    // Act and Assert
    assertNotEquals(floatConstant, new FloatConstant(10.0f));
  }

  /**
   * Method under test: {@link FloatConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FloatConstant(10.0f), null);
  }

  /**
   * Method under test: {@link FloatConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FloatConstant(10.0f), "Different type to FloatConstant");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FloatConstant#FloatConstant()}
   *   <li>{@link FloatConstant#setValue(float)}
   *   <li>{@link FloatConstant#toString()}
   *   <li>{@link FloatConstant#getTag()}
   *   <li>{@link FloatConstant#getValue()}
   *   <li>{@link FloatConstant#isCategory2()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    FloatConstant actualFloatConstant = new FloatConstant();
    actualFloatConstant.setValue(10.0f);
    String actualToStringResult = actualFloatConstant.toString();
    int actualTag = actualFloatConstant.getTag();
    float actualValue = actualFloatConstant.getValue();
    boolean actualIsCategory2Result = actualFloatConstant.isCategory2();

    // Assert that nothing has changed
    assertEquals("Float(10.0)", actualToStringResult);
    assertEquals(0, actualFloatConstant.getProcessingFlags());
    assertEquals(10.0f, actualValue, 0.0f);
    assertEquals(4, actualTag);
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FloatConstant#FloatConstant(float)}
   *   <li>{@link FloatConstant#setValue(float)}
   *   <li>{@link FloatConstant#toString()}
   *   <li>{@link FloatConstant#getTag()}
   *   <li>{@link FloatConstant#getValue()}
   *   <li>{@link FloatConstant#isCategory2()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange and Act
    FloatConstant actualFloatConstant = new FloatConstant(10.0f);
    actualFloatConstant.setValue(10.0f);
    String actualToStringResult = actualFloatConstant.toString();
    int actualTag = actualFloatConstant.getTag();
    float actualValue = actualFloatConstant.getValue();
    boolean actualIsCategory2Result = actualFloatConstant.isCategory2();

    // Assert that nothing has changed
    assertEquals("Float(10.0)", actualToStringResult);
    assertEquals(0, actualFloatConstant.getProcessingFlags());
    assertEquals(10.0f, actualValue, 0.0f);
    assertEquals(4, actualTag);
    assertFalse(actualIsCategory2Result);
  }
}
