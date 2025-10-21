package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.evaluation.ParticularReferenceValueFactory;

public class IdentifiedLongValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IdentifiedLongValue#IdentifiedLongValue(ValueFactory, int)}
   *   <li>{@link IdentifiedLongValue#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void IdentifiedLongValue.<init>(ValueFactory, int)",
    "java.lang.String IdentifiedLongValue.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(
        "l1", (new IdentifiedLongValue(new ParticularReferenceValueFactory(), 1)).toString());
  }

  /**
   * Test {@link IdentifiedLongValue#equals(Object)}, and {@link IdentifiedLongValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IdentifiedLongValue#equals(Object)}
   *   <li>{@link IdentifiedLongValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean IdentifiedLongValue.equals(Object)",
    "int IdentifiedLongValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    IdentifiedLongValue identifiedLongValue =
        new IdentifiedLongValue(new ParticularReferenceValueFactory(), 1);

    // Act and Assert
    assertEquals(identifiedLongValue, identifiedLongValue);
    int expectedHashCodeResult = identifiedLongValue.hashCode();
    assertEquals(expectedHashCodeResult, identifiedLongValue.hashCode());
  }

  /**
   * Test {@link IdentifiedLongValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedLongValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean IdentifiedLongValue.equals(Object)",
    "int IdentifiedLongValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    IdentifiedLongValue identifiedLongValue =
        new IdentifiedLongValue(new ParticularReferenceValueFactory(), 1);

    // Act and Assert
    assertNotEquals(
        identifiedLongValue, new IdentifiedLongValue(new ParticularReferenceValueFactory(), 1));
  }

  /**
   * Test {@link IdentifiedLongValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedLongValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean IdentifiedLongValue.equals(Object)",
    "int IdentifiedLongValue.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new IdentifiedLongValue(new ParticularReferenceValueFactory(), 1), null);
  }

  /**
   * Test {@link IdentifiedLongValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedLongValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean IdentifiedLongValue.equals(Object)",
    "int IdentifiedLongValue.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new IdentifiedLongValue(new ParticularReferenceValueFactory(), 1),
        "Different type to IdentifiedLongValue");
  }
}
