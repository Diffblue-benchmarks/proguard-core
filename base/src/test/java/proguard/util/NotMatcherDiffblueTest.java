package proguard.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NotMatcherDiffblueTest {
  /**
   * Test {@link NotMatcher#matches(String, int, int)} with {@code string}, {@code beginOffset},
   * {@code endOffset}.
   *
   * <ul>
   *   <li>Given {@link ConstantMatcher#ConstantMatcher(boolean)} with matches is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link NotMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName(
      "Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'; given ConstantMatcher(boolean) with matches is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.util.NotMatcher.matches(java.lang.String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset_givenConstantMatcherWithMatchesIsTrue() {
    // Arrange, Act and Assert
    assertFalse((new NotMatcher(new ConstantMatcher(true))).matches("String", 1, 3));
  }

  /**
   * Test {@link NotMatcher#matches(String, int, int)} with {@code string}, {@code beginOffset},
   * {@code endOffset}.
   *
   * <ul>
   *   <li>Given {@link NotMatcher#NotMatcher(StringMatcher)} with matcher is {@link
   *       NotMatcher#NotMatcher(StringMatcher)}.
   * </ul>
   *
   * <p>Method under test: {@link NotMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName(
      "Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'; given NotMatcher(StringMatcher) with matcher is NotMatcher(StringMatcher)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.util.NotMatcher.matches(java.lang.String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset_givenNotMatcherWithMatcherIsNotMatcher() {
    // Arrange, Act and Assert
    assertFalse((new NotMatcher(new NotMatcher(new EmptyStringMatcher()))).matches("String", 1, 3));
  }

  /**
   * Test {@link NotMatcher#matches(String, int, int)} with {@code string}, {@code beginOffset},
   * {@code endOffset}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link NotMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName(
      "Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.util.NotMatcher.matches(java.lang.String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new NotMatcher(new EmptyStringMatcher())).matches("String", 1, 3));
  }
}
