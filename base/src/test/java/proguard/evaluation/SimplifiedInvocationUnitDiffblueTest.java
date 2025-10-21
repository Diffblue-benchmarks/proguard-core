package proguard.evaluation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.constant.AnyMethodrefConstant;
import proguard.classfile.constant.InterfaceMethodrefConstant;
import proguard.classfile.instruction.ConstantInstruction;

public class SimplifiedInvocationUnitDiffblueTest {
  /**
   * Test {@link SimplifiedInvocationUnit#invokeMember(Clazz, Method, CodeAttribute, int,
   * ConstantInstruction, Stack, Variables)}.
   *
   * <ul>
   *   <li>Given minus seventy-eight.
   * </ul>
   *
   * <p>Method under test: {@link SimplifiedInvocationUnit#invokeMember(Clazz, Method,
   * CodeAttribute, int, ConstantInstruction, Stack, Variables)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void SimplifiedInvocationUnit.invokeMember(Clazz, Method, CodeAttribute, int, ConstantInstruction, Stack, Variables)"
  })
  public void testInvokeMember_givenMinusSeventyEight() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit =
        new BasicInvocationUnit(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    constantInstruction.opcode = (byte) -78;
    Stack stack = new Stack(3);

    // Act
    basicInvocationUnit.invokeMember(
        clazz, method, codeAttribute, 2, constantInstruction, stack, new Variables(3));

    // Assert
    assertTrue(basicInvocationUnit.isLoad);
    assertTrue(basicInvocationUnit.isStatic);
  }

  /**
   * Test {@link SimplifiedInvocationUnit#invokeMember(Clazz, Method, CodeAttribute, int,
   * ConstantInstruction, Stack, Variables)}.
   *
   * <ul>
   *   <li>Given minus seventy-five.
   * </ul>
   *
   * <p>Method under test: {@link SimplifiedInvocationUnit#invokeMember(Clazz, Method,
   * CodeAttribute, int, ConstantInstruction, Stack, Variables)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void SimplifiedInvocationUnit.invokeMember(Clazz, Method, CodeAttribute, int, ConstantInstruction, Stack, Variables)"
  })
  public void testInvokeMember_givenMinusSeventyFive() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit =
        new BasicInvocationUnit(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    constantInstruction.opcode = (byte) -75;
    Stack stack = new Stack(3);

    // Act
    basicInvocationUnit.invokeMember(
        clazz, method, codeAttribute, 2, constantInstruction, stack, new Variables(3));

    // Assert that nothing has changed
    assertFalse(basicInvocationUnit.isLoad);
    assertFalse(basicInvocationUnit.isStatic);
  }

  /**
   * Test {@link SimplifiedInvocationUnit#invokeMember(Clazz, Method, CodeAttribute, int,
   * ConstantInstruction, Stack, Variables)}.
   *
   * <ul>
   *   <li>Given minus seventy-four.
   * </ul>
   *
   * <p>Method under test: {@link SimplifiedInvocationUnit#invokeMember(Clazz, Method,
   * CodeAttribute, int, ConstantInstruction, Stack, Variables)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void SimplifiedInvocationUnit.invokeMember(Clazz, Method, CodeAttribute, int, ConstantInstruction, Stack, Variables)"
  })
  public void testInvokeMember_givenMinusSeventyFour() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit =
        new BasicInvocationUnit(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    constantInstruction.opcode = (byte) -74;
    Stack stack = new Stack(3);

    // Act
    basicInvocationUnit.invokeMember(
        clazz, method, codeAttribute, 2, constantInstruction, stack, new Variables(3));

    // Assert that nothing has changed
    assertFalse(basicInvocationUnit.isLoad);
    assertFalse(basicInvocationUnit.isStatic);
  }

  /**
   * Test {@link SimplifiedInvocationUnit#invokeMember(Clazz, Method, CodeAttribute, int,
   * ConstantInstruction, Stack, Variables)}.
   *
   * <ul>
   *   <li>Given minus seventy-seven.
   * </ul>
   *
   * <p>Method under test: {@link SimplifiedInvocationUnit#invokeMember(Clazz, Method,
   * CodeAttribute, int, ConstantInstruction, Stack, Variables)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void SimplifiedInvocationUnit.invokeMember(Clazz, Method, CodeAttribute, int, ConstantInstruction, Stack, Variables)"
  })
  public void testInvokeMember_givenMinusSeventySeven() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit =
        new BasicInvocationUnit(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    constantInstruction.opcode = (byte) -77;
    Stack stack = new Stack(3);

    // Act
    basicInvocationUnit.invokeMember(
        clazz, method, codeAttribute, 2, constantInstruction, stack, new Variables(3));

    // Assert
    assertFalse(basicInvocationUnit.isLoad);
    assertTrue(basicInvocationUnit.isStatic);
  }

  /**
   * Test {@link SimplifiedInvocationUnit#invokeMember(Clazz, Method, CodeAttribute, int,
   * ConstantInstruction, Stack, Variables)}.
   *
   * <ul>
   *   <li>Given minus seventy-six.
   * </ul>
   *
   * <p>Method under test: {@link SimplifiedInvocationUnit#invokeMember(Clazz, Method,
   * CodeAttribute, int, ConstantInstruction, Stack, Variables)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void SimplifiedInvocationUnit.invokeMember(Clazz, Method, CodeAttribute, int, ConstantInstruction, Stack, Variables)"
  })
  public void testInvokeMember_givenMinusSeventySix() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit =
        new BasicInvocationUnit(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    constantInstruction.opcode = (byte) -76;
    Stack stack = new Stack(3);

    // Act
    basicInvocationUnit.invokeMember(
        clazz, method, codeAttribute, 2, constantInstruction, stack, new Variables(3));

    // Assert
    assertFalse(basicInvocationUnit.isStatic);
    assertTrue(basicInvocationUnit.isLoad);
  }

  /**
   * Test {@link SimplifiedInvocationUnit#invokeMember(Clazz, Method, CodeAttribute, int,
   * ConstantInstruction, Stack, Variables)}.
   *
   * <ul>
   *   <li>Given minus seventy-two.
   * </ul>
   *
   * <p>Method under test: {@link SimplifiedInvocationUnit#invokeMember(Clazz, Method,
   * CodeAttribute, int, ConstantInstruction, Stack, Variables)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void SimplifiedInvocationUnit.invokeMember(Clazz, Method, CodeAttribute, int, ConstantInstruction, Stack, Variables)"
  })
  public void testInvokeMember_givenMinusSeventyTwo() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit =
        new BasicInvocationUnit(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    constantInstruction.opcode = (byte) -72;
    Stack stack = new Stack(3);

    // Act
    basicInvocationUnit.invokeMember(
        clazz, method, codeAttribute, 2, constantInstruction, stack, new Variables(3));

    // Assert
    assertFalse(basicInvocationUnit.isLoad);
    assertTrue(basicInvocationUnit.isStatic);
  }

  /**
   * Test {@link SimplifiedInvocationUnit#invokeMember(Clazz, Method, CodeAttribute, int,
   * ConstantInstruction, Stack, Variables)}.
   *
   * <ul>
   *   <li>When {@link ConstantInstruction#ConstantInstruction(byte, int)} with opcode is {@code A}
   *       and constantIndex is one.
   * </ul>
   *
   * <p>Method under test: {@link SimplifiedInvocationUnit#invokeMember(Clazz, Method,
   * CodeAttribute, int, ConstantInstruction, Stack, Variables)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void SimplifiedInvocationUnit.invokeMember(Clazz, Method, CodeAttribute, int, ConstantInstruction, Stack, Variables)"
  })
  public void testInvokeMember_whenConstantInstructionWithOpcodeIsAAndConstantIndexIsOne() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit =
        new BasicInvocationUnit(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    Stack stack = new Stack(3);

    // Act
    basicInvocationUnit.invokeMember(
        clazz, method, codeAttribute, 2, constantInstruction, stack, new Variables(3));

    // Assert that nothing has changed
    assertFalse(basicInvocationUnit.isLoad);
    assertFalse(basicInvocationUnit.isStatic);
  }

  /**
   * Test {@link SimplifiedInvocationUnit#methodMayHaveSideEffects(Clazz, AnyMethodrefConstant,
   * String)}.
   *
   * <p>Method under test: {@link SimplifiedInvocationUnit#methodMayHaveSideEffects(Clazz,
   * AnyMethodrefConstant, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean SimplifiedInvocationUnit.methodMayHaveSideEffects(Clazz, AnyMethodrefConstant, String)"
  })
  public void testMethodMayHaveSideEffects() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit =
        new BasicInvocationUnit(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertFalse(
        basicInvocationUnit.methodMayHaveSideEffects(
            clazz, new InterfaceMethodrefConstant(), "Return Type"));
  }
}
