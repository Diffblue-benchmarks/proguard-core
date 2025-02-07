package proguard.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SuffixAddingStringFunctionDiffblueTest {
  /**
   * Test {@link SuffixAddingStringFunction#transform(String)}.
   *
   * <p>Method under test: {@link SuffixAddingStringFunction#transform(String)}
   */
  @Test
  @DisplayName("Test transform(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.util.SuffixAddingStringFunction.transform(java.lang.String)"
  })
  void testTransform() {
    // Arrange, Act and Assert
    assertEquals("StringSuffix", (new SuffixAddingStringFunction("Suffix")).transform("String"));
  }
}
