package proguard.util.kotlin.asserter.constraint;

import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FunctionIntegrityDiffblueTest {
  /**
   * Test new {@link FunctionIntegrity} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link FunctionIntegrity}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FunctionIntegrity.<init>()"})
  public void testNewFunctionIntegrity() {
    // Arrange and Act
    FunctionIntegrity actualFunctionIntegrity = new FunctionIntegrity();

    // Assert
    assertNull(actualFunctionIntegrity.libraryClassPool);
    assertNull(actualFunctionIntegrity.programClassPool);
    assertNull(actualFunctionIntegrity.reporter);
  }
}
