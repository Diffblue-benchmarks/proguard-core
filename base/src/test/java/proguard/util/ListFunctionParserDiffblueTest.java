package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ListFunctionParserDiffblueTest {
  /**
   * Test {@link ListFunctionParser#parse(String)} with {@code regularExpression}.
   *
   * <ul>
   *   <li>Then return {@link MatchingStringFunction}.
   * </ul>
   *
   * <p>Method under test: {@link ListFunctionParser#parse(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringFunction ListFunctionParser.parse(String)"})
  public void testParseWithRegularExpression_thenReturnMatchingStringFunction() {
    // Arrange
    ClassNameParser stringParser = new ClassNameParser();

    // Act
    StringFunction actualParseResult =
        (new ListFunctionParser(new SingleFunctionParser(stringParser, new WildcardManager())))
            .parse("Regular Expression");
    String actualTransformResult = actualParseResult.transform("foo");

    // Assert
    assertTrue(actualParseResult instanceof MatchingStringFunction);
    assertNull(actualParseResult.transform("String"));
    assertNull(actualTransformResult);
  }

  /**
   * Test {@link ListFunctionParser#parse(String)} with {@code regularExpression}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return transform {@code foo} is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link ListFunctionParser#parse(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringFunction ListFunctionParser.parse(String)"})
  public void testParseWithRegularExpression_whenEmptyString_thenReturnTransformFooIsFoo() {
    // Arrange
    ClassNameParser stringParser = new ClassNameParser();

    // Act and Assert
    assertEquals(
        "foo",
        (new ListFunctionParser(new SingleFunctionParser(stringParser, new WildcardManager())))
            .parse("")
            .transform("foo"));
  }

  /**
   * Test {@link ListFunctionParser#parse(List)} with {@code regularExpressions}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return {@link MatchingStringFunction}.
   * </ul>
   *
   * <p>Method under test: {@link ListFunctionParser#parse(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringFunction ListFunctionParser.parse(List)"})
  public void testParseWithRegularExpressions_given42_thenReturnMatchingStringFunction() {
    // Arrange
    ClassNameParser stringParser = new ClassNameParser();
    ListFunctionParser listFunctionParser =
        new ListFunctionParser(new SingleFunctionParser(stringParser, new WildcardManager()));

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
   * Test {@link ListFunctionParser#parse(List)} with {@code regularExpressions}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return {@link OrStringFunction}.
   * </ul>
   *
   * <p>Method under test: {@link ListFunctionParser#parse(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringFunction ListFunctionParser.parse(List)"})
  public void testParseWithRegularExpressions_given42_thenReturnOrStringFunction() {
    // Arrange
    ClassNameParser stringParser = new ClassNameParser();
    ListFunctionParser listFunctionParser =
        new ListFunctionParser(new SingleFunctionParser(stringParser, new WildcardManager()));

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
   * Test {@link ListFunctionParser#parse(List)} with {@code regularExpressions}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link ListFunctionParser#parse(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringFunction ListFunctionParser.parse(List)"})
  public void testParseWithRegularExpressions_givenFoo_whenArrayListAddFoo() {
    // Arrange
    ClassNameParser stringParser = new ClassNameParser();
    ListFunctionParser listFunctionParser =
        new ListFunctionParser(new SingleFunctionParser(stringParser, new WildcardManager()));

    ArrayList<Object> regularExpressions = new ArrayList<>();
    regularExpressions.add("foo");

    // Act
    StringFunction actualParseResult = listFunctionParser.parse(regularExpressions);

    // Assert
    assertTrue(actualParseResult instanceof MatchingStringFunction);
    assertEquals("foo", actualParseResult.transform("foo"));
    assertNull(actualParseResult.transform("String"));
  }

  /**
   * Test {@link ListFunctionParser#parse(List)} with {@code regularExpressions}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return transform {@code foo} is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link ListFunctionParser#parse(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringFunction ListFunctionParser.parse(List)"})
  public void testParseWithRegularExpressions_whenArrayList_thenReturnTransformFooIsFoo() {
    // Arrange
    ClassNameParser stringParser = new ClassNameParser();
    ListFunctionParser listFunctionParser =
        new ListFunctionParser(new SingleFunctionParser(stringParser, new WildcardManager()));

    // Act and Assert
    assertEquals("foo", listFunctionParser.parse(new ArrayList<>()).transform("foo"));
  }
}
