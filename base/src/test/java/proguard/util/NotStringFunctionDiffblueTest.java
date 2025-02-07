package proguard.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class NotStringFunctionDiffblueTest {
  /**
   * Test {@link NotStringFunction#transform(String)}.
   *
   * <ul>
   *   <li>Given {@link StringFunction} {@link StringFunction#transform(String)} return {@code
   *       null}.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link NotStringFunction#transform(String)}
   */
  @Test
  @DisplayName(
      "Test transform(String); given StringFunction transform(String) return 'null'; then return 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.util.NotStringFunction.transform(java.lang.String)"
  })
  void testTransform_givenStringFunctionTransformReturnNull_thenReturnString() {
    // Arrange
    StringFunction stringFunction = mock(StringFunction.class);
    when(stringFunction.transform(Mockito.<String>any())).thenReturn(null);

    // Act
    String actualTransformResult = (new NotStringFunction(stringFunction)).transform("String");

    // Assert
    verify(stringFunction).transform(eq("String"));
    assertEquals("String", actualTransformResult);
  }

  /**
   * Test {@link NotStringFunction#transform(String)}.
   *
   * <ul>
   *   <li>Given {@link StringFunction} {@link StringFunction#transform(String)} return {@code
   *       Transform}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NotStringFunction#transform(String)}
   */
  @Test
  @DisplayName(
      "Test transform(String); given StringFunction transform(String) return 'Transform'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.util.NotStringFunction.transform(java.lang.String)"
  })
  void testTransform_givenStringFunctionTransformReturnTransform_thenReturnNull() {
    // Arrange
    StringFunction stringFunction = mock(StringFunction.class);
    when(stringFunction.transform(Mockito.<String>any())).thenReturn("Transform");

    // Act
    String actualTransformResult = (new NotStringFunction(stringFunction)).transform("String");

    // Assert
    verify(stringFunction).transform(eq("String"));
    assertNull(actualTransformResult);
  }
}
