package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.evaluation.ParticularReferenceValueFactory;

public class IdentifiedIntegerValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IdentifiedIntegerValue#IdentifiedIntegerValue(ValueFactory, int)}
   *   <li>{@link IdentifiedIntegerValue#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void IdentifiedIntegerValue.<init>(ValueFactory, int)",
    "java.lang.String IdentifiedIntegerValue.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(
        "i1", (new IdentifiedIntegerValue(new ParticularReferenceValueFactory(), 1)).toString());
  }

  /**
   * Test {@link IdentifiedIntegerValue#equals(Object)}, and {@link
   * IdentifiedIntegerValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IdentifiedIntegerValue#equals(Object)}
   *   <li>{@link IdentifiedIntegerValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean IdentifiedIntegerValue.equals(Object)",
    "int IdentifiedIntegerValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    IdentifiedIntegerValue identifiedIntegerValue =
        new IdentifiedIntegerValue(new ParticularReferenceValueFactory(), 1);

    // Act and Assert
    assertEquals(identifiedIntegerValue, identifiedIntegerValue);
    int expectedHashCodeResult = identifiedIntegerValue.hashCode();
    assertEquals(expectedHashCodeResult, identifiedIntegerValue.hashCode());
  }

  /**
   * Test {@link IdentifiedIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedIntegerValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean IdentifiedIntegerValue.equals(Object)",
    "int IdentifiedIntegerValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    IdentifiedIntegerValue identifiedIntegerValue =
        new IdentifiedIntegerValue(new ParticularReferenceValueFactory(), 1);

    // Act and Assert
    assertNotEquals(
        identifiedIntegerValue,
        new IdentifiedIntegerValue(new ParticularReferenceValueFactory(), 1));
  }

  /**
   * Test {@link IdentifiedIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedIntegerValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean IdentifiedIntegerValue.equals(Object)",
    "int IdentifiedIntegerValue.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new IdentifiedIntegerValue(new ParticularReferenceValueFactory(), 1), null);
  }

  /**
   * Test {@link IdentifiedIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedIntegerValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean IdentifiedIntegerValue.equals(Object)",
    "int IdentifiedIntegerValue.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new IdentifiedIntegerValue(new ParticularReferenceValueFactory(), 1),
        "Different type to IdentifiedIntegerValue");
  }
}
