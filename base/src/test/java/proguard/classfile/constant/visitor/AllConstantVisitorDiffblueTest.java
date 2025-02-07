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

class AllConstantVisitorDiffblueTest {
  /**
   * Test {@link AllConstantVisitor#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#constantPoolEntriesAccept(ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link AllConstantVisitor#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName(
      "Test visitProgramClass(ProgramClass); then calls constantPoolEntriesAccept(ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.visitor.AllConstantVisitor.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass_thenCallsConstantPoolEntriesAccept() {
    // Arrange
    AllConstantVisitor allConstantVisitor = new AllConstantVisitor(new ConstantLookupVisitor());
    ProgramClass programClass = mock(ProgramClass.class);
    doNothing().when(programClass).constantPoolEntriesAccept(Mockito.<ConstantVisitor>any());

    // Act
    allConstantVisitor.visitProgramClass(programClass);

    // Assert
    verify(programClass).constantPoolEntriesAccept(isA(ConstantVisitor.class));
  }
}
