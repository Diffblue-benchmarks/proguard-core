package proguard.classfile.instruction.visitor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.instruction.Instruction;

class InstructionCounterDiffblueTest {
  /**
   * Test {@link InstructionCounter#visitAnyInstruction(Clazz, Method, CodeAttribute, int,
   * Instruction)}.
   *
   * <p>Method under test: {@link InstructionCounter#visitAnyInstruction(Clazz, Method,
   * CodeAttribute, int, Instruction)}
   */
  @Test
  @DisplayName("Test visitAnyInstruction(Clazz, Method, CodeAttribute, int, Instruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.instruction.visitor.InstructionCounter.visitAnyInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.Instruction)"
  })
  void testVisitAnyInstruction() {
    // Arrange
    InstructionCounter instructionCounter = new InstructionCounter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    instructionCounter.visitAnyInstruction(
        clazz, method, codeAttribute, 2, new BranchInstruction((byte) 'A', 1));

    // Assert
    assertEquals(1, instructionCounter.getCount());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link InstructionCounter}
   *   <li>{@link InstructionCounter#getCount()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.instruction.visitor.InstructionCounter.<init>()",
    "int proguard.classfile.instruction.visitor.InstructionCounter.getCount()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(0, (new InstructionCounter()).getCount());
  }
}
