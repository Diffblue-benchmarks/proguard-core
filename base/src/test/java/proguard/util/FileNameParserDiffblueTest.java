package proguard.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FileNameParserDiffblueTest {
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
  @DisplayName("Test parse(String); given FileNameParser(); then return VariableStringMatcher")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StringMatcher FileNameParser.parse(String)"})
  void testParse_givenFileNameParser_thenReturnVariableStringMatcher() {
    // Arrange and Act
    StringMatcher actualParseResult = new FileNameParser().parse("**");

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
  @DisplayName(
      "Test parse(String); given FileNameParser(); when 'Regular Expression'; then return FixedStringMatcher")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StringMatcher FileNameParser.parse(String)"})
  void testParse_givenFileNameParser_whenRegularExpression_thenReturnFixedStringMatcher() {
    // Arrange and Act
    StringMatcher actualParseResult = new FileNameParser().parse("Regular Expression");

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
  @DisplayName("Test parse(String); then return VariableStringMatcher")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StringMatcher FileNameParser.parse(String)"})
  void testParse_thenReturnVariableStringMatcher() {
    // Arrange and Act
    StringMatcher actualParseResult = new FileNameParser(new WildcardManager()).parse("**");

    // Assert
    assertTrue(actualParseResult instanceof VariableStringMatcher);
    assertEquals("", actualParseResult.prefix());
  }
}
