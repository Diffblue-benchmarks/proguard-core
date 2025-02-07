package proguard.classfile.constant.visitor;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.analysis.cpa.jvm.util.ConstantLookupVisitor;
import proguard.classfile.ProgramClass;

class SuperClassConstantVisitorDiffblueTest {
  /**
   * Test {@link SuperClassConstantVisitor#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#interfaceConstantsAccept(ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link SuperClassConstantVisitor#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName(
      "Test visitProgramClass(ProgramClass); then calls interfaceConstantsAccept(ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.visitor.SuperClassConstantVisitor.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass_thenCallsInterfaceConstantsAccept() {
    // Arrange
    SuperClassConstantVisitor superClassConstantVisitor =
        new SuperClassConstantVisitor(true, true, new ConstantLookupVisitor());
    ProgramClass programClass = mock(ProgramClass.class);
    doNothing().when(programClass).interfaceConstantsAccept(Mockito.<ConstantVisitor>any());
    doNothing().when(programClass).superClassConstantAccept(Mockito.<ConstantVisitor>any());

    // Act
    superClassConstantVisitor.visitProgramClass(programClass);

    // Assert
    verify(programClass).interfaceConstantsAccept(isA(ConstantVisitor.class));
    verify(programClass).superClassConstantAccept(isA(ConstantVisitor.class));
  }
}
