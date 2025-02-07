package proguard.classfile.instruction.visitor;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
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
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.instruction.LookUpSwitchInstruction;
import proguard.classfile.instruction.TableSwitchInstruction;

class MultiInstructionVisitorDiffblueTest {
  /**
   * Test {@link MultiInstructionVisitor#visitBranchInstruction(Clazz, Method, CodeAttribute, int,
   * BranchInstruction)}.
   *
   * <ul>
   *   <li>Then calls {@link InstructionVisitor#visitBranchInstruction(Clazz, Method, CodeAttribute,
   *       int, BranchInstruction)}.
   * </ul>
   *
   * <p>Method under test: {@link MultiInstructionVisitor#visitBranchInstruction(Clazz, Method,
   * CodeAttribute, int, BranchInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction); then calls visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.instruction.visitor.MultiInstructionVisitor.visitBranchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.BranchInstruction)"
  })
  void testVisitBranchInstruction_thenCallsVisitBranchInstruction() {
    // Arrange
    InstructionConstantVisitor instructionConstantVisitor = mock(InstructionConstantVisitor.class);
    doNothing()
        .when(instructionConstantVisitor)
        .visitBranchInstruction(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            anyInt(),
            Mockito.<BranchInstruction>any());
    MultiInstructionVisitor multiInstructionVisitor =
        new MultiInstructionVisitor(instructionConstantVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    multiInstructionVisitor.visitBranchInstruction(
        clazz, method, codeAttribute, 2, new BranchInstruction((byte) 'A', 1));

    // Assert
    verify(instructionConstantVisitor)
        .visitBranchInstruction(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            eq(2),
            isA(BranchInstruction.class));
  }

  /**
   * Test {@link MultiInstructionVisitor#visitTableSwitchInstruction(Clazz, Method, CodeAttribute,
   * int, TableSwitchInstruction)}.
   *
   * <ul>
   *   <li>Then calls {@link InstructionVisitor#visitTableSwitchInstruction(Clazz, Method,
   *       CodeAttribute, int, TableSwitchInstruction)}.
   * </ul>
   *
   * <p>Method under test: {@link MultiInstructionVisitor#visitTableSwitchInstruction(Clazz, Method,
   * CodeAttribute, int, TableSwitchInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitTableSwitchInstruction(Clazz, Method, CodeAttribute, int, TableSwitchInstruction); then calls visitTableSwitchInstruction(Clazz, Method, CodeAttribute, int, TableSwitchInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.instruction.visitor.MultiInstructionVisitor.visitTableSwitchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.TableSwitchInstruction)"
  })
  void testVisitTableSwitchInstruction_thenCallsVisitTableSwitchInstruction() {
    // Arrange
    InstructionConstantVisitor instructionConstantVisitor = mock(InstructionConstantVisitor.class);
    doNothing()
        .when(instructionConstantVisitor)
        .visitTableSwitchInstruction(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            anyInt(),
            Mockito.<TableSwitchInstruction>any());
    MultiInstructionVisitor multiInstructionVisitor =
        new MultiInstructionVisitor(instructionConstantVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    multiInstructionVisitor.visitTableSwitchInstruction(
        clazz, method, codeAttribute, 2, new TableSwitchInstruction());

    // Assert
    verify(instructionConstantVisitor)
        .visitTableSwitchInstruction(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            eq(2),
            isA(TableSwitchInstruction.class));
  }

  /**
   * Test {@link MultiInstructionVisitor#visitLookUpSwitchInstruction(Clazz, Method, CodeAttribute,
   * int, LookUpSwitchInstruction)}.
   *
   * <ul>
   *   <li>Then calls {@link InstructionVisitor#visitLookUpSwitchInstruction(Clazz, Method,
   *       CodeAttribute, int, LookUpSwitchInstruction)}.
   * </ul>
   *
   * <p>Method under test: {@link MultiInstructionVisitor#visitLookUpSwitchInstruction(Clazz,
   * Method, CodeAttribute, int, LookUpSwitchInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitLookUpSwitchInstruction(Clazz, Method, CodeAttribute, int, LookUpSwitchInstruction); then calls visitLookUpSwitchInstruction(Clazz, Method, CodeAttribute, int, LookUpSwitchInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.instruction.visitor.MultiInstructionVisitor.visitLookUpSwitchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.LookUpSwitchInstruction)"
  })
  void testVisitLookUpSwitchInstruction_thenCallsVisitLookUpSwitchInstruction() {
    // Arrange
    InstructionConstantVisitor instructionConstantVisitor = mock(InstructionConstantVisitor.class);
    doNothing()
        .when(instructionConstantVisitor)
        .visitLookUpSwitchInstruction(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            anyInt(),
            Mockito.<LookUpSwitchInstruction>any());
    MultiInstructionVisitor multiInstructionVisitor =
        new MultiInstructionVisitor(instructionConstantVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    multiInstructionVisitor.visitLookUpSwitchInstruction(
        clazz, method, codeAttribute, 2, new LookUpSwitchInstruction());

    // Assert
    verify(instructionConstantVisitor)
        .visitLookUpSwitchInstruction(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            eq(2),
            isA(LookUpSwitchInstruction.class));
  }
}
