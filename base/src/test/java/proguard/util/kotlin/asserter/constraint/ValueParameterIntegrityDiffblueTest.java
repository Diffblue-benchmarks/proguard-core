package proguard.util.kotlin.asserter.constraint;

import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.kotlin.KotlinValueParameterMetadata;
import proguard.classfile.kotlin.flags.KotlinValueParameterFlags;

public class ValueParameterIntegrityDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ValueParameterIntegrity}
   *   <li>{@link ValueParameterIntegrity#visitAnyValueParameter(Clazz,
   *       KotlinValueParameterMetadata)}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ValueParameterIntegrity.<init>()",
    "void ValueParameterIntegrity.visitAnyValueParameter(Clazz, KotlinValueParameterMetadata)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ValueParameterIntegrity actualValueParameterIntegrity = new ValueParameterIntegrity();
    LibraryClass clazz = new LibraryClass();
    KotlinValueParameterFlags flags = new KotlinValueParameterFlags();
    flags.hasAnnotations = true;
    flags.hasDefaultValue = true;
    flags.isCrossInline = true;
    flags.isNoInline = true;
    actualValueParameterIntegrity.visitAnyValueParameter(
        clazz, new KotlinValueParameterMetadata(flags, 1, "Parameter Name"));

    // Assert
    assertNull(actualValueParameterIntegrity.libraryClassPool);
    assertNull(actualValueParameterIntegrity.programClassPool);
    assertNull(actualValueParameterIntegrity.reporter);
  }
}
