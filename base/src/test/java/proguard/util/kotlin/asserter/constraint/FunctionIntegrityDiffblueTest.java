package proguard.util.kotlin.asserter.constraint;

import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FunctionIntegrityDiffblueTest {
  /**
   * Test new {@link FunctionIntegrity} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link FunctionIntegrity}
   */
  @Test
  @DisplayName("Test new FunctionIntegrity (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.util.kotlin.asserter.constraint.FunctionIntegrity.<init>()"})
  void testNewFunctionIntegrity() {
    // Arrange and Act
    FunctionIntegrity actualFunctionIntegrity = new FunctionIntegrity();

    // Assert
    assertNull(actualFunctionIntegrity.libraryClassPool);
    assertNull(actualFunctionIntegrity.programClassPool);
    assertNull(actualFunctionIntegrity.reporter);
  }
}
