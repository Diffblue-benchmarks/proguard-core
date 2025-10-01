package proguard.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class VariableStringMatcherDiffblueTest {
  /**
   * Test {@link VariableStringMatcher#getMatchingString()}.
   *
   * <p>Method under test: {@link VariableStringMatcher#getMatchingString()}
   */
  @Test
  @DisplayName("Test getMatchingString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String VariableStringMatcher.getMatchingString()"})
  void testGetMatchingString() {
    // Arrange
    char[] allowedCharacters = "AZAZ".toCharArray();
    char[] disallowedCharacters = "AZAZ".toCharArray();

    VariableStringMatcher variableStringMatcher =
        new VariableStringMatcher(
            allowedCharacters, disallowedCharacters, 3, 3, new EmptyStringMatcher());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> variableStringMatcher.getMatchingString());
  }

  /**
   * Test {@link VariableStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <p>Method under test: {@link VariableStringMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName("Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean VariableStringMatcher.matches(String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset() {
    // Arrange
    char[] allowedCharacters = "AZAZ".toCharArray();
    char[] disallowedCharacters = "AZAZ".toCharArray();

    VariableStringMatcher variableStringMatcher =
        new VariableStringMatcher(
            allowedCharacters, disallowedCharacters, 3, 3, new EmptyStringMatcher());

    // Act and Assert
    assertFalse(variableStringMatcher.matches("String", 1, 3));
  }

  /**
   * Test {@link VariableStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <p>Method under test: {@link VariableStringMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName("Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean VariableStringMatcher.matches(String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset2() {
    // Arrange
    VariableStringMatcher variableStringMatcher = new VariableStringMatcher(null, null, 3, 3, null);

    // Act and Assert
    assertFalse(variableStringMatcher.matches("String", 1, 3));
  }

  /**
   * Test {@link VariableStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <p>Method under test: {@link VariableStringMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName("Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean VariableStringMatcher.matches(String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset3() {
    // Arrange
    char[] allowedCharacters = "AZAZ".toCharArray();
    char[] disallowedCharacters = "AZAZ".toCharArray();

    VariableStringMatcher variableStringMatcher =
        new VariableStringMatcher(
            allowedCharacters, disallowedCharacters, 1, 3, new EmptyStringMatcher());

    // Act and Assert
    assertFalse(variableStringMatcher.matches("String", 1, 3));
  }

  /**
   * Test {@link VariableStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <p>Method under test: {@link VariableStringMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName("Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean VariableStringMatcher.matches(String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset4() {
    // Arrange
    char[] allowedCharacters = "AZAZ".toCharArray();
    char[] disallowedCharacters = "AZAZ".toCharArray();

    VariableStringMatcher variableStringMatcher =
        new VariableStringMatcher(
            allowedCharacters, disallowedCharacters, 0, 3, new EmptyStringMatcher());

    // Act and Assert
    assertFalse(variableStringMatcher.matches("String", 1, 3));
  }

  /**
   * Test {@link VariableStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <p>Method under test: {@link VariableStringMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName("Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean VariableStringMatcher.matches(String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset5() {
    // Arrange
    char[] disallowedCharacters = "AZAZ".toCharArray();
    VariableStringMatcher variableStringMatcher =
        new VariableStringMatcher(null, disallowedCharacters, 1, 3, new EmptyStringMatcher());

    // Act
    boolean actualMatchesResult = variableStringMatcher.matches("String", 1, 3);

    // Assert
    assertEquals("tr", variableStringMatcher.getMatchingString());
    assertTrue(actualMatchesResult);
  }

  /**
   * Test {@link VariableStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <p>Method under test: {@link VariableStringMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName("Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean VariableStringMatcher.matches(String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset6() {
    // Arrange
    char[] allowedCharacters = "AZAZ".toCharArray();
    VariableStringMatcher variableStringMatcher =
        new VariableStringMatcher(allowedCharacters, "AZAZ".toCharArray(), 1, 3, null);

    // Act and Assert
    assertFalse(variableStringMatcher.matches("String", 1, 3));
  }

  /**
   * Test {@link VariableStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <p>Method under test: {@link VariableStringMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName("Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean VariableStringMatcher.matches(String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset7() {
    // Arrange
    char[] allowedCharacters = "AZAZ".toCharArray();
    char[] disallowedCharacters = "AZAZ".toCharArray();

    VariableStringMatcher variableStringMatcher =
        new VariableStringMatcher(
            allowedCharacters, disallowedCharacters, 0, 0, new EmptyStringMatcher());

    // Act and Assert
    assertFalse(variableStringMatcher.matches("String", 1, 3));
  }

  /**
   * Test {@link VariableStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <p>Method under test: {@link VariableStringMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName("Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean VariableStringMatcher.matches(String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset8() {
    // Arrange
    char[] allowedCharacters = "AZAZ".toCharArray();
    char[] disallowedCharacters = "AZAZ".toCharArray();

    VariableStringMatcher variableStringMatcher =
        new VariableStringMatcher(
            allowedCharacters, disallowedCharacters, 0, 3, new ConstantMatcher(true));

    // Act
    boolean actualMatchesResult = variableStringMatcher.matches("String", 1, 3);

    // Assert
    assertEquals("", variableStringMatcher.getMatchingString());
    assertTrue(actualMatchesResult);
  }

  /**
   * Test {@link VariableStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <p>Method under test: {@link VariableStringMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName("Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean VariableStringMatcher.matches(String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset9() {
    // Arrange
    VariableStringMatcher variableStringMatcher =
        new VariableStringMatcher(null, null, 1, 3, new EmptyStringMatcher());

    // Act
    boolean actualMatchesResult = variableStringMatcher.matches("String", 1, 3);

    // Assert
    assertEquals("tr", variableStringMatcher.getMatchingString());
    assertTrue(actualMatchesResult);
  }

  /**
   * Test {@link VariableStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <p>Method under test: {@link VariableStringMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName("Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean VariableStringMatcher.matches(String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset10() {
    // Arrange
    VariableStringMatcher variableStringMatcher =
        new VariableStringMatcher(null, "AZAZ".toCharArray(), 1, 3, null);

    // Act
    boolean actualMatchesResult = variableStringMatcher.matches("String", 1, 3);

    // Assert
    assertEquals("tr", variableStringMatcher.getMatchingString());
    assertTrue(actualMatchesResult);
  }

  /**
   * Test {@link VariableStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <p>Method under test: {@link VariableStringMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName("Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean VariableStringMatcher.matches(String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset11() {
    // Arrange
    char[] allowedCharacters = "AZAZ".toCharArray();
    VariableStringMatcher variableStringMatcher =
        new VariableStringMatcher(allowedCharacters, "AZAZ".toCharArray(), 1, 1, null);

    // Act and Assert
    assertFalse(variableStringMatcher.matches("String", 1, 3));
  }

  /**
   * Test {@link VariableStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <p>Method under test: {@link VariableStringMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName("Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean VariableStringMatcher.matches(String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset12() {
    // Arrange
    char[] allowedCharacters = "tZAZ".toCharArray();
    char[] disallowedCharacters = "AZAZ".toCharArray();

    VariableStringMatcher variableStringMatcher =
        new VariableStringMatcher(
            allowedCharacters, disallowedCharacters, 1, 3, new EmptyStringMatcher());

    // Act and Assert
    assertFalse(variableStringMatcher.matches("String", 1, 3));
  }

  /**
   * Test {@link VariableStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <p>Method under test: {@link VariableStringMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName("Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean VariableStringMatcher.matches(String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset13() {
    // Arrange
    char[] disallowedCharacters = "tZAZ".toCharArray();
    VariableStringMatcher variableStringMatcher =
        new VariableStringMatcher(null, disallowedCharacters, 1, 3, new EmptyStringMatcher());

    // Act and Assert
    assertFalse(variableStringMatcher.matches("String", 1, 3));
  }

  /**
   * Test {@link VariableStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link VariableStringMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName(
      "Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'; then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean VariableStringMatcher.matches(String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset_thenThrowUnsupportedOperationException() {
    // Arrange
    char[] allowedCharacters = "AZAZ".toCharArray();
    char[] disallowedCharacters = "AZAZ".toCharArray();
    char[] allowedCharacters2 = "\u0003\u0002\u0003\u0002".toCharArray();
    char[] disallowedCharacters2 = "\u0003\u0002\u0003\u0002".toCharArray();

    VariableStringMatcher variableStringMatcher =
        new VariableStringMatcher(
            allowedCharacters2, disallowedCharacters2, 3, 3, new EmptyStringMatcher());
    MatchedStringMatcher nextMatcher =
        new MatchedStringMatcher(variableStringMatcher, new EmptyStringMatcher());

    VariableStringMatcher variableStringMatcher2 =
        new VariableStringMatcher(allowedCharacters, disallowedCharacters, 0, 3, nextMatcher);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> variableStringMatcher2.matches("String", 1, 3));
  }
}
