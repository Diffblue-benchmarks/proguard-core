package proguard.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ListParserDiffblueTest {
  /**
   * Test {@link ListParser#parse(String)} with {@code regularExpression}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@link ConstantMatcher}.
   * </ul>
   *
   * <p>Method under test: {@link ListParser#parse(String)}
   */
  @Test
  @DisplayName(
      "Test parse(String) with 'regularExpression'; when empty string; then return ConstantMatcher")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.util.StringMatcher proguard.util.ListParser.parse(java.lang.String)"
  })
  void testParseWithRegularExpression_whenEmptyString_thenReturnConstantMatcher() {
    // Arrange and Act
    StringMatcher actualParseResult = (new ListParser(mock(StringParser.class))).parse("");

    // Assert
    assertTrue(actualParseResult instanceof ConstantMatcher);
    assertEquals("", actualParseResult.prefix());
  }

  /**
   * Test {@link ListParser#parse(String)} with {@code regularExpression}.
   *
   * <ul>
   *   <li>When {@code Regular Expression}.
   *   <li>Then return {@link OrMatcher}.
   * </ul>
   *
   * <p>Method under test: {@link ListParser#parse(String)}
   */
  @Test
  @DisplayName(
      "Test parse(String) with 'regularExpression'; when 'Regular Expression'; then return OrMatcher")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.util.StringMatcher proguard.util.ListParser.parse(java.lang.String)"
  })
  void testParseWithRegularExpression_whenRegularExpression_thenReturnOrMatcher() {
    // Arrange
    StringParser stringParser = mock(StringParser.class);
    when(stringParser.parse(Mockito.<String>any())).thenReturn(new EmptyStringMatcher());

    // Act
    StringMatcher actualParseResult = (new ListParser(stringParser)).parse("Regular Expression");

    // Assert
    verify(stringParser).parse(eq("Regular Expression"));
    assertTrue(actualParseResult instanceof OrMatcher);
    assertEquals("", actualParseResult.prefix());
  }

  /**
   * Test {@link ListParser#parse(List)} with {@code regularExpressions}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@link OrMatcher}.
   * </ul>
   *
   * <p>Method under test: {@link ListParser#parse(List)}
   */
  @Test
  @DisplayName(
      "Test parse(List) with 'regularExpressions'; given '42'; when ArrayList() add '42'; then return OrMatcher")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"proguard.util.StringMatcher proguard.util.ListParser.parse(java.util.List)"})
  void testParseWithRegularExpressions_given42_whenArrayListAdd42_thenReturnOrMatcher() {
    // Arrange
    StringParser stringParser = mock(StringParser.class);
    when(stringParser.parse(Mockito.<String>any())).thenReturn(new EmptyStringMatcher());
    ListParser listParser = new ListParser(stringParser);

    ArrayList<Object> regularExpressions = new ArrayList<>();
    regularExpressions.add("42");

    // Act
    StringMatcher actualParseResult = listParser.parse(regularExpressions);

    // Assert
    verify(stringParser).parse(eq("42"));
    assertTrue(actualParseResult instanceof OrMatcher);
    assertEquals("", actualParseResult.prefix());
  }

  /**
   * Test {@link ListParser#parse(List)} with {@code regularExpressions}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@link OrMatcher}.
   * </ul>
   *
   * <p>Method under test: {@link ListParser#parse(List)}
   */
  @Test
  @DisplayName(
      "Test parse(List) with 'regularExpressions'; given '42'; when ArrayList() add '42'; then return OrMatcher")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"proguard.util.StringMatcher proguard.util.ListParser.parse(java.util.List)"})
  void testParseWithRegularExpressions_given42_whenArrayListAdd42_thenReturnOrMatcher2() {
    // Arrange
    StringParser stringParser = mock(StringParser.class);
    when(stringParser.parse(Mockito.<String>any())).thenReturn(new EmptyStringMatcher());
    ListParser listParser = new ListParser(stringParser);

    ArrayList<Object> regularExpressions = new ArrayList<>();
    regularExpressions.add("42");
    regularExpressions.add("42");

    // Act
    StringMatcher actualParseResult = listParser.parse(regularExpressions);

    // Assert
    verify(stringParser, atLeast(1)).parse(eq("42"));
    assertTrue(actualParseResult instanceof OrMatcher);
    assertEquals("", actualParseResult.prefix());
  }

  /**
   * Test {@link ListParser#parse(List)} with {@code regularExpressions}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link ArrayList#ArrayList()} add empty string.
   * </ul>
   *
   * <p>Method under test: {@link ListParser#parse(List)}
   */
  @Test
  @DisplayName(
      "Test parse(List) with 'regularExpressions'; given empty string; when ArrayList() add empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"proguard.util.StringMatcher proguard.util.ListParser.parse(java.util.List)"})
  void testParseWithRegularExpressions_givenEmptyString_whenArrayListAddEmptyString() {
    // Arrange
    StringParser stringParser = mock(StringParser.class);
    when(stringParser.parse(Mockito.<String>any())).thenReturn(new EmptyStringMatcher());
    ListParser listParser = new ListParser(stringParser);

    ArrayList<Object> regularExpressions = new ArrayList<>();
    regularExpressions.add("");

    // Act
    StringMatcher actualParseResult = listParser.parse(regularExpressions);

    // Assert
    verify(stringParser).parse(eq(""));
    assertTrue(actualParseResult instanceof OrMatcher);
    assertEquals("", actualParseResult.prefix());
  }

  /**
   * Test {@link ListParser#parse(List)} with {@code regularExpressions}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link ConstantMatcher}.
   * </ul>
   *
   * <p>Method under test: {@link ListParser#parse(List)}
   */
  @Test
  @DisplayName(
      "Test parse(List) with 'regularExpressions'; when ArrayList(); then return ConstantMatcher")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"proguard.util.StringMatcher proguard.util.ListParser.parse(java.util.List)"})
  void testParseWithRegularExpressions_whenArrayList_thenReturnConstantMatcher() {
    // Arrange
    ListParser listParser = new ListParser(mock(StringParser.class));

    // Act
    StringMatcher actualParseResult = listParser.parse(new ArrayList<>());

    // Assert
    assertTrue(actualParseResult instanceof ConstantMatcher);
    assertEquals("", actualParseResult.prefix());
  }
}
