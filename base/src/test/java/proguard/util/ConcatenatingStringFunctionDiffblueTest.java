package proguard.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ConcatenatingStringFunctionDiffblueTest {
  /**
   * Test {@link ConcatenatingStringFunction#transform(String)}.
   *
   * <p>Method under test: {@link ConcatenatingStringFunction#transform(String)}
   */
  @Test
  @DisplayName("Test transform(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.util.ConcatenatingStringFunction.transform(java.lang.String)"
  })
  void testTransform() {
    // Arrange
    StringFunction stringFunction1 = mock(StringFunction.class);
    when(stringFunction1.transform(Mockito.<String>any())).thenReturn("Transform");
    StringFunction stringFunction2 = mock(StringFunction.class);
    when(stringFunction2.transform(Mockito.<String>any())).thenReturn("Transform");

    // Act
    String actualTransformResult =
        (new ConcatenatingStringFunction(stringFunction1, stringFunction2)).transform("String");

    // Assert
    verify(stringFunction1).transform(eq("String"));
    verify(stringFunction2).transform(eq("String"));
    assertEquals("TransformTransform", actualTransformResult);
  }
}
