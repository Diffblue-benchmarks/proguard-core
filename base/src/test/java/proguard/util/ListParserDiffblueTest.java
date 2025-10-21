package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ListParserDiffblueTest {
  /**
   * Test {@link ListParser#parse(String)} with {@code regularExpression}.
   *
   * <ul>
   *   <li>Given {@link ListParser#ListParser(StringParser)} with stringParser is {@link
   *       CollectionParser} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ListParser#parse(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringMatcher ListParser.parse(String)"})
  public void testParseWithRegularExpression_givenListParserWithStringParserIsCollectionParser() {
    // Arrange and Act
    StringMatcher actualParseResult =
        (new ListParser(new CollectionParser())).parse("Regular Expression");

    // Assert
    assertTrue(actualParseResult instanceof OrMatcher);
    assertEquals("", actualParseResult.prefix());
  }

  /**
   * Test {@link ListParser#parse(String)} with {@code regularExpression}.
   *
   * <ul>
   *   <li>Given {@link ListParser#ListParser(StringParser)} with stringParser is {@link
   *       ListParser#ListParser(StringParser)}.
   *   <li>When {@code L///;}.
   * </ul>
   *
   * <p>Method under test: {@link ListParser#parse(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringMatcher ListParser.parse(String)"})
  public void testParseWithRegularExpression_givenListParserWithStringParserIsListParser_whenL() {
    // Arrange and Act
    StringMatcher actualParseResult =
        (new ListParser(new ListParser(new ClassNameParser()))).parse("L///;");

    // Assert
    assertTrue(actualParseResult instanceof OrMatcher);
    assertEquals("", actualParseResult.prefix());
  }

  /**
   * Test {@link ListParser#parse(String)} with {@code regularExpression}.
   *
   * <ul>
   *   <li>Then return prefix is {@code Regular Expression}.
   * </ul>
   *
   * <p>Method under test: {@link ListParser#parse(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringMatcher ListParser.parse(String)"})
  public void testParseWithRegularExpression_thenReturnPrefixIsRegularExpression() {
    // Arrange and Act
    StringMatcher actualParseResult =
        (new ListParser(new ClassNameParser())).parse("Regular Expression");

    // Assert
    assertTrue(actualParseResult instanceof OrMatcher);
    assertEquals("Regular Expression", actualParseResult.prefix());
  }

  /**
   * Test {@link ListParser#parse(String)} with {@code regularExpression}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@link ConstantMatcher}.
   * </ul>
   *
   * <p>Method under test: {@link ListParser#parse(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringMatcher ListParser.parse(String)"})
  public void testParseWithRegularExpression_whenEmptyString_thenReturnConstantMatcher() {
    // Arrange and Act
    StringMatcher actualParseResult = (new ListParser(new ClassNameParser())).parse("");

    // Assert
    assertTrue(actualParseResult instanceof ConstantMatcher);
    assertEquals("", actualParseResult.prefix());
  }

  /**
   * Test {@link ListParser#parse(List)} with {@code regularExpressions}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@link OrMatcher}.
   * </ul>
   *
   * <p>Method under test: {@link ListParser#parse(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringMatcher ListParser.parse(List)"})
  public void testParseWithRegularExpressions_given42_whenArrayListAdd42_thenReturnOrMatcher() {
    // Arrange
    ListParser listParser = new ListParser(new ClassNameParser());

    ArrayList<Object> regularExpressions = new ArrayList<>();
    regularExpressions.add("42");
    regularExpressions.add("42");

    // Act
    StringMatcher actualParseResult = listParser.parse(regularExpressions);

    // Assert
    assertTrue(actualParseResult instanceof OrMatcher);
    assertEquals("", actualParseResult.prefix());
  }

  /**
   * Test {@link ListParser#parse(List)} with {@code regularExpressions}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return prefix is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ListParser#parse(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringMatcher ListParser.parse(List)"})
  public void testParseWithRegularExpressions_given42_whenArrayListAdd42_thenReturnPrefixIs42() {
    // Arrange
    ListParser listParser = new ListParser(new ClassNameParser());

    ArrayList<Object> regularExpressions = new ArrayList<>();
    regularExpressions.add("42");

    // Act
    StringMatcher actualParseResult = listParser.parse(regularExpressions);

    // Assert
    assertTrue(actualParseResult instanceof OrMatcher);
    assertEquals("42", actualParseResult.prefix());
  }

  /**
   * Test {@link ListParser#parse(List)} with {@code regularExpressions}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link ArrayList#ArrayList()} add empty string.
   * </ul>
   *
   * <p>Method under test: {@link ListParser#parse(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringMatcher ListParser.parse(List)"})
  public void testParseWithRegularExpressions_givenEmptyString_whenArrayListAddEmptyString() {
    // Arrange
    ListParser listParser = new ListParser(new ClassNameParser());

    ArrayList<Object> regularExpressions = new ArrayList<>();
    regularExpressions.add("");

    // Act
    StringMatcher actualParseResult = listParser.parse(regularExpressions);

    // Assert
    assertTrue(actualParseResult instanceof OrMatcher);
    assertEquals("", actualParseResult.prefix());
  }

  /**
   * Test {@link ListParser#parse(List)} with {@code regularExpressions}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link ConstantMatcher}.
   * </ul>
   *
   * <p>Method under test: {@link ListParser#parse(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringMatcher ListParser.parse(List)"})
  public void testParseWithRegularExpressions_whenArrayList_thenReturnConstantMatcher() {
    // Arrange
    ListParser listParser = new ListParser(new ClassNameParser());

    // Act
    StringMatcher actualParseResult = listParser.parse(new ArrayList<>());

    // Assert
    assertTrue(actualParseResult instanceof ConstantMatcher);
    assertEquals("", actualParseResult.prefix());
  }
}
