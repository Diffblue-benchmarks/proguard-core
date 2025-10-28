package proguard.classfile.instruction.visitor;

import static org.junit.Assert.assertThrows;
import org.junit.Test;
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
   * Method under test:
   * {@link InstructionVisitor#visitAnyInstruction(Clazz, Method, CodeAttribute, int, Instruction)}
   */
  @Test
  public void testVisitAnyInstruction() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> maxStackSizeComputer.visitAnyInstruction(clazz, method,
        codeAttribute, 2, new BranchInstruction((byte) 'A', 1)));
  }
}
