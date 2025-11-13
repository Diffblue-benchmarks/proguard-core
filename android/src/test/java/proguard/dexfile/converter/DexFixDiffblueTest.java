package proguard.dexfile.converter;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.ir.expr.Constant;

class DexFixDiffblueTest {
  /**
   * Test {@link DexFix#isPrimitiveZero(String, Object)}.
   *
   * <ul>
   *   <li>When {@code Desc}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DexFix#isPrimitiveZero(String, Object)}
   */
  @Test
  @DisplayName("Test isPrimitiveZero(String, Object); when 'Desc'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DexFix.isPrimitiveZero(String, Object)"})
  void testIsPrimitiveZero_whenDesc_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(DexFix.isPrimitiveZero("Desc", 0.0d));
  }

  /**
   * Test {@link DexFix#isPrimitiveZero(String, Object)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DexFix#isPrimitiveZero(String, Object)}
   */
  @Test
  @DisplayName("Test isPrimitiveZero(String, Object); when empty string; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DexFix.isPrimitiveZero(String, Object)"})
  void testIsPrimitiveZero_whenEmptyString_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(DexFix.isPrimitiveZero("", Constant.Null));
  }

  /**
   * Test {@link DexFix#isPrimitiveZero(String, Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DexFix#isPrimitiveZero(String, Object)}
   */
  @Test
  @DisplayName("Test isPrimitiveZero(String, Object); when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DexFix.isPrimitiveZero(String, Object)"})
  void testIsPrimitiveZero_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(DexFix.isPrimitiveZero(null, 0));
  }

  /**
   * Test {@link DexFix#isPrimitiveZero(String, Object)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DexFix#isPrimitiveZero(String, Object)}
   */
  @Test
  @DisplayName("Test isPrimitiveZero(String, Object); when ten; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DexFix.isPrimitiveZero(String, Object)"})
  void testIsPrimitiveZero_whenTen_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(DexFix.isPrimitiveZero("Desc", 10.0d));
  }

  /**
   * Test {@link DexFix#isPrimitiveZero(String, Object)}.
   *
   * <ul>
   *   <li>When {@code The characteristics of someone or something}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DexFix#isPrimitiveZero(String, Object)}
   */
  @Test
  @DisplayName(
      "Test isPrimitiveZero(String, Object); when 'The characteristics of someone or something'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DexFix.isPrimitiveZero(String, Object)"})
  void testIsPrimitiveZero_whenTheCharacteristicsOfSomeoneOrSomething_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        DexFix.isPrimitiveZero("The characteristics of someone or something", Constant.Null));
  }

  /**
   * Test {@link DexFix#isPrimitiveZero(String, Object)}.
   *
   * <ul>
   *   <li>When {@code The characteristics of someone or something}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DexFix#isPrimitiveZero(String, Object)}
   */
  @Test
  @DisplayName(
      "Test isPrimitiveZero(String, Object); when 'The characteristics of someone or something'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DexFix.isPrimitiveZero(String, Object)"})
  void testIsPrimitiveZero_whenTheCharacteristicsOfSomeoneOrSomething_thenReturnFalse2() {
    // Arrange, Act and Assert
    assertFalse(DexFix.isPrimitiveZero("The characteristics of someone or something", null));
  }
}
