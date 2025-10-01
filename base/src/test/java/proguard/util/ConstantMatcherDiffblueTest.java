package proguard.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ConstantMatcherDiffblueTest {
  /**
   * Test {@link ConstantMatcher#prefix()}.
   *
   * <ul>
   *   <li>Given {@link ConstantMatcher#ConstantMatcher(boolean)} with matches is {@code false}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantMatcher#prefix()}
   */
  @Test
  @DisplayName(
      "Test prefix(); given ConstantMatcher(boolean) with matches is 'false'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ConstantMatcher.prefix()"})
  void testPrefix_givenConstantMatcherWithMatchesIsFalse_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ConstantMatcher(false).prefix());
  }

  /**
   * Test {@link ConstantMatcher#prefix()}.
   *
   * <ul>
   *   <li>Given {@link ConstantMatcher#ConstantMatcher(boolean)} with matches is {@code true}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ConstantMatcher#prefix()}
   */
  @Test
  @DisplayName(
      "Test prefix(); given ConstantMatcher(boolean) with matches is 'true'; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ConstantMatcher.prefix()"})
  void testPrefix_givenConstantMatcherWithMatchesIsTrue_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new ConstantMatcher(true).prefix());
  }

  /**
   * Test {@link ConstantMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName(
      "Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ConstantMatcher.matches(String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new ConstantMatcher(false).matches("String", 1, 3));
  }

  /**
   * Test {@link ConstantMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName(
      "Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ConstantMatcher.matches(String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new ConstantMatcher(true).matches("String", 1, 3));
  }
}
