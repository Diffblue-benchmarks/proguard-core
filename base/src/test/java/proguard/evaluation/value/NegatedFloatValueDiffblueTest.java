package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class NegatedFloatValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NegatedFloatValue#NegatedFloatValue(FloatValue)}
   *   <li>{@link NegatedFloatValue#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void NegatedFloatValue.<init>(FloatValue)",
    "java.lang.String NegatedFloatValue.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("-f", (new NegatedFloatValue(BasicValueFactory.FLOAT_VALUE)).toString());
  }

  /**
   * Test {@link NegatedFloatValue#negate()}.
   *
   * <p>Method under test: {@link NegatedFloatValue#negate()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue NegatedFloatValue.negate()"})
  public void testNegate() {
    // Arrange and Act
    FloatValue actualNegateResult = (new NegatedFloatValue(BasicValueFactory.FLOAT_VALUE)).negate();

    // Assert
    assertTrue(actualNegateResult instanceof UnknownFloatValue);
    assertFalse(actualNegateResult.isCategory2());
    assertFalse(actualNegateResult.isParticular());
    assertFalse(actualNegateResult.isSpecific());
  }

  /**
   * Test {@link NegatedFloatValue#equals(Object)}, and {@link NegatedFloatValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NegatedFloatValue#equals(Object)}
   *   <li>{@link NegatedFloatValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NegatedFloatValue.equals(Object)",
    "int NegatedFloatValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NegatedFloatValue negatedFloatValue = new NegatedFloatValue(BasicValueFactory.FLOAT_VALUE);
    NegatedFloatValue negatedFloatValue2 = new NegatedFloatValue(BasicValueFactory.FLOAT_VALUE);

    // Act and Assert
    assertEquals(negatedFloatValue, negatedFloatValue2);
    int expectedHashCodeResult = negatedFloatValue.hashCode();
    assertEquals(expectedHashCodeResult, negatedFloatValue2.hashCode());
  }

  /**
   * Test {@link NegatedFloatValue#equals(Object)}, and {@link NegatedFloatValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NegatedFloatValue#equals(Object)}
   *   <li>{@link NegatedFloatValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NegatedFloatValue.equals(Object)",
    "int NegatedFloatValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NegatedFloatValue negatedFloatValue = new NegatedFloatValue(BasicValueFactory.FLOAT_VALUE);

    // Act and Assert
    assertEquals(negatedFloatValue, negatedFloatValue);
    int expectedHashCodeResult = negatedFloatValue.hashCode();
    assertEquals(expectedHashCodeResult, negatedFloatValue.hashCode());
  }

  /**
   * Test {@link NegatedFloatValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NegatedFloatValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NegatedFloatValue.equals(Object)",
    "int NegatedFloatValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NegatedFloatValue negatedFloatValue =
        new NegatedFloatValue(ParticularValueFactory.FLOAT_VALUE_0);

    // Act and Assert
    assertNotEquals(negatedFloatValue, new NegatedFloatValue(BasicValueFactory.FLOAT_VALUE));
  }

  /**
   * Test {@link NegatedFloatValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NegatedFloatValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NegatedFloatValue.equals(Object)",
    "int NegatedFloatValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NegatedFloatValue negatedFloatValue =
        new NegatedFloatValue(new NegatedFloatValue(BasicValueFactory.FLOAT_VALUE));

    // Act and Assert
    assertNotEquals(negatedFloatValue, new NegatedFloatValue(BasicValueFactory.FLOAT_VALUE));
  }

  /**
   * Test {@link NegatedFloatValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NegatedFloatValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NegatedFloatValue.equals(Object)",
    "int NegatedFloatValue.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NegatedFloatValue(BasicValueFactory.FLOAT_VALUE), null);
  }

  /**
   * Test {@link NegatedFloatValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NegatedFloatValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NegatedFloatValue.equals(Object)",
    "int NegatedFloatValue.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new NegatedFloatValue(BasicValueFactory.FLOAT_VALUE),
        "Different type to NegatedFloatValue");
  }
}
