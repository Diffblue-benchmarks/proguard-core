package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class FileNameParserDiffblueTest {
  /**
   * Method under test: {@link FileNameParser#parse(String)}
   */
  @Test
  public void testParse() {
    // Arrange and Act
    StringMatcher actualParseResult = (new FileNameParser()).parse("Regular Expression");

    // Assert
    assertTrue(actualParseResult instanceof FixedStringMatcher);
    assertEquals("Regular Expression", actualParseResult.prefix());
  }

  /**
   * Method under test: {@link FileNameParser#parse(String)}
   */
  @Test
  public void testParse2() {
    // Arrange and Act
    StringMatcher actualParseResult = (new FileNameParser()).parse("**");

    // Assert
    assertTrue(actualParseResult instanceof VariableStringMatcher);
    assertEquals("", actualParseResult.prefix());
  }

  /**
   * Method under test: {@link FileNameParser#parse(String)}
   */
  @Test
  public void testParse3() {
    // Arrange and Act
    StringMatcher actualParseResult = (new FileNameParser(new WildcardManager())).parse("**");

    // Assert
    assertTrue(actualParseResult instanceof VariableStringMatcher);
    assertEquals("", actualParseResult.prefix());
  }
}
