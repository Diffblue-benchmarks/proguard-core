package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class VariableStringMatcherDiffblueTest {
  /**
   * Method under test: {@link VariableStringMatcher#getMatchingString()}
   */
  @Test
  public void testGetMatchingString() {
    // Arrange
    char[] allowedCharacters = "AZAZ".toCharArray();
    char[] disallowedCharacters = "AZAZ".toCharArray();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new VariableStringMatcher(allowedCharacters, disallowedCharacters, 3, 3, new EmptyStringMatcher()))
            .getMatchingString());
  }

  /**
   * Method under test: {@link VariableStringMatcher#matches(String, int, int)}
   */
  @Test
  public void testMatches() {
    // Arrange
    char[] allowedCharacters = "AZAZ".toCharArray();
    char[] disallowedCharacters = "AZAZ".toCharArray();

    // Act and Assert
    assertFalse((new VariableStringMatcher(allowedCharacters, disallowedCharacters, 3, 3, new EmptyStringMatcher()))
        .matches("String", 1, 3));
  }

  /**
   * Method under test: {@link VariableStringMatcher#matches(String, int, int)}
   */
  @Test
  public void testMatches2() {
    // Arrange
    char[] allowedCharacters = "AZAZ".toCharArray();
    char[] disallowedCharacters = "AZAZ".toCharArray();

    // Act and Assert
    assertFalse((new VariableStringMatcher(allowedCharacters, disallowedCharacters, 1, 3, new EmptyStringMatcher()))
        .matches("String", 1, 3));
  }

  /**
   * Method under test: {@link VariableStringMatcher#matches(String, int, int)}
   */
  @Test
  public void testMatches3() {
    // Arrange
    char[] allowedCharacters = "AZAZ".toCharArray();
    char[] disallowedCharacters = "AZAZ".toCharArray();

    // Act and Assert
    assertFalse((new VariableStringMatcher(allowedCharacters, disallowedCharacters, 0, 3, new EmptyStringMatcher()))
        .matches("String", 1, 3));
  }

  /**
   * Method under test: {@link VariableStringMatcher#matches(String, int, int)}
   */
  @Test
  public void testMatches4() {
    // Arrange
    char[] allowedCharacters = "AZAZ".toCharArray();

    // Act and Assert
    assertFalse(
        (new VariableStringMatcher(allowedCharacters, "AZAZ".toCharArray(), 3, 3, null)).matches("String", 1, 3));
  }

  /**
   * Method under test: {@link VariableStringMatcher#matches(String, int, int)}
   */
  @Test
  public void testMatches5() {
    // Arrange
    char[] allowedCharacters = "tZAZ".toCharArray();
    char[] disallowedCharacters = "AZAZ".toCharArray();

    // Act and Assert
    assertFalse((new VariableStringMatcher(allowedCharacters, disallowedCharacters, 1, 3, new EmptyStringMatcher()))
        .matches("String", 1, 3));
  }

  /**
   * Method under test: {@link VariableStringMatcher#matches(String, int, int)}
   */
  @Test
  public void testMatches6() {
    // Arrange
    char[] disallowedCharacters = "AZAZ".toCharArray();
    VariableStringMatcher variableStringMatcher = new VariableStringMatcher(null, disallowedCharacters, 1, 3,
        new EmptyStringMatcher());

    // Act
    boolean actualMatchesResult = variableStringMatcher.matches("String", 1, 3);

    // Assert
    assertEquals("tr", variableStringMatcher.getMatchingString());
    assertTrue(actualMatchesResult);
  }

  /**
   * Method under test: {@link VariableStringMatcher#matches(String, int, int)}
   */
  @Test
  public void testMatches7() {
    // Arrange
    char[] allowedCharacters = "AZAZ".toCharArray();

    // Act and Assert
    assertFalse(
        (new VariableStringMatcher(allowedCharacters, "AZAZ".toCharArray(), 1, 3, null)).matches("String", 1, 3));
  }

  /**
   * Method under test: {@link VariableStringMatcher#matches(String, int, int)}
   */
  @Test
  public void testMatches8() {
    // Arrange
    char[] allowedCharacters = "AZAZ".toCharArray();
    char[] disallowedCharacters = "AZAZ".toCharArray();

    // Act and Assert
    assertFalse((new VariableStringMatcher(allowedCharacters, disallowedCharacters, 0, 0, new EmptyStringMatcher()))
        .matches("String", 1, 3));
  }

  /**
   * Method under test: {@link VariableStringMatcher#matches(String, int, int)}
   */
  @Test
  public void testMatches9() {
    // Arrange
    char[] allowedCharacters = "AZAZ".toCharArray();
    char[] disallowedCharacters = "AZAZ".toCharArray();
    VariableStringMatcher variableStringMatcher = new VariableStringMatcher(allowedCharacters, disallowedCharacters, 0,
        3, new ConstantMatcher(true));

    // Act
    boolean actualMatchesResult = variableStringMatcher.matches("String", 1, 3);

    // Assert
    assertEquals("", variableStringMatcher.getMatchingString());
    assertTrue(actualMatchesResult);
  }

  /**
   * Method under test: {@link VariableStringMatcher#matches(String, int, int)}
   */
  @Test
  public void testMatches10() {
    // Arrange
    char[] allowedCharacters = "AZAZ".toCharArray();

    // Act and Assert
    assertFalse(
        (new VariableStringMatcher(allowedCharacters, "AZAZ".toCharArray(), 3, 3, null)).matches("String", -1, 3));
  }
}
