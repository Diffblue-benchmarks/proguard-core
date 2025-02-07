package proguard.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OrMatcherDiffblueTest {
  /**
   * Test {@link OrMatcher#prefix()}.
   *
   * <p>Method under test: {@link OrMatcher#prefix()}
   */
  @Test
  @DisplayName("Test prefix()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.util.OrMatcher.prefix()"})
  void testPrefix() {
    // Arrange
    EmptyStringMatcher matcher1 = new EmptyStringMatcher();

    // Act and Assert
    assertEquals("", (new OrMatcher(new AndMatcher(matcher1, new EmptyStringMatcher()))).prefix());
  }

  /**
   * Test {@link OrMatcher#prefix()}.
   *
   * <ul>
   *   <li>Given {@link ConstantMatcher#ConstantMatcher(boolean)} with matches is {@code true}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link OrMatcher#prefix()}
   */
  @Test
  @DisplayName(
      "Test prefix(); given ConstantMatcher(boolean) with matches is 'true'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.util.OrMatcher.prefix()"})
  void testPrefix_givenConstantMatcherWithMatchesIsTrue_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new OrMatcher(new ConstantMatcher(true))).prefix());
  }

  /**
   * Test {@link OrMatcher#prefix()}.
   *
   * <ul>
   *   <li>Given {@link OrMatcher#OrMatcher(StringMatcher[])} with matchers is {@link
   *       EmptyStringMatcher} (default constructor) and {@link EmptyStringMatcher} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrMatcher#prefix()}
   */
  @Test
  @DisplayName(
      "Test prefix(); given OrMatcher(StringMatcher[]) with matchers is EmptyStringMatcher (default constructor) and EmptyStringMatcher (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.util.OrMatcher.prefix()"})
  void testPrefix_givenOrMatcherWithMatchersIsEmptyStringMatcherAndEmptyStringMatcher() {
    // Arrange
    EmptyStringMatcher emptyStringMatcher = new EmptyStringMatcher();

    // Act and Assert
    assertEquals("", (new OrMatcher(emptyStringMatcher, new EmptyStringMatcher())).prefix());
  }

  /**
   * Test {@link OrMatcher#prefix()}.
   *
   * <ul>
   *   <li>Given {@link OrMatcher#OrMatcher(StringMatcher[])} with matchers is {@link
   *       EmptyStringMatcher} (default constructor).
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link OrMatcher#prefix()}
   */
  @Test
  @DisplayName(
      "Test prefix(); given OrMatcher(StringMatcher[]) with matchers is EmptyStringMatcher (default constructor); then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.util.OrMatcher.prefix()"})
  void testPrefix_givenOrMatcherWithMatchersIsEmptyStringMatcher_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new OrMatcher(new EmptyStringMatcher())).prefix());
  }

  /**
   * Test {@link OrMatcher#prefix()}.
   *
   * <ul>
   *   <li>Given {@link OrMatcher#OrMatcher(StringMatcher[])}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrMatcher#prefix()}
   */
  @Test
  @DisplayName("Test prefix(); given OrMatcher(StringMatcher[]); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.util.OrMatcher.prefix()"})
  void testPrefix_givenOrMatcher_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new OrMatcher()).prefix());
  }

  /**
   * Test {@link OrMatcher#matches(String, int, int)} with {@code string}, {@code beginOffset},
   * {@code endOffset}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName(
      "Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.util.OrMatcher.matches(java.lang.String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new OrMatcher(new EmptyStringMatcher())).matches("String", 1, 3));
  }

  /**
   * Test {@link OrMatcher#matches(String, int, int)} with {@code string}, {@code beginOffset},
   * {@code endOffset}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OrMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName(
      "Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.util.OrMatcher.matches(java.lang.String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new OrMatcher(new ConstantMatcher(true))).matches("String", 1, 3));
  }
}
