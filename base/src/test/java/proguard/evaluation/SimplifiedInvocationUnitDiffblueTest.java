package proguard.evaluation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
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
   * Method under test:
   * {@link SimplifiedInvocationUnit#invokeMember(Clazz, Method, CodeAttribute, int, ConstantInstruction, Stack, Variables)}
   */
  @Test
  public void testInvokeMember() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit = new BasicInvocationUnit(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    Stack stack = new Stack(3);

    // Act
    basicInvocationUnit.invokeMember(clazz, method, codeAttribute, 2, constantInstruction, stack, new Variables(3));

    // Assert
    assertFalse(basicInvocationUnit.isLoad);
    assertFalse(basicInvocationUnit.isStatic);
  }

  /**
   * Method under test:
   * {@link SimplifiedInvocationUnit#invokeMember(Clazz, Method, CodeAttribute, int, ConstantInstruction, Stack, Variables)}
   */
  @Test
  public void testInvokeMember2() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit = new BasicInvocationUnit(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    constantInstruction.opcode = (byte) -78;
    Stack stack = new Stack(3);

    // Act
    basicInvocationUnit.invokeMember(clazz, method, codeAttribute, 2, constantInstruction, stack, new Variables(3));

    // Assert
    assertTrue(basicInvocationUnit.isLoad);
    assertTrue(basicInvocationUnit.isStatic);
  }

  /**
   * Method under test:
   * {@link SimplifiedInvocationUnit#invokeMember(Clazz, Method, CodeAttribute, int, ConstantInstruction, Stack, Variables)}
   */
  @Test
  public void testInvokeMember3() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit = new BasicInvocationUnit(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    constantInstruction.opcode = (byte) -77;
    Stack stack = new Stack(3);

    // Act
    basicInvocationUnit.invokeMember(clazz, method, codeAttribute, 2, constantInstruction, stack, new Variables(3));

    // Assert
    assertFalse(basicInvocationUnit.isLoad);
    assertTrue(basicInvocationUnit.isStatic);
  }

  /**
   * Method under test:
   * {@link SimplifiedInvocationUnit#invokeMember(Clazz, Method, CodeAttribute, int, ConstantInstruction, Stack, Variables)}
   */
  @Test
  public void testInvokeMember4() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit = new BasicInvocationUnit(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    constantInstruction.opcode = (byte) -76;
    Stack stack = new Stack(3);

    // Act
    basicInvocationUnit.invokeMember(clazz, method, codeAttribute, 2, constantInstruction, stack, new Variables(3));

    // Assert
    assertFalse(basicInvocationUnit.isStatic);
    assertTrue(basicInvocationUnit.isLoad);
  }

  /**
   * Method under test:
   * {@link SimplifiedInvocationUnit#invokeMember(Clazz, Method, CodeAttribute, int, ConstantInstruction, Stack, Variables)}
   */
  @Test
  public void testInvokeMember5() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit = new BasicInvocationUnit(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    constantInstruction.opcode = (byte) -75;
    Stack stack = new Stack(3);

    // Act
    basicInvocationUnit.invokeMember(clazz, method, codeAttribute, 2, constantInstruction, stack, new Variables(3));

    // Assert
    assertFalse(basicInvocationUnit.isLoad);
    assertFalse(basicInvocationUnit.isStatic);
  }

  /**
   * Method under test:
   * {@link SimplifiedInvocationUnit#invokeMember(Clazz, Method, CodeAttribute, int, ConstantInstruction, Stack, Variables)}
   */
  @Test
  public void testInvokeMember6() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit = new BasicInvocationUnit(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    constantInstruction.opcode = (byte) -74;
    Stack stack = new Stack(3);

    // Act
    basicInvocationUnit.invokeMember(clazz, method, codeAttribute, 2, constantInstruction, stack, new Variables(3));

    // Assert
    assertFalse(basicInvocationUnit.isLoad);
    assertFalse(basicInvocationUnit.isStatic);
  }

  /**
   * Method under test:
   * {@link SimplifiedInvocationUnit#invokeMember(Clazz, Method, CodeAttribute, int, ConstantInstruction, Stack, Variables)}
   */
  @Test
  public void testInvokeMember7() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit = new BasicInvocationUnit(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    constantInstruction.opcode = (byte) -72;
    Stack stack = new Stack(3);

    // Act
    basicInvocationUnit.invokeMember(clazz, method, codeAttribute, 2, constantInstruction, stack, new Variables(3));

    // Assert
    assertFalse(basicInvocationUnit.isLoad);
    assertTrue(basicInvocationUnit.isStatic);
  }

  /**
   * Method under test:
   * {@link SimplifiedInvocationUnit#methodMayHaveSideEffects(Clazz, AnyMethodrefConstant, String)}
   */
  @Test
  public void testMethodMayHaveSideEffects() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit = new BasicInvocationUnit(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertFalse(basicInvocationUnit.methodMayHaveSideEffects(clazz, new InterfaceMethodrefConstant(), "Return Type"));
  }
}
