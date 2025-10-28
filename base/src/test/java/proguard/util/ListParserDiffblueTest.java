package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class ListParserDiffblueTest {
  /**
   * Method under test: {@link ListParser#parse(String)}
   */
  @Test
  public void testParse() {
    // Arrange and Act
    StringMatcher actualParseResult = (new ListParser(new ClassNameParser())).parse("Regular Expression");

    // Assert
    assertTrue(actualParseResult instanceof OrMatcher);
    assertEquals("Regular Expression", actualParseResult.prefix());
  }

  /**
   * Method under test: {@link ListParser#parse(String)}
   */
  @Test
  public void testParse2() {
    // Arrange and Act
    StringMatcher actualParseResult = (new ListParser(new CollectionParser())).parse("Regular Expression");

    // Assert
    assertTrue(actualParseResult instanceof OrMatcher);
    assertEquals("", actualParseResult.prefix());
  }

  /**
   * Method under test: {@link ListParser#parse(String)}
   */
  @Test
  public void testParse3() {
    // Arrange and Act
    StringMatcher actualParseResult = (new ListParser(new ClassNameParser())).parse("");

    // Assert
    assertTrue(actualParseResult instanceof ConstantMatcher);
    assertEquals("", actualParseResult.prefix());
  }

  /**
   * Method under test: {@link ListParser#parse(String)}
   */
  @Test
  public void testParse4() {
    // Arrange and Act
    StringMatcher actualParseResult = (new ListParser(new ListParser(new ClassNameParser()))).parse("L///;");

    // Assert
    assertTrue(actualParseResult instanceof OrMatcher);
    assertEquals("", actualParseResult.prefix());
  }

  /**
   * Method under test: {@link ListParser#parse(List)}
   */
  @Test
  public void testParse5() {
    // Arrange
    ListParser listParser = new ListParser(new ClassNameParser());

    // Act
    StringMatcher actualParseResult = listParser.parse(new ArrayList<>());

    // Assert
    assertTrue(actualParseResult instanceof ConstantMatcher);
    assertEquals("", actualParseResult.prefix());
  }

  /**
   * Method under test: {@link ListParser#parse(List)}
   */
  @Test
  public void testParse6() {
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
   * Method under test: {@link ListParser#parse(List)}
   */
  @Test
  public void testParse7() {
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
   * Method under test: {@link ListParser#parse(List)}
   */
  @Test
  public void testParse8() {
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
}
