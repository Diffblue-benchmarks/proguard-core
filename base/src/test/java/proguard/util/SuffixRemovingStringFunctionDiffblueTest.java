package proguard.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SuffixRemovingStringFunctionDiffblueTest {
  /**
   * Test {@link SuffixRemovingStringFunction#transform(String)}.
   *
   * <ul>
   *   <li>Given {@link SuffixRemovingStringFunction#SuffixRemovingStringFunction(String)} with
   *       {@code Suffix}.
   * </ul>
   *
   * <p>Method under test: {@link SuffixRemovingStringFunction#transform(String)}
   */
  @Test
  @DisplayName("Test transform(String); given SuffixRemovingStringFunction(String) with 'Suffix'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SuffixRemovingStringFunction.transform(String)"})
  void testTransform_givenSuffixRemovingStringFunctionWithSuffix() {
    // Arrange, Act and Assert
    assertEquals("String", new SuffixRemovingStringFunction("Suffix").transform("String"));
  }

  /**
   * Test {@link SuffixRemovingStringFunction#transform(String)}.
   *
   * <ul>
   *   <li>Given {@link SuffixRemovingStringFunction#SuffixRemovingStringFunction(String)} with
   *       suffix is empty string.
   * </ul>
   *
   * <p>Method under test: {@link SuffixRemovingStringFunction#transform(String)}
   */
  @Test
  @DisplayName(
      "Test transform(String); given SuffixRemovingStringFunction(String) with suffix is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SuffixRemovingStringFunction.transform(String)"})
  void testTransform_givenSuffixRemovingStringFunctionWithSuffixIsEmptyString() {
    // Arrange, Act and Assert
    assertEquals("String", new SuffixRemovingStringFunction("").transform("String"));
  }
}
