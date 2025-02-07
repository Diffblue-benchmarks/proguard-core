package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TopValueDiffblueTest {
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
  @DisplayName("Test generalize(Value); when INTEGER_VALUE_BYTE; then return UnknownValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.value.TopValue.generalize(proguard.evaluation.value.Value)"
  })
  void testGeneralize_whenInteger_value_byte_thenReturnUnknownValue() {
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
  @DisplayName(
      "Test generalize(Value); when TopValue (default constructor); then return TopValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.value.TopValue.generalize(proguard.evaluation.value.Value)"
  })
  void testGeneralize_whenTopValue_thenReturnTopValue() {
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
  @DisplayName("Test computationalType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.evaluation.value.TopValue.computationalType()"})
  void testComputationalType() {
    // Arrange, Act and Assert
    assertEquals(7, (new TopValue()).computationalType());
  }

  /**
   * Test {@link TopValue#internalType()}.
   *
   * <p>Method under test: {@link TopValue#internalType()}
   */
  @Test
  @DisplayName("Test internalType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.evaluation.value.TopValue.internalType()"})
  void testInternalType() {
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.TopValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.TopValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.TopValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.TopValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.TopValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.TopValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.TopValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.TopValue.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.TopValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.TopValue.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.value.TopValue.<init>()",
    "boolean proguard.evaluation.value.TopValue.isParticular()",
    "boolean proguard.evaluation.value.TopValue.isSpecific()",
    "java.lang.String proguard.evaluation.value.TopValue.toString()"
  })
  void testGettersAndSetters() {
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
