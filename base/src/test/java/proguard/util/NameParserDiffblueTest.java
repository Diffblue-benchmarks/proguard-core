package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class NameParserDiffblueTest {
  /**
   * Method under test: {@link NameParser#parse(String)}
   */
  @Test
  public void testParse() {
    // Arrange and Act
    StringMatcher actualParseResult = (new NameParser()).parse("Regular Expression");

    // Assert
    assertTrue(actualParseResult instanceof FixedStringMatcher);
    assertEquals("Regular Expression", actualParseResult.prefix());
  }

  /**
   * Method under test: {@link NameParser#parse(String)}
   */
  @Test
  public void testParse2() {
    // Arrange and Act
    StringMatcher actualParseResult = (new NameParser(new WildcardManager())).parse("Regular Expression");

    // Assert
    assertTrue(actualParseResult instanceof FixedStringMatcher);
    assertEquals("Regular Expression", actualParseResult.prefix());
  }

  /**
   * Method under test: {@link NameParser#parse(String)}
   */
  @Test
  public void testParse3() {
    // Arrange and Act
    StringMatcher actualParseResult = (new NameParser()).parse("");

    // Assert
    assertTrue(actualParseResult instanceof EmptyStringMatcher);
    assertEquals("", actualParseResult.prefix());
  }
}
