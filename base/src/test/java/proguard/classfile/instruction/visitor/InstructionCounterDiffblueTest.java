package proguard.classfile.instruction.visitor;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.instruction.Instruction;

public class InstructionCounterDiffblueTest {
  /**
   * Test {@link InstructionCounter#visitAnyInstruction(Clazz, Method, CodeAttribute, int,
   * Instruction)}.
   *
   * <p>Method under test: {@link InstructionCounter#visitAnyInstruction(Clazz, Method,
   * CodeAttribute, int, Instruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void InstructionCounter.visitAnyInstruction(Clazz, Method, CodeAttribute, int, Instruction)"
  })
  public void testVisitAnyInstruction() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InstructionCounter.<init>()", "int InstructionCounter.getCount()"})
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(0, (new InstructionCounter()).getCount());
  }
}
