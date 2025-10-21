package proguard.util.kotlin.asserter.constraint;

import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ConstructorIntegrityDiffblueTest {
  /**
   * Test new {@link ConstructorIntegrity} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link ConstructorIntegrity}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstructorIntegrity.<init>()"})
  public void testNewConstructorIntegrity() {
    // Arrange and Act
    ConstructorIntegrity actualConstructorIntegrity = new ConstructorIntegrity();

    // Assert
    assertNull(actualConstructorIntegrity.libraryClassPool);
    assertNull(actualConstructorIntegrity.programClassPool);
    assertNull(actualConstructorIntegrity.reporter);
  }
}
