package proguard.evaluation.value.object;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PreciseObjectDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PreciseObject#equals(Object)}
   *   <li>{@link PreciseObject#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PreciseObject preciseObject = new PreciseObject("Object");
    PreciseObject preciseObject2 = new PreciseObject("Object");

    // Act and Assert
    assertEquals(preciseObject, preciseObject2);
    int expectedHashCodeResult = preciseObject.hashCode();
    assertEquals(expectedHashCodeResult, preciseObject2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PreciseObject#equals(Object)}
   *   <li>{@link PreciseObject#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PreciseObject preciseObject = new PreciseObject("Object");

    // Act and Assert
    assertEquals(preciseObject, preciseObject);
    int expectedHashCodeResult = preciseObject.hashCode();
    assertEquals(expectedHashCodeResult, preciseObject.hashCode());
  }

  /**
   * Method under test: {@link PreciseObject#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PreciseObject preciseObject = new PreciseObject(1);

    // Act and Assert
    assertNotEquals(preciseObject, new PreciseObject("Object"));
  }

  /**
   * Method under test: {@link PreciseObject#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PreciseObject preciseObject = new PreciseObject(new PreciseObject("Object"));

    // Act and Assert
    assertNotEquals(preciseObject, new PreciseObject("Object"));
  }

  /**
   * Method under test: {@link PreciseObject#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PreciseObject("Object"), null);
  }

  /**
   * Method under test: {@link PreciseObject#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PreciseObject("Object"), "Different type to PreciseObject");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PreciseObject#toString()}
   *   <li>{@link PreciseObject#getPreciseValue()}
   *   <li>{@link PreciseObject#getType()}
   *   <li>{@link PreciseObject#isModeled()}
   *   <li>{@link PreciseObject#isNull()}
   *   <li>{@link PreciseObject#isPrecise()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    PreciseObject preciseObject = new PreciseObject("Object");

    // Act
    String actualToStringResult = preciseObject.toString();
    Object actualPreciseValue = preciseObject.getPreciseValue();
    String actualType = preciseObject.getType();
    boolean actualIsModeledResult = preciseObject.isModeled();
    boolean actualIsNullResult = preciseObject.isNull();

    // Assert
    assertEquals("Ljava/lang/String;", actualType);
    assertEquals("Object", actualPreciseValue);
    assertEquals("PreciseObject(Object)", actualToStringResult);
    assertFalse(actualIsModeledResult);
    assertFalse(actualIsNullResult);
    assertTrue(preciseObject.isPrecise());
  }

  /**
   * Method under test: {@link PreciseObject#PreciseObject(Object)}
   */
  @Test
  public void testNewPreciseObject() {
    // Arrange and Act
    PreciseObject actualPreciseObject = new PreciseObject("Object");

    // Assert
    assertEquals("Ljava/lang/String;", actualPreciseObject.getType());
    assertEquals("Object", actualPreciseObject.getPreciseValue());
    assertFalse(actualPreciseObject.isModeled());
    assertFalse(actualPreciseObject.isNull());
    assertTrue(actualPreciseObject.isPrecise());
  }
}
