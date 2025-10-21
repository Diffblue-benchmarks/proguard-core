package proguard.util.kotlin.asserter.constraint;

import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SyntheticClassIntegrityDiffblueTest {
  /**
   * Test new {@link SyntheticClassIntegrity} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link SyntheticClassIntegrity}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyntheticClassIntegrity.<init>()"})
  public void testNewSyntheticClassIntegrity() {
    // Arrange and Act
    SyntheticClassIntegrity actualSyntheticClassIntegrity = new SyntheticClassIntegrity();

    // Assert
    assertNull(actualSyntheticClassIntegrity.libraryClassPool);
    assertNull(actualSyntheticClassIntegrity.programClassPool);
    assertNull(actualSyntheticClassIntegrity.reporter);
  }
}
