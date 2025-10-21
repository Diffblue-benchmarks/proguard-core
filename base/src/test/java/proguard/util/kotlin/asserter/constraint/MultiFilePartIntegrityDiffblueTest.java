package proguard.util.kotlin.asserter.constraint;

import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MultiFilePartIntegrityDiffblueTest {
  /**
   * Test new {@link MultiFilePartIntegrity} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link MultiFilePartIntegrity}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MultiFilePartIntegrity.<init>()"})
  public void testNewMultiFilePartIntegrity() {
    // Arrange and Act
    MultiFilePartIntegrity actualMultiFilePartIntegrity = new MultiFilePartIntegrity();

    // Assert
    assertNull(actualMultiFilePartIntegrity.libraryClassPool);
    assertNull(actualMultiFilePartIntegrity.programClassPool);
    assertNull(actualMultiFilePartIntegrity.reporter);
  }
}
