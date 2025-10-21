package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FileNameParserDiffblueTest {
  /**
   * Test {@link FileNameParser#parse(String)}.
   *
   * <ul>
   *   <li>Given {@link FileNameParser#FileNameParser()}.
   *   <li>Then return {@link VariableStringMatcher}.
   * </ul>
   *
   * <p>Method under test: {@link FileNameParser#parse(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringMatcher FileNameParser.parse(String)"})
  public void testParse_givenFileNameParser_thenReturnVariableStringMatcher() {
    // Arrange and Act
    StringMatcher actualParseResult = (new FileNameParser()).parse("**");

    // Assert
    assertTrue(actualParseResult instanceof VariableStringMatcher);
    assertEquals("", actualParseResult.prefix());
  }

  /**
   * Test {@link FileNameParser#parse(String)}.
   *
   * <ul>
   *   <li>Given {@link FileNameParser#FileNameParser()}.
   *   <li>When {@code Regular Expression}.
   *   <li>Then return {@link FixedStringMatcher}.
   * </ul>
   *
   * <p>Method under test: {@link FileNameParser#parse(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringMatcher FileNameParser.parse(String)"})
  public void testParse_givenFileNameParser_whenRegularExpression_thenReturnFixedStringMatcher() {
    // Arrange and Act
    StringMatcher actualParseResult = (new FileNameParser()).parse("Regular Expression");

    // Assert
    assertTrue(actualParseResult instanceof FixedStringMatcher);
    assertEquals("Regular Expression", actualParseResult.prefix());
  }

  /**
   * Test {@link FileNameParser#parse(String)}.
   *
   * <ul>
   *   <li>Then return {@link VariableStringMatcher}.
   * </ul>
   *
   * <p>Method under test: {@link FileNameParser#parse(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringMatcher FileNameParser.parse(String)"})
  public void testParse_thenReturnVariableStringMatcher() {
    // Arrange and Act
    StringMatcher actualParseResult = (new FileNameParser(new WildcardManager())).parse("**");

    // Assert
    assertTrue(actualParseResult instanceof VariableStringMatcher);
    assertEquals("", actualParseResult.prefix());
  }
}
