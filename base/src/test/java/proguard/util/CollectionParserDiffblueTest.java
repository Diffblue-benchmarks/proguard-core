package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class CollectionParserDiffblueTest {
  /**
   * Method under test: {@link CollectionParser#parse(String)}
   */
  @Test
  public void testParse() {
    // Arrange and Act
    StringMatcher actualParseResult = (new CollectionParser()).parse("Regular Expression");

    // Assert
    assertTrue(actualParseResult instanceof CollectionMatcher);
    assertEquals("", actualParseResult.prefix());
  }

  /**
   * Method under test: {@link CollectionParser#parse(List)}
   */
  @Test
  public void testParse2() {
    // Arrange
    CollectionParser collectionParser = new CollectionParser();

    // Act
    StringMatcher actualParseResult = collectionParser.parse(new ArrayList<>());

    // Assert
    assertTrue(actualParseResult instanceof CollectionMatcher);
    assertEquals("", actualParseResult.prefix());
  }

  /**
   * Method under test: {@link CollectionParser#parse(List)}
   */
  @Test
  public void testParse3() {
    // Arrange
    CollectionParser collectionParser = new CollectionParser();

    ArrayList<String> regularExpressions = new ArrayList<>();
    regularExpressions.add("foo");

    // Act
    StringMatcher actualParseResult = collectionParser.parse(regularExpressions);

    // Assert
    assertTrue(actualParseResult instanceof CollectionMatcher);
    assertEquals("", actualParseResult.prefix());
  }

  /**
   * Method under test: {@link CollectionParser#parse(List)}
   */
  @Test
  public void testParse4() {
    // Arrange
    CollectionParser collectionParser = new CollectionParser();

    ArrayList<String> regularExpressions = new ArrayList<>();
    regularExpressions.add("42");
    regularExpressions.add("foo");

    // Act
    StringMatcher actualParseResult = collectionParser.parse(regularExpressions);

    // Assert
    assertTrue(actualParseResult instanceof CollectionMatcher);
    assertEquals("", actualParseResult.prefix());
  }
}
