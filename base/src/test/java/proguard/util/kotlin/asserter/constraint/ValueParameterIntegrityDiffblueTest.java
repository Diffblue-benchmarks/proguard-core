package proguard.util.kotlin.asserter.constraint;

import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.kotlin.KotlinValueParameterMetadata;
import proguard.classfile.kotlin.flags.KotlinValueParameterFlags;

class ValueParameterIntegrityDiffblueTest {
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.util.kotlin.asserter.constraint.ValueParameterIntegrity.<init>()",
    "void proguard.util.kotlin.asserter.constraint.ValueParameterIntegrity.visitAnyValueParameter(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinValueParameterMetadata)"
  })
  void testGettersAndSetters() {
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
