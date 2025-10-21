package proguard.util.kotlin.asserter.constraint;

import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MultiFileFacadeIntegrityDiffblueTest {
  /**
   * Test new {@link MultiFileFacadeIntegrity} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link MultiFileFacadeIntegrity}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MultiFileFacadeIntegrity.<init>()"})
  public void testNewMultiFileFacadeIntegrity() {
    // Arrange and Act
    MultiFileFacadeIntegrity actualMultiFileFacadeIntegrity = new MultiFileFacadeIntegrity();

    // Assert
    assertNull(actualMultiFileFacadeIntegrity.libraryClassPool);
    assertNull(actualMultiFileFacadeIntegrity.programClassPool);
    assertNull(actualMultiFileFacadeIntegrity.reporter);
  }
}
