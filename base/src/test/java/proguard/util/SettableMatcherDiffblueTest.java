package proguard.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SettableMatcherDiffblueTest {
  /**
   * Test {@link SettableMatcher#prefix()}.
   *
   * <p>Method under test: {@link SettableMatcher#prefix()}
   */
  @Test
  @DisplayName("Test prefix()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SettableMatcher.prefix()"})
  void testPrefix() {
    // Arrange
    SettableMatcher settableMatcher = new SettableMatcher();
    EmptyStringMatcher matcher1 = new EmptyStringMatcher();
    AndMatcher matcher = new AndMatcher(matcher1, new EmptyStringMatcher());
    settableMatcher.setMatcher(matcher);

    // Act and Assert
    assertEquals("", settableMatcher.prefix());
  }

  /**
   * Test {@link SettableMatcher#prefix()}.
   *
   * <p>Method under test: {@link SettableMatcher#prefix()}
   */
  @Test
  @DisplayName("Test prefix()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SettableMatcher.prefix()"})
  void testPrefix2() {
    // Arrange
    SettableMatcher matcher2 = new SettableMatcher();
    matcher2.setMatcher(new EmptyStringMatcher());
    AndMatcher matcher = new AndMatcher(new EmptyStringMatcher(), matcher2);

    SettableMatcher settableMatcher = new SettableMatcher();
    settableMatcher.setMatcher(matcher);

    // Act and Assert
    assertEquals("", settableMatcher.prefix());
  }

  /**
   * Test {@link SettableMatcher#prefix()}.
   *
   * <ul>
   *   <li>Given {@link SettableMatcher} (default constructor) Matcher is {@link
   *       ConstantMatcher#ConstantMatcher(boolean)} with matches is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SettableMatcher#prefix()}
   */
  @Test
  @DisplayName(
      "Test prefix(); given SettableMatcher (default constructor) Matcher is ConstantMatcher(boolean) with matches is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SettableMatcher.prefix()"})
  void testPrefix_givenSettableMatcherMatcherIsConstantMatcherWithMatchesIsTrue() {
    // Arrange
    SettableMatcher settableMatcher = new SettableMatcher();
    settableMatcher.setMatcher(new ConstantMatcher(true));

    // Act and Assert
    assertEquals("", settableMatcher.prefix());
  }

  /**
   * Test {@link SettableMatcher#prefix()}.
   *
   * <ul>
   *   <li>Given {@link SettableMatcher} (default constructor) Matcher is {@link EmptyStringMatcher}
   *       (default constructor).
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link SettableMatcher#prefix()}
   */
  @Test
  @DisplayName(
      "Test prefix(); given SettableMatcher (default constructor) Matcher is EmptyStringMatcher (default constructor); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SettableMatcher.prefix()"})
  void testPrefix_givenSettableMatcherMatcherIsEmptyStringMatcher_thenReturnEmptyString() {
    // Arrange
    SettableMatcher settableMatcher = new SettableMatcher();
    settableMatcher.setMatcher(new EmptyStringMatcher());

    // Act and Assert
    assertEquals("", settableMatcher.prefix());
  }

  /**
   * Test {@link SettableMatcher#prefix()}.
   *
   * <ul>
   *   <li>Given {@link SettableMatcher} (default constructor) Matcher is {@link SettableMatcher}
   *       (default constructor).
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link SettableMatcher#prefix()}
   */
  @Test
  @DisplayName(
      "Test prefix(); given SettableMatcher (default constructor) Matcher is SettableMatcher (default constructor); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SettableMatcher.prefix()"})
  void testPrefix_givenSettableMatcherMatcherIsSettableMatcher_thenReturnEmptyString() {
    // Arrange
    SettableMatcher matcher = new SettableMatcher();
    matcher.setMatcher(new EmptyStringMatcher());

    SettableMatcher settableMatcher = new SettableMatcher();
    settableMatcher.setMatcher(matcher);

    // Act and Assert
    assertEquals("", settableMatcher.prefix());
  }

  /**
   * Test {@link SettableMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SettableMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName(
      "Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SettableMatcher.matches(String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset_thenReturnFalse() {
    // Arrange
    SettableMatcher settableMatcher = new SettableMatcher();
    settableMatcher.setMatcher(new EmptyStringMatcher());

    // Act and Assert
    assertFalse(settableMatcher.matches("String", 1, 3));
  }

  /**
   * Test {@link SettableMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SettableMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName(
      "Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SettableMatcher.matches(String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset_thenReturnFalse2() {
    // Arrange
    SettableMatcher matcher = new SettableMatcher();
    matcher.setMatcher(new EmptyStringMatcher());

    SettableMatcher settableMatcher = new SettableMatcher();
    settableMatcher.setMatcher(matcher);

    // Act and Assert
    assertFalse(settableMatcher.matches("String", 1, 3));
  }

  /**
   * Test {@link SettableMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SettableMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName(
      "Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SettableMatcher.matches(String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset_thenReturnTrue() {
    // Arrange
    SettableMatcher settableMatcher = new SettableMatcher();
    settableMatcher.setMatcher(new ConstantMatcher(true));

    // Act and Assert
    assertTrue(settableMatcher.matches("String", 1, 3));
  }
}
