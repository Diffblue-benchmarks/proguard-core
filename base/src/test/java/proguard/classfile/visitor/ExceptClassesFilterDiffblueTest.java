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

class ExceptClassesFilterDiffblueTest {
  /**
   * Test {@link ExceptClassesFilter#visitAnyClass(Clazz)}.
   *
   * <ul>
   *   <li>Given {@link ExceptClassesFilter#ExceptClassesFilter(Clazz[], ClassVisitor)} with
   *       exceptClasses is {@code null} and {@link ClassVisitor}.
   * </ul>
   *
   * <p>Method under test: {@link ExceptClassesFilter#visitAnyClass(Clazz)}
   */
  @Test
  @DisplayName(
      "Test visitAnyClass(Clazz); given ExceptClassesFilter(Clazz[], ClassVisitor) with exceptClasses is 'null' and ClassVisitor")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ExceptClassesFilter.visitAnyClass(proguard.classfile.Clazz)"
  })
  void testVisitAnyClass_givenExceptClassesFilterWithExceptClassesIsNullAndClassVisitor() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    ExceptClassesFilter exceptClassesFilter = new ExceptClassesFilter(null, classVisitor);

    // Act
    exceptClassesFilter.visitAnyClass(new LibraryClass());

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link ExceptClassesFilter#visitAnyClass(Clazz)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ExceptClassesFilter#visitAnyClass(Clazz)}
   */
  @Test
  @DisplayName("Test visitAnyClass(Clazz); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ExceptClassesFilter.visitAnyClass(proguard.classfile.Clazz)"
  })
  void testVisitAnyClass_thenCallsVisitLibraryClass() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    ExceptClassesFilter exceptClassesFilter =
        new ExceptClassesFilter(new Clazz[] {new LibraryClass()}, classVisitor);

    // Act
    exceptClassesFilter.visitAnyClass(new LibraryClass());

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }
}
