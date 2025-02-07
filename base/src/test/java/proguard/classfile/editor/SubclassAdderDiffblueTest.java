package proguard.classfile.editor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;

class SubclassAdderDiffblueTest {
  /**
   * Test {@link SubclassAdder#visitAnyClass(Clazz)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass#LibraryClass()}.
   *   <li>Then array length is one.
   * </ul>
   *
   * <p>Method under test: {@link SubclassAdder#visitAnyClass(Clazz)}
   */
  @Test
  @DisplayName("Test visitAnyClass(Clazz); when LibraryClass(); then array length is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.SubclassAdder.visitAnyClass(proguard.classfile.Clazz)"
  })
  void testVisitAnyClass_whenLibraryClass_thenArrayLengthIsOne() {
    // Arrange
    LibraryClass subclass = new LibraryClass();
    SubclassAdder subclassAdder = new SubclassAdder(subclass);
    LibraryClass clazz = new LibraryClass();

    // Act
    subclassAdder.visitAnyClass(clazz);

    // Assert
    Clazz[] clazzArray = clazz.subClasses;
    assertEquals(1, clazzArray.length);
    assertEquals(1, clazz.subClassCount);
    assertSame(subclass, clazzArray[0]);
  }
}
