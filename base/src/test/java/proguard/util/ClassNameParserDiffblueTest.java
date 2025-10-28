package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ClassNameParserDiffblueTest {
  /**
   * Method under test: {@link ClassNameParser#parse(String)}
   */
  @Test
  public void testParse() {
    // Arrange and Act
    StringMatcher actualParseResult = (new ClassNameParser()).parse("Regular Expression");

    // Assert
    assertTrue(actualParseResult instanceof FixedStringMatcher);
    assertEquals("Regular Expression", actualParseResult.prefix());
  }

  /**
   * Method under test: {@link ClassNameParser#parse(String)}
   */
  @Test
  public void testParse2() {
    // Arrange and Act
    StringMatcher actualParseResult = (new ClassNameParser(new WildcardManager())).parse("Regular Expression");

    // Assert
    assertTrue(actualParseResult instanceof FixedStringMatcher);
    assertEquals("Regular Expression", actualParseResult.prefix());
  }

  /**
   * Method under test: {@link ClassNameParser#parse(String)}
   */
  @Test
  public void testParse3() {
    // Arrange and Act
    StringMatcher actualParseResult = (new ClassNameParser()).parse("L///;");

    // Assert
    assertTrue(actualParseResult instanceof VariableStringMatcher);
    assertEquals("", actualParseResult.prefix());
  }

  /**
   * Method under test: {@link ClassNameParser#parse(String)}
   */
  @Test
  public void testParse4() {
    // Arrange and Act
    StringMatcher actualParseResult = (new ClassNameParser()).parse("L***;");

    // Assert
    assertTrue(actualParseResult instanceof VariableStringMatcher);
    assertEquals("", actualParseResult.prefix());
  }

  /**
   * Method under test: {@link ClassNameParser#parse(String)}
   */
  @Test
  public void testParse5() {
    // Arrange and Act
    StringMatcher actualParseResult = (new ClassNameParser()).parse("**");

    // Assert
    assertTrue(actualParseResult instanceof VariableStringMatcher);
    assertEquals("", actualParseResult.prefix());
  }

  /**
   * Method under test: {@link ClassNameParser#parse(String)}
   */
  @Test
  public void testParse6() {
    // Arrange and Act
    StringMatcher actualParseResult = (new ClassNameParser(new WildcardManager())).parse("L///;");

    // Assert
    assertTrue(actualParseResult instanceof VariableStringMatcher);
    assertEquals("", actualParseResult.prefix());
  }

  /**
   * Method under test: {@link ClassNameParser#parse(String)}
   */
  @Test
  public void testParse7() {
    // Arrange and Act
    StringMatcher actualParseResult = (new ClassNameParser(new WildcardManager())).parse("L***;");

    // Assert
    assertTrue(actualParseResult instanceof VariableStringMatcher);
    assertEquals("", actualParseResult.prefix());
  }

  /**
   * Method under test: {@link ClassNameParser#parse(String)}
   */
  @Test
  public void testParse8() {
    // Arrange and Act
    StringMatcher actualParseResult = (new ClassNameParser(new WildcardManager())).parse("**");

    // Assert
    assertTrue(actualParseResult instanceof VariableStringMatcher);
    assertEquals("", actualParseResult.prefix());
  }

  /**
   * Method under test: {@link ClassNameParser#parse(String)}
   */
  @Test
  public void testParse9() {
    // Arrange and Act
    StringMatcher actualParseResult = (new ClassNameParser(new WildcardManager(new WildcardManager())))
        .parse("**Regular Expression");

    // Assert
    assertTrue(actualParseResult instanceof VariableStringMatcher);
    assertEquals("", actualParseResult.prefix());
  }
}
