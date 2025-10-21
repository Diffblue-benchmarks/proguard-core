package proguard.util;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SingleFunctionParserDiffblueTest {
  /**
   * Test {@link SingleFunctionParser#parse(String)}.
   *
   * <p>Method under test: {@link SingleFunctionParser#parse(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringFunction SingleFunctionParser.parse(String)"})
  public void testParse() {
    // Arrange
    ClassNameParser stringParser = new ClassNameParser();

    // Act
    StringFunction actualParseResult =
        (new SingleFunctionParser(stringParser, new WildcardManager())).parse("Regular Expression");
    String actualTransformResult = actualParseResult.transform("foo");

    // Assert
    assertTrue(actualParseResult instanceof MatchingStringFunction);
    assertNull(actualParseResult.transform("String"));
    assertNull(actualTransformResult);
  }
}
