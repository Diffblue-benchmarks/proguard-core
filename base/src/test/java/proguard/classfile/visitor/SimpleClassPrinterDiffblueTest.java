package proguard.classfile.visitor;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramMethod;

class SimpleClassPrinterDiffblueTest {
  /**
   * Test {@link SimpleClassPrinter#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#getAccessFlags()}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleClassPrinter#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName("Test visitProgramMethod(ProgramClass, ProgramMethod); then calls getAccessFlags()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.SimpleClassPrinter.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod_thenCallsGetAccessFlags() {
    // Arrange
    SimpleClassPrinter simpleClassPrinter = new SimpleClassPrinter(true);
    ProgramClass programClass = mock(ProgramClass.class);
    when(programClass.getString(anyInt())).thenReturn("<init>");
    when(programClass.getAccessFlags()).thenReturn(1);
    when(programClass.getName()).thenReturn("Name");

    // Act
    simpleClassPrinter.visitProgramMethod(programClass, new ProgramMethod());

    // Assert
    verify(programClass).getAccessFlags();
    verify(programClass, atLeast(1)).getName();
    verify(programClass, atLeast(1)).getString(eq(0));
  }
}
