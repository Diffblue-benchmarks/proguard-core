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

class AndStringFunctionDiffblueTest {
  /**
   * Test {@link AndStringFunction#transform(String)}.
   *
   * <ul>
   *   <li>Given {@link StringFunction} {@link StringFunction#transform(String)} return {@code
   *       null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AndStringFunction#transform(String)}
   */
  @Test
  @DisplayName(
      "Test transform(String); given StringFunction transform(String) return 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.util.AndStringFunction.transform(java.lang.String)"
  })
  void testTransform_givenStringFunctionTransformReturnNull_thenReturnNull() {
    // Arrange
    StringFunction stringFunction1 = mock(StringFunction.class);
    when(stringFunction1.transform(Mockito.<String>any())).thenReturn(null);
    StringFunction stringFunction2 = mock(StringFunction.class);
    when(stringFunction2.transform(Mockito.<String>any())).thenReturn("Transform");

    // Act
    String actualTransformResult =
        (new AndStringFunction(stringFunction1, stringFunction2)).transform("String");

    // Assert
    verify(stringFunction1).transform(eq("String"));
    assertNull(actualTransformResult);
  }

  /**
   * Test {@link AndStringFunction#transform(String)}.
   *
   * <ul>
   *   <li>Then return {@code Transform}.
   * </ul>
   *
   * <p>Method under test: {@link AndStringFunction#transform(String)}
   */
  @Test
  @DisplayName("Test transform(String); then return 'Transform'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.util.AndStringFunction.transform(java.lang.String)"
  })
  void testTransform_thenReturnTransform() {
    // Arrange
    StringFunction stringFunction1 = mock(StringFunction.class);
    when(stringFunction1.transform(Mockito.<String>any())).thenReturn("Transform");
    StringFunction stringFunction2 = mock(StringFunction.class);
    when(stringFunction2.transform(Mockito.<String>any())).thenReturn("Transform");

    // Act
    String actualTransformResult =
        (new AndStringFunction(stringFunction1, stringFunction2)).transform("String");

    // Assert
    verify(stringFunction1).transform(eq("String"));
    verify(stringFunction2).transform(eq("String"));
    assertEquals("Transform", actualTransformResult);
  }
}
