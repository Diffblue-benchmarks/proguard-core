package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class WildcardManagerDiffblueTest {
  /**
   * Method under test:
   * {@link WildcardManager#createVariableStringMatcher(char[], char[], int, int, StringMatcher)}
   */
  @Test
  public void testCreateVariableStringMatcher() {
    // Arrange
    WildcardManager wildcardManager = new WildcardManager();
    char[] allowedCharacters = "A<A<".toCharArray();
    char[] disallowedCharacters = "A<A<".toCharArray();

    // Act and Assert
    assertEquals("",
        wildcardManager
            .createVariableStringMatcher(allowedCharacters, disallowedCharacters, 3, 3, new EmptyStringMatcher())
            .prefix());
  }

  /**
   * Method under test:
   * {@link WildcardManager#createMatchedStringFunction(String)}
   */
  @Test
  public void testCreateMatchedStringFunction() {
    // Arrange and Act
    StringFunction actualCreateMatchedStringFunctionResult = (new WildcardManager())
        .createMatchedStringFunction("Expression");
    String actualTransformResult = actualCreateMatchedStringFunctionResult.transform("foo");

    // Assert
    assertTrue(actualCreateMatchedStringFunctionResult instanceof ConstantStringFunction);
    assertEquals("Expression", actualCreateMatchedStringFunctionResult.transform("String"));
    assertEquals("Expression", actualTransformResult);
  }

  /**
   * Method under test: {@link WildcardManager#wildCardIndex(String, int)}
   */
  @Test
  public void testWildCardIndex() throws IllegalArgumentException {
    // Arrange, Act and Assert
    assertEquals(-1, (new WildcardManager()).wildCardIndex("Regular Expression", 1));
  }

  /**
   * Method under test: {@link WildcardManager#WildcardManager(WildcardManager)}
   */
  @Test
  public void testNewWildcardManager() {
    // Arrange, Act and Assert
    assertTrue((new WildcardManager(new WildcardManager()))
        .createMatchedStringFunction("Expression") instanceof ConstantStringFunction);
  }
}
