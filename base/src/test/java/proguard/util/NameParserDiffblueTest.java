package proguard.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NameParserDiffblueTest {
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
  @DisplayName(
      "Test parse(String); given NameParser(WildcardManager) with wildcardManager is WildcardManager()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.util.StringMatcher proguard.util.NameParser.parse(java.lang.String)"
  })
  void testParse_givenNameParserWithWildcardManagerIsWildcardManager() {
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
  @DisplayName(
      "Test parse(String); given NameParser(); when empty string; then return EmptyStringMatcher")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.util.StringMatcher proguard.util.NameParser.parse(java.lang.String)"
  })
  void testParse_givenNameParser_whenEmptyString_thenReturnEmptyStringMatcher() {
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
  @DisplayName(
      "Test parse(String); given NameParser(); when 'Regular Expression'; then return FixedStringMatcher")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.util.StringMatcher proguard.util.NameParser.parse(java.lang.String)"
  })
  void testParse_givenNameParser_whenRegularExpression_thenReturnFixedStringMatcher() {
    // Arrange and Act
    StringMatcher actualParseResult = (new NameParser()).parse("Regular Expression");

    // Assert
    assertTrue(actualParseResult instanceof FixedStringMatcher);
    assertEquals("Regular Expression", actualParseResult.prefix());
  }
}
