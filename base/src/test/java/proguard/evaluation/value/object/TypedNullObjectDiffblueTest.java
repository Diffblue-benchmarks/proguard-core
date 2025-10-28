package proguard.evaluation.value.object;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TypedNullObjectDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TypedNullObject#equals(Object)}
   *   <li>{@link TypedNullObject#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TypedNullObject typedNullObject = new TypedNullObject("Type");
    TypedNullObject typedNullObject2 = new TypedNullObject("Type");

    // Act and Assert
    assertEquals(typedNullObject, typedNullObject2);
    int expectedHashCodeResult = typedNullObject.hashCode();
    assertEquals(expectedHashCodeResult, typedNullObject2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TypedNullObject#equals(Object)}
   *   <li>{@link TypedNullObject#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TypedNullObject typedNullObject = new TypedNullObject("Type");

    // Act and Assert
    assertEquals(typedNullObject, typedNullObject);
    int expectedHashCodeResult = typedNullObject.hashCode();
    assertEquals(expectedHashCodeResult, typedNullObject.hashCode());
  }

  /**
   * Method under test: {@link TypedNullObject#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TypedNullObject typedNullObject = new TypedNullObject("proguard.evaluation.value.object.TypedNullObject");

    // Act and Assert
    assertNotEquals(typedNullObject, new TypedNullObject("Type"));
  }

  /**
   * Method under test: {@link TypedNullObject#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TypedNullObject("Type"), null);
  }

  /**
   * Method under test: {@link TypedNullObject#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TypedNullObject("Type"), "Different type to TypedNullObject");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TypedNullObject#TypedNullObject(String)}
   *   <li>{@link TypedNullObject#toString()}
   *   <li>{@link TypedNullObject#getPreciseValue()}
   *   <li>{@link TypedNullObject#getType()}
   *   <li>{@link TypedNullObject#isModeled()}
   *   <li>{@link TypedNullObject#isNull()}
   *   <li>{@link TypedNullObject#isPrecise()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    TypedNullObject actualTypedNullObject = new TypedNullObject("Type");
    String actualToStringResult = actualTypedNullObject.toString();
    Object actualPreciseValue = actualTypedNullObject.getPreciseValue();
    String actualType = actualTypedNullObject.getType();
    boolean actualIsModeledResult = actualTypedNullObject.isModeled();
    boolean actualIsNullResult = actualTypedNullObject.isNull();

    // Assert
    assertEquals("Type", actualType);
    assertEquals("TypedNullObject(Type)", actualToStringResult);
    assertNull(actualPreciseValue);
    assertFalse(actualIsModeledResult);
    assertTrue(actualIsNullResult);
    assertTrue(actualTypedNullObject.isPrecise());
  }
}
