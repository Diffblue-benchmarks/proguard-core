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
import proguard.classfile.ProgramClass;

class ProgramClassFilterDiffblueTest {
  /**
   * Test {@link ProgramClassFilter#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ProgramClassFilter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ProgramClassFilter.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());
    ProgramClassFilter programClassFilter = new ProgramClassFilter(classVisitor);

    // Act
    programClassFilter.visitProgramClass(new ProgramClass());

    // Assert
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }
}
