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

class ListFunctionParserDiffblueTest {
  /**
   * Test {@link ListFunctionParser#parse(String)} with {@code regularExpression}.
   *
   * <p>Method under test: {@link ListFunctionParser#parse(String)}
   */
  @Test
  @DisplayName("Test parse(String) with 'regularExpression'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.util.StringFunction proguard.util.ListFunctionParser.parse(java.lang.String)"
  })
  void testParseWithRegularExpression() {
    // Arrange, Act and Assert
    assertEquals(
        "foo",
        (new ListFunctionParser(mock(StringFunctionParser.class))).parse("").transform("foo"));
  }

  /**
   * Test {@link ListFunctionParser#parse(List)} with {@code regularExpressions}.
   *
   * <ul>
   *   <li>Then return {@link OrStringFunction}.
   * </ul>
   *
   * <p>Method under test: {@link ListFunctionParser#parse(List)}
   */
  @Test
  @DisplayName("Test parse(List) with 'regularExpressions'; then return OrStringFunction")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.util.StringFunction proguard.util.ListFunctionParser.parse(java.util.List)"
  })
  void testParseWithRegularExpressions_thenReturnOrStringFunction() {
    // Arrange
    StringFunction stringFunction = mock(StringFunction.class);
    when(stringFunction.transform(Mockito.<String>any())).thenReturn("Transform");
    StringFunctionParser stringFunctionParser = mock(StringFunctionParser.class);
    when(stringFunctionParser.parse(Mockito.<String>any())).thenReturn(stringFunction);
    ListFunctionParser listFunctionParser = new ListFunctionParser(stringFunctionParser);

    ArrayList<Object> regularExpressions = new ArrayList<>();
    regularExpressions.add("42");
    regularExpressions.add("42");

    // Act
    StringFunction actualParseResult = listFunctionParser.parse(regularExpressions);
    String actualTransformResult = actualParseResult.transform("foo");

    // Assert
    verify(stringFunction).transform(eq("foo"));
    verify(stringFunctionParser, atLeast(1)).parse(eq("42"));
    assertTrue(actualParseResult instanceof OrStringFunction);
    assertEquals("Transform", actualParseResult.transform("String"));
    assertEquals("Transform", actualTransformResult);
  }

  /**
   * Test {@link ListFunctionParser#parse(List)} with {@code regularExpressions}.
   *
   * <ul>
   *   <li>Then return transform {@code foo} is {@code Transform}.
   * </ul>
   *
   * <p>Method under test: {@link ListFunctionParser#parse(List)}
   */
  @Test
  @DisplayName(
      "Test parse(List) with 'regularExpressions'; then return transform 'foo' is 'Transform'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.util.StringFunction proguard.util.ListFunctionParser.parse(java.util.List)"
  })
  void testParseWithRegularExpressions_thenReturnTransformFooIsTransform() {
    // Arrange
    StringFunction stringFunction = mock(StringFunction.class);
    when(stringFunction.transform(Mockito.<String>any())).thenReturn("Transform");
    StringFunctionParser stringFunctionParser = mock(StringFunctionParser.class);
    when(stringFunctionParser.parse(Mockito.<String>any())).thenReturn(stringFunction);
    ListFunctionParser listFunctionParser = new ListFunctionParser(stringFunctionParser);

    ArrayList<Object> regularExpressions = new ArrayList<>();
    regularExpressions.add("42");

    // Act
    String actualTransformResult = listFunctionParser.parse(regularExpressions).transform("foo");

    // Assert
    verify(stringFunction).transform(eq("foo"));
    verify(stringFunctionParser).parse(eq("42"));
    assertEquals("Transform", actualTransformResult);
  }

  /**
   * Test {@link ListFunctionParser#parse(List)} with {@code regularExpressions}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return transform {@code foo} is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link ListFunctionParser#parse(List)}
   */
  @Test
  @DisplayName(
      "Test parse(List) with 'regularExpressions'; when ArrayList(); then return transform 'foo' is 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.util.StringFunction proguard.util.ListFunctionParser.parse(java.util.List)"
  })
  void testParseWithRegularExpressions_whenArrayList_thenReturnTransformFooIsFoo() {
    // Arrange
    ListFunctionParser listFunctionParser =
        new ListFunctionParser(mock(StringFunctionParser.class));

    // Act and Assert
    assertEquals("foo", listFunctionParser.parse(new ArrayList<>()).transform("foo"));
  }
}
