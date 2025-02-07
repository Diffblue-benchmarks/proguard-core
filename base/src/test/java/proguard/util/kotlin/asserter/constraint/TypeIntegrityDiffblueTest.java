package proguard.util.kotlin.asserter.constraint;

import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TypeIntegrityDiffblueTest {
  /**
   * Test new {@link TypeIntegrity} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TypeIntegrity}
   */
  @Test
  @DisplayName("Test new TypeIntegrity (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.util.kotlin.asserter.constraint.TypeIntegrity.<init>()"})
  void testNewTypeIntegrity() {
    // Arrange and Act
    TypeIntegrity actualTypeIntegrity = new TypeIntegrity();

    // Assert
    assertNull(actualTypeIntegrity.libraryClassPool);
    assertNull(actualTypeIntegrity.programClassPool);
    assertNull(actualTypeIntegrity.reporter);
  }
}
