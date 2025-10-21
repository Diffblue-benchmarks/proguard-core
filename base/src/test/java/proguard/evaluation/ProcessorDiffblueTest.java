package proguard.evaluation;

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
import proguard.classfile.instruction.ConstantInstruction;
import proguard.classfile.instruction.SimpleInstruction;
import proguard.classfile.instruction.VariableInstruction;

public class ProcessorDiffblueTest {
  /**
   * Test {@link Processor#visitSimpleInstruction(Clazz, Method, CodeAttribute, int,
   * SimpleInstruction)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Processor#visitSimpleInstruction(Clazz, Method, CodeAttribute,
   * int, SimpleInstruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void Processor.visitSimpleInstruction(Clazz, Method, CodeAttribute, int, SimpleInstruction)"
  })
  public void testVisitSimpleInstruction_thenThrowIllegalArgumentException() {
    // Arrange
    Variables variables = new Variables(3);
    Stack stack = new Stack(3);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    BasicBranchUnit branchUnit = new BasicBranchUnit();
    Processor processor =
        new Processor(
            variables,
            stack,
            valueFactory,
            branchUnit,
            new BasicInvocationUnit(new ParticularReferenceValueFactory()),
            true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            processor.visitSimpleInstruction(
                clazz, method, codeAttribute, 2, new SimpleInstruction((byte) 'A')));
  }

  /**
   * Test {@link Processor#visitConstantInstruction(Clazz, Method, CodeAttribute, int,
   * ConstantInstruction)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Processor#visitConstantInstruction(Clazz, Method, CodeAttribute,
   * int, ConstantInstruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void Processor.visitConstantInstruction(Clazz, Method, CodeAttribute, int, ConstantInstruction)"
  })
  public void testVisitConstantInstruction_thenThrowIllegalArgumentException() {
    // Arrange
    Variables variables = new Variables(3);
    Stack stack = new Stack(3);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    BasicBranchUnit branchUnit = new BasicBranchUnit();
    Processor processor =
        new Processor(
            variables,
            stack,
            valueFactory,
            branchUnit,
            new BasicInvocationUnit(new ParticularReferenceValueFactory()),
            true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            processor.visitConstantInstruction(
                clazz, method, codeAttribute, 2, new ConstantInstruction((byte) 'A', 1)));
  }

  /**
   * Test {@link Processor#visitVariableInstruction(Clazz, Method, CodeAttribute, int,
   * VariableInstruction)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Processor#visitVariableInstruction(Clazz, Method, CodeAttribute,
   * int, VariableInstruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void Processor.visitVariableInstruction(Clazz, Method, CodeAttribute, int, VariableInstruction)"
  })
  public void testVisitVariableInstruction_thenThrowIllegalArgumentException() {
    // Arrange
    Variables variables = new Variables(3);
    Stack stack = new Stack(3);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    BasicBranchUnit branchUnit = new BasicBranchUnit();
    Processor processor =
        new Processor(
            variables,
            stack,
            valueFactory,
            branchUnit,
            new BasicInvocationUnit(new ParticularReferenceValueFactory()),
            true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    variableInstruction.opcode = (byte) -123;
    variableInstruction.variableIndex = 0;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            processor.visitVariableInstruction(
                clazz, method, codeAttribute, 2, variableInstruction));
  }
}
