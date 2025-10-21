package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class NameParserDiffblueTest {
  /**
   * Test {@link NameParser#parse(String)}.
   *
   * <ul>
   *   <li>Given {@link NameParser#NameParser(WildcardManager)} with wildcardManager is {@link
   *       WildcardManager#WildcardManager()}.
   * </ul>
   *
   * <p>Method under test: {@link NameParser#parse(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringMatcher NameParser.parse(String)"})
  public void testParse_givenNameParserWithWildcardManagerIsWildcardManager() {
    // Arrange and Act
    StringMatcher actualParseResult =
        (new NameParser(new WildcardManager())).parse("Regular Expression");

    // Assert
    assertTrue(actualParseResult instanceof FixedStringMatcher);
    assertEquals("Regular Expression", actualParseResult.prefix());
  }

  /**
   * Test {@link NameParser#parse(String)}.
   *
   * <ul>
   *   <li>Given {@link NameParser#NameParser()}.
   *   <li>When empty string.
   *   <li>Then return {@link EmptyStringMatcher}.
   * </ul>
   *
   * <p>Method under test: {@link NameParser#parse(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringMatcher NameParser.parse(String)"})
  public void testParse_givenNameParser_whenEmptyString_thenReturnEmptyStringMatcher() {
    // Arrange and Act
    StringMatcher actualParseResult = (new NameParser()).parse("");

    // Assert
    assertTrue(actualParseResult instanceof EmptyStringMatcher);
    assertEquals("", actualParseResult.prefix());
  }

  /**
   * Test {@link NameParser#parse(String)}.
   *
   * <ul>
   *   <li>Given {@link NameParser#NameParser()}.
   *   <li>When {@code Regular Expression}.
   *   <li>Then return {@link FixedStringMatcher}.
   * </ul>
   *
   * <p>Method under test: {@link NameParser#parse(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringMatcher NameParser.parse(String)"})
  public void testParse_givenNameParser_whenRegularExpression_thenReturnFixedStringMatcher() {
    // Arrange and Act
    StringMatcher actualParseResult = (new NameParser()).parse("Regular Expression");

    // Assert
    assertTrue(actualParseResult instanceof FixedStringMatcher);
    assertEquals("Regular Expression", actualParseResult.prefix());
  }
}
