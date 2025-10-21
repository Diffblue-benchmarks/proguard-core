package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class WildcardManagerDiffblueTest {
  /**
   * Test {@link WildcardManager#WildcardManager(WildcardManager)}.
   *
   * <p>Method under test: {@link WildcardManager#WildcardManager(WildcardManager)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WildcardManager.<init>(WildcardManager)"})
  public void testNewWildcardManager() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "proguard.util.VariableStringMatcher WildcardManager.createVariableStringMatcher(char[], char[], int, int, StringMatcher)"
  })
  public void testCreateVariableStringMatcher() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringFunction WildcardManager.createMatchedStringFunction(String)"})
  public void testCreateMatchedStringFunction() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int WildcardManager.wildCardIndex(String, int)"})
  public void testWildCardIndex_whenRegularExpression_thenReturnMinusOne()
      throws IllegalArgumentException {
    // Arrange, Act and Assert
    assertEquals(-1, (new WildcardManager()).wildCardIndex("Regular Expression", 1));
  }
}
