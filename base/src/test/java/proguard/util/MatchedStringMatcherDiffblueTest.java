package proguard.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MatchedStringMatcherDiffblueTest {
  /**
   * Test {@link MatchedStringMatcher#prefix()}.
   *
   * <p>Method under test: {@link MatchedStringMatcher#prefix()}
   */
  @Test
  @DisplayName("Test prefix()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.util.MatchedStringMatcher.prefix()"})
  void testPrefix() {
    // Arrange
    VariableStringMatcher variableStringMatcher = mock(VariableStringMatcher.class);
    when(variableStringMatcher.getMatchingString()).thenReturn("Matching String");

    // Act
    String actualPrefixResult =
        (new MatchedStringMatcher(variableStringMatcher, new EmptyStringMatcher())).prefix();

    // Assert
    verify(variableStringMatcher).getMatchingString();
    assertEquals("Matching String", actualPrefixResult);
  }

  /**
   * Test {@link MatchedStringMatcher#prefix()}.
   *
   * <p>Method under test: {@link MatchedStringMatcher#prefix()}
   */
  @Test
  @DisplayName("Test prefix()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.util.MatchedStringMatcher.prefix()"})
  void testPrefix2() {
    // Arrange
    VariableStringMatcher variableStringMatcher = mock(VariableStringMatcher.class);
    when(variableStringMatcher.getMatchingString()).thenReturn("Matching String");

    // Act
    String actualPrefixResult = (new MatchedStringMatcher(variableStringMatcher, null)).prefix();

    // Assert
    verify(variableStringMatcher).getMatchingString();
    assertEquals("Matching String", actualPrefixResult);
  }

  /**
   * Test {@link MatchedStringMatcher#prefix()}.
   *
   * <ul>
   *   <li>Given {@link ConstantMatcher#ConstantMatcher(boolean)} with matches is {@code false}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MatchedStringMatcher#prefix()}
   */
  @Test
  @DisplayName(
      "Test prefix(); given ConstantMatcher(boolean) with matches is 'false'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.util.MatchedStringMatcher.prefix()"})
  void testPrefix_givenConstantMatcherWithMatchesIsFalse_thenReturnNull() {
    // Arrange
    VariableStringMatcher variableStringMatcher = mock(VariableStringMatcher.class);
    when(variableStringMatcher.getMatchingString()).thenReturn("Matching String");

    // Act
    String actualPrefixResult =
        (new MatchedStringMatcher(variableStringMatcher, new ConstantMatcher(false))).prefix();

    // Assert
    verify(variableStringMatcher).getMatchingString();
    assertNull(actualPrefixResult);
  }

  /**
   * Test {@link MatchedStringMatcher#prefix()}.
   *
   * <ul>
   *   <li>Given {@link ConstantMatcher#ConstantMatcher(boolean)} with matches is {@code true}.
   *   <li>Then return {@code Matching String}.
   * </ul>
   *
   * <p>Method under test: {@link MatchedStringMatcher#prefix()}
   */
  @Test
  @DisplayName(
      "Test prefix(); given ConstantMatcher(boolean) with matches is 'true'; then return 'Matching String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.util.MatchedStringMatcher.prefix()"})
  void testPrefix_givenConstantMatcherWithMatchesIsTrue_thenReturnMatchingString() {
    // Arrange
    VariableStringMatcher variableStringMatcher = mock(VariableStringMatcher.class);
    when(variableStringMatcher.getMatchingString()).thenReturn("Matching String");

    // Act
    String actualPrefixResult =
        (new MatchedStringMatcher(variableStringMatcher, new ConstantMatcher(true))).prefix();

    // Assert
    verify(variableStringMatcher).getMatchingString();
    assertEquals("Matching String", actualPrefixResult);
  }

  /**
   * Test {@link MatchedStringMatcher#prefix()}.
   *
   * <ul>
   *   <li>Given {@link VariableStringMatcher} {@link VariableStringMatcher#getMatchingString()}
   *       return {@code foo}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link MatchedStringMatcher#prefix()}
   */
  @Test
  @DisplayName(
      "Test prefix(); given VariableStringMatcher getMatchingString() return 'foo'; then return 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.util.MatchedStringMatcher.prefix()"})
  void testPrefix_givenVariableStringMatcherGetMatchingStringReturnFoo_thenReturnFoo() {
    // Arrange
    VariableStringMatcher variableStringMatcher = mock(VariableStringMatcher.class);
    when(variableStringMatcher.getMatchingString()).thenReturn("foo");
    EmptyStringMatcher matcher1 = new EmptyStringMatcher();

    // Act
    String actualPrefixResult =
        (new MatchedStringMatcher(
                variableStringMatcher, new AndMatcher(matcher1, new EmptyStringMatcher())))
            .prefix();

    // Assert
    verify(variableStringMatcher).getMatchingString();
    assertEquals("foo", actualPrefixResult);
  }

  /**
   * Test {@link MatchedStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <p>Method under test: {@link MatchedStringMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName("Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.util.MatchedStringMatcher.matches(java.lang.String, int, int)"
  })
  void testMatchesWithStringBeginOffsetEndOffset() {
    // Arrange
    VariableStringMatcher variableStringMatcher = mock(VariableStringMatcher.class);
    when(variableStringMatcher.getMatchingString()).thenReturn("Matching String");

    // Act
    boolean actualMatchesResult =
        (new MatchedStringMatcher(variableStringMatcher, new EmptyStringMatcher()))
            .matches("String", 1, 3);

    // Assert
    verify(variableStringMatcher).getMatchingString();
    assertFalse(actualMatchesResult);
  }

  /**
   * Test {@link MatchedStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <p>Method under test: {@link MatchedStringMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName("Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.util.MatchedStringMatcher.matches(java.lang.String, int, int)"
  })
  void testMatchesWithStringBeginOffsetEndOffset2() {
    // Arrange
    VariableStringMatcher variableStringMatcher = mock(VariableStringMatcher.class);
    when(variableStringMatcher.getMatchingString()).thenReturn(null);

    // Act
    boolean actualMatchesResult =
        (new MatchedStringMatcher(variableStringMatcher, new EmptyStringMatcher()))
            .matches("String", 1, 3);

    // Assert
    verify(variableStringMatcher).getMatchingString();
    assertFalse(actualMatchesResult);
  }

  /**
   * Test {@link MatchedStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <p>Method under test: {@link MatchedStringMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName("Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.util.MatchedStringMatcher.matches(java.lang.String, int, int)"
  })
  void testMatchesWithStringBeginOffsetEndOffset3() {
    // Arrange
    VariableStringMatcher variableStringMatcher = mock(VariableStringMatcher.class);
    when(variableStringMatcher.getMatchingString()).thenReturn("42");

    // Act
    boolean actualMatchesResult =
        (new MatchedStringMatcher(variableStringMatcher, new EmptyStringMatcher()))
            .matches("String", 1, 3);

    // Assert
    verify(variableStringMatcher).getMatchingString();
    assertFalse(actualMatchesResult);
  }

  /**
   * Test {@link MatchedStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <p>Method under test: {@link MatchedStringMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName("Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.util.MatchedStringMatcher.matches(java.lang.String, int, int)"
  })
  void testMatchesWithStringBeginOffsetEndOffset4() {
    // Arrange
    VariableStringMatcher variableStringMatcher = mock(VariableStringMatcher.class);
    when(variableStringMatcher.getMatchingString()).thenReturn("");

    // Act
    boolean actualMatchesResult =
        (new MatchedStringMatcher(variableStringMatcher, null)).matches("String", 1, 3);

    // Assert
    verify(variableStringMatcher).getMatchingString();
    assertFalse(actualMatchesResult);
  }

  /**
   * Test {@link MatchedStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <ul>
   *   <li>Given {@link ConstantMatcher#ConstantMatcher(boolean)} with matches is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MatchedStringMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName(
      "Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'; given ConstantMatcher(boolean) with matches is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.util.MatchedStringMatcher.matches(java.lang.String, int, int)"
  })
  void testMatchesWithStringBeginOffsetEndOffset_givenConstantMatcherWithMatchesIsTrue() {
    // Arrange
    VariableStringMatcher variableStringMatcher = mock(VariableStringMatcher.class);
    when(variableStringMatcher.getMatchingString()).thenReturn("");

    // Act
    boolean actualMatchesResult =
        (new MatchedStringMatcher(variableStringMatcher, new ConstantMatcher(true)))
            .matches("String", 1, 3);

    // Assert
    verify(variableStringMatcher).getMatchingString();
    assertTrue(actualMatchesResult);
  }

  /**
   * Test {@link MatchedStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MatchedStringMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName(
      "Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.util.MatchedStringMatcher.matches(java.lang.String, int, int)"
  })
  void testMatchesWithStringBeginOffsetEndOffset_thenReturnFalse() {
    // Arrange
    VariableStringMatcher variableStringMatcher = mock(VariableStringMatcher.class);
    when(variableStringMatcher.getMatchingString()).thenReturn("");

    // Act
    boolean actualMatchesResult =
        (new MatchedStringMatcher(variableStringMatcher, new EmptyStringMatcher()))
            .matches("String", 1, 3);

    // Assert
    verify(variableStringMatcher).getMatchingString();
    assertFalse(actualMatchesResult);
  }

  /**
   * Test {@link MatchedStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MatchedStringMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName(
      "Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.util.MatchedStringMatcher.matches(java.lang.String, int, int)"
  })
  void testMatchesWithStringBeginOffsetEndOffset_thenReturnTrue() {
    // Arrange
    VariableStringMatcher variableStringMatcher = mock(VariableStringMatcher.class);
    when(variableStringMatcher.getMatchingString()).thenReturn("");

    // Act
    boolean actualMatchesResult =
        (new MatchedStringMatcher(variableStringMatcher, null)).matches("String", 1, 1);

    // Assert
    verify(variableStringMatcher).getMatchingString();
    assertTrue(actualMatchesResult);
  }
}
