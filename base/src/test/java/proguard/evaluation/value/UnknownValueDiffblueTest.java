package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UnknownValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link UnknownValue}
   *   <li>{@link UnknownValue#toString()}
   *   <li>{@link UnknownValue#isCategory2()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.value.UnknownValue.<init>()",
    "boolean proguard.evaluation.value.UnknownValue.isCategory2()",
    "java.lang.String proguard.evaluation.value.UnknownValue.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    UnknownValue actualUnknownValue = new UnknownValue();
    String actualToStringResult = actualUnknownValue.toString();

    // Assert
    assertEquals("UNKNOWN", actualToStringResult);
    assertFalse(actualUnknownValue.isCategory2());
  }

  /**
   * Test {@link UnknownValue#generalize(Value)}.
   *
   * <p>Method under test: {@link UnknownValue#generalize(Value)}
   */
  @Test
  @DisplayName("Test generalize(Value)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.value.UnknownValue.generalize(proguard.evaluation.value.Value)"
  })
  void testGeneralize() {
    // Arrange
    UnknownValue unknownValue = BasicValueFactory.UNKNOWN_VALUE;

    // Act and Assert
    assertSame(unknownValue, unknownValue.generalize(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link UnknownValue#computationalType()}.
   *
   * <p>Method under test: {@link UnknownValue#computationalType()}
   */
  @Test
  @DisplayName("Test computationalType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.evaluation.value.UnknownValue.computationalType()"})
  void testComputationalType() {
    // Arrange, Act and Assert
    assertEquals(Value.NEVER, BasicValueFactory.UNKNOWN_VALUE.computationalType());
  }

  /**
   * Test {@link UnknownValue#internalType()}.
   *
   * <p>Method under test: {@link UnknownValue#internalType()}
   */
  @Test
  @DisplayName("Test internalType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.evaluation.value.UnknownValue.internalType()"})
  void testInternalType() {
    // Arrange, Act and Assert
    assertNull(BasicValueFactory.UNKNOWN_VALUE.internalType());
  }

  /**
   * Test {@link UnknownValue#equals(Object)}, and {@link UnknownValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UnknownValue#equals(Object)}
   *   <li>{@link UnknownValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.UnknownValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.UnknownValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UnknownValue unknownValue = BasicValueFactory.UNKNOWN_VALUE;
    UnknownValue unknownValue2 = BasicValueFactory.UNKNOWN_VALUE;

    // Act and Assert
    assertEquals(unknownValue, unknownValue2);
    int expectedHashCodeResult = unknownValue.hashCode();
    assertEquals(expectedHashCodeResult, unknownValue2.hashCode());
  }

  /**
   * Test {@link UnknownValue#equals(Object)}, and {@link UnknownValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UnknownValue#equals(Object)}
   *   <li>{@link UnknownValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.UnknownValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.UnknownValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UnknownValue unknownValue = BasicValueFactory.UNKNOWN_VALUE;

    // Act and Assert
    assertEquals(unknownValue, unknownValue);
    int expectedHashCodeResult = unknownValue.hashCode();
    assertEquals(expectedHashCodeResult, unknownValue.hashCode());
  }

  /**
   * Test {@link UnknownValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UnknownValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.UnknownValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.UnknownValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(BasicValueFactory.UNKNOWN_VALUE, 3);
  }

  /**
   * Test {@link UnknownValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UnknownValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.UnknownValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.UnknownValue.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(BasicValueFactory.UNKNOWN_VALUE, null);
  }

  /**
   * Test {@link UnknownValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UnknownValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.UnknownValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.UnknownValue.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(BasicValueFactory.UNKNOWN_VALUE, "Different type to UnknownValue");
  }
}
