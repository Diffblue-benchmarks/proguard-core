package proguard.classfile.visitor;

import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.Member;

public class ReferencedClassesExtractorDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ReferencedClassesExtractor.<init>()",
    "Clazz[] ReferencedClassesExtractor.getParameterClasses()",
    "Clazz ReferencedClassesExtractor.getReturnClass()",
    "void ReferencedClassesExtractor.visitAnyMember(Clazz, Member)"
  })
  public void testGettersAndSetters() {
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
