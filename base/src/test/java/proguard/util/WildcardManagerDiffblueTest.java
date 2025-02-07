package proguard.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class WildcardManagerDiffblueTest {
  /**
   * Test {@link WildcardManager#WildcardManager(WildcardManager)}.
   *
   * <p>Method under test: {@link WildcardManager#WildcardManager(WildcardManager)}
   */
  @Test
  @DisplayName("Test new WildcardManager(WildcardManager)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.util.WildcardManager.<init>(proguard.util.WildcardManager)"})
  void testNewWildcardManager() {
    // Arrange, Act and Assert
    assertTrue(
        (new WildcardManager(new WildcardManager())).createMatchedStringFunction("Expression")
            instanceof ConstantStringFunction);
  }

  /**
   * Test {@link WildcardManager#createVariableStringMatcher(char[], char[], int, int,
   * StringMatcher)}.
   *
   * <p>Method under test: {@link WildcardManager#createVariableStringMatcher(char[], char[], int,
   * int, StringMatcher)}
   */
  @Test
  @DisplayName("Test createVariableStringMatcher(char[], char[], int, int, StringMatcher)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.util.VariableStringMatcher proguard.util.WildcardManager.createVariableStringMatcher(char[], char[], int, int, proguard.util.StringMatcher)"
  })
  void testCreateVariableStringMatcher() {
    // Arrange
    WildcardManager wildcardManager = new WildcardManager();
    char[] allowedCharacters = "A<A<".toCharArray();
    char[] disallowedCharacters = "A<A<".toCharArray();

    // Act and Assert
    assertEquals(
        "",
        wildcardManager
            .createVariableStringMatcher(
                allowedCharacters, disallowedCharacters, 3, 3, new EmptyStringMatcher())
            .prefix());
  }

  /**
   * Test {@link WildcardManager#createMatchedStringFunction(String)}.
   *
   * <p>Method under test: {@link WildcardManager#createMatchedStringFunction(String)}
   */
  @Test
  @DisplayName("Test createMatchedStringFunction(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.util.StringFunction proguard.util.WildcardManager.createMatchedStringFunction(java.lang.String)"
  })
  void testCreateMatchedStringFunction() {
    // Arrange and Act
    StringFunction actualCreateMatchedStringFunctionResult =
        (new WildcardManager()).createMatchedStringFunction("Expression");
    String actualTransformResult = actualCreateMatchedStringFunctionResult.transform("foo");

    // Assert
    assertTrue(actualCreateMatchedStringFunctionResult instanceof ConstantStringFunction);
    assertEquals("Expression", actualCreateMatchedStringFunctionResult.transform("String"));
    assertEquals("Expression", actualTransformResult);
  }

  /**
   * Test {@link WildcardManager#wildCardIndex(String, int)}.
   *
   * <ul>
   *   <li>When {@code Regular Expression}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link WildcardManager#wildCardIndex(String, int)}
   */
  @Test
  @DisplayName("Test wildCardIndex(String, int); when 'Regular Expression'; then return minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.WildcardManager.wildCardIndex(java.lang.String, int)"})
  void testWildCardIndex_whenRegularExpression_thenReturnMinusOne()
      throws IllegalArgumentException {
    // Arrange, Act and Assert
    assertEquals(-1, (new WildcardManager()).wildCardIndex("Regular Expression", 1));
  }
}
