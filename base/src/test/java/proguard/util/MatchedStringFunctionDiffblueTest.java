package proguard.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MatchedStringFunctionDiffblueTest {
  /**
   * Test {@link MatchedStringFunction#transform(String)}.
   *
   * <ul>
   *   <li>Then return {@code Matching String}.
   * </ul>
   *
   * <p>Method under test: {@link MatchedStringFunction#transform(String)}
   */
  @Test
  @DisplayName("Test transform(String); then return 'Matching String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.util.MatchedStringFunction.transform(java.lang.String)"
  })
  void testTransform_thenReturnMatchingString() {
    // Arrange
    VariableStringMatcher variableStringMatcher = mock(VariableStringMatcher.class);
    when(variableStringMatcher.getMatchingString()).thenReturn("Matching String");

    // Act
    String actualTransformResult =
        (new MatchedStringFunction(variableStringMatcher)).transform("String");

    // Assert
    verify(variableStringMatcher).getMatchingString();
    assertEquals("Matching String", actualTransformResult);
  }
}
