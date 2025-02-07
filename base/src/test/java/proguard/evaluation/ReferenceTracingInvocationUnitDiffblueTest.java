package proguard.evaluation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
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
import java.util.ArrayList;
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
import proguard.classfile.constant.FieldrefConstant;
import proguard.classfile.constant.InterfaceMethodrefConstant;
import proguard.classfile.constant.InvokeDynamicConstant;
import proguard.classfile.instruction.ConstantInstruction;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.DoubleValue;
import proguard.evaluation.value.IdentifiedReferenceValue;
import proguard.evaluation.value.InstructionOffsetValue;
import proguard.evaluation.value.MultiTypedReferenceValue;
import proguard.evaluation.value.MultiTypedReferenceValueFactory;
import proguard.evaluation.value.PrimitiveTypedReferenceValueFactory;
import proguard.evaluation.value.ReferenceValue;
import proguard.evaluation.value.TopValue;
import proguard.evaluation.value.TracedReferenceValue;
import proguard.evaluation.value.UnknownDoubleValue;
import proguard.evaluation.value.UnknownReferenceValue;
import proguard.evaluation.value.Value;
import proguard.evaluation.value.ValueFactory;

class ReferenceTracingInvocationUnitDiffblueTest {
  /**
   * Test {@link
   * ReferenceTracingInvocationUnit#ReferenceTracingInvocationUnit(SimplifiedInvocationUnit)}.
   *
   * <p>Method under test: {@link
   * ReferenceTracingInvocationUnit#ReferenceTracingInvocationUnit(SimplifiedInvocationUnit)}
   */
  @Test
  @DisplayName("Test new ReferenceTracingInvocationUnit(SimplifiedInvocationUnit)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.ReferenceTracingInvocationUnit.<init>(proguard.evaluation.SimplifiedInvocationUnit)"
  })
  void testNewReferenceTracingInvocationUnit() {
    // Arrange and Act
    ReferenceTracingInvocationUnit actualReferenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new BasicInvocationUnit(new ParticularReferenceValueFactory()));

    // Assert
    assertNull(actualReferenceTracingInvocationUnit.method);
    assertNull(actualReferenceTracingInvocationUnit.stack);
    assertNull(actualReferenceTracingInvocationUnit.variables);
    assertFalse(actualReferenceTracingInvocationUnit.isLoad);
    assertFalse(actualReferenceTracingInvocationUnit.isStatic);
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#enterExceptionHandler(Clazz, Method, CodeAttribute,
   * int, int, Stack)}.
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#enterExceptionHandler(Clazz,
   * Method, CodeAttribute, int, int, Stack)}
   */
  @Test
  @DisplayName("Test enterExceptionHandler(Clazz, Method, CodeAttribute, int, int, Stack)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.ReferenceTracingInvocationUnit.enterExceptionHandler(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, int, proguard.evaluation.Stack)"
  })
  void testEnterExceptionHandler() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new ReferenceTracingInvocationUnit(
                new BasicInvocationUnit(new ParticularReferenceValueFactory())));
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    Stack stack = new Stack(3);

    // Act
    referenceTracingInvocationUnit.enterExceptionHandler(clazz, method, codeAttribute, 2, 1, stack);

    // Assert
    verify(clazz).getConstant(eq(1));
    verify(clazz).getString(eq(0));
    Value[] valueArray = stack.values;
    Value value = valueArray[0];
    ReferenceValue referenceValue = ((TracedReferenceValue) value).getReferenceValue();
    assertTrue(referenceValue instanceof IdentifiedReferenceValue);
    assertTrue(value instanceof TracedReferenceValue);
    assertEquals("LString;", referenceValue.getType());
    assertEquals("LString;", ((TracedReferenceValue) value).getType());
    assertNull(referenceValue.getReferencedClass());
    assertEquals(1, referenceValue.isNotNull());
    assertEquals(1, ((TracedReferenceValue) value).isNotNull());
    assertEquals(3, valueArray.length);
    assertFalse(referenceValue.isParticular());
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(referenceValue.isSpecific());
    assertTrue(value.isSpecific());
    assertEquals(InitializationFinder.NONE, referenceValue.isNull());
    assertEquals(InitializationFinder.NONE, ((TracedReferenceValue) value).isNull());
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#enterExceptionHandler(Clazz, Method, CodeAttribute,
   * int, int, Stack)}.
   *
   * <ul>
   *   <li>Then first element {@link InstructionOffsetValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#enterExceptionHandler(Clazz,
   * Method, CodeAttribute, int, int, Stack)}
   */
  @Test
  @DisplayName(
      "Test enterExceptionHandler(Clazz, Method, CodeAttribute, int, int, Stack); then first element InstructionOffsetValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.ReferenceTracingInvocationUnit.enterExceptionHandler(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, int, proguard.evaluation.Stack)"
  })
  void testEnterExceptionHandler_thenFirstElementInstructionOffsetValue() {
    // Arrange
    BasicInvocationUnit invocationUnit = mock(BasicInvocationUnit.class);
    when(invocationUnit.getExceptionValue(Mockito.<Clazz>any(), Mockito.<ClassConstant>any()))
        .thenReturn(InstructionOffsetValue.EMPTY_VALUE);
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(invocationUnit);
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    Stack stack = new Stack(3);

    // Act
    referenceTracingInvocationUnit.enterExceptionHandler(clazz, method, codeAttribute, 2, 1, stack);

    // Assert
    verify(clazz).getConstant(eq(1));
    verify(invocationUnit).getExceptionValue(isA(Clazz.class), isA(ClassConstant.class));
    Value[] valueArray = stack.values;
    Value value = valueArray[0];
    assertTrue(value instanceof InstructionOffsetValue);
    assertEquals(1, stack.getActualMaxSize());
    assertEquals(1, stack.size());
    assertEquals(3, valueArray.length);
    assertTrue(value.isParticular());
    assertTrue(value.isSpecific());
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#enterExceptionHandler(Clazz, Method, CodeAttribute,
   * int, int, Stack)}.
   *
   * <ul>
   *   <li>Then first element ReferenceValue {@link IdentifiedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#enterExceptionHandler(Clazz,
   * Method, CodeAttribute, int, int, Stack)}
   */
  @Test
  @DisplayName(
      "Test enterExceptionHandler(Clazz, Method, CodeAttribute, int, int, Stack); then first element ReferenceValue IdentifiedReferenceValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.ReferenceTracingInvocationUnit.enterExceptionHandler(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, int, proguard.evaluation.Stack)"
  })
  void testEnterExceptionHandler_thenFirstElementReferenceValueIdentifiedReferenceValue() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    Stack stack = new Stack(3);

    // Act
    referenceTracingInvocationUnit.enterExceptionHandler(clazz, method, codeAttribute, 2, 1, stack);

    // Assert
    verify(clazz).getConstant(eq(1));
    verify(clazz).getString(eq(0));
    Value[] valueArray = stack.values;
    Value value = valueArray[0];
    ReferenceValue referenceValue = ((TracedReferenceValue) value).getReferenceValue();
    assertTrue(referenceValue instanceof IdentifiedReferenceValue);
    assertTrue(value instanceof TracedReferenceValue);
    assertEquals("LString;", referenceValue.getType());
    assertEquals("LString;", ((TracedReferenceValue) value).getType());
    assertNull(referenceValue.getReferencedClass());
    assertEquals(1, referenceValue.isNotNull());
    assertEquals(1, ((TracedReferenceValue) value).isNotNull());
    assertEquals(3, valueArray.length);
    assertFalse(referenceValue.isParticular());
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(referenceValue.isSpecific());
    assertTrue(value.isSpecific());
    assertEquals(InitializationFinder.NONE, referenceValue.isNull());
    assertEquals(InitializationFinder.NONE, ((TracedReferenceValue) value).isNull());
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#enterExceptionHandler(Clazz, Method, CodeAttribute,
   * int, int, Stack)}.
   *
   * <ul>
   *   <li>Then first element ReferenceValue {@link UnknownReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#enterExceptionHandler(Clazz,
   * Method, CodeAttribute, int, int, Stack)}
   */
  @Test
  @DisplayName(
      "Test enterExceptionHandler(Clazz, Method, CodeAttribute, int, int, Stack); then first element ReferenceValue UnknownReferenceValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.ReferenceTracingInvocationUnit.enterExceptionHandler(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, int, proguard.evaluation.Stack)"
  })
  void testEnterExceptionHandler_thenFirstElementReferenceValueUnknownReferenceValue() {
    // Arrange
    ValueFactory valueFactory = mock(ValueFactory.class);
    when(valueFactory.createReferenceValue(
            Mockito.<String>any(), Mockito.<Clazz>any(), anyBoolean(), anyBoolean()))
        .thenReturn(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicValueFactory.DOUBLE_VALUE));
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(new BasicInvocationUnit(valueFactory));
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    Stack stack = new Stack(3);

    // Act
    referenceTracingInvocationUnit.enterExceptionHandler(clazz, method, codeAttribute, 2, 1, stack);

    // Assert
    verify(clazz).getConstant(eq(1));
    verify(clazz).getString(eq(0));
    verify(valueFactory)
        .createReferenceValue(eq("LString;"), (Clazz) isNull(), eq(true), eq(false));
    Value[] valueArray = stack.values;
    Value value = valueArray[0];
    assertTrue(value instanceof TracedReferenceValue);
    ReferenceValue referenceValue = ((TracedReferenceValue) value).getReferenceValue();
    assertTrue(referenceValue instanceof UnknownReferenceValue);
    assertEquals("Ljava/lang/Object;", referenceValue.getType());
    assertEquals("Ljava/lang/Object;", ((TracedReferenceValue) value).getType());
    assertNull(referenceValue.getReferencedClass());
    assertEquals(0, referenceValue.isNotNull());
    assertEquals(0, ((TracedReferenceValue) value).isNotNull());
    assertEquals(0, referenceValue.isNull());
    assertEquals(0, ((TracedReferenceValue) value).isNull());
    assertEquals(3, valueArray.length);
    assertFalse(referenceValue.isParticular());
    assertFalse(referenceValue.isSpecific());
    assertFalse(value.isSpecific());
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#enterExceptionHandler(Clazz, Method, CodeAttribute,
   * int, int, Stack)}.
   *
   * <ul>
   *   <li>Then first element {@link TopValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#enterExceptionHandler(Clazz,
   * Method, CodeAttribute, int, int, Stack)}
   */
  @Test
  @DisplayName(
      "Test enterExceptionHandler(Clazz, Method, CodeAttribute, int, int, Stack); then first element TopValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.ReferenceTracingInvocationUnit.enterExceptionHandler(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, int, proguard.evaluation.Stack)"
  })
  void testEnterExceptionHandler_thenFirstElementTopValue() {
    // Arrange
    BasicInvocationUnit invocationUnit = mock(BasicInvocationUnit.class);
    when(invocationUnit.getExceptionValue(Mockito.<Clazz>any(), Mockito.<ClassConstant>any()))
        .thenReturn(BasicValueFactory.DOUBLE_VALUE);
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(invocationUnit);
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    Stack stack = new Stack(3);

    // Act
    referenceTracingInvocationUnit.enterExceptionHandler(clazz, method, codeAttribute, 2, 1, stack);

    // Assert
    verify(clazz).getConstant(eq(1));
    verify(invocationUnit).getExceptionValue(isA(Clazz.class), isA(ClassConstant.class));
    Value[] valueArray = stack.values;
    Value value = valueArray[0];
    assertTrue(value instanceof TopValue);
    Value value2 = valueArray[1];
    assertTrue(value2 instanceof UnknownDoubleValue);
    assertEquals(2, stack.getActualMaxSize());
    assertEquals(2, stack.size());
    assertEquals(3, valueArray.length);
    assertFalse(value2.isParticular());
    assertFalse(value2.isSpecific());
    assertTrue(value2.isCategory2());
    assertTrue(value.isParticular());
    assertTrue(value.isSpecific());
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#enterExceptionHandler(Clazz, Method, CodeAttribute,
   * int, int, Stack)}.
   *
   * <ul>
   *   <li>When {@link Stack} {@link Stack#push(Value)} does nothing.
   *   <li>Then calls {@link Stack#push(Value)}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#enterExceptionHandler(Clazz,
   * Method, CodeAttribute, int, int, Stack)}
   */
  @Test
  @DisplayName(
      "Test enterExceptionHandler(Clazz, Method, CodeAttribute, int, int, Stack); when Stack push(Value) does nothing; then calls push(Value)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.ReferenceTracingInvocationUnit.enterExceptionHandler(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, int, proguard.evaluation.Stack)"
  })
  void testEnterExceptionHandler_whenStackPushDoesNothing_thenCallsPush() {
    // Arrange
    BasicInvocationUnit invocationUnit = mock(BasicInvocationUnit.class);
    when(invocationUnit.getExceptionValue(Mockito.<Clazz>any(), Mockito.<ClassConstant>any()))
        .thenReturn(BasicValueFactory.DOUBLE_VALUE);
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(invocationUnit);
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    Stack stack = mock(Stack.class);
    doNothing().when(stack).push(Mockito.<Value>any());

    // Act
    referenceTracingInvocationUnit.enterExceptionHandler(clazz, method, codeAttribute, 2, 1, stack);

    // Assert
    verify(clazz).getConstant(eq(1));
    verify(invocationUnit).getExceptionValue(isA(Clazz.class), isA(ClassConstant.class));
    verify(stack).push(isA(Value.class));
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#invokeMember(Clazz, Method, CodeAttribute, int,
   * ConstantInstruction, Stack, Variables)}.
   *
   * <ul>
   *   <li>Given minus seventy-eight.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#invokeMember(Clazz, Method,
   * CodeAttribute, int, ConstantInstruction, Stack, Variables)}
   */
  @Test
  @DisplayName(
      "Test invokeMember(Clazz, Method, CodeAttribute, int, ConstantInstruction, Stack, Variables); given minus seventy-eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.ReferenceTracingInvocationUnit.invokeMember(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.ConstantInstruction, proguard.evaluation.Stack, proguard.evaluation.Variables)"
  })
  void testInvokeMember_givenMinusSeventyEight() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    constantInstruction.opcode = (byte) -78;
    Stack stack = new Stack(3);

    // Act
    referenceTracingInvocationUnit.invokeMember(
        clazz, method, codeAttribute, 2, constantInstruction, stack, new Variables(3));

    // Assert
    assertTrue(referenceTracingInvocationUnit.isLoad);
    assertTrue(referenceTracingInvocationUnit.isStatic);
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#invokeMember(Clazz, Method, CodeAttribute, int,
   * ConstantInstruction, Stack, Variables)}.
   *
   * <ul>
   *   <li>Given minus seventy-five.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#invokeMember(Clazz, Method,
   * CodeAttribute, int, ConstantInstruction, Stack, Variables)}
   */
  @Test
  @DisplayName(
      "Test invokeMember(Clazz, Method, CodeAttribute, int, ConstantInstruction, Stack, Variables); given minus seventy-five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.ReferenceTracingInvocationUnit.invokeMember(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.ConstantInstruction, proguard.evaluation.Stack, proguard.evaluation.Variables)"
  })
  void testInvokeMember_givenMinusSeventyFive() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    constantInstruction.opcode = (byte) -75;
    Stack stack = new Stack(3);

    // Act
    referenceTracingInvocationUnit.invokeMember(
        clazz, method, codeAttribute, 2, constantInstruction, stack, new Variables(3));

    // Assert that nothing has changed
    assertFalse(referenceTracingInvocationUnit.isLoad);
    assertFalse(referenceTracingInvocationUnit.isStatic);
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#invokeMember(Clazz, Method, CodeAttribute, int,
   * ConstantInstruction, Stack, Variables)}.
   *
   * <ul>
   *   <li>Given minus seventy-four.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#invokeMember(Clazz, Method,
   * CodeAttribute, int, ConstantInstruction, Stack, Variables)}
   */
  @Test
  @DisplayName(
      "Test invokeMember(Clazz, Method, CodeAttribute, int, ConstantInstruction, Stack, Variables); given minus seventy-four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.ReferenceTracingInvocationUnit.invokeMember(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.ConstantInstruction, proguard.evaluation.Stack, proguard.evaluation.Variables)"
  })
  void testInvokeMember_givenMinusSeventyFour() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    constantInstruction.opcode = (byte) -74;
    Stack stack = new Stack(3);

    // Act
    referenceTracingInvocationUnit.invokeMember(
        clazz, method, codeAttribute, 2, constantInstruction, stack, new Variables(3));

    // Assert that nothing has changed
    assertFalse(referenceTracingInvocationUnit.isLoad);
    assertFalse(referenceTracingInvocationUnit.isStatic);
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#invokeMember(Clazz, Method, CodeAttribute, int,
   * ConstantInstruction, Stack, Variables)}.
   *
   * <ul>
   *   <li>Given minus seventy-seven.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#invokeMember(Clazz, Method,
   * CodeAttribute, int, ConstantInstruction, Stack, Variables)}
   */
  @Test
  @DisplayName(
      "Test invokeMember(Clazz, Method, CodeAttribute, int, ConstantInstruction, Stack, Variables); given minus seventy-seven")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.ReferenceTracingInvocationUnit.invokeMember(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.ConstantInstruction, proguard.evaluation.Stack, proguard.evaluation.Variables)"
  })
  void testInvokeMember_givenMinusSeventySeven() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    constantInstruction.opcode = (byte) -77;
    Stack stack = new Stack(3);

    // Act
    referenceTracingInvocationUnit.invokeMember(
        clazz, method, codeAttribute, 2, constantInstruction, stack, new Variables(3));

    // Assert
    assertFalse(referenceTracingInvocationUnit.isLoad);
    assertTrue(referenceTracingInvocationUnit.isStatic);
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#invokeMember(Clazz, Method, CodeAttribute, int,
   * ConstantInstruction, Stack, Variables)}.
   *
   * <ul>
   *   <li>Given minus seventy-six.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#invokeMember(Clazz, Method,
   * CodeAttribute, int, ConstantInstruction, Stack, Variables)}
   */
  @Test
  @DisplayName(
      "Test invokeMember(Clazz, Method, CodeAttribute, int, ConstantInstruction, Stack, Variables); given minus seventy-six")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.ReferenceTracingInvocationUnit.invokeMember(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.ConstantInstruction, proguard.evaluation.Stack, proguard.evaluation.Variables)"
  })
  void testInvokeMember_givenMinusSeventySix() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    constantInstruction.opcode = (byte) -76;
    Stack stack = new Stack(3);

    // Act
    referenceTracingInvocationUnit.invokeMember(
        clazz, method, codeAttribute, 2, constantInstruction, stack, new Variables(3));

    // Assert
    assertFalse(referenceTracingInvocationUnit.isStatic);
    assertTrue(referenceTracingInvocationUnit.isLoad);
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#invokeMember(Clazz, Method, CodeAttribute, int,
   * ConstantInstruction, Stack, Variables)}.
   *
   * <ul>
   *   <li>Given minus seventy-two.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#invokeMember(Clazz, Method,
   * CodeAttribute, int, ConstantInstruction, Stack, Variables)}
   */
  @Test
  @DisplayName(
      "Test invokeMember(Clazz, Method, CodeAttribute, int, ConstantInstruction, Stack, Variables); given minus seventy-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.ReferenceTracingInvocationUnit.invokeMember(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.ConstantInstruction, proguard.evaluation.Stack, proguard.evaluation.Variables)"
  })
  void testInvokeMember_givenMinusSeventyTwo() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    constantInstruction.opcode = (byte) -72;
    Stack stack = new Stack(3);

    // Act
    referenceTracingInvocationUnit.invokeMember(
        clazz, method, codeAttribute, 2, constantInstruction, stack, new Variables(3));

    // Assert
    assertFalse(referenceTracingInvocationUnit.isLoad);
    assertTrue(referenceTracingInvocationUnit.isStatic);
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#invokeMember(Clazz, Method, CodeAttribute, int,
   * ConstantInstruction, Stack, Variables)}.
   *
   * <ul>
   *   <li>When {@link ConstantInstruction#ConstantInstruction(byte, int)} with opcode is {@code A}
   *       and constantIndex is one.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#invokeMember(Clazz, Method,
   * CodeAttribute, int, ConstantInstruction, Stack, Variables)}
   */
  @Test
  @DisplayName(
      "Test invokeMember(Clazz, Method, CodeAttribute, int, ConstantInstruction, Stack, Variables); when ConstantInstruction(byte, int) with opcode is 'A' and constantIndex is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.ReferenceTracingInvocationUnit.invokeMember(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.ConstantInstruction, proguard.evaluation.Stack, proguard.evaluation.Variables)"
  })
  void testInvokeMember_whenConstantInstructionWithOpcodeIsAAndConstantIndexIsOne() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    Stack stack = new Stack(3);

    // Act
    referenceTracingInvocationUnit.invokeMember(
        clazz, method, codeAttribute, 2, constantInstruction, stack, new Variables(3));

    // Assert that nothing has changed
    assertFalse(referenceTracingInvocationUnit.isLoad);
    assertFalse(referenceTracingInvocationUnit.isStatic);
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#getExceptionValue(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>Then ReferenceValue return {@link IdentifiedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#getExceptionValue(Clazz,
   * ClassConstant)}
   */
  @Test
  @DisplayName(
      "Test getExceptionValue(Clazz, ClassConstant); then ReferenceValue return IdentifiedReferenceValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.ReferenceTracingInvocationUnit.getExceptionValue(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testGetExceptionValue_thenReferenceValueReturnIdentifiedReferenceValue() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new ReferenceTracingInvocationUnit(
                new BasicInvocationUnit(new ParticularReferenceValueFactory())));

    // Act
    Value actualExceptionValue =
        referenceTracingInvocationUnit.getExceptionValue(new LibraryClass(), null);

    // Assert
    assertTrue(
        ((TracedReferenceValue) actualExceptionValue).getReferenceValue()
            instanceof IdentifiedReferenceValue);
    assertTrue(
        ((TracedReferenceValue) actualExceptionValue).getTraceValue()
            instanceof InstructionOffsetValue);
    assertTrue(actualExceptionValue instanceof TracedReferenceValue);
    assertEquals("Ljava/lang/Throwable;", ((TracedReferenceValue) actualExceptionValue).getType());
    assertNull(((TracedReferenceValue) actualExceptionValue).getReferencedClass());
    assertEquals(1, ((TracedReferenceValue) actualExceptionValue).isNotNull());
    assertFalse(actualExceptionValue.isCategory2());
    assertFalse(actualExceptionValue.isParticular());
    assertTrue(actualExceptionValue.isSpecific());
    assertEquals(InitializationFinder.NONE, ((TracedReferenceValue) actualExceptionValue).isNull());
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#getExceptionValue(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then ReferenceValue return {@link IdentifiedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#getExceptionValue(Clazz,
   * ClassConstant)}
   */
  @Test
  @DisplayName(
      "Test getExceptionValue(Clazz, ClassConstant); when 'null'; then ReferenceValue return IdentifiedReferenceValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.ReferenceTracingInvocationUnit.getExceptionValue(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testGetExceptionValue_whenNull_thenReferenceValueReturnIdentifiedReferenceValue() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new BasicInvocationUnit(new ParticularReferenceValueFactory()));

    // Act
    Value actualExceptionValue =
        referenceTracingInvocationUnit.getExceptionValue(new LibraryClass(), null);

    // Assert
    assertTrue(
        ((TracedReferenceValue) actualExceptionValue).getReferenceValue()
            instanceof IdentifiedReferenceValue);
    assertTrue(
        ((TracedReferenceValue) actualExceptionValue).getTraceValue()
            instanceof InstructionOffsetValue);
    assertTrue(actualExceptionValue instanceof TracedReferenceValue);
    assertEquals("Ljava/lang/Throwable;", ((TracedReferenceValue) actualExceptionValue).getType());
    assertNull(((TracedReferenceValue) actualExceptionValue).getReferencedClass());
    assertEquals(1, ((TracedReferenceValue) actualExceptionValue).isNotNull());
    assertFalse(actualExceptionValue.isCategory2());
    assertFalse(actualExceptionValue.isParticular());
    assertTrue(actualExceptionValue.isSpecific());
    assertEquals(InitializationFinder.NONE, ((TracedReferenceValue) actualExceptionValue).isNull());
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#getFieldClassValue(Clazz, FieldrefConstant,
   * String)}.
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#getFieldClassValue(Clazz,
   * FieldrefConstant, String)}
   */
  @Test
  @DisplayName("Test getFieldClassValue(Clazz, FieldrefConstant, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.ReferenceTracingInvocationUnit.getFieldClassValue(proguard.classfile.Clazz, proguard.classfile.constant.FieldrefConstant, java.lang.String)"
  })
  void testGetFieldClassValue() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new ReferenceTracingInvocationUnit(
                new BasicInvocationUnit(new ParticularReferenceValueFactory())));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualFieldClassValue =
        referenceTracingInvocationUnit.getFieldClassValue(clazz, new FieldrefConstant(), "Type");

    // Assert
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualFieldClassValue).getReferenceValue();
    assertTrue(referenceValue instanceof IdentifiedReferenceValue);
    assertTrue(actualFieldClassValue instanceof TracedReferenceValue);
    assertEquals("Type", referenceValue.getType());
    assertNull(referenceValue.getReferencedClass());
    assertEquals(0, referenceValue.isNull());
    assertFalse(referenceValue.isParticular());
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(actualFieldClassValue.isSpecific());
    assertTrue(referenceValue.isSpecific());
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#getFieldClassValue(Clazz, FieldrefConstant,
   * String)}.
   *
   * <ul>
   *   <li>Then ReferenceValue return {@link IdentifiedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#getFieldClassValue(Clazz,
   * FieldrefConstant, String)}
   */
  @Test
  @DisplayName(
      "Test getFieldClassValue(Clazz, FieldrefConstant, String); then ReferenceValue return IdentifiedReferenceValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.ReferenceTracingInvocationUnit.getFieldClassValue(proguard.classfile.Clazz, proguard.classfile.constant.FieldrefConstant, java.lang.String)"
  })
  void testGetFieldClassValue_thenReferenceValueReturnIdentifiedReferenceValue() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualFieldClassValue =
        referenceTracingInvocationUnit.getFieldClassValue(clazz, new FieldrefConstant(), "Type");

    // Assert
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualFieldClassValue).getReferenceValue();
    assertTrue(referenceValue instanceof IdentifiedReferenceValue);
    assertTrue(actualFieldClassValue instanceof TracedReferenceValue);
    assertEquals("Type", referenceValue.getType());
    assertNull(referenceValue.getReferencedClass());
    assertEquals(0, referenceValue.isNull());
    assertFalse(referenceValue.isParticular());
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(actualFieldClassValue.isSpecific());
    assertTrue(referenceValue.isSpecific());
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#getFieldClassValue(Clazz, FieldrefConstant,
   * String)}.
   *
   * <ul>
   *   <li>Then ReferenceValue return {@link MultiTypedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#getFieldClassValue(Clazz,
   * FieldrefConstant, String)}
   */
  @Test
  @DisplayName(
      "Test getFieldClassValue(Clazz, FieldrefConstant, String); then ReferenceValue return MultiTypedReferenceValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.ReferenceTracingInvocationUnit.getFieldClassValue(proguard.classfile.Clazz, proguard.classfile.constant.FieldrefConstant, java.lang.String)"
  })
  void testGetFieldClassValue_thenReferenceValueReturnMultiTypedReferenceValue() {
    // Arrange
    MultiTypedReferenceValueFactory valueFactory =
        new MultiTypedReferenceValueFactory(
            true, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);

    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new ExecutingInvocationUnit(
                KotlinConstants.dummyClassPool,
                KotlinConstants.dummyClassPool,
                valueFactory,
                true,
                new ArrayList<>()));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualFieldClassValue =
        referenceTracingInvocationUnit.getFieldClassValue(clazz, new FieldrefConstant(), "Type");

    // Assert
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualFieldClassValue).getReferenceValue();
    assertTrue(referenceValue instanceof MultiTypedReferenceValue);
    assertTrue(actualFieldClassValue instanceof TracedReferenceValue);
    assertEquals("Type", referenceValue.getType());
    assertNull(referenceValue.getReferencedClass());
    assertEquals(1, ((MultiTypedReferenceValue) referenceValue).getPotentialTypes().size());
    assertFalse(referenceValue.isParticular());
    assertFalse(((MultiTypedReferenceValue) referenceValue).mayBeUnknown);
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#getFieldClassValue(Clazz, FieldrefConstant,
   * String)}.
   *
   * <ul>
   *   <li>Then return Type is {@code Ljava/lang/Object;}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#getFieldClassValue(Clazz,
   * FieldrefConstant, String)}
   */
  @Test
  @DisplayName(
      "Test getFieldClassValue(Clazz, FieldrefConstant, String); then return Type is 'Ljava/lang/Object;'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.ReferenceTracingInvocationUnit.getFieldClassValue(proguard.classfile.Clazz, proguard.classfile.constant.FieldrefConstant, java.lang.String)"
  })
  void testGetFieldClassValue_thenReturnTypeIsLjavaLangObject() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(new BasicInvocationUnit(valueFactory));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualFieldClassValue =
        referenceTracingInvocationUnit.getFieldClassValue(clazz, new FieldrefConstant(), "Type");

    // Assert
    assertTrue(actualFieldClassValue instanceof TracedReferenceValue);
    assertEquals("Ljava/lang/Object;", ((TracedReferenceValue) actualFieldClassValue).getType());
    ReferenceValue expectedReferenceValue = valueFactory.REFERENCE_VALUE;
    assertSame(
        expectedReferenceValue, ((TracedReferenceValue) actualFieldClassValue).getReferenceValue());
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#getFieldValue(Clazz, FieldrefConstant, String)}.
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#getFieldValue(Clazz,
   * FieldrefConstant, String)}
   */
  @Test
  @DisplayName("Test getFieldValue(Clazz, FieldrefConstant, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.ReferenceTracingInvocationUnit.getFieldValue(proguard.classfile.Clazz, proguard.classfile.constant.FieldrefConstant, java.lang.String)"
  })
  void testGetFieldValue() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new ReferenceTracingInvocationUnit(
                new BasicInvocationUnit(new ParticularReferenceValueFactory())));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualFieldValue =
        referenceTracingInvocationUnit.getFieldValue(clazz, new FieldrefConstant(), "Type");

    // Assert
    ReferenceValue referenceValue = ((TracedReferenceValue) actualFieldValue).getReferenceValue();
    assertTrue(referenceValue instanceof IdentifiedReferenceValue);
    assertTrue(actualFieldValue instanceof TracedReferenceValue);
    assertEquals("Type", referenceValue.getType());
    assertNull(referenceValue.getReferencedClass());
    assertEquals(0, referenceValue.isNull());
    assertFalse(referenceValue.isParticular());
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(actualFieldValue.isSpecific());
    assertTrue(referenceValue.isSpecific());
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#getFieldValue(Clazz, FieldrefConstant, String)}.
   *
   * <ul>
   *   <li>Then ReferenceValue return {@link IdentifiedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#getFieldValue(Clazz,
   * FieldrefConstant, String)}
   */
  @Test
  @DisplayName(
      "Test getFieldValue(Clazz, FieldrefConstant, String); then ReferenceValue return IdentifiedReferenceValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.ReferenceTracingInvocationUnit.getFieldValue(proguard.classfile.Clazz, proguard.classfile.constant.FieldrefConstant, java.lang.String)"
  })
  void testGetFieldValue_thenReferenceValueReturnIdentifiedReferenceValue() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualFieldValue =
        referenceTracingInvocationUnit.getFieldValue(clazz, new FieldrefConstant(), "Type");

    // Assert
    ReferenceValue referenceValue = ((TracedReferenceValue) actualFieldValue).getReferenceValue();
    assertTrue(referenceValue instanceof IdentifiedReferenceValue);
    assertTrue(actualFieldValue instanceof TracedReferenceValue);
    assertEquals("Type", referenceValue.getType());
    assertNull(referenceValue.getReferencedClass());
    assertEquals(0, referenceValue.isNull());
    assertFalse(referenceValue.isParticular());
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(actualFieldValue.isSpecific());
    assertTrue(referenceValue.isSpecific());
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#getFieldValue(Clazz, FieldrefConstant, String)}.
   *
   * <ul>
   *   <li>Then ReferenceValue return {@link MultiTypedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#getFieldValue(Clazz,
   * FieldrefConstant, String)}
   */
  @Test
  @DisplayName(
      "Test getFieldValue(Clazz, FieldrefConstant, String); then ReferenceValue return MultiTypedReferenceValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.ReferenceTracingInvocationUnit.getFieldValue(proguard.classfile.Clazz, proguard.classfile.constant.FieldrefConstant, java.lang.String)"
  })
  void testGetFieldValue_thenReferenceValueReturnMultiTypedReferenceValue() {
    // Arrange
    MultiTypedReferenceValueFactory valueFactory =
        new MultiTypedReferenceValueFactory(
            true, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);

    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new ExecutingInvocationUnit(
                KotlinConstants.dummyClassPool,
                KotlinConstants.dummyClassPool,
                valueFactory,
                true,
                new ArrayList<>()));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualFieldValue =
        referenceTracingInvocationUnit.getFieldValue(clazz, new FieldrefConstant(), "Type");

    // Assert
    ReferenceValue referenceValue = ((TracedReferenceValue) actualFieldValue).getReferenceValue();
    assertTrue(referenceValue instanceof MultiTypedReferenceValue);
    assertTrue(actualFieldValue instanceof TracedReferenceValue);
    assertEquals("Type", referenceValue.getType());
    assertNull(referenceValue.getReferencedClass());
    assertEquals(1, ((MultiTypedReferenceValue) referenceValue).getPotentialTypes().size());
    assertFalse(referenceValue.isParticular());
    assertFalse(((MultiTypedReferenceValue) referenceValue).mayBeUnknown);
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#getFieldValue(Clazz, FieldrefConstant, String)}.
   *
   * <ul>
   *   <li>Then return Type is {@code Ljava/lang/Object;}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#getFieldValue(Clazz,
   * FieldrefConstant, String)}
   */
  @Test
  @DisplayName(
      "Test getFieldValue(Clazz, FieldrefConstant, String); then return Type is 'Ljava/lang/Object;'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.ReferenceTracingInvocationUnit.getFieldValue(proguard.classfile.Clazz, proguard.classfile.constant.FieldrefConstant, java.lang.String)"
  })
  void testGetFieldValue_thenReturnTypeIsLjavaLangObject() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(new BasicInvocationUnit(valueFactory));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualFieldValue =
        referenceTracingInvocationUnit.getFieldValue(clazz, new FieldrefConstant(), "Type");

    // Assert
    assertTrue(actualFieldValue instanceof TracedReferenceValue);
    assertEquals("Ljava/lang/Object;", ((TracedReferenceValue) actualFieldValue).getType());
    ReferenceValue expectedReferenceValue = valueFactory.REFERENCE_VALUE;
    assertSame(
        expectedReferenceValue, ((TracedReferenceValue) actualFieldValue).getReferenceValue());
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#getMethodParameterValue(Clazz, Method, int, String,
   * Clazz)}.
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#getMethodParameterValue(Clazz,
   * Method, int, String, Clazz)}
   */
  @Test
  @DisplayName("Test getMethodParameterValue(Clazz, Method, int, String, Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.ReferenceTracingInvocationUnit.getMethodParameterValue(proguard.classfile.Clazz, proguard.classfile.Method, int, java.lang.String, proguard.classfile.Clazz)"
  })
  void testGetMethodParameterValue() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    LibraryClass referencedClass = new LibraryClass();

    // Act
    Value actualMethodParameterValue =
        referenceTracingInvocationUnit.getMethodParameterValue(
            clazz, method, 1, "Type", referencedClass);

    // Assert
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualMethodParameterValue).getReferenceValue();
    assertTrue(referenceValue instanceof IdentifiedReferenceValue);
    assertTrue(actualMethodParameterValue instanceof TracedReferenceValue);
    assertSame(referencedClass, referenceValue.getReferencedClass());
    assertSame(
        referencedClass, ((TracedReferenceValue) actualMethodParameterValue).getReferencedClass());
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#getMethodParameterValue(Clazz, Method, int, String,
   * Clazz)}.
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#getMethodParameterValue(Clazz,
   * Method, int, String, Clazz)}
   */
  @Test
  @DisplayName("Test getMethodParameterValue(Clazz, Method, int, String, Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.ReferenceTracingInvocationUnit.getMethodParameterValue(proguard.classfile.Clazz, proguard.classfile.Method, int, java.lang.String, proguard.classfile.Clazz)"
  })
  void testGetMethodParameterValue2() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new ReferenceTracingInvocationUnit(
                new BasicInvocationUnit(new ParticularReferenceValueFactory())));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    LibraryClass referencedClass = new LibraryClass();

    // Act
    Value actualMethodParameterValue =
        referenceTracingInvocationUnit.getMethodParameterValue(
            clazz, method, 1, "Type", referencedClass);

    // Assert
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualMethodParameterValue).getReferenceValue();
    assertTrue(referenceValue instanceof IdentifiedReferenceValue);
    assertTrue(actualMethodParameterValue instanceof TracedReferenceValue);
    assertSame(referencedClass, referenceValue.getReferencedClass());
    assertSame(
        referencedClass, ((TracedReferenceValue) actualMethodParameterValue).getReferencedClass());
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#getMethodParameterValue(Clazz, Method, int, String,
   * Clazz)}.
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#getMethodParameterValue(Clazz,
   * Method, int, String, Clazz)}
   */
  @Test
  @DisplayName("Test getMethodParameterValue(Clazz, Method, int, String, Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.ReferenceTracingInvocationUnit.getMethodParameterValue(proguard.classfile.Clazz, proguard.classfile.Method, int, java.lang.String, proguard.classfile.Clazz)"
  })
  void testGetMethodParameterValue3() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    ProgramClass referencedClass = new ProgramClass();

    // Act
    Value actualMethodParameterValue =
        referenceTracingInvocationUnit.getMethodParameterValue(
            clazz, method, 1, "Type", referencedClass);

    // Assert
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualMethodParameterValue).getReferenceValue();
    assertTrue(referenceValue instanceof IdentifiedReferenceValue);
    assertTrue(actualMethodParameterValue instanceof TracedReferenceValue);
    assertSame(referencedClass, referenceValue.getReferencedClass());
    assertSame(
        referencedClass, ((TracedReferenceValue) actualMethodParameterValue).getReferencedClass());
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#getMethodParameterValue(Clazz, Method, int, String,
   * Clazz)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then TraceValue return {@link InstructionOffsetValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#getMethodParameterValue(Clazz,
   * Method, int, String, Clazz)}
   */
  @Test
  @DisplayName(
      "Test getMethodParameterValue(Clazz, Method, int, String, Clazz); when 'null'; then TraceValue return InstructionOffsetValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.ReferenceTracingInvocationUnit.getMethodParameterValue(proguard.classfile.Clazz, proguard.classfile.Method, int, java.lang.String, proguard.classfile.Clazz)"
  })
  void testGetMethodParameterValue_whenNull_thenTraceValueReturnInstructionOffsetValue() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualMethodParameterValue =
        referenceTracingInvocationUnit.getMethodParameterValue(
            clazz, new LibraryMethod(1, "Name", "Descriptor"), 1, "Type", null);

    // Assert
    assertTrue(
        ((TracedReferenceValue) actualMethodParameterValue).getTraceValue()
            instanceof InstructionOffsetValue);
    assertTrue(actualMethodParameterValue instanceof TracedReferenceValue);
    assertEquals("Type", ((TracedReferenceValue) actualMethodParameterValue).getType());
    assertNull(((TracedReferenceValue) actualMethodParameterValue).getReferencedClass());
    assertEquals(0, ((TracedReferenceValue) actualMethodParameterValue).isNotNull());
    assertEquals(0, ((TracedReferenceValue) actualMethodParameterValue).isNull());
    assertFalse(actualMethodParameterValue.isCategory2());
    assertFalse(actualMethodParameterValue.isParticular());
    assertTrue(actualMethodParameterValue.isSpecific());
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#getMethodReturnValue(Clazz, AnyMethodrefConstant,
   * String)} with {@code clazz}, {@code anyMethodrefConstant}, {@code type}.
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#getMethodReturnValue(Clazz,
   * AnyMethodrefConstant, String)}
   */
  @Test
  @DisplayName(
      "Test getMethodReturnValue(Clazz, AnyMethodrefConstant, String) with 'clazz', 'anyMethodrefConstant', 'type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.ReferenceTracingInvocationUnit.getMethodReturnValue(proguard.classfile.Clazz, proguard.classfile.constant.AnyMethodrefConstant, java.lang.String)"
  })
  void testGetMethodReturnValueWithClazzAnyMethodrefConstantType() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualMethodReturnValue =
        referenceTracingInvocationUnit.getMethodReturnValue(
            clazz, new InterfaceMethodrefConstant(), "Type");

    // Assert
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualMethodReturnValue).getReferenceValue();
    assertTrue(referenceValue instanceof IdentifiedReferenceValue);
    assertTrue(actualMethodReturnValue instanceof TracedReferenceValue);
    assertEquals("Type", referenceValue.getType());
    assertNull(referenceValue.getReferencedClass());
    assertEquals(0, referenceValue.isNull());
    assertFalse(referenceValue.isParticular());
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(actualMethodReturnValue.isSpecific());
    assertTrue(referenceValue.isSpecific());
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#getMethodReturnValue(Clazz, AnyMethodrefConstant,
   * String)} with {@code clazz}, {@code anyMethodrefConstant}, {@code type}.
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#getMethodReturnValue(Clazz,
   * AnyMethodrefConstant, String)}
   */
  @Test
  @DisplayName(
      "Test getMethodReturnValue(Clazz, AnyMethodrefConstant, String) with 'clazz', 'anyMethodrefConstant', 'type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.ReferenceTracingInvocationUnit.getMethodReturnValue(proguard.classfile.Clazz, proguard.classfile.constant.AnyMethodrefConstant, java.lang.String)"
  })
  void testGetMethodReturnValueWithClazzAnyMethodrefConstantType2() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new ReferenceTracingInvocationUnit(
                new BasicInvocationUnit(new ParticularReferenceValueFactory())));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualMethodReturnValue =
        referenceTracingInvocationUnit.getMethodReturnValue(
            clazz, new InterfaceMethodrefConstant(), "Type");

    // Assert
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualMethodReturnValue).getReferenceValue();
    assertTrue(referenceValue instanceof IdentifiedReferenceValue);
    assertTrue(actualMethodReturnValue instanceof TracedReferenceValue);
    assertEquals("Type", referenceValue.getType());
    assertNull(referenceValue.getReferencedClass());
    assertEquals(0, referenceValue.isNull());
    assertFalse(referenceValue.isParticular());
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(actualMethodReturnValue.isSpecific());
    assertTrue(referenceValue.isSpecific());
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#getMethodReturnValue(Clazz, AnyMethodrefConstant,
   * String)} with {@code clazz}, {@code anyMethodrefConstant}, {@code type}.
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#getMethodReturnValue(Clazz,
   * AnyMethodrefConstant, String)}
   */
  @Test
  @DisplayName(
      "Test getMethodReturnValue(Clazz, AnyMethodrefConstant, String) with 'clazz', 'anyMethodrefConstant', 'type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.ReferenceTracingInvocationUnit.getMethodReturnValue(proguard.classfile.Clazz, proguard.classfile.constant.AnyMethodrefConstant, java.lang.String)"
  })
  void testGetMethodReturnValueWithClazzAnyMethodrefConstantType3() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(new BasicInvocationUnit(valueFactory));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualMethodReturnValue =
        referenceTracingInvocationUnit.getMethodReturnValue(
            clazz, new InterfaceMethodrefConstant(), "Type");

    // Assert
    assertTrue(actualMethodReturnValue instanceof TracedReferenceValue);
    assertEquals("Ljava/lang/Object;", ((TracedReferenceValue) actualMethodReturnValue).getType());
    ReferenceValue expectedReferenceValue = valueFactory.REFERENCE_VALUE;
    assertSame(
        expectedReferenceValue,
        ((TracedReferenceValue) actualMethodReturnValue).getReferenceValue());
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#getMethodReturnValue(Clazz, AnyMethodrefConstant,
   * String)} with {@code clazz}, {@code anyMethodrefConstant}, {@code type}.
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#getMethodReturnValue(Clazz,
   * AnyMethodrefConstant, String)}
   */
  @Test
  @DisplayName(
      "Test getMethodReturnValue(Clazz, AnyMethodrefConstant, String) with 'clazz', 'anyMethodrefConstant', 'type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.ReferenceTracingInvocationUnit.getMethodReturnValue(proguard.classfile.Clazz, proguard.classfile.constant.AnyMethodrefConstant, java.lang.String)"
  })
  void testGetMethodReturnValueWithClazzAnyMethodrefConstantType4() {
    // Arrange
    MultiTypedReferenceValueFactory valueFactory =
        new MultiTypedReferenceValueFactory(
            true, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);

    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new ExecutingInvocationUnit(
                KotlinConstants.dummyClassPool,
                KotlinConstants.dummyClassPool,
                valueFactory,
                true,
                new ArrayList<>()));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualMethodReturnValue =
        referenceTracingInvocationUnit.getMethodReturnValue(
            clazz, new InterfaceMethodrefConstant(), "Type");

    // Assert
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualMethodReturnValue).getReferenceValue();
    assertTrue(referenceValue instanceof MultiTypedReferenceValue);
    assertTrue(actualMethodReturnValue instanceof TracedReferenceValue);
    assertEquals("Type", referenceValue.getType());
    assertNull(referenceValue.getReferencedClass());
    assertEquals(1, ((MultiTypedReferenceValue) referenceValue).getPotentialTypes().size());
    assertFalse(referenceValue.isParticular());
    assertFalse(((MultiTypedReferenceValue) referenceValue).mayBeUnknown);
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#getMethodReturnValue(Clazz, InvokeDynamicConstant,
   * String)} with {@code clazz}, {@code invokeDynamicConstant}, {@code type}.
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#getMethodReturnValue(Clazz,
   * InvokeDynamicConstant, String)}
   */
  @Test
  @DisplayName(
      "Test getMethodReturnValue(Clazz, InvokeDynamicConstant, String) with 'clazz', 'invokeDynamicConstant', 'type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.ReferenceTracingInvocationUnit.getMethodReturnValue(proguard.classfile.Clazz, proguard.classfile.constant.InvokeDynamicConstant, java.lang.String)"
  })
  void testGetMethodReturnValueWithClazzInvokeDynamicConstantType() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualMethodReturnValue =
        referenceTracingInvocationUnit.getMethodReturnValue(
            clazz, new InvokeDynamicConstant(), "Type");

    // Assert
    assertTrue(
        ((TracedReferenceValue) actualMethodReturnValue).getReferenceValue()
            instanceof IdentifiedReferenceValue);
    assertTrue(
        ((TracedReferenceValue) actualMethodReturnValue).getTraceValue()
            instanceof InstructionOffsetValue);
    assertTrue(actualMethodReturnValue instanceof TracedReferenceValue);
    assertEquals("Type", ((TracedReferenceValue) actualMethodReturnValue).getType());
    assertNull(((TracedReferenceValue) actualMethodReturnValue).getReferencedClass());
    assertEquals(0, ((TracedReferenceValue) actualMethodReturnValue).isNotNull());
    assertEquals(0, ((TracedReferenceValue) actualMethodReturnValue).isNull());
    assertFalse(actualMethodReturnValue.isCategory2());
    assertFalse(actualMethodReturnValue.isParticular());
    assertTrue(actualMethodReturnValue.isSpecific());
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#getMethodReturnValue(Clazz, InvokeDynamicConstant,
   * String)} with {@code clazz}, {@code invokeDynamicConstant}, {@code type}.
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#getMethodReturnValue(Clazz,
   * InvokeDynamicConstant, String)}
   */
  @Test
  @DisplayName(
      "Test getMethodReturnValue(Clazz, InvokeDynamicConstant, String) with 'clazz', 'invokeDynamicConstant', 'type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.ReferenceTracingInvocationUnit.getMethodReturnValue(proguard.classfile.Clazz, proguard.classfile.constant.InvokeDynamicConstant, java.lang.String)"
  })
  void testGetMethodReturnValueWithClazzInvokeDynamicConstantType2() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new ReferenceTracingInvocationUnit(
                new BasicInvocationUnit(new ParticularReferenceValueFactory())));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualMethodReturnValue =
        referenceTracingInvocationUnit.getMethodReturnValue(
            clazz, new InvokeDynamicConstant(), "Type");

    // Assert
    assertTrue(
        ((TracedReferenceValue) actualMethodReturnValue).getReferenceValue()
            instanceof IdentifiedReferenceValue);
    assertTrue(
        ((TracedReferenceValue) actualMethodReturnValue).getTraceValue()
            instanceof InstructionOffsetValue);
    assertTrue(actualMethodReturnValue instanceof TracedReferenceValue);
    assertEquals("Type", ((TracedReferenceValue) actualMethodReturnValue).getType());
    assertNull(((TracedReferenceValue) actualMethodReturnValue).getReferencedClass());
    assertEquals(0, ((TracedReferenceValue) actualMethodReturnValue).isNotNull());
    assertEquals(0, ((TracedReferenceValue) actualMethodReturnValue).isNull());
    assertFalse(actualMethodReturnValue.isCategory2());
    assertFalse(actualMethodReturnValue.isParticular());
    assertTrue(actualMethodReturnValue.isSpecific());
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#getMethodReturnValue(Clazz, InvokeDynamicConstant,
   * String)} with {@code clazz}, {@code invokeDynamicConstant}, {@code type}.
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#getMethodReturnValue(Clazz,
   * InvokeDynamicConstant, String)}
   */
  @Test
  @DisplayName(
      "Test getMethodReturnValue(Clazz, InvokeDynamicConstant, String) with 'clazz', 'invokeDynamicConstant', 'type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.ReferenceTracingInvocationUnit.getMethodReturnValue(proguard.classfile.Clazz, proguard.classfile.constant.InvokeDynamicConstant, java.lang.String)"
  })
  void testGetMethodReturnValueWithClazzInvokeDynamicConstantType3() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualMethodReturnValue =
        referenceTracingInvocationUnit.getMethodReturnValue(
            clazz, new InvokeDynamicConstant(1, 1, new Clazz[] {new LibraryClass()}), "Type");

    // Assert
    assertTrue(
        ((TracedReferenceValue) actualMethodReturnValue).getReferenceValue()
            instanceof IdentifiedReferenceValue);
    assertTrue(
        ((TracedReferenceValue) actualMethodReturnValue).getTraceValue()
            instanceof InstructionOffsetValue);
    assertTrue(actualMethodReturnValue instanceof TracedReferenceValue);
    assertEquals("Type", ((TracedReferenceValue) actualMethodReturnValue).getType());
    assertNull(((TracedReferenceValue) actualMethodReturnValue).getReferencedClass());
    assertEquals(0, ((TracedReferenceValue) actualMethodReturnValue).isNotNull());
    assertEquals(0, ((TracedReferenceValue) actualMethodReturnValue).isNull());
    assertFalse(actualMethodReturnValue.isCategory2());
    assertFalse(actualMethodReturnValue.isParticular());
    assertTrue(actualMethodReturnValue.isSpecific());
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#trace(Value, int)} with {@code value}, {@code
   * trace}.
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#trace(Value, int)}
   */
  @Test
  @DisplayName("Test trace(Value, int) with 'value', 'trace'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.ReferenceTracingInvocationUnit.trace(proguard.evaluation.value.Value, int)"
  })
  void testTraceWithValueTrace() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(new BasicInvocationUnit(valueFactory));

    // Act
    Value actualTraceResult =
        referenceTracingInvocationUnit.trace(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicValueFactory.DOUBLE_VALUE),
            1);

    // Assert
    assertTrue(
        ((TracedReferenceValue) actualTraceResult).getTraceValue()
            instanceof InstructionOffsetValue);
    assertTrue(actualTraceResult instanceof TracedReferenceValue);
    ReferenceValue referenceValue = ((TracedReferenceValue) actualTraceResult).getReferenceValue();
    assertTrue(referenceValue instanceof UnknownReferenceValue);
    assertEquals("Ljava/lang/Object;", ((TracedReferenceValue) actualTraceResult).getType());
    assertNull(((TracedReferenceValue) actualTraceResult).getReferencedClass());
    assertEquals(0, ((TracedReferenceValue) actualTraceResult).isNotNull());
    assertEquals(0, ((TracedReferenceValue) actualTraceResult).isNull());
    assertFalse(actualTraceResult.isParticular());
    assertFalse(actualTraceResult.isSpecific());
    assertSame(valueFactory.REFERENCE_VALUE, referenceValue);
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#trace(Value, InstructionOffsetValue)} with {@code
   * value}, {@code traceValue}.
   *
   * <ul>
   *   <li>Then TraceValue return {@link InstructionOffsetValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#trace(Value,
   * InstructionOffsetValue)}
   */
  @Test
  @DisplayName(
      "Test trace(Value, InstructionOffsetValue) with 'value', 'traceValue'; then TraceValue return InstructionOffsetValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.ReferenceTracingInvocationUnit.trace(proguard.evaluation.value.Value, proguard.evaluation.value.InstructionOffsetValue)"
  })
  void testTraceWithValueTraceValue_thenTraceValueReturnInstructionOffsetValue() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(new BasicInvocationUnit(valueFactory));
    InstructionOffsetValue traceValue = InstructionOffsetValue.EMPTY_VALUE;

    // Act
    Value actualTraceResult =
        referenceTracingInvocationUnit.trace(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicValueFactory.DOUBLE_VALUE),
            traceValue);

    // Assert
    Value traceValue2 = ((TracedReferenceValue) actualTraceResult).getTraceValue();
    assertTrue(traceValue2 instanceof InstructionOffsetValue);
    assertTrue(actualTraceResult instanceof TracedReferenceValue);
    ReferenceValue referenceValue = ((TracedReferenceValue) actualTraceResult).getReferenceValue();
    assertTrue(referenceValue instanceof UnknownReferenceValue);
    assertEquals("Ljava/lang/Object;", ((TracedReferenceValue) actualTraceResult).getType());
    assertNull(((TracedReferenceValue) actualTraceResult).getReferencedClass());
    assertEquals(0, ((TracedReferenceValue) actualTraceResult).isNotNull());
    assertEquals(0, ((TracedReferenceValue) actualTraceResult).isNull());
    assertFalse(actualTraceResult.isCategory2());
    assertFalse(actualTraceResult.isParticular());
    assertFalse(actualTraceResult.isSpecific());
    assertSame(valueFactory.REFERENCE_VALUE, referenceValue);
    assertSame(traceValue.EMPTY_VALUE, traceValue2);
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#trace(Value, int)} with {@code value}, {@code
   * trace}.
   *
   * <ul>
   *   <li>Then return ReferenceValue is {@link BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#trace(Value, int)}
   */
  @Test
  @DisplayName(
      "Test trace(Value, int) with 'value', 'trace'; then return ReferenceValue is REFERENCE_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.ReferenceTracingInvocationUnit.trace(proguard.evaluation.value.Value, int)"
  })
  void testTraceWithValueTrace_thenReturnReferenceValueIsReference_value() {
    // Arrange
    ReferenceValue value = BasicValueFactory.REFERENCE_VALUE;

    // Act
    Value actualTraceResult =
        (new ReferenceTracingInvocationUnit(
                new BasicInvocationUnit(new ParticularReferenceValueFactory())))
            .trace(value, 1);

    // Assert
    assertTrue(
        ((TracedReferenceValue) actualTraceResult).getTraceValue()
            instanceof InstructionOffsetValue);
    assertTrue(actualTraceResult instanceof TracedReferenceValue);
    ReferenceValue referenceValue = ((TracedReferenceValue) actualTraceResult).getReferenceValue();
    assertTrue(referenceValue instanceof UnknownReferenceValue);
    assertEquals("Ljava/lang/Object;", ((TracedReferenceValue) actualTraceResult).getType());
    assertNull(((TracedReferenceValue) actualTraceResult).getReferencedClass());
    assertEquals(0, ((TracedReferenceValue) actualTraceResult).isNotNull());
    assertEquals(0, ((TracedReferenceValue) actualTraceResult).isNull());
    assertFalse(actualTraceResult.isParticular());
    assertFalse(actualTraceResult.isSpecific());
    assertSame(value, referenceValue);
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#trace(Value, int)} with {@code value}, {@code
   * trace}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#DOUBLE_VALUE}.
   *   <li>Then return {@link BasicValueFactory#DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#trace(Value, int)}
   */
  @Test
  @DisplayName(
      "Test trace(Value, int) with 'value', 'trace'; when DOUBLE_VALUE; then return DOUBLE_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.ReferenceTracingInvocationUnit.trace(proguard.evaluation.value.Value, int)"
  })
  void testTraceWithValueTrace_whenDouble_value_thenReturnDouble_value() {
    // Arrange
    DoubleValue value = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(
        value,
        (new ReferenceTracingInvocationUnit(
                new BasicInvocationUnit(new ParticularReferenceValueFactory())))
            .trace(value, 1));
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#trace(Value, int)} with {@code value}, {@code
   * trace}.
   *
   * <ul>
   *   <li>When {@link InstructionOffsetValue#EMPTY_VALUE}.
   *   <li>Then return {@link InstructionOffsetValue#EMPTY_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#trace(Value, int)}
   */
  @Test
  @DisplayName(
      "Test trace(Value, int) with 'value', 'trace'; when EMPTY_VALUE; then return EMPTY_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.ReferenceTracingInvocationUnit.trace(proguard.evaluation.value.Value, int)"
  })
  void testTraceWithValueTrace_whenEmpty_value_thenReturnEmpty_value() {
    // Arrange and Act
    Value actualTraceResult =
        (new ReferenceTracingInvocationUnit(
                new BasicInvocationUnit(new ParticularReferenceValueFactory())))
            .trace(InstructionOffsetValue.EMPTY_VALUE, 1);

    // Assert
    assertSame(((InstructionOffsetValue) actualTraceResult).EMPTY_VALUE, actualTraceResult);
  }
}
