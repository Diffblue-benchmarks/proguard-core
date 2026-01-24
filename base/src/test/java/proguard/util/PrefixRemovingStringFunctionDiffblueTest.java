package proguard.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PrefixRemovingStringFunction.<init>(String)"})
  void testNewPrefixRemovingStringFunction_whenEmptyString() {
    // Arrange, Act and Assert
    assertEquals("String", new PrefixRemovingStringFunction("").transform("String"));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PrefixRemovingStringFunction.<init>(String)"})
  void testNewPrefixRemovingStringFunction_whenPrefix() {
    // Arrange, Act and Assert
    assertEquals("String", new PrefixRemovingStringFunction("Prefix").transform("String"));
  }
}
