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

class MultiClassVisitorDiffblueTest {
  /**
   * Test {@link MultiClassVisitor#visitAnyClass(Clazz)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link MultiClassVisitor#visitAnyClass(Clazz)}
   */
  @Test
  @DisplayName("Test visitAnyClass(Clazz); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MultiClassVisitor.visitAnyClass(proguard.classfile.Clazz)"
  })
  void testVisitAnyClass_thenCallsVisitLibraryClass() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    MultiClassVisitor multiClassVisitor = new MultiClassVisitor(classVisitor);

    // Act
    multiClassVisitor.visitAnyClass(new LibraryClass());

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }
}
