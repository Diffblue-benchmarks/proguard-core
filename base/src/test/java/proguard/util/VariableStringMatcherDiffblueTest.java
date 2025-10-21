package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class VariableStringMatcherDiffblueTest {
  /**
   * Test {@link VariableStringMatcher#getMatchingString()}.
   *
   * <p>Method under test: {@link VariableStringMatcher#getMatchingString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String VariableStringMatcher.getMatchingString()"})
  public void testGetMatchingString() {
    // Arrange
    char[] allowedCharacters = "AZAZ".toCharArray();
    char[] disallowedCharacters = "AZAZ".toCharArray();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            (new VariableStringMatcher(
                    allowedCharacters, disallowedCharacters, 3, 3, new EmptyStringMatcher()))
                .getMatchingString());
  }

  /**
   * Test {@link VariableStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <p>Method under test: {@link VariableStringMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean VariableStringMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset() {
    // Arrange
    char[] allowedCharacters = "AZAZ".toCharArray();
    char[] disallowedCharacters = "AZAZ".toCharArray();

    // Act and Assert
    assertFalse(
        (new VariableStringMatcher(
                allowedCharacters, disallowedCharacters, 3, 3, new EmptyStringMatcher()))
            .matches("String", 1, 3));
  }

  /**
   * Test {@link VariableStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <p>Method under test: {@link VariableStringMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean VariableStringMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset2() {
    // Arrange
    char[] allowedCharacters = "AZAZ".toCharArray();
    char[] disallowedCharacters = "AZAZ".toCharArray();

    // Act and Assert
    assertFalse(
        (new VariableStringMatcher(
                allowedCharacters, disallowedCharacters, 1, 3, new EmptyStringMatcher()))
            .matches("String", 1, 3));
  }

  /**
   * Test {@link VariableStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <p>Method under test: {@link VariableStringMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean VariableStringMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset3() {
    // Arrange
    char[] allowedCharacters = "AZAZ".toCharArray();
    char[] disallowedCharacters = "AZAZ".toCharArray();

    // Act and Assert
    assertFalse(
        (new VariableStringMatcher(
                allowedCharacters, disallowedCharacters, 0, 3, new EmptyStringMatcher()))
            .matches("String", 1, 3));
  }

  /**
   * Test {@link VariableStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <p>Method under test: {@link VariableStringMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean VariableStringMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset4() {
    // Arrange
    char[] allowedCharacters = "AZAZ".toCharArray();

    // Act and Assert
    assertFalse(
        (new VariableStringMatcher(allowedCharacters, "AZAZ".toCharArray(), 3, 3, null))
            .matches("String", 1, 3));
  }

  /**
   * Test {@link VariableStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <p>Method under test: {@link VariableStringMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean VariableStringMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset5() {
    // Arrange
    char[] allowedCharacters = "tZAZ".toCharArray();
    char[] disallowedCharacters = "AZAZ".toCharArray();

    // Act and Assert
    assertFalse(
        (new VariableStringMatcher(
                allowedCharacters, disallowedCharacters, 1, 3, new EmptyStringMatcher()))
            .matches("String", 1, 3));
  }

  /**
   * Test {@link VariableStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <p>Method under test: {@link VariableStringMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean VariableStringMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset6() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean VariableStringMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset7() {
    // Arrange
    char[] allowedCharacters = "AZAZ".toCharArray();

    // Act and Assert
    assertFalse(
        (new VariableStringMatcher(allowedCharacters, "AZAZ".toCharArray(), 1, 3, null))
            .matches("String", 1, 3));
  }

  /**
   * Test {@link VariableStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <p>Method under test: {@link VariableStringMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean VariableStringMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset8() {
    // Arrange
    char[] allowedCharacters = "AZAZ".toCharArray();
    char[] disallowedCharacters = "AZAZ".toCharArray();

    // Act and Assert
    assertFalse(
        (new VariableStringMatcher(
                allowedCharacters, disallowedCharacters, 0, 0, new EmptyStringMatcher()))
            .matches("String", 1, 3));
  }

  /**
   * Test {@link VariableStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <p>Method under test: {@link VariableStringMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean VariableStringMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset9() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean VariableStringMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset10() {
    // Arrange
    char[] allowedCharacters = "AZAZ".toCharArray();

    // Act and Assert
    assertFalse(
        (new VariableStringMatcher(allowedCharacters, "AZAZ".toCharArray(), 3, 3, null))
            .matches("String", -1, 3));
  }
}
