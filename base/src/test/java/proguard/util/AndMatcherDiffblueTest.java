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

class AndMatcherDiffblueTest {
  /**
   * Test {@link AndMatcher#prefix()}.
   *
   * <p>Method under test: {@link AndMatcher#prefix()}
   */
  @Test
  @DisplayName("Test prefix()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AndMatcher.prefix()"})
  void testPrefix() {
    // Arrange
    EmptyStringMatcher matcher1 = new EmptyStringMatcher();
    AndMatcher andMatcher = new AndMatcher(matcher1, new EmptyStringMatcher());

    // Act and Assert
    assertEquals("", andMatcher.prefix());
  }

  /**
   * Test {@link AndMatcher#prefix()}.
   *
   * <p>Method under test: {@link AndMatcher#prefix()}
   */
  @Test
  @DisplayName("Test prefix()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AndMatcher.prefix()"})
  void testPrefix2() {
    // Arrange
    EmptyStringMatcher matcher1 = new EmptyStringMatcher();
    AndMatcher matcher12 = new AndMatcher(matcher1, new EmptyStringMatcher());
    AndMatcher andMatcher = new AndMatcher(matcher12, new EmptyStringMatcher());

    // Act and Assert
    assertEquals("", andMatcher.prefix());
  }

  /**
   * Test {@link AndMatcher#prefix()}.
   *
   * <p>Method under test: {@link AndMatcher#prefix()}
   */
  @Test
  @DisplayName("Test prefix()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AndMatcher.prefix()"})
  void testPrefix3() {
    // Arrange
    FixedStringMatcher matcher1 = new FixedStringMatcher("Fixed String", new EmptyStringMatcher());
    AndMatcher andMatcher = new AndMatcher(matcher1, new EmptyStringMatcher());

    // Act and Assert
    assertEquals("", andMatcher.prefix());
  }

  /**
   * Test {@link AndMatcher#prefix()}.
   *
   * <p>Method under test: {@link AndMatcher#prefix()}
   */
  @Test
  @DisplayName("Test prefix()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AndMatcher.prefix()"})
  void testPrefix4() {
    // Arrange
    EmptyStringMatcher matcher1 = new EmptyStringMatcher();
    EmptyStringMatcher matcher12 = new EmptyStringMatcher();
    AndMatcher matcher2 = new AndMatcher(matcher12, new EmptyStringMatcher());

    AndMatcher andMatcher = new AndMatcher(matcher1, matcher2);

    // Act and Assert
    assertEquals("", andMatcher.prefix());
  }

  /**
   * Test {@link AndMatcher#prefix()}.
   *
   * <ul>
   *   <li>Given {@link ConstantMatcher#ConstantMatcher(boolean)} with matches is {@code false}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AndMatcher#prefix()}
   */
  @Test
  @DisplayName(
      "Test prefix(); given ConstantMatcher(boolean) with matches is 'false'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AndMatcher.prefix()"})
  void testPrefix_givenConstantMatcherWithMatchesIsFalse_thenReturnNull() {
    // Arrange
    ConstantMatcher matcher1 = new ConstantMatcher(false);
    AndMatcher andMatcher = new AndMatcher(matcher1, new EmptyStringMatcher());

    // Act and Assert
    assertNull(andMatcher.prefix());
  }

  /**
   * Test {@link AndMatcher#prefix()}.
   *
   * <ul>
   *   <li>Given {@link ConstantMatcher#ConstantMatcher(boolean)} with matches is {@code false}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AndMatcher#prefix()}
   */
  @Test
  @DisplayName(
      "Test prefix(); given ConstantMatcher(boolean) with matches is 'false'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AndMatcher.prefix()"})
  void testPrefix_givenConstantMatcherWithMatchesIsFalse_thenReturnNull2() {
    // Arrange
    EmptyStringMatcher matcher1 = new EmptyStringMatcher();
    AndMatcher andMatcher = new AndMatcher(matcher1, new ConstantMatcher(false));

    // Act and Assert
    assertNull(andMatcher.prefix());
  }

  /**
   * Test {@link AndMatcher#prefix()}.
   *
   * <ul>
   *   <li>Given {@link ConstantMatcher#ConstantMatcher(boolean)} with matches is {@code true}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link AndMatcher#prefix()}
   */
  @Test
  @DisplayName(
      "Test prefix(); given ConstantMatcher(boolean) with matches is 'true'; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AndMatcher.prefix()"})
  void testPrefix_givenConstantMatcherWithMatchesIsTrue_thenReturnEmptyString() {
    // Arrange
    ConstantMatcher matcher1 = new ConstantMatcher(true);
    AndMatcher andMatcher = new AndMatcher(matcher1, new EmptyStringMatcher());

    // Act and Assert
    assertEquals("", andMatcher.prefix());
  }

  /**
   * Test {@link AndMatcher#prefix()}.
   *
   * <ul>
   *   <li>Given {@link ConstantMatcher#ConstantMatcher(boolean)} with matches is {@code true}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link AndMatcher#prefix()}
   */
  @Test
  @DisplayName(
      "Test prefix(); given ConstantMatcher(boolean) with matches is 'true'; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AndMatcher.prefix()"})
  void testPrefix_givenConstantMatcherWithMatchesIsTrue_thenReturnEmptyString2() {
    // Arrange
    EmptyStringMatcher matcher1 = new EmptyStringMatcher();
    AndMatcher andMatcher = new AndMatcher(matcher1, new ConstantMatcher(true));

    // Act and Assert
    assertEquals("", andMatcher.prefix());
  }

  /**
   * Test {@link AndMatcher#prefix()}.
   *
   * <ul>
   *   <li>Given {@link FixedStringMatcher#FixedStringMatcher(String, StringMatcher)} with {@code
   *       Fixed String} and nextMatcher is {@link AndMatcher#AndMatcher(StringMatcher,
   *       StringMatcher)}.
   * </ul>
   *
   * <p>Method under test: {@link AndMatcher#prefix()}
   */
  @Test
  @DisplayName(
      "Test prefix(); given FixedStringMatcher(String, StringMatcher) with 'Fixed String' and nextMatcher is AndMatcher(StringMatcher, StringMatcher)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AndMatcher.prefix()"})
  void testPrefix_givenFixedStringMatcherWithFixedStringAndNextMatcherIsAndMatcher() {
    // Arrange
    EmptyStringMatcher matcher1 = new EmptyStringMatcher();
    AndMatcher nextMatcher = new AndMatcher(matcher1, new EmptyStringMatcher());
    FixedStringMatcher matcher12 = new FixedStringMatcher("Fixed String", nextMatcher);
    AndMatcher andMatcher = new AndMatcher(matcher12, new EmptyStringMatcher());

    // Act and Assert
    assertEquals("", andMatcher.prefix());
  }

  /**
   * Test {@link AndMatcher#prefix()}.
   *
   * <ul>
   *   <li>Given {@link FixedStringMatcher#FixedStringMatcher(String)} with {@code Fixed String}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link AndMatcher#prefix()}
   */
  @Test
  @DisplayName(
      "Test prefix(); given FixedStringMatcher(String) with 'Fixed String'; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AndMatcher.prefix()"})
  void testPrefix_givenFixedStringMatcherWithFixedString_thenReturnEmptyString() {
    // Arrange
    EmptyStringMatcher matcher1 = new EmptyStringMatcher();
    AndMatcher andMatcher = new AndMatcher(matcher1, new FixedStringMatcher("Fixed String"));

    // Act and Assert
    assertEquals("", andMatcher.prefix());
  }

  /**
   * Test {@link AndMatcher#matches(String, int, int)} with {@code string}, {@code beginOffset},
   * {@code endOffset}.
   *
   * <p>Method under test: {@link AndMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName("Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AndMatcher.matches(String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset() {
    // Arrange
    EmptyStringMatcher matcher1 = new EmptyStringMatcher();
    AndMatcher andMatcher = new AndMatcher(matcher1, new EmptyStringMatcher());

    // Act and Assert
    assertFalse(andMatcher.matches("String", 1, 3));
  }

  /**
   * Test {@link AndMatcher#matches(String, int, int)} with {@code string}, {@code beginOffset},
   * {@code endOffset}.
   *
   * <p>Method under test: {@link AndMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName("Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AndMatcher.matches(String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset2() {
    // Arrange
    EmptyStringMatcher matcher1 = new EmptyStringMatcher();
    AndMatcher matcher12 = new AndMatcher(matcher1, new EmptyStringMatcher());
    AndMatcher andMatcher = new AndMatcher(matcher12, new EmptyStringMatcher());

    // Act and Assert
    assertFalse(andMatcher.matches("String", 1, 3));
  }

  /**
   * Test {@link AndMatcher#matches(String, int, int)} with {@code string}, {@code beginOffset},
   * {@code endOffset}.
   *
   * <p>Method under test: {@link AndMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName("Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AndMatcher.matches(String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset3() {
    // Arrange
    ConstantMatcher matcher1 = new ConstantMatcher(true);
    AndMatcher andMatcher = new AndMatcher(matcher1, new EmptyStringMatcher());

    // Act and Assert
    assertFalse(andMatcher.matches("String", 1, 3));
  }

  /**
   * Test {@link AndMatcher#matches(String, int, int)} with {@code string}, {@code beginOffset},
   * {@code endOffset}.
   *
   * <p>Method under test: {@link AndMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName("Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AndMatcher.matches(String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset4() {
    // Arrange
    ConstantMatcher matcher1 = new ConstantMatcher(true);
    EmptyStringMatcher matcher12 = new EmptyStringMatcher();
    AndMatcher matcher2 = new AndMatcher(matcher12, new EmptyStringMatcher());

    AndMatcher andMatcher = new AndMatcher(matcher1, matcher2);

    // Act and Assert
    assertFalse(andMatcher.matches("String", 1, 3));
  }

  /**
   * Test {@link AndMatcher#matches(String, int, int)} with {@code string}, {@code beginOffset},
   * {@code endOffset}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AndMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName(
      "Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AndMatcher.matches(String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset_thenReturnTrue() {
    // Arrange
    ConstantMatcher matcher1 = new ConstantMatcher(true);
    AndMatcher andMatcher = new AndMatcher(matcher1, new ConstantMatcher(true));

    // Act and Assert
    assertTrue(andMatcher.matches("String", 1, 3));
  }
}
