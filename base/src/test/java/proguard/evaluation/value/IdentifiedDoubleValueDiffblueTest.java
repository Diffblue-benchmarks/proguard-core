package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.evaluation.ParticularReferenceValueFactory;

public class IdentifiedDoubleValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IdentifiedDoubleValue#IdentifiedDoubleValue(ValueFactory, int)}
   *   <li>{@link IdentifiedDoubleValue#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void IdentifiedDoubleValue.<init>(ValueFactory, int)",
    "java.lang.String IdentifiedDoubleValue.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(
        "d1", (new IdentifiedDoubleValue(new ParticularReferenceValueFactory(), 1)).toString());
  }

  /**
   * Test {@link IdentifiedDoubleValue#equals(Object)}, and {@link
   * IdentifiedDoubleValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IdentifiedDoubleValue#equals(Object)}
   *   <li>{@link IdentifiedDoubleValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean IdentifiedDoubleValue.equals(Object)",
    "int IdentifiedDoubleValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    IdentifiedDoubleValue identifiedDoubleValue =
        new IdentifiedDoubleValue(new ParticularReferenceValueFactory(), 1);

    // Act and Assert
    assertEquals(identifiedDoubleValue, identifiedDoubleValue);
    int expectedHashCodeResult = identifiedDoubleValue.hashCode();
    assertEquals(expectedHashCodeResult, identifiedDoubleValue.hashCode());
  }

  /**
   * Test {@link IdentifiedDoubleValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedDoubleValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean IdentifiedDoubleValue.equals(Object)",
    "int IdentifiedDoubleValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    IdentifiedDoubleValue identifiedDoubleValue =
        new IdentifiedDoubleValue(new ParticularReferenceValueFactory(), 1);

    // Act and Assert
    assertNotEquals(
        identifiedDoubleValue, new IdentifiedDoubleValue(new ParticularReferenceValueFactory(), 1));
  }

  /**
   * Test {@link IdentifiedDoubleValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedDoubleValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean IdentifiedDoubleValue.equals(Object)",
    "int IdentifiedDoubleValue.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new IdentifiedDoubleValue(new ParticularReferenceValueFactory(), 1), null);
  }

  /**
   * Test {@link IdentifiedDoubleValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedDoubleValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean IdentifiedDoubleValue.equals(Object)",
    "int IdentifiedDoubleValue.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new IdentifiedDoubleValue(new ParticularReferenceValueFactory(), 1),
        "Different type to IdentifiedDoubleValue");
  }
}
