package proguard.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FixedStringMatcherDiffblueTest {
  /**
   * Test {@link FixedStringMatcher#prefix()}.
   *
   * <p>Method under test: {@link FixedStringMatcher#prefix()}
   */
  @Test
  @DisplayName("Test prefix()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.util.FixedStringMatcher.prefix()"})
  void testPrefix() {
    // Arrange, Act and Assert
    assertEquals(
        "Fixed String",
        (new FixedStringMatcher("Fixed String", new EmptyStringMatcher())).prefix());
  }

  /**
   * Test {@link FixedStringMatcher#prefix()}.
   *
   * <p>Method under test: {@link FixedStringMatcher#prefix()}
   */
  @Test
  @DisplayName("Test prefix()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.util.FixedStringMatcher.prefix()"})
  void testPrefix2() {
    // Arrange
    EmptyStringMatcher matcher1 = new EmptyStringMatcher();

    // Act and Assert
    assertEquals(
        "Fixed String",
        (new FixedStringMatcher("Fixed String", new AndMatcher(matcher1, new EmptyStringMatcher())))
            .prefix());
  }

  /**
   * Test {@link FixedStringMatcher#prefix()}.
   *
   * <p>Method under test: {@link FixedStringMatcher#prefix()}
   */
  @Test
  @DisplayName("Test prefix()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.util.FixedStringMatcher.prefix()"})
  void testPrefix3() {
    // Arrange
    EmptyStringMatcher matcher1 = new EmptyStringMatcher();

    // Act and Assert
    assertEquals(
        "Fixed String",
        (new FixedStringMatcher(
                "Fixed String", new AndMatcher(matcher1, new FixedStringMatcher("Fixed String"))))
            .prefix());
  }

  /**
   * Test {@link FixedStringMatcher#prefix()}.
   *
   * <ul>
   *   <li>Given {@link ConstantMatcher#ConstantMatcher(boolean)} with matches is {@code false}.
   *   <li>Then return {@code Fixed String}.
   * </ul>
   *
   * <p>Method under test: {@link FixedStringMatcher#prefix()}
   */
  @Test
  @DisplayName(
      "Test prefix(); given ConstantMatcher(boolean) with matches is 'false'; then return 'Fixed String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.util.FixedStringMatcher.prefix()"})
  void testPrefix_givenConstantMatcherWithMatchesIsFalse_thenReturnFixedString() {
    // Arrange, Act and Assert
    assertEquals(
        "Fixed String",
        (new FixedStringMatcher("Fixed String", new ConstantMatcher(false))).prefix());
  }

  /**
   * Test {@link FixedStringMatcher#prefix()}.
   *
   * <ul>
   *   <li>Given {@link ConstantMatcher#ConstantMatcher(boolean)} with matches is {@code true}.
   *   <li>Then return {@code Fixed String}.
   * </ul>
   *
   * <p>Method under test: {@link FixedStringMatcher#prefix()}
   */
  @Test
  @DisplayName(
      "Test prefix(); given ConstantMatcher(boolean) with matches is 'true'; then return 'Fixed String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.util.FixedStringMatcher.prefix()"})
  void testPrefix_givenConstantMatcherWithMatchesIsTrue_thenReturnFixedString() {
    // Arrange, Act and Assert
    assertEquals(
        "Fixed String",
        (new FixedStringMatcher("Fixed String", new ConstantMatcher(true))).prefix());
  }

  /**
   * Test {@link FixedStringMatcher#prefix()}.
   *
   * <ul>
   *   <li>Given {@link FixedStringMatcher#FixedStringMatcher(String)} with {@code Fixed String}.
   *   <li>Then return {@code Fixed String}.
   * </ul>
   *
   * <p>Method under test: {@link FixedStringMatcher#prefix()}
   */
  @Test
  @DisplayName(
      "Test prefix(); given FixedStringMatcher(String) with 'Fixed String'; then return 'Fixed String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.util.FixedStringMatcher.prefix()"})
  void testPrefix_givenFixedStringMatcherWithFixedString_thenReturnFixedString() {
    // Arrange, Act and Assert
    assertEquals("Fixed String", (new FixedStringMatcher("Fixed String")).prefix());
  }

  /**
   * Test {@link FixedStringMatcher#prefix()}.
   *
   * <ul>
   *   <li>Then return {@code Fixed StringFixed String}.
   * </ul>
   *
   * <p>Method under test: {@link FixedStringMatcher#prefix()}
   */
  @Test
  @DisplayName("Test prefix(); then return 'Fixed StringFixed String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.util.FixedStringMatcher.prefix()"})
  void testPrefix_thenReturnFixedStringFixedString() {
    // Arrange, Act and Assert
    assertEquals(
        "Fixed StringFixed String",
        (new FixedStringMatcher("Fixed String", new FixedStringMatcher("Fixed String"))).prefix());
  }

  /**
   * Test {@link FixedStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <p>Method under test: {@link FixedStringMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName("Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.util.FixedStringMatcher.matches(java.lang.String, int, int)"
  })
  void testMatchesWithStringBeginOffsetEndOffset() {
    // Arrange, Act and Assert
    assertFalse((new FixedStringMatcher("42")).matches("String", 1, 3));
  }

  /**
   * Test {@link FixedStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <p>Method under test: {@link FixedStringMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName("Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.util.FixedStringMatcher.matches(java.lang.String, int, int)"
  })
  void testMatchesWithStringBeginOffsetEndOffset2() {
    // Arrange, Act and Assert
    assertFalse((new FixedStringMatcher("")).matches("String", 1, 3));
  }

  /**
   * Test {@link FixedStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <p>Method under test: {@link FixedStringMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName("Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.util.FixedStringMatcher.matches(java.lang.String, int, int)"
  })
  void testMatchesWithStringBeginOffsetEndOffset3() {
    // Arrange, Act and Assert
    assertFalse((new FixedStringMatcher("", new EmptyStringMatcher())).matches("String", 1, 3));
  }

  /**
   * Test {@link FixedStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <p>Method under test: {@link FixedStringMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName("Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.util.FixedStringMatcher.matches(java.lang.String, int, int)"
  })
  void testMatchesWithStringBeginOffsetEndOffset4() {
    // Arrange, Act and Assert
    assertFalse(
        (new FixedStringMatcher("", new FixedStringMatcher("Fixed String")))
            .matches("String", 1, 3));
  }

  /**
   * Test {@link FixedStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <ul>
   *   <li>Given {@link ConstantMatcher#ConstantMatcher(boolean)} with matches is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FixedStringMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName(
      "Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'; given ConstantMatcher(boolean) with matches is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.util.FixedStringMatcher.matches(java.lang.String, int, int)"
  })
  void testMatchesWithStringBeginOffsetEndOffset_givenConstantMatcherWithMatchesIsTrue() {
    // Arrange, Act and Assert
    assertTrue((new FixedStringMatcher("", new ConstantMatcher(true))).matches("String", 1, 3));
  }

  /**
   * Test {@link FixedStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <ul>
   *   <li>Given {@link FixedStringMatcher#FixedStringMatcher(String)} with {@code Fixed String}.
   * </ul>
   *
   * <p>Method under test: {@link FixedStringMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName(
      "Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'; given FixedStringMatcher(String) with 'Fixed String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.util.FixedStringMatcher.matches(java.lang.String, int, int)"
  })
  void testMatchesWithStringBeginOffsetEndOffset_givenFixedStringMatcherWithFixedString() {
    // Arrange, Act and Assert
    assertFalse((new FixedStringMatcher("Fixed String")).matches("String", 1, 3));
  }

  /**
   * Test {@link FixedStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FixedStringMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName(
      "Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.util.FixedStringMatcher.matches(java.lang.String, int, int)"
  })
  void testMatchesWithStringBeginOffsetEndOffset_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new FixedStringMatcher("")).matches("String", 1, 1));
  }
}
