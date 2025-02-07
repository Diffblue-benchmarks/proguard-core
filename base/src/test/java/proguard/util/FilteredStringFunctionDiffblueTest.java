package proguard.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

class FilteredStringFunctionDiffblueTest {
  /**
   * Test {@link FilteredStringFunction#FilteredStringFunction(String, StringFunction,
   * StringFunction)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link FilteredStringFunction#FilteredStringFunction(String,
   * StringFunction, StringFunction)}
   */
  @Test
  @DisplayName(
      "Test new FilteredStringFunction(String, StringFunction, StringFunction); when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.util.FilteredStringFunction.<init>(java.lang.String, proguard.util.StringFunction, proguard.util.StringFunction)"
  })
  void testNewFilteredStringFunction_whenEmptyString() {
    // Arrange
    StringFunction acceptedFunction = mock(StringFunction.class);
    when(acceptedFunction.transform(Mockito.<String>any())).thenReturn("Transform");
    StringFunction rejectedFunction = mock(StringFunction.class);
    when(rejectedFunction.transform(Mockito.<String>any())).thenReturn("Transform");

    // Act
    String actualTransformResult =
        (new FilteredStringFunction("", acceptedFunction, rejectedFunction)).transform("foo.txt");

    // Assert
    verify(acceptedFunction).transform(eq("foo.txt"));
    assertEquals("Transform", actualTransformResult);
  }

  /**
   * Test {@link FilteredStringFunction#FilteredStringFunction(String, StringFunction,
   * StringFunction)}.
   *
   * <ul>
   *   <li>When {@code Name Filter}.
   * </ul>
   *
   * <p>Method under test: {@link FilteredStringFunction#FilteredStringFunction(String,
   * StringFunction, StringFunction)}
   */
  @Test
  @DisplayName(
      "Test new FilteredStringFunction(String, StringFunction, StringFunction); when 'Name Filter'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.util.FilteredStringFunction.<init>(java.lang.String, proguard.util.StringFunction, proguard.util.StringFunction)"
  })
  void testNewFilteredStringFunction_whenNameFilter() {
    // Arrange
    StringFunction acceptedFunction = mock(StringFunction.class);
    StringFunction rejectedFunction = mock(StringFunction.class);
    when(rejectedFunction.transform(Mockito.<String>any())).thenReturn("Transform");

    // Act
    String actualTransformResult =
        (new FilteredStringFunction("Name Filter", acceptedFunction, rejectedFunction))
            .transform("foo.txt");

    // Assert
    verify(rejectedFunction).transform(eq("foo.txt"));
    assertEquals("Transform", actualTransformResult);
  }

  /**
   * Test {@link FilteredStringFunction#transform(String)}.
   *
   * <p>Method under test: {@link FilteredStringFunction#transform(String)}
   */
  @Test
  @DisplayName("Test transform(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.util.FilteredStringFunction.transform(java.lang.String)"
  })
  void testTransform() {
    // Arrange
    StringFunction rejectedFunction = mock(StringFunction.class);
    when(rejectedFunction.transform(Mockito.<String>any())).thenReturn("Transform");

    // Act
    String actualTransformResult =
        (new FilteredStringFunction("Name Filter", mock(StringFunction.class), rejectedFunction))
            .transform("foo.txt");

    // Assert
    verify(rejectedFunction).transform(eq("foo.txt"));
    assertEquals("Transform", actualTransformResult);
  }

  /**
   * Test {@link FilteredStringFunction#transform(String)}.
   *
   * <p>Method under test: {@link FilteredStringFunction#transform(String)}
   */
  @Test
  @DisplayName("Test transform(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.util.FilteredStringFunction.transform(java.lang.String)"
  })
  void testTransform2() {
    // Arrange
    StringFunction acceptedFunction = mock(StringFunction.class);
    when(acceptedFunction.transform(Mockito.<String>any())).thenReturn("Transform");
    StringFunction rejectedFunction = mock(StringFunction.class);
    when(rejectedFunction.transform(Mockito.<String>any())).thenReturn("Transform");

    // Act
    String actualTransformResult =
        (new FilteredStringFunction("", acceptedFunction, rejectedFunction)).transform("foo.txt");

    // Assert
    verify(acceptedFunction).transform(eq("foo.txt"));
    assertEquals("Transform", actualTransformResult);
  }

  /**
   * Test {@link FilteredStringFunction#transform(String)}.
   *
   * <ul>
   *   <li>Given {@link CollectionMatcher#CollectionMatcher(Set)} with set is {@link
   *       HashSet#HashSet()}.
   *   <li>Then return {@code Transform}.
   * </ul>
   *
   * <p>Method under test: {@link FilteredStringFunction#transform(String)}
   */
  @Test
  @DisplayName(
      "Test transform(String); given CollectionMatcher(Set) with set is HashSet(); then return 'Transform'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.util.FilteredStringFunction.transform(java.lang.String)"
  })
  void testTransform_givenCollectionMatcherWithSetIsHashSet_thenReturnTransform() {
    // Arrange
    StringFunction rejectedFunction = mock(StringFunction.class);
    when(rejectedFunction.transform(Mockito.<String>any())).thenReturn("Transform");

    // Act
    String actualTransformResult =
        (new FilteredStringFunction(
                new CollectionMatcher(new HashSet<>()),
                mock(StringFunction.class),
                rejectedFunction))
            .transform("foo.txt");

    // Assert
    verify(rejectedFunction).transform(eq("foo.txt"));
    assertEquals("Transform", actualTransformResult);
  }
}
