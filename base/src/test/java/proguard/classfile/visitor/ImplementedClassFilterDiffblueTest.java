package proguard.classfile.visitor;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;

class ImplementedClassFilterDiffblueTest {
  /**
   * Test {@link ImplementedClassFilter#visitAnyClass(Clazz)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass#LibraryClass()}.
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ImplementedClassFilter#visitAnyClass(Clazz)}
   */
  @Test
  @DisplayName(
      "Test visitAnyClass(Clazz); when LibraryClass(); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ImplementedClassFilter.visitAnyClass(proguard.classfile.Clazz)"
  })
  void testVisitAnyClass_whenLibraryClass_thenCallsVisitLibraryClass() {
    // Arrange
    ClassVisitor rejectedClassVisistor = mock(ClassVisitor.class);
    doNothing().when(rejectedClassVisistor).visitLibraryClass(Mockito.<LibraryClass>any());
    ImplementedClassFilter implementedClassFilter =
        new ImplementedClassFilter(
            new LibraryClass(), true, mock(ClassVisitor.class), rejectedClassVisistor);

    // Act
    implementedClassFilter.visitAnyClass(new LibraryClass());

    // Assert
    verify(rejectedClassVisistor).visitLibraryClass(isA(LibraryClass.class));
  }
}
