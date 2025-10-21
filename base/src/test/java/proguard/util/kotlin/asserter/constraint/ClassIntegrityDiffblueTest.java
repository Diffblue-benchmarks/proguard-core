package proguard.util.kotlin.asserter.constraint;

import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ClassIntegrityDiffblueTest {
  /**
   * Test new {@link ClassIntegrity} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link ClassIntegrity}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassIntegrity.<init>()"})
  public void testNewClassIntegrity() {
    // Arrange and Act
    ClassIntegrity actualClassIntegrity = new ClassIntegrity();

    // Assert
    assertNull(actualClassIntegrity.libraryClassPool);
    assertNull(actualClassIntegrity.programClassPool);
    assertNull(actualClassIntegrity.reporter);
  }
}
