package proguard.classfile.visitor;

import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.Member;

class ReferencedClassesExtractorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ReferencedClassesExtractor}
   *   <li>{@link ReferencedClassesExtractor#visitAnyMember(Clazz, Member)}
   *   <li>{@link ReferencedClassesExtractor#getParameterClasses()}
   *   <li>{@link ReferencedClassesExtractor#getReturnClass()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassesExtractor.<init>()",
    "proguard.classfile.Clazz[] proguard.classfile.visitor.ReferencedClassesExtractor.getParameterClasses()",
    "proguard.classfile.Clazz proguard.classfile.visitor.ReferencedClassesExtractor.getReturnClass()",
    "void proguard.classfile.visitor.ReferencedClassesExtractor.visitAnyMember(proguard.classfile.Clazz, proguard.classfile.Member)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ReferencedClassesExtractor actualReferencedClassesExtractor = new ReferencedClassesExtractor();
    LibraryClass clazz = new LibraryClass();
    actualReferencedClassesExtractor.visitAnyMember(
        clazz, new LibraryField(1, "Name", "Descriptor"));
    Clazz[] actualParameterClasses = actualReferencedClassesExtractor.getParameterClasses();

    // Assert
    assertNull(actualParameterClasses);
    assertNull(actualReferencedClassesExtractor.getReturnClass());
  }
}
