package proguard.util.kotlin.asserter.constraint;

import static org.junit.Assert.assertNull;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.kotlin.KotlinValueParameterMetadata;
import proguard.classfile.kotlin.flags.KotlinValueParameterFlags;

public class ValueParameterIntegrityDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ValueParameterIntegrity}
   *   <li>
   * {@link ValueParameterIntegrity#visitAnyValueParameter(Clazz, KotlinValueParameterMetadata)}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ValueParameterIntegrity actualValueParameterIntegrity = new ValueParameterIntegrity();
    LibraryClass clazz = new LibraryClass();
    KotlinValueParameterFlags flags = new KotlinValueParameterFlags();
    flags.hasAnnotations = true;
    flags.hasDefaultValue = true;
    flags.isCrossInline = true;
    flags.isNoInline = true;
    actualValueParameterIntegrity.visitAnyValueParameter(clazz,
        new KotlinValueParameterMetadata(flags, 1, "Parameter Name"));

    // Assert that nothing has changed
    assertNull(actualValueParameterIntegrity.libraryClassPool);
    assertNull(actualValueParameterIntegrity.programClassPool);
    assertNull(actualValueParameterIntegrity.reporter);
  }
}
