package proguard.classfile.instruction.visitor;

import static org.junit.Assert.assertThrows;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.visitor.MaxStackSizeComputer;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.instruction.Instruction;

public class InstructionVisitorDiffblueTest {
  /**
   * Test {@link InstructionVisitor#visitAnyInstruction(Clazz, Method, CodeAttribute, int,
   * Instruction)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionVisitor#visitAnyInstruction(Clazz, Method,
   * CodeAttribute, int, Instruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void InstructionVisitor.visitAnyInstruction(Clazz, Method, CodeAttribute, int, Instruction)"
  })
  public void testVisitAnyInstruction_thenThrowUnsupportedOperationException() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            maxStackSizeComputer.visitAnyInstruction(
                clazz, method, codeAttribute, 2, new BranchInstruction((byte) 'A', 1)));
  }
}
