package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TopValueDiffblueTest {
  /**
   * Test {@link TopValue#generalize(Value)}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return {@link UnknownValue}.
   * </ul>
   *
   * <p>Method under test: {@link TopValue#generalize(Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value TopValue.generalize(Value)"})
  public void testGeneralize_whenInteger_value_byte_thenReturnUnknownValue() {
    // Arrange and Act
    Value actualGeneralizeResult =
        (new TopValue()).generalize(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link TopValue#generalize(Value)}.
   *
   * <ul>
   *   <li>When {@link TopValue} (default constructor).
   *   <li>Then return {@link TopValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TopValue#generalize(Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value TopValue.generalize(Value)"})
  public void testGeneralize_whenTopValue_thenReturnTopValue() {
    // Arrange
    TopValue topValue = new TopValue();

    // Act and Assert
    assertSame(topValue, topValue.generalize(new TopValue()));
  }

  /**
   * Test {@link TopValue#computationalType()}.
   *
   * <p>Method under test: {@link TopValue#computationalType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TopValue.computationalType()"})
  public void testComputationalType() {
    // Arrange, Act and Assert
    assertEquals(7, (new TopValue()).computationalType());
  }

  /**
   * Test {@link TopValue#internalType()}.
   *
   * <p>Method under test: {@link TopValue#internalType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TopValue.internalType()"})
  public void testInternalType() {
    // Arrange, Act and Assert
    assertNull((new TopValue()).internalType());
  }

  /**
   * Test {@link TopValue#equals(Object)}, and {@link TopValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TopValue#equals(Object)}
   *   <li>{@link TopValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TopValue.equals(Object)", "int TopValue.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TopValue topValue = new TopValue();
    TopValue topValue2 = new TopValue();

    // Act and Assert
    assertEquals(topValue, topValue2);
    int expectedHashCodeResult = topValue.hashCode();
    assertEquals(expectedHashCodeResult, topValue2.hashCode());
  }

  /**
   * Test {@link TopValue#equals(Object)}, and {@link TopValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TopValue#equals(Object)}
   *   <li>{@link TopValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TopValue.equals(Object)", "int TopValue.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TopValue topValue = new TopValue();

    // Act and Assert
    assertEquals(topValue, topValue);
    int expectedHashCodeResult = topValue.hashCode();
    assertEquals(expectedHashCodeResult, topValue.hashCode());
  }

  /**
   * Test {@link TopValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TopValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TopValue.equals(Object)", "int TopValue.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TopValue(), 1);
  }

  /**
   * Test {@link TopValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TopValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TopValue.equals(Object)", "int TopValue.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TopValue(), null);
  }

  /**
   * Test {@link TopValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TopValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TopValue.equals(Object)", "int TopValue.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TopValue(), "Different type to TopValue");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TopValue}
   *   <li>{@link TopValue#toString()}
   *   <li>{@link TopValue#isParticular()}
   *   <li>{@link TopValue#isSpecific()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void TopValue.<init>()",
    "boolean TopValue.isParticular()",
    "boolean TopValue.isSpecific()",
    "String TopValue.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    TopValue actualTopValue = new TopValue();
    String actualToStringResult = actualTopValue.toString();
    boolean actualIsParticularResult = actualTopValue.isParticular();

    // Assert
    assertEquals("T", actualToStringResult);
    assertTrue(actualIsParticularResult);
    assertTrue(actualTopValue.isSpecific());
  }
}
