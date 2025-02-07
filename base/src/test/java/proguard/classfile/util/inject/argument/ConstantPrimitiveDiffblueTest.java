package proguard.classfile.util.inject.argument;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ConstantPrimitiveDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConstantPrimitive#ConstantPrimitive(Number)}
   *   <li>{@link ConstantPrimitive#toString()}
   *   <li>{@link ConstantPrimitive#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.inject.argument.ConstantPrimitive.<init>(java.lang.Number)",
    "java.lang.Object proguard.classfile.util.inject.argument.ConstantPrimitive.getValue()",
    "java.lang.String proguard.classfile.util.inject.argument.ConstantPrimitive.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Integer valueOfResult = Integer.valueOf(1);

    // Act
    ConstantPrimitive<Number> actualConstantPrimitive = new ConstantPrimitive<>(valueOfResult);
    String actualToStringResult = actualConstantPrimitive.toString();

    // Assert
    assertEquals("1:int", actualToStringResult);
    assertSame(valueOfResult, actualConstantPrimitive.getValue());
  }

  /**
   * Test {@link ConstantPrimitive#getInternalType()}.
   *
   * <ul>
   *   <li>Given {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPrimitive#getInternalType()}
   */
  @Test
  @DisplayName(
      "Test getInternalType(); given BigDecimal(String) with '2.3'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.inject.argument.ConstantPrimitive.getInternalType()"
  })
  void testGetInternalType_givenBigDecimalWith23_thenThrowRuntimeException() {
    // Arrange
    ConstantPrimitive<Number> constantPrimitive = new ConstantPrimitive<>(new BigDecimal("2.3"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> constantPrimitive.getInternalType());
  }

  /**
   * Test {@link ConstantPrimitive#getInternalType()}.
   *
   * <ul>
   *   <li>Given {@link ConstantPrimitive#ConstantPrimitive(Number)} with constant is {@code A}.
   *   <li>Then return {@code B}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPrimitive#getInternalType()}
   */
  @Test
  @DisplayName(
      "Test getInternalType(); given ConstantPrimitive(Number) with constant is 'A'; then return 'B'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.inject.argument.ConstantPrimitive.getInternalType()"
  })
  void testGetInternalType_givenConstantPrimitiveWithConstantIsA_thenReturnB() {
    // Arrange
    ConstantPrimitive<Number> constantPrimitive = new ConstantPrimitive<>((byte) 'A');

    // Act and Assert
    assertEquals("B", constantPrimitive.getInternalType());
  }

  /**
   * Test {@link ConstantPrimitive#getInternalType()}.
   *
   * <ul>
   *   <li>Given {@link ConstantPrimitive#ConstantPrimitive(Number)} with constant is minus one.
   *   <li>Then return {@code J}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPrimitive#getInternalType()}
   */
  @Test
  @DisplayName(
      "Test getInternalType(); given ConstantPrimitive(Number) with constant is minus one; then return 'J'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.inject.argument.ConstantPrimitive.getInternalType()"
  })
  void testGetInternalType_givenConstantPrimitiveWithConstantIsMinusOne_thenReturnJ() {
    // Arrange
    ConstantPrimitive<Number> constantPrimitive = new ConstantPrimitive<>(-1L);

    // Act and Assert
    assertEquals("J", constantPrimitive.getInternalType());
  }

  /**
   * Test {@link ConstantPrimitive#getInternalType()}.
   *
   * <ul>
   *   <li>Given {@link ConstantPrimitive#ConstantPrimitive(Number)} with constant is minus one.
   *   <li>Then return {@code S}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPrimitive#getInternalType()}
   */
  @Test
  @DisplayName(
      "Test getInternalType(); given ConstantPrimitive(Number) with constant is minus one; then return 'S'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.inject.argument.ConstantPrimitive.getInternalType()"
  })
  void testGetInternalType_givenConstantPrimitiveWithConstantIsMinusOne_thenReturnS() {
    // Arrange
    ConstantPrimitive<Number> constantPrimitive = new ConstantPrimitive<>((short) -1);

    // Act and Assert
    assertEquals("S", constantPrimitive.getInternalType());
  }

  /**
   * Test {@link ConstantPrimitive#getInternalType()}.
   *
   * <ul>
   *   <li>Given {@link ConstantPrimitive#ConstantPrimitive(Number)} with constant is ten.
   *   <li>Then return {@code D}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPrimitive#getInternalType()}
   */
  @Test
  @DisplayName(
      "Test getInternalType(); given ConstantPrimitive(Number) with constant is ten; then return 'D'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.inject.argument.ConstantPrimitive.getInternalType()"
  })
  void testGetInternalType_givenConstantPrimitiveWithConstantIsTen_thenReturnD() {
    // Arrange
    ConstantPrimitive<Number> constantPrimitive = new ConstantPrimitive<>(10.0d);

    // Act and Assert
    assertEquals("D", constantPrimitive.getInternalType());
  }

  /**
   * Test {@link ConstantPrimitive#getInternalType()}.
   *
   * <ul>
   *   <li>Given {@link ConstantPrimitive#ConstantPrimitive(Number)} with constant is ten.
   *   <li>Then return {@code F}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPrimitive#getInternalType()}
   */
  @Test
  @DisplayName(
      "Test getInternalType(); given ConstantPrimitive(Number) with constant is ten; then return 'F'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.inject.argument.ConstantPrimitive.getInternalType()"
  })
  void testGetInternalType_givenConstantPrimitiveWithConstantIsTen_thenReturnF() {
    // Arrange
    ConstantPrimitive<Number> constantPrimitive = new ConstantPrimitive<>(10.0f);

    // Act and Assert
    assertEquals("F", constantPrimitive.getInternalType());
  }

  /**
   * Test {@link ConstantPrimitive#getInternalType()}.
   *
   * <ul>
   *   <li>Given {@link ConstantPrimitive#ConstantPrimitive(Number)} with constant is valueOf one.
   *   <li>Then return {@code I}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPrimitive#getInternalType()}
   */
  @Test
  @DisplayName(
      "Test getInternalType(); given ConstantPrimitive(Number) with constant is valueOf one; then return 'I'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.inject.argument.ConstantPrimitive.getInternalType()"
  })
  void testGetInternalType_givenConstantPrimitiveWithConstantIsValueOfOne_thenReturnI() {
    // Arrange
    ConstantPrimitive<Number> constantPrimitive = new ConstantPrimitive<>(Integer.valueOf(1));

    // Act and Assert
    assertEquals("I", constantPrimitive.getInternalType());
  }
}
