package proguard.util.kotlin.asserter.constraint;

import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TypeIntegrityDiffblueTest {
  /**
   * Test new {@link TypeIntegrity} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TypeIntegrity}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TypeIntegrity.<init>()"})
  public void testNewTypeIntegrity() {
    // Arrange and Act
    TypeIntegrity actualTypeIntegrity = new TypeIntegrity();

    // Assert
    assertNull(actualTypeIntegrity.libraryClassPool);
    assertNull(actualTypeIntegrity.programClassPool);
    assertNull(actualTypeIntegrity.reporter);
  }
}
