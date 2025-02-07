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

class PrefixRemovingStringFunctionDiffblueTest {
  /**
   * Test {@link PrefixRemovingStringFunction#PrefixRemovingStringFunction(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link PrefixRemovingStringFunction#PrefixRemovingStringFunction(String)}
   */
  @Test
  @DisplayName("Test new PrefixRemovingStringFunction(String); when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.util.PrefixRemovingStringFunction.<init>(java.lang.String)"})
  void testNewPrefixRemovingStringFunction_whenEmptyString() {
    // Arrange, Act and Assert
    assertEquals("String", (new PrefixRemovingStringFunction("")).transform("String"));
  }

  /**
   * Test {@link PrefixRemovingStringFunction#PrefixRemovingStringFunction(String)}.
   *
   * <ul>
   *   <li>When {@code Prefix}.
   * </ul>
   *
   * <p>Method under test: {@link PrefixRemovingStringFunction#PrefixRemovingStringFunction(String)}
   */
  @Test
  @DisplayName("Test new PrefixRemovingStringFunction(String); when 'Prefix'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.util.PrefixRemovingStringFunction.<init>(java.lang.String)"})
  void testNewPrefixRemovingStringFunction_whenPrefix() {
    // Arrange, Act and Assert
    assertEquals("String", (new PrefixRemovingStringFunction("Prefix")).transform("String"));
  }

  /**
   * Test {@link PrefixRemovingStringFunction#transform(String)}.
   *
   * <p>Method under test: {@link PrefixRemovingStringFunction#transform(String)}
   */
  @Test
  @DisplayName("Test transform(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.util.PrefixRemovingStringFunction.transform(java.lang.String)"
  })
  void testTransform() {
    // Arrange
    StringFunction stringFunction = mock(StringFunction.class);
    when(stringFunction.transform(Mockito.<String>any())).thenReturn("Transform");

    // Act
    String actualTransformResult =
        (new PrefixRemovingStringFunction("", stringFunction)).transform("String");

    // Assert
    verify(stringFunction).transform(eq("String"));
    assertEquals("Transform", actualTransformResult);
  }

  /**
   * Test {@link PrefixRemovingStringFunction#transform(String)}.
   *
   * <ul>
   *   <li>Given {@link PrefixRemovingStringFunction#PrefixRemovingStringFunction(String,
   *       StringFunction)} with {@code Prefix} and {@link StringFunction}.
   * </ul>
   *
   * <p>Method under test: {@link PrefixRemovingStringFunction#transform(String)}
   */
  @Test
  @DisplayName(
      "Test transform(String); given PrefixRemovingStringFunction(String, StringFunction) with 'Prefix' and StringFunction")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.util.PrefixRemovingStringFunction.transform(java.lang.String)"
  })
  void testTransform_givenPrefixRemovingStringFunctionWithPrefixAndStringFunction() {
    // Arrange
    StringFunction stringFunction = mock(StringFunction.class);
    when(stringFunction.transform(Mockito.<String>any())).thenReturn("Transform");

    // Act
    String actualTransformResult =
        (new PrefixRemovingStringFunction("Prefix", stringFunction)).transform("String");

    // Assert
    verify(stringFunction).transform(eq("String"));
    assertEquals("Transform", actualTransformResult);
  }

  /**
   * Test {@link PrefixRemovingStringFunction#transform(String)}.
   *
   * <ul>
   *   <li>Given {@link PrefixRemovingStringFunction#PrefixRemovingStringFunction(String)} with
   *       prefix is empty string.
   * </ul>
   *
   * <p>Method under test: {@link PrefixRemovingStringFunction#transform(String)}
   */
  @Test
  @DisplayName(
      "Test transform(String); given PrefixRemovingStringFunction(String) with prefix is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.util.PrefixRemovingStringFunction.transform(java.lang.String)"
  })
  void testTransform_givenPrefixRemovingStringFunctionWithPrefixIsEmptyString() {
    // Arrange, Act and Assert
    assertEquals("String", (new PrefixRemovingStringFunction("")).transform("String"));
  }

  /**
   * Test {@link PrefixRemovingStringFunction#transform(String)}.
   *
   * <ul>
   *   <li>Given {@link PrefixRemovingStringFunction#PrefixRemovingStringFunction(String)} with
   *       {@code Prefix}.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link PrefixRemovingStringFunction#transform(String)}
   */
  @Test
  @DisplayName(
      "Test transform(String); given PrefixRemovingStringFunction(String) with 'Prefix'; then return 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.util.PrefixRemovingStringFunction.transform(java.lang.String)"
  })
  void testTransform_givenPrefixRemovingStringFunctionWithPrefix_thenReturnString() {
    // Arrange, Act and Assert
    assertEquals("String", (new PrefixRemovingStringFunction("Prefix")).transform("String"));
  }
}
