package proguard.evaluation;

import static org.junit.Assert.assertThrows;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.instruction.ConstantInstruction;
import proguard.classfile.instruction.SimpleInstruction;
import proguard.classfile.instruction.VariableInstruction;

public class ProcessorDiffblueTest {
  /**
   * Method under test:
   * {@link Processor#visitSimpleInstruction(Clazz, Method, CodeAttribute, int, SimpleInstruction)}
   */
  @Test
  public void testVisitSimpleInstruction() {
    // Arrange
    Variables variables = new Variables(3);
    Stack stack = new Stack(3);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    BasicBranchUnit branchUnit = new BasicBranchUnit();
    Processor processor = new Processor(variables, stack, valueFactory, branchUnit,
        new BasicInvocationUnit(new ParticularReferenceValueFactory()), true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> processor.visitSimpleInstruction(clazz, method, codeAttribute, 2, new SimpleInstruction((byte) 'A')));
  }

  /**
   * Method under test:
   * {@link Processor#visitConstantInstruction(Clazz, Method, CodeAttribute, int, ConstantInstruction)}
   */
  @Test
  public void testVisitConstantInstruction() {
    // Arrange
    Variables variables = new Variables(3);
    Stack stack = new Stack(3);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    BasicBranchUnit branchUnit = new BasicBranchUnit();
    Processor processor = new Processor(variables, stack, valueFactory, branchUnit,
        new BasicInvocationUnit(new ParticularReferenceValueFactory()), true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> processor.visitConstantInstruction(clazz, method, codeAttribute,
        2, new ConstantInstruction((byte) 'A', 1)));
  }

  /**
   * Method under test:
   * {@link Processor#visitVariableInstruction(Clazz, Method, CodeAttribute, int, VariableInstruction)}
   */
  @Test
  public void testVisitVariableInstruction() {
    // Arrange
    Variables variables = new Variables(3);
    Stack stack = new Stack(3);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    BasicBranchUnit branchUnit = new BasicBranchUnit();
    Processor processor = new Processor(variables, stack, valueFactory, branchUnit,
        new BasicInvocationUnit(new ParticularReferenceValueFactory()), true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = (byte) -123;
    variableInstruction.variableIndex = 0;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> processor.visitVariableInstruction(clazz, method, codeAttribute, 2, variableInstruction));
  }
}
