package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class NegatedDoubleValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NegatedDoubleValue#NegatedDoubleValue(DoubleValue)}
   *   <li>{@link NegatedDoubleValue#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void NegatedDoubleValue.<init>(DoubleValue)",
    "java.lang.String NegatedDoubleValue.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("-d", (new NegatedDoubleValue(BasicValueFactory.DOUBLE_VALUE)).toString());
  }

  /**
   * Test {@link NegatedDoubleValue#negate()}.
   *
   * <p>Method under test: {@link NegatedDoubleValue#negate()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue NegatedDoubleValue.negate()"})
  public void testNegate() {
    // Arrange and Act
    DoubleValue actualNegateResult =
        (new NegatedDoubleValue(BasicValueFactory.DOUBLE_VALUE)).negate();

    // Assert
    assertTrue(actualNegateResult instanceof UnknownDoubleValue);
    assertFalse(actualNegateResult.isParticular());
    assertFalse(actualNegateResult.isSpecific());
    assertTrue(actualNegateResult.isCategory2());
  }

  /**
   * Test {@link NegatedDoubleValue#equals(Object)}, and {@link NegatedDoubleValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NegatedDoubleValue#equals(Object)}
   *   <li>{@link NegatedDoubleValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NegatedDoubleValue.equals(Object)",
    "int NegatedDoubleValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NegatedDoubleValue negatedDoubleValue = new NegatedDoubleValue(BasicValueFactory.DOUBLE_VALUE);
    NegatedDoubleValue negatedDoubleValue2 = new NegatedDoubleValue(BasicValueFactory.DOUBLE_VALUE);

    // Act and Assert
    assertEquals(negatedDoubleValue, negatedDoubleValue2);
    int expectedHashCodeResult = negatedDoubleValue.hashCode();
    assertEquals(expectedHashCodeResult, negatedDoubleValue2.hashCode());
  }

  /**
   * Test {@link NegatedDoubleValue#equals(Object)}, and {@link NegatedDoubleValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NegatedDoubleValue#equals(Object)}
   *   <li>{@link NegatedDoubleValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NegatedDoubleValue.equals(Object)",
    "int NegatedDoubleValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NegatedDoubleValue negatedDoubleValue = new NegatedDoubleValue(BasicValueFactory.DOUBLE_VALUE);

    // Act and Assert
    assertEquals(negatedDoubleValue, negatedDoubleValue);
    int expectedHashCodeResult = negatedDoubleValue.hashCode();
    assertEquals(expectedHashCodeResult, negatedDoubleValue.hashCode());
  }

  /**
   * Test {@link NegatedDoubleValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NegatedDoubleValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NegatedDoubleValue.equals(Object)",
    "int NegatedDoubleValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NegatedDoubleValue negatedDoubleValue =
        new NegatedDoubleValue(ParticularValueFactory.DOUBLE_VALUE_0);

    // Act and Assert
    assertNotEquals(negatedDoubleValue, new NegatedDoubleValue(BasicValueFactory.DOUBLE_VALUE));
  }

  /**
   * Test {@link NegatedDoubleValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NegatedDoubleValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NegatedDoubleValue.equals(Object)",
    "int NegatedDoubleValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NegatedDoubleValue negatedDoubleValue =
        new NegatedDoubleValue(new NegatedDoubleValue(BasicValueFactory.DOUBLE_VALUE));

    // Act and Assert
    assertNotEquals(negatedDoubleValue, new NegatedDoubleValue(BasicValueFactory.DOUBLE_VALUE));
  }

  /**
   * Test {@link NegatedDoubleValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NegatedDoubleValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NegatedDoubleValue.equals(Object)",
    "int NegatedDoubleValue.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NegatedDoubleValue(BasicValueFactory.DOUBLE_VALUE), null);
  }

  /**
   * Test {@link NegatedDoubleValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NegatedDoubleValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NegatedDoubleValue.equals(Object)",
    "int NegatedDoubleValue.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new NegatedDoubleValue(BasicValueFactory.DOUBLE_VALUE),
        "Different type to NegatedDoubleValue");
  }
}
