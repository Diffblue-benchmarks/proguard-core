package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.evaluation.ParticularReferenceValueFactory;

public class IdentifiedFloatValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IdentifiedFloatValue#IdentifiedFloatValue(ValueFactory, int)}
   *   <li>{@link IdentifiedFloatValue#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void IdentifiedFloatValue.<init>(ValueFactory, int)",
    "java.lang.String IdentifiedFloatValue.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(
        "f1", (new IdentifiedFloatValue(new ParticularReferenceValueFactory(), 1)).toString());
  }

  /**
   * Test {@link IdentifiedFloatValue#equals(Object)}, and {@link IdentifiedFloatValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IdentifiedFloatValue#equals(Object)}
   *   <li>{@link IdentifiedFloatValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean IdentifiedFloatValue.equals(Object)",
    "int IdentifiedFloatValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    IdentifiedFloatValue identifiedFloatValue =
        new IdentifiedFloatValue(new ParticularReferenceValueFactory(), 1);

    // Act and Assert
    assertEquals(identifiedFloatValue, identifiedFloatValue);
    int expectedHashCodeResult = identifiedFloatValue.hashCode();
    assertEquals(expectedHashCodeResult, identifiedFloatValue.hashCode());
  }

  /**
   * Test {@link IdentifiedFloatValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedFloatValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean IdentifiedFloatValue.equals(Object)",
    "int IdentifiedFloatValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    IdentifiedFloatValue identifiedFloatValue =
        new IdentifiedFloatValue(new ParticularReferenceValueFactory(), 1);

    // Act and Assert
    assertNotEquals(
        identifiedFloatValue, new IdentifiedFloatValue(new ParticularReferenceValueFactory(), 1));
  }

  /**
   * Test {@link IdentifiedFloatValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedFloatValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean IdentifiedFloatValue.equals(Object)",
    "int IdentifiedFloatValue.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new IdentifiedFloatValue(new ParticularReferenceValueFactory(), 1), null);
  }

  /**
   * Test {@link IdentifiedFloatValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedFloatValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean IdentifiedFloatValue.equals(Object)",
    "int IdentifiedFloatValue.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new IdentifiedFloatValue(new ParticularReferenceValueFactory(), 1),
        "Different type to IdentifiedFloatValue");
  }
}
