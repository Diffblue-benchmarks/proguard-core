package proguard.evaluation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.ProgramClass;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.constant.AnyMethodrefConstant;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.InterfaceMethodrefConstant;
import proguard.classfile.instruction.ConstantInstruction;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.IdentifiedReferenceValue;
import proguard.evaluation.value.UnknownReferenceValue;
import proguard.evaluation.value.Value;
import proguard.evaluation.value.ValueFactory;

class SimplifiedInvocationUnitDiffblueTest {
  /**
   * Test {@link SimplifiedInvocationUnit#enterExceptionHandler(Clazz, Method, CodeAttribute, int,
   * int, Stack)}.
   *
   * <p>Method under test: {@link SimplifiedInvocationUnit#enterExceptionHandler(Clazz, Method,
   * CodeAttribute, int, int, Stack)}
   */
  @Test
  @DisplayName("Test enterExceptionHandler(Clazz, Method, CodeAttribute, int, int, Stack)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.SimplifiedInvocationUnit.enterExceptionHandler(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, int, proguard.evaluation.Stack)"
  })
  void testEnterExceptionHandler() {
    // Arrange
    ValueFactory valueFactory = mock(ValueFactory.class);
    when(valueFactory.createReferenceValue(
            Mockito.<String>any(), Mockito.<Clazz>any(), anyBoolean(), anyBoolean()))
        .thenReturn(BasicValueFactory.REFERENCE_VALUE);
    BasicInvocationUnit basicInvocationUnit = new BasicInvocationUnit(valueFactory);
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant(1, new LibraryClass()));
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    Stack stack = new Stack(3);

    // Act
    basicInvocationUnit.enterExceptionHandler(clazz, method, codeAttribute, 2, 1, stack);

    // Assert
    verify(clazz).getConstant(eq(1));
    verify(clazz).getString(eq(1));
    verify(valueFactory)
        .createReferenceValue(eq("LString;"), isA(Clazz.class), eq(true), eq(false));
    Value[] valueArray = stack.values;
    Value value = valueArray[0];
    assertTrue(value instanceof UnknownReferenceValue);
    assertEquals("Ljava/lang/Object;", ((UnknownReferenceValue) value).getType());
    assertNull(((UnknownReferenceValue) value).getReferencedClass());
    assertEquals(0, ((UnknownReferenceValue) value).isNotNull());
    assertEquals(0, ((UnknownReferenceValue) value).isNull());
    assertEquals(3, valueArray.length);
    assertFalse(value.isParticular());
    assertFalse(value.isSpecific());
  }

  /**
   * Test {@link SimplifiedInvocationUnit#enterExceptionHandler(Clazz, Method, CodeAttribute, int,
   * int, Stack)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ProgramClass} {@link ProgramClass#getConstant(int)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SimplifiedInvocationUnit#enterExceptionHandler(Clazz, Method,
   * CodeAttribute, int, int, Stack)}
   */
  @Test
  @DisplayName(
      "Test enterExceptionHandler(Clazz, Method, CodeAttribute, int, int, Stack); given 'null'; when ProgramClass getConstant(int) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.SimplifiedInvocationUnit.enterExceptionHandler(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, int, proguard.evaluation.Stack)"
  })
  void testEnterExceptionHandler_givenNull_whenProgramClassGetConstantReturnNull() {
    // Arrange
    ValueFactory valueFactory = mock(ValueFactory.class);
    when(valueFactory.createReferenceValue(
            Mockito.<String>any(), Mockito.<Clazz>any(), anyBoolean(), anyBoolean()))
        .thenReturn(BasicValueFactory.REFERENCE_VALUE);
    BasicInvocationUnit basicInvocationUnit = new BasicInvocationUnit(valueFactory);
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(null);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    Stack stack = new Stack(3);

    // Act
    basicInvocationUnit.enterExceptionHandler(clazz, method, codeAttribute, 2, 1, stack);

    // Assert
    verify(clazz).getConstant(eq(1));
    verify(valueFactory)
        .createReferenceValue(eq("Ljava/lang/Throwable;"), (Clazz) isNull(), eq(true), eq(false));
    Value[] valueArray = stack.values;
    Value value = valueArray[0];
    assertTrue(value instanceof UnknownReferenceValue);
    assertEquals("Ljava/lang/Object;", ((UnknownReferenceValue) value).getType());
    assertNull(((UnknownReferenceValue) value).getReferencedClass());
    assertEquals(0, ((UnknownReferenceValue) value).isNotNull());
    assertEquals(0, ((UnknownReferenceValue) value).isNull());
    assertEquals(3, valueArray.length);
    assertFalse(value.isParticular());
    assertFalse(value.isSpecific());
  }

  /**
   * Test {@link SimplifiedInvocationUnit#enterExceptionHandler(Clazz, Method, CodeAttribute, int,
   * int, Stack)}.
   *
   * <ul>
   *   <li>Then first element {@link IdentifiedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link SimplifiedInvocationUnit#enterExceptionHandler(Clazz, Method,
   * CodeAttribute, int, int, Stack)}
   */
  @Test
  @DisplayName(
      "Test enterExceptionHandler(Clazz, Method, CodeAttribute, int, int, Stack); then first element IdentifiedReferenceValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.SimplifiedInvocationUnit.enterExceptionHandler(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, int, proguard.evaluation.Stack)"
  })
  void testEnterExceptionHandler_thenFirstElementIdentifiedReferenceValue() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit =
        new BasicInvocationUnit(new ParticularReferenceValueFactory());
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    Stack stack = new Stack(3);

    // Act
    basicInvocationUnit.enterExceptionHandler(clazz, method, codeAttribute, 2, 1, stack);

    // Assert
    verify(clazz).getConstant(eq(1));
    verify(clazz).getString(eq(0));
    Value[] valueArray = stack.values;
    Value value = valueArray[0];
    assertTrue(value instanceof IdentifiedReferenceValue);
    assertEquals("LString;", ((IdentifiedReferenceValue) value).getType());
    assertNull(((IdentifiedReferenceValue) value).getReferencedClass());
    assertEquals(1, ((IdentifiedReferenceValue) value).isNotNull());
    assertEquals(3, valueArray.length);
    assertFalse(value.isParticular());
    assertTrue(((IdentifiedReferenceValue) value).mayBeExtension());
    assertTrue(value.isSpecific());
    assertEquals(InitializationFinder.NONE, ((IdentifiedReferenceValue) value).isNull());
  }

  /**
   * Test {@link SimplifiedInvocationUnit#enterExceptionHandler(Clazz, Method, CodeAttribute, int,
   * int, Stack)}.
   *
   * <ul>
   *   <li>When {@link Stack} {@link Stack#push(Value)} does nothing.
   *   <li>Then calls {@link ClassConstant#getName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link SimplifiedInvocationUnit#enterExceptionHandler(Clazz, Method,
   * CodeAttribute, int, int, Stack)}
   */
  @Test
  @DisplayName(
      "Test enterExceptionHandler(Clazz, Method, CodeAttribute, int, int, Stack); when Stack push(Value) does nothing; then calls getName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.SimplifiedInvocationUnit.enterExceptionHandler(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, int, proguard.evaluation.Stack)"
  })
  void testEnterExceptionHandler_whenStackPushDoesNothing_thenCallsGetName() {
    // Arrange
    ValueFactory valueFactory = mock(ValueFactory.class);
    when(valueFactory.createReferenceValue(
            Mockito.<String>any(), Mockito.<Clazz>any(), anyBoolean(), anyBoolean()))
        .thenReturn(BasicValueFactory.REFERENCE_VALUE);
    BasicInvocationUnit basicInvocationUnit = new BasicInvocationUnit(valueFactory);
    ClassConstant classConstant = mock(ClassConstant.class);
    when(classConstant.getName(Mockito.<Clazz>any())).thenReturn("Name");
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(classConstant);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    Stack stack = mock(Stack.class);
    doNothing().when(stack).push(Mockito.<Value>any());

    // Act
    basicInvocationUnit.enterExceptionHandler(clazz, method, codeAttribute, 2, 1, stack);

    // Assert
    verify(clazz).getConstant(eq(1));
    verify(classConstant).getName(isA(Clazz.class));
    verify(stack).push(isA(Value.class));
    verify(valueFactory).createReferenceValue(eq("LName;"), (Clazz) isNull(), eq(true), eq(false));
  }

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
  @DisplayName(
      "Test invokeMember(Clazz, Method, CodeAttribute, int, ConstantInstruction, Stack, Variables); given minus seventy-eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.SimplifiedInvocationUnit.invokeMember(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.ConstantInstruction, proguard.evaluation.Stack, proguard.evaluation.Variables)"
  })
  void testInvokeMember_givenMinusSeventyEight() {
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
  @DisplayName(
      "Test invokeMember(Clazz, Method, CodeAttribute, int, ConstantInstruction, Stack, Variables); given minus seventy-five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.SimplifiedInvocationUnit.invokeMember(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.ConstantInstruction, proguard.evaluation.Stack, proguard.evaluation.Variables)"
  })
  void testInvokeMember_givenMinusSeventyFive() {
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
  @DisplayName(
      "Test invokeMember(Clazz, Method, CodeAttribute, int, ConstantInstruction, Stack, Variables); given minus seventy-four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.SimplifiedInvocationUnit.invokeMember(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.ConstantInstruction, proguard.evaluation.Stack, proguard.evaluation.Variables)"
  })
  void testInvokeMember_givenMinusSeventyFour() {
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
  @DisplayName(
      "Test invokeMember(Clazz, Method, CodeAttribute, int, ConstantInstruction, Stack, Variables); given minus seventy-seven")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.SimplifiedInvocationUnit.invokeMember(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.ConstantInstruction, proguard.evaluation.Stack, proguard.evaluation.Variables)"
  })
  void testInvokeMember_givenMinusSeventySeven() {
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
  @DisplayName(
      "Test invokeMember(Clazz, Method, CodeAttribute, int, ConstantInstruction, Stack, Variables); given minus seventy-six")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.SimplifiedInvocationUnit.invokeMember(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.ConstantInstruction, proguard.evaluation.Stack, proguard.evaluation.Variables)"
  })
  void testInvokeMember_givenMinusSeventySix() {
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
  @DisplayName(
      "Test invokeMember(Clazz, Method, CodeAttribute, int, ConstantInstruction, Stack, Variables); given minus seventy-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.SimplifiedInvocationUnit.invokeMember(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.ConstantInstruction, proguard.evaluation.Stack, proguard.evaluation.Variables)"
  })
  void testInvokeMember_givenMinusSeventyTwo() {
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
  @DisplayName(
      "Test invokeMember(Clazz, Method, CodeAttribute, int, ConstantInstruction, Stack, Variables); when ConstantInstruction(byte, int) with opcode is 'A' and constantIndex is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.SimplifiedInvocationUnit.invokeMember(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.ConstantInstruction, proguard.evaluation.Stack, proguard.evaluation.Variables)"
  })
  void testInvokeMember_whenConstantInstructionWithOpcodeIsAAndConstantIndexIsOne() {
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
  @DisplayName("Test methodMayHaveSideEffects(Clazz, AnyMethodrefConstant, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.SimplifiedInvocationUnit.methodMayHaveSideEffects(proguard.classfile.Clazz, proguard.classfile.constant.AnyMethodrefConstant, java.lang.String)"
  })
  void testMethodMayHaveSideEffects() {
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
