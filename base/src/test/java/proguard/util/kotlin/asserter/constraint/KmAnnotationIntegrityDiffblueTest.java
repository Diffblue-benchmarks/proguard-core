package proguard.util.kotlin.asserter.constraint;

import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class KmAnnotationIntegrityDiffblueTest {
  /**
   * Test new {@link KmAnnotationIntegrity} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link KmAnnotationIntegrity}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KmAnnotationIntegrity.<init>()"})
  public void testNewKmAnnotationIntegrity() {
    // Arrange and Act
    KmAnnotationIntegrity actualKmAnnotationIntegrity = new KmAnnotationIntegrity();

    // Assert
    assertNull(actualKmAnnotationIntegrity.libraryClassPool);
    assertNull(actualKmAnnotationIntegrity.programClassPool);
    assertNull(actualKmAnnotationIntegrity.reporter);
  }
}
