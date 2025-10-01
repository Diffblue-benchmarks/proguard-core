package proguard.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EmptyStringMatcherDiffblueTest {
  /**
   * Test {@link EmptyStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EmptyStringMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName(
      "Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'; when one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EmptyStringMatcher.matches(String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new EmptyStringMatcher().matches("String", 1, 3));
  }

  /**
   * Test {@link EmptyStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <ul>
   *   <li>When {@code String}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EmptyStringMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName(
      "Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'; when 'String'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EmptyStringMatcher.matches(String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset_whenString_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new EmptyStringMatcher().matches("String", 3, 3));
  }
}
