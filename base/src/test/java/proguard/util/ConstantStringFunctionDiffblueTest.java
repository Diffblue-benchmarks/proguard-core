package proguard.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ConstantStringFunctionDiffblueTest {
  /**
   * Test {@link ConstantStringFunction#transform(String)}.
   *
   * <p>Method under test: {@link ConstantStringFunction#transform(String)}
   */
  @Test
  @DisplayName("Test transform(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.util.ConstantStringFunction.transform(java.lang.String)"
  })
  void testTransform() {
    // Arrange, Act and Assert
    assertEquals("String", (new ConstantStringFunction("String")).transform("String"));
  }
}
