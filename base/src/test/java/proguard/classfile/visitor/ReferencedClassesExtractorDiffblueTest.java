package proguard.classfile.visitor;

import static org.junit.Assert.assertNull;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.Member;

public class ReferencedClassesExtractorDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ReferencedClassesExtractor}
   *   <li>{@link ReferencedClassesExtractor#visitAnyMember(Clazz, Member)}
   *   <li>{@link ReferencedClassesExtractor#getParameterClasses()}
   *   <li>{@link ReferencedClassesExtractor#getReturnClass()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ReferencedClassesExtractor actualReferencedClassesExtractor = new ReferencedClassesExtractor();
    LibraryClass clazz = new LibraryClass();
    actualReferencedClassesExtractor.visitAnyMember(clazz, new LibraryField(1, "Name", "Descriptor"));
    Clazz[] actualParameterClasses = actualReferencedClassesExtractor.getParameterClasses();

    // Assert that nothing has changed
    assertNull(actualParameterClasses);
    assertNull(actualReferencedClassesExtractor.getReturnClass());
  }
}
