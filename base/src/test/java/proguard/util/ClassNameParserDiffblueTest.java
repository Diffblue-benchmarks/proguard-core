package proguard.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ClassNameParserDiffblueTest {
  /**
   * Test {@link ClassNameParser#parse(String)}.
   *
   * <ul>
   *   <li>Given {@link ClassNameParser#ClassNameParser(WildcardManager)} with wildcardManager is
   *       {@link WildcardManager#WildcardManager()}.
   *   <li>When {@code L///;}.
   * </ul>
   *
   * <p>Method under test: {@link ClassNameParser#parse(String)}
   */
  @Test
  @DisplayName(
      "Test parse(String); given ClassNameParser(WildcardManager) with wildcardManager is WildcardManager(); when 'L///;'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StringMatcher ClassNameParser.parse(String)"})
  void testParse_givenClassNameParserWithWildcardManagerIsWildcardManager_whenL() {
    // Arrange and Act
    StringMatcher actualParseResult = new ClassNameParser(new WildcardManager()).parse("L///;");

    // Assert
    assertTrue(actualParseResult instanceof VariableStringMatcher);
    assertEquals("", actualParseResult.prefix());
  }

  /**
   * Test {@link ClassNameParser#parse(String)}.
   *
   * <ul>
   *   <li>Given {@link ClassNameParser#ClassNameParser(WildcardManager)} with wildcardManager is
   *       {@link WildcardManager#WildcardManager()}.
   *   <li>When {@code L***;}.
   * </ul>
   *
   * <p>Method under test: {@link ClassNameParser#parse(String)}
   */
  @Test
  @DisplayName(
      "Test parse(String); given ClassNameParser(WildcardManager) with wildcardManager is WildcardManager(); when 'L***;'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StringMatcher ClassNameParser.parse(String)"})
  void testParse_givenClassNameParserWithWildcardManagerIsWildcardManager_whenL2() {
    // Arrange and Act
    StringMatcher actualParseResult = new ClassNameParser(new WildcardManager()).parse("L***;");

    // Assert
    assertTrue(actualParseResult instanceof VariableStringMatcher);
    assertEquals("", actualParseResult.prefix());
  }

  /**
   * Test {@link ClassNameParser#parse(String)}.
   *
   * <ul>
   *   <li>Given {@link ClassNameParser#ClassNameParser()}.
   *   <li>When {@code **}.
   * </ul>
   *
   * <p>Method under test: {@link ClassNameParser#parse(String)}
   */
  @Test
  @DisplayName("Test parse(String); given ClassNameParser(); when '**'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StringMatcher ClassNameParser.parse(String)"})
  void testParse_givenClassNameParser_whenAsteriskAsterisk() {
    // Arrange and Act
    StringMatcher actualParseResult = new ClassNameParser().parse("**");

    // Assert
    assertTrue(actualParseResult instanceof VariableStringMatcher);
    assertEquals("", actualParseResult.prefix());
  }

  /**
   * Test {@link ClassNameParser#parse(String)}.
   *
   * <ul>
   *   <li>Given {@link ClassNameParser#ClassNameParser()}.
   *   <li>When {@code L///;}.
   *   <li>Then return {@link VariableStringMatcher}.
   * </ul>
   *
   * <p>Method under test: {@link ClassNameParser#parse(String)}
   */
  @Test
  @DisplayName(
      "Test parse(String); given ClassNameParser(); when 'L///;'; then return VariableStringMatcher")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StringMatcher ClassNameParser.parse(String)"})
  void testParse_givenClassNameParser_whenL_thenReturnVariableStringMatcher() {
    // Arrange and Act
    StringMatcher actualParseResult = new ClassNameParser().parse("L///;");

    // Assert
    assertTrue(actualParseResult instanceof VariableStringMatcher);
    assertEquals("", actualParseResult.prefix());
  }

  /**
   * Test {@link ClassNameParser#parse(String)}.
   *
   * <ul>
   *   <li>Given {@link ClassNameParser#ClassNameParser()}.
   *   <li>When {@code L***;}.
   *   <li>Then return {@link VariableStringMatcher}.
   * </ul>
   *
   * <p>Method under test: {@link ClassNameParser#parse(String)}
   */
  @Test
  @DisplayName(
      "Test parse(String); given ClassNameParser(); when 'L***;'; then return VariableStringMatcher")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StringMatcher ClassNameParser.parse(String)"})
  void testParse_givenClassNameParser_whenL_thenReturnVariableStringMatcher2() {
    // Arrange and Act
    StringMatcher actualParseResult = new ClassNameParser().parse("L***;");

    // Assert
    assertTrue(actualParseResult instanceof VariableStringMatcher);
    assertEquals("", actualParseResult.prefix());
  }

  /**
   * Test {@link ClassNameParser#parse(String)}.
   *
   * <ul>
   *   <li>Given {@link ClassNameParser#ClassNameParser()}.
   *   <li>When {@code **L///;}.
   *   <li>Then return {@link VariableStringMatcher}.
   * </ul>
   *
   * <p>Method under test: {@link ClassNameParser#parse(String)}
   */
  @Test
  @DisplayName(
      "Test parse(String); given ClassNameParser(); when '**L///;'; then return VariableStringMatcher")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StringMatcher ClassNameParser.parse(String)"})
  void testParse_givenClassNameParser_whenL_thenReturnVariableStringMatcher3() {
    // Arrange and Act
    StringMatcher actualParseResult = new ClassNameParser().parse("**L///;");

    // Assert
    assertTrue(actualParseResult instanceof VariableStringMatcher);
    assertEquals("", actualParseResult.prefix());
  }

  /**
   * Test {@link ClassNameParser#parse(String)}.
   *
   * <ul>
   *   <li>When {@code **}.
   * </ul>
   *
   * <p>Method under test: {@link ClassNameParser#parse(String)}
   */
  @Test
  @DisplayName("Test parse(String); when '**'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StringMatcher ClassNameParser.parse(String)"})
  void testParse_whenAsteriskAsterisk() {
    // Arrange and Act
    StringMatcher actualParseResult = new ClassNameParser(new WildcardManager()).parse("**");

    // Assert
    assertTrue(actualParseResult instanceof VariableStringMatcher);
    assertEquals("", actualParseResult.prefix());
  }

  /**
   * Test {@link ClassNameParser#parse(String)}.
   *
   * <ul>
   *   <li>When {@code Regular Expression}.
   *   <li>Then return {@link FixedStringMatcher}.
   * </ul>
   *
   * <p>Method under test: {@link ClassNameParser#parse(String)}
   */
  @Test
  @DisplayName("Test parse(String); when 'Regular Expression'; then return FixedStringMatcher")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StringMatcher ClassNameParser.parse(String)"})
  void testParse_whenRegularExpression_thenReturnFixedStringMatcher() {
    // Arrange and Act
    StringMatcher actualParseResult = new ClassNameParser().parse("Regular Expression");

    // Assert
    assertTrue(actualParseResult instanceof FixedStringMatcher);
    assertEquals("Regular Expression", actualParseResult.prefix());
  }

  /**
   * Test {@link ClassNameParser#parse(String)}.
   *
   * <ul>
   *   <li>When {@code Regular Expression}.
   *   <li>Then return {@link FixedStringMatcher}.
   * </ul>
   *
   * <p>Method under test: {@link ClassNameParser#parse(String)}
   */
  @Test
  @DisplayName("Test parse(String); when 'Regular Expression'; then return FixedStringMatcher")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StringMatcher ClassNameParser.parse(String)"})
  void testParse_whenRegularExpression_thenReturnFixedStringMatcher2() {
    // Arrange and Act
    StringMatcher actualParseResult =
        new ClassNameParser(new WildcardManager()).parse("Regular Expression");

    // Assert
    assertTrue(actualParseResult instanceof FixedStringMatcher);
    assertEquals("Regular Expression", actualParseResult.prefix());
  }
}
