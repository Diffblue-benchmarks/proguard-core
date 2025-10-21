package proguard.evaluation.value.object;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PreciseObjectDiffblueTest {
  /**
   * Test {@link PreciseObject#PreciseObject(Object)}.
   *
   * <p>Method under test: {@link PreciseObject#PreciseObject(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PreciseObject.<init>(Object)"})
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

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Object PreciseObject.getPreciseValue()",
    "String PreciseObject.getType()",
    "boolean PreciseObject.isModeled()",
    "boolean PreciseObject.isNull()",
    "boolean PreciseObject.isPrecise()",
    "String PreciseObject.toString()"
  })
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
   * Test {@link PreciseObject#equals(Object)}, and {@link PreciseObject#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PreciseObject#equals(Object)}
   *   <li>{@link PreciseObject#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PreciseObject.equals(Object)", "int PreciseObject.hashCode()"})
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
   * Test {@link PreciseObject#equals(Object)}, and {@link PreciseObject#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PreciseObject#equals(Object)}
   *   <li>{@link PreciseObject#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PreciseObject.equals(Object)", "int PreciseObject.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PreciseObject preciseObject = new PreciseObject("Object");

    // Act and Assert
    assertEquals(preciseObject, preciseObject);
    int expectedHashCodeResult = preciseObject.hashCode();
    assertEquals(expectedHashCodeResult, preciseObject.hashCode());
  }

  /**
   * Test {@link PreciseObject#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PreciseObject#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PreciseObject.equals(Object)", "int PreciseObject.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PreciseObject preciseObject = new PreciseObject(1);

    // Act and Assert
    assertNotEquals(preciseObject, new PreciseObject("Object"));
  }

  /**
   * Test {@link PreciseObject#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PreciseObject#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PreciseObject.equals(Object)", "int PreciseObject.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PreciseObject preciseObject = new PreciseObject(new PreciseObject("Object"));

    // Act and Assert
    assertNotEquals(preciseObject, new PreciseObject("Object"));
  }

  /**
   * Test {@link PreciseObject#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PreciseObject#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PreciseObject.equals(Object)", "int PreciseObject.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PreciseObject("Object"), null);
  }

  /**
   * Test {@link PreciseObject#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PreciseObject#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PreciseObject.equals(Object)", "int PreciseObject.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PreciseObject("Object"), "Different type to PreciseObject");
  }
}
