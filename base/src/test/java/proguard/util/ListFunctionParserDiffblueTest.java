package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class ListFunctionParserDiffblueTest {
  /**
   * Method under test: {@link ListFunctionParser#parse(String)}
   */
  @Test
  public void testParse() {
    // Arrange
    ClassNameParser stringParser = new ClassNameParser();

    // Act
    StringFunction actualParseResult = (new ListFunctionParser(
        new SingleFunctionParser(stringParser, new WildcardManager()))).parse("Regular Expression");
    String actualTransformResult = actualParseResult.transform("foo");

    // Assert
    assertTrue(actualParseResult instanceof MatchingStringFunction);
    assertNull(actualParseResult.transform("String"));
    assertNull(actualTransformResult);
  }

  /**
   * Method under test: {@link ListFunctionParser#parse(String)}
   */
  @Test
  public void testParse2() {
    // Arrange
    ClassNameParser stringParser = new ClassNameParser();

    // Act and Assert
    assertEquals("foo",
        (new ListFunctionParser(new SingleFunctionParser(stringParser, new WildcardManager()))).parse("")
            .transform("foo"));
  }

  /**
   * Method under test: {@link ListFunctionParser#parse(List)}
   */
  @Test
  public void testParse3() {
    // Arrange
    ClassNameParser stringParser = new ClassNameParser();
    ListFunctionParser listFunctionParser = new ListFunctionParser(
        new SingleFunctionParser(stringParser, new WildcardManager()));

    // Act and Assert
    assertEquals("foo", listFunctionParser.parse(new ArrayList<>()).transform("foo"));
  }

  /**
   * Method under test: {@link ListFunctionParser#parse(List)}
   */
  @Test
  public void testParse4() {
    // Arrange
    ClassNameParser stringParser = new ClassNameParser();
    ListFunctionParser listFunctionParser = new ListFunctionParser(
        new SingleFunctionParser(stringParser, new WildcardManager()));

    ArrayList<Object> regularExpressions = new ArrayList<>();
    regularExpressions.add("42");

    // Act
    StringFunction actualParseResult = listFunctionParser.parse(regularExpressions);
    String actualTransformResult = actualParseResult.transform("foo");

    // Assert
    assertTrue(actualParseResult instanceof MatchingStringFunction);
    assertNull(actualParseResult.transform("String"));
    assertNull(actualTransformResult);
  }

  /**
   * Method under test: {@link ListFunctionParser#parse(List)}
   */
  @Test
  public void testParse5() {
    // Arrange
    ClassNameParser stringParser = new ClassNameParser();
    ListFunctionParser listFunctionParser = new ListFunctionParser(
        new SingleFunctionParser(stringParser, new WildcardManager()));

    ArrayList<Object> regularExpressions = new ArrayList<>();
    regularExpressions.add("42");
    regularExpressions.add("42");

    // Act
    StringFunction actualParseResult = listFunctionParser.parse(regularExpressions);
    String actualTransformResult = actualParseResult.transform("foo");

    // Assert
    assertTrue(actualParseResult instanceof OrStringFunction);
    assertNull(actualParseResult.transform("String"));
    assertNull(actualTransformResult);
  }

  /**
   * Method under test: {@link ListFunctionParser#parse(List)}
   */
  @Test
  public void testParse6() {
    // Arrange
    ClassNameParser stringParser = new ClassNameParser();
    ListFunctionParser listFunctionParser = new ListFunctionParser(
        new SingleFunctionParser(stringParser, new WildcardManager()));

    ArrayList<Object> regularExpressions = new ArrayList<>();
    regularExpressions.add("foo");

    // Act
    StringFunction actualParseResult = listFunctionParser.parse(regularExpressions);

    // Assert
    assertTrue(actualParseResult instanceof MatchingStringFunction);
    assertEquals("foo", actualParseResult.transform("foo"));
    assertNull(actualParseResult.transform("String"));
  }
}
