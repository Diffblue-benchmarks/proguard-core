package proguard.util;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class SingleFunctionParserDiffblueTest {
  /**
   * Method under test: {@link SingleFunctionParser#parse(String)}
   */
  @Test
  public void testParse() {
    // Arrange
    ClassNameParser stringParser = new ClassNameParser();

    // Act
    StringFunction actualParseResult = (new SingleFunctionParser(stringParser, new WildcardManager()))
        .parse("Regular Expression");
    String actualTransformResult = actualParseResult.transform("foo");

    // Assert
    assertTrue(actualParseResult instanceof MatchingStringFunction);
    assertNull(actualParseResult.transform("String"));
    assertNull(actualTransformResult);
  }
}
