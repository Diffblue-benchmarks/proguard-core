package proguard.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StringMatcherDiffblueTest {
  /**
   * Test {@link StringMatcher#matches(String)} with {@code String}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link StringMatcher#matches(String)}
   */
  @Test
  @DisplayName("Test matches(String) with 'String'; when empty string; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringMatcher.matches(String)"})
  void testMatchesWithString_whenEmptyString_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new EmptyStringMatcher().matches(""));
  }

  /**
   * Test {@link StringMatcher#matches(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code String}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StringMatcher#matches(String)}
   */
  @Test
  @DisplayName("Test matches(String) with 'String'; when 'String'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringMatcher.matches(String)"})
  void testMatchesWithString_whenString_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new EmptyStringMatcher().matches("String"));
  }

  /**
   * Test {@link StringMatcher#prefix()}.
   *
   * <p>Method under test: {@link StringMatcher#prefix()}
   */
  @Test
  @DisplayName("Test prefix()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringMatcher.prefix()"})
  void testPrefix() {
    // Arrange, Act and Assert
    assertEquals("", new EmptyStringMatcher().prefix());
  }
}
