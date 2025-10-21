package proguard.util.kotlin.asserter.constraint;

import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PropertyIntegrityDiffblueTest {
  /**
   * Test new {@link PropertyIntegrity} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link PropertyIntegrity}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PropertyIntegrity.<init>()"})
  public void testNewPropertyIntegrity() {
    // Arrange and Act
    PropertyIntegrity actualPropertyIntegrity = new PropertyIntegrity();

    // Assert
    assertNull(actualPropertyIntegrity.libraryClassPool);
    assertNull(actualPropertyIntegrity.programClassPool);
    assertNull(actualPropertyIntegrity.reporter);
  }
}
