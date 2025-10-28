package proguard.classfile.constant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class LongConstantDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LongConstant#equals(Object)}
   *   <li>{@link LongConstant#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LongConstant longConstant = new LongConstant(42L);
    LongConstant longConstant2 = new LongConstant(42L);

    // Act and Assert
    assertEquals(longConstant, longConstant2);
    int expectedHashCodeResult = longConstant.hashCode();
    assertEquals(expectedHashCodeResult, longConstant2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LongConstant#equals(Object)}
   *   <li>{@link LongConstant#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LongConstant longConstant = new LongConstant(42L);

    // Act and Assert
    assertEquals(longConstant, longConstant);
    int expectedHashCodeResult = longConstant.hashCode();
    assertEquals(expectedHashCodeResult, longConstant.hashCode());
  }

  /**
   * Method under test: {@link LongConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LongConstant longConstant = new LongConstant(1L);

    // Act and Assert
    assertNotEquals(longConstant, new LongConstant(42L));
  }

  /**
   * Method under test: {@link LongConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LongConstant(42L), null);
  }

  /**
   * Method under test: {@link LongConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LongConstant(42L), "Different type to LongConstant");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LongConstant#LongConstant()}
   *   <li>{@link LongConstant#setValue(long)}
   *   <li>{@link LongConstant#toString()}
   *   <li>{@link LongConstant#getTag()}
   *   <li>{@link LongConstant#getValue()}
   *   <li>{@link LongConstant#isCategory2()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    LongConstant actualLongConstant = new LongConstant();
    actualLongConstant.setValue(42L);
    String actualToStringResult = actualLongConstant.toString();
    int actualTag = actualLongConstant.getTag();
    long actualValue = actualLongConstant.getValue();
    boolean actualIsCategory2Result = actualLongConstant.isCategory2();

    // Assert that nothing has changed
    assertEquals("Long(42)", actualToStringResult);
    assertEquals(0, actualLongConstant.getProcessingFlags());
    assertEquals(42L, actualValue);
    assertEquals(5, actualTag);
    assertTrue(actualIsCategory2Result);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LongConstant#LongConstant(long)}
   *   <li>{@link LongConstant#setValue(long)}
   *   <li>{@link LongConstant#toString()}
   *   <li>{@link LongConstant#getTag()}
   *   <li>{@link LongConstant#getValue()}
   *   <li>{@link LongConstant#isCategory2()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange and Act
    LongConstant actualLongConstant = new LongConstant(42L);
    actualLongConstant.setValue(42L);
    String actualToStringResult = actualLongConstant.toString();
    int actualTag = actualLongConstant.getTag();
    long actualValue = actualLongConstant.getValue();
    boolean actualIsCategory2Result = actualLongConstant.isCategory2();

    // Assert that nothing has changed
    assertEquals("Long(42)", actualToStringResult);
    assertEquals(0, actualLongConstant.getProcessingFlags());
    assertEquals(42L, actualValue);
    assertEquals(5, actualTag);
    assertTrue(actualIsCategory2Result);
  }
}
