package proguard.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TransformedStringMatcherDiffblueTest {
  /**
   * Test {@link TransformedStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <ul>
   *   <li>Given {@link StringFunction} {@link StringFunction#transform(String)} return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link TransformedStringMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName(
      "Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'; given StringFunction transform(String) return 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.util.TransformedStringMatcher.matches(java.lang.String, int, int)"
  })
  void testMatchesWithStringBeginOffsetEndOffset_givenStringFunctionTransformReturnFoo() {
    // Arrange
    StringFunction stringFunction = mock(StringFunction.class);
    when(stringFunction.transform(Mockito.<String>any())).thenReturn("foo");

    // Act
    boolean actualMatchesResult =
        (new TransformedStringMatcher(stringFunction, new CollectionMatcher(new HashSet<>())))
            .matches("String", 1, 3);

    // Assert
    verify(stringFunction).transform(eq("tr"));
    assertFalse(actualMatchesResult);
  }

  /**
   * Test {@link TransformedStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TransformedStringMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName(
      "Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.util.TransformedStringMatcher.matches(java.lang.String, int, int)"
  })
  void testMatchesWithStringBeginOffsetEndOffset_thenReturnFalse() {
    // Arrange
    StringFunction stringFunction = mock(StringFunction.class);
    when(stringFunction.transform(Mockito.<String>any())).thenReturn("Transform");

    // Act
    boolean actualMatchesResult =
        (new TransformedStringMatcher(stringFunction, new EmptyStringMatcher()))
            .matches("String", 1, 3);

    // Assert
    verify(stringFunction).transform(eq("tr"));
    assertFalse(actualMatchesResult);
  }

  /**
   * Test {@link TransformedStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TransformedStringMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName(
      "Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.util.TransformedStringMatcher.matches(java.lang.String, int, int)"
  })
  void testMatchesWithStringBeginOffsetEndOffset_thenReturnTrue() {
    // Arrange
    StringFunction stringFunction = mock(StringFunction.class);
    when(stringFunction.transform(Mockito.<String>any())).thenReturn("");

    // Act
    boolean actualMatchesResult =
        (new TransformedStringMatcher(stringFunction, new EmptyStringMatcher()))
            .matches("String", 1, 3);

    // Assert
    verify(stringFunction).transform(eq("tr"));
    assertTrue(actualMatchesResult);
  }

  /**
   * Test {@link TransformedStringMatcher#matches(String)} with {@code string}.
   *
   * <ul>
   *   <li>Given {@link StringFunction} {@link StringFunction#transform(String)} return {@code foo}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TransformedStringMatcher#matches(String)}
   */
  @Test
  @DisplayName(
      "Test matches(String) with 'string'; given StringFunction transform(String) return 'foo'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.util.TransformedStringMatcher.matches(java.lang.String)"})
  void testMatchesWithString_givenStringFunctionTransformReturnFoo_thenReturnFalse() {
    // Arrange
    StringFunction stringFunction = mock(StringFunction.class);
    when(stringFunction.transform(Mockito.<String>any())).thenReturn("foo");

    // Act
    boolean actualMatchesResult =
        (new TransformedStringMatcher(stringFunction, new CollectionMatcher(new HashSet<>())))
            .matches("String");

    // Assert
    verify(stringFunction).transform(eq("String"));
    assertFalse(actualMatchesResult);
  }

  /**
   * Test {@link TransformedStringMatcher#matches(String)} with {@code string}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TransformedStringMatcher#matches(String)}
   */
  @Test
  @DisplayName("Test matches(String) with 'string'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.util.TransformedStringMatcher.matches(java.lang.String)"})
  void testMatchesWithString_thenReturnFalse() {
    // Arrange
    StringFunction stringFunction = mock(StringFunction.class);
    when(stringFunction.transform(Mockito.<String>any())).thenReturn("Transform");

    // Act
    boolean actualMatchesResult =
        (new TransformedStringMatcher(stringFunction, new EmptyStringMatcher())).matches("String");

    // Assert
    verify(stringFunction).transform(eq("String"));
    assertFalse(actualMatchesResult);
  }

  /**
   * Test {@link TransformedStringMatcher#matches(String)} with {@code string}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TransformedStringMatcher#matches(String)}
   */
  @Test
  @DisplayName("Test matches(String) with 'string'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.util.TransformedStringMatcher.matches(java.lang.String)"})
  void testMatchesWithString_thenReturnTrue() {
    // Arrange
    StringFunction stringFunction = mock(StringFunction.class);
    when(stringFunction.transform(Mockito.<String>any())).thenReturn("");

    // Act
    boolean actualMatchesResult =
        (new TransformedStringMatcher(stringFunction, new EmptyStringMatcher())).matches("String");

    // Assert
    verify(stringFunction).transform(eq("String"));
    assertTrue(actualMatchesResult);
  }
}
