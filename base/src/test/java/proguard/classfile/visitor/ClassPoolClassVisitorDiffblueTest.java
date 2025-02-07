package proguard.classfile.visitor;

import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.ClassPool;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;

class ClassPoolClassVisitorDiffblueTest {
  /**
   * Test {@link ClassPoolClassVisitor#visitAnyClass(Clazz)}.
   *
   * <p>Method under test: {@link ClassPoolClassVisitor#visitAnyClass(Clazz)}
   */
  @Test
  @DisplayName("Test visitAnyClass(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPoolClassVisitor.visitAnyClass(proguard.classfile.Clazz)"
  })
  void testVisitAnyClass() {
    // Arrange
    ClassPoolVisitor classPoolVisitor = mock(ClassPoolVisitor.class);
    doNothing().when(classPoolVisitor).visitClassPool(Mockito.<ClassPool>any());
    ClassPoolClassVisitor classPoolClassVisitor = new ClassPoolClassVisitor(classPoolVisitor);

    // Act
    classPoolClassVisitor.visitAnyClass(new LibraryClass());

    // Assert
    verify(classPoolVisitor).visitClassPool(isNull());
  }
}
