package proguard.classfile.constant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class IntegerConstantDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link IntegerConstant#equals(Object)}
   *   <li>{@link IntegerConstant#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    IntegerConstant integerConstant = new IntegerConstant(42);
    IntegerConstant integerConstant2 = new IntegerConstant(42);

    // Act and Assert
    assertEquals(integerConstant, integerConstant2);
    int expectedHashCodeResult = integerConstant.hashCode();
    assertEquals(expectedHashCodeResult, integerConstant2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link IntegerConstant#equals(Object)}
   *   <li>{@link IntegerConstant#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    IntegerConstant integerConstant = new IntegerConstant(42);

    // Act and Assert
    assertEquals(integerConstant, integerConstant);
    int expectedHashCodeResult = integerConstant.hashCode();
    assertEquals(expectedHashCodeResult, integerConstant.hashCode());
  }

  /**
   * Method under test: {@link IntegerConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    IntegerConstant integerConstant = new IntegerConstant(1);

    // Act and Assert
    assertNotEquals(integerConstant, new IntegerConstant(42));
  }

  /**
   * Method under test: {@link IntegerConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new IntegerConstant(42), null);
  }

  /**
   * Method under test: {@link IntegerConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new IntegerConstant(42), "Different type to IntegerConstant");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link IntegerConstant#IntegerConstant()}
   *   <li>{@link IntegerConstant#setValue(int)}
   *   <li>{@link IntegerConstant#toString()}
   *   <li>{@link IntegerConstant#getTag()}
   *   <li>{@link IntegerConstant#getValue()}
   *   <li>{@link IntegerConstant#isCategory2()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    IntegerConstant actualIntegerConstant = new IntegerConstant();
    actualIntegerConstant.setValue(42);
    String actualToStringResult = actualIntegerConstant.toString();
    int actualTag = actualIntegerConstant.getTag();
    int actualValue = actualIntegerConstant.getValue();
    boolean actualIsCategory2Result = actualIntegerConstant.isCategory2();

    // Assert that nothing has changed
    assertEquals("Integer(42)", actualToStringResult);
    assertEquals(0, actualIntegerConstant.getProcessingFlags());
    assertEquals(3, actualTag);
    assertEquals(42, actualValue);
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link IntegerConstant#IntegerConstant(int)}
   *   <li>{@link IntegerConstant#setValue(int)}
   *   <li>{@link IntegerConstant#toString()}
   *   <li>{@link IntegerConstant#getTag()}
   *   <li>{@link IntegerConstant#getValue()}
   *   <li>{@link IntegerConstant#isCategory2()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange and Act
    IntegerConstant actualIntegerConstant = new IntegerConstant(42);
    actualIntegerConstant.setValue(42);
    String actualToStringResult = actualIntegerConstant.toString();
    int actualTag = actualIntegerConstant.getTag();
    int actualValue = actualIntegerConstant.getValue();
    boolean actualIsCategory2Result = actualIntegerConstant.isCategory2();

    // Assert that nothing has changed
    assertEquals("Integer(42)", actualToStringResult);
    assertEquals(0, actualIntegerConstant.getProcessingFlags());
    assertEquals(3, actualTag);
    assertEquals(42, actualValue);
    assertFalse(actualIsCategory2Result);
  }
}
