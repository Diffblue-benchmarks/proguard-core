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

class PrefixAddingStringFunctionDiffblueTest {
  /**
   * Test {@link PrefixAddingStringFunction#transform(String)}.
   *
   * <ul>
   *   <li>Given {@link PrefixAddingStringFunction#PrefixAddingStringFunction(String)} with {@code
   *       Prefix}.
   *   <li>Then return {@code PrefixString}.
   * </ul>
   *
   * <p>Method under test: {@link PrefixAddingStringFunction#transform(String)}
   */
  @Test
  @DisplayName(
      "Test transform(String); given PrefixAddingStringFunction(String) with 'Prefix'; then return 'PrefixString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.util.PrefixAddingStringFunction.transform(java.lang.String)"
  })
  void testTransform_givenPrefixAddingStringFunctionWithPrefix_thenReturnPrefixString() {
    // Arrange, Act and Assert
    assertEquals("PrefixString", (new PrefixAddingStringFunction("Prefix")).transform("String"));
  }

  /**
   * Test {@link PrefixAddingStringFunction#transform(String)}.
   *
   * <ul>
   *   <li>Then return {@code PrefixTransform}.
   * </ul>
   *
   * <p>Method under test: {@link PrefixAddingStringFunction#transform(String)}
   */
  @Test
  @DisplayName("Test transform(String); then return 'PrefixTransform'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.util.PrefixAddingStringFunction.transform(java.lang.String)"
  })
  void testTransform_thenReturnPrefixTransform() {
    // Arrange
    StringFunction delegateFunction = mock(StringFunction.class);
    when(delegateFunction.transform(Mockito.<String>any())).thenReturn("Transform");

    // Act
    String actualTransformResult =
        (new PrefixAddingStringFunction("Prefix", delegateFunction)).transform("String");

    // Assert
    verify(delegateFunction).transform(eq("String"));
    assertEquals("PrefixTransform", actualTransformResult);
  }
}
